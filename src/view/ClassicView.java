package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.events.*;

import controller.Game;

import resources.MyIcons;
import resources.MyImages;

public class ClassicView extends BaseView {
	

	protected int rotateDiamond;
	protected int rotateIndex;
	protected boolean onDiamond;
	protected int selectedFirst;
	protected boolean showRect;
	protected boolean showUnswappable;
	public static final MyIcons DIAMONDS = new MyIcons();
	protected Image[][] diamonds;
	protected Image board;
	protected Image scorepod;
	protected Image hintbg;
	protected Image hint;
	protected Image backToMenu;
	protected Font menuFont;
	protected Font hintFont;
	protected Font scoreFont;
	protected Color foregroundColor;
	protected Color rectColor;

	public ClassicView(MainFrame mf) {
		super(mf);
		background = new Image(mf.getDisplay(),MyImages.DIR+MyImages.HELPBG);
		
		board = new Image(mainFrame.getDisplay(),MyImages.DIR+MyImages.BOARD);
		scorepod = new Image(mainFrame.getDisplay(),MyImages.DIR+MyImages.SCOREPOD);
		hintbg = new Image(mainFrame.getDisplay(),MyImages.DIR+MyImages.HINTBG);
		hint = new Image(mainFrame.getDisplay(),MyImages.DIR+MyImages.HINT);
		backToMenu = new Image(mainFrame.getDisplay(),MyImages.DIR+MyImages.BACKTOMENU);
		diamonds = new Image[7][20];
		for(int i=0;i<7;i++) {
			diamonds[i] = new Image[20];
			for(int j=0;j<20;j++)
				diamonds[i][j] = new Image(mainFrame.getDisplay(),DIAMONDS.ICONS[i][j]);
		}
		
		menuFont = new Font(mainFrame.getDisplay(),"Segoe Print",15,SWT.NORMAL);
		hintFont = new Font(mainFrame.getDisplay(),"Segoe Print",25,SWT.NORMAL);
		scoreFont = new Font(mainFrame.getDisplay(),"Segoe Print",25,SWT.ITALIC);
		
		foregroundColor = new Color(mainFrame.getDisplay(),255,255,255);
		rectColor = new Color(mainFrame.getDisplay(),255,0,0);
		
		rotateDiamond = -1;
		rotateIndex = 0;
		onDiamond = false;
		selectedFirst = -1;
		showRect = false;
		showUnswappable = false;
	}
	
	@Override
	public void paintComponents() {	
		canvas.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				// TODO Auto-generated method stub
				Image image = new Image(mainFrame.getDisplay(),canvas.getBounds());
				GC tgc = new GC(image);
				//
				tgc.drawImage(background,0,0);
				tgc.drawImage(board, 70, 70);
				tgc.drawImage(scorepod, 680, 50);
				tgc.drawImage(hintbg, 685, 420);
				tgc.drawImage(hint, 701, 491);
				
				tgc.setFont(menuFont);
				tgc.setAlpha(180);
				tgc.setForeground(foregroundColor);
				
				tgc.drawString("Menu",725,435,true);
				
				tgc.setFont(hintFont);
				tgc.setAlpha(180);
				tgc.setForeground(foregroundColor);
				
				tgc.drawString("Hint",710,510,true);
				
				tgc.drawImage(backToMenu, 740, 600);
				
				paintMatrix(tgc);
				paintScore(tgc);
				
				if(showRect)
					paintRect(tgc);
				//
				
				e.gc.drawImage(image,0,0);
				
				image.dispose();
				tgc.dispose();
			}
			
		});	
	}
	
	@Override
	public void addListeners() {
		canvas.addMouseMoveListener(new MouseMoveListener() {

			@Override
			public void mouseMove(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.x;
				int y = e.y;
				
				if(onBack(x,y))
					changeCursor(true);
				else
					changeCursor(false);
				
				int index = -1;
				if((index=onDiamondN(x,y))!=-1) {
					if(rotateDiamond!=index) {
						onDiamond = true;
						rotateDiamond = index;
						rotateIndex = 0;
					}
				}
				else {
					onDiamond = false;
					rotateDiamond = -1;
					rotateIndex = 0;
					canvas.redraw();
				}
				
			}
			
		});
		
		canvas.addMouseListener(new MouseListener() {

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.x;
				int y = e.y;
				
				if(onBack(x,y)) {
					canvas.dispose();
					changeCursor(false);
					mainFrame.setView(new MenuView(mainFrame));
				}
				
				int index = -1;
				if((index=onDiamondN(x,y))!=-1
						&&(selectedFirst==-1||(selectedFirst!=-1&&!nearby(selectedFirst,index)))) {
					selectedFirst = index;
					showRect = true;
				}
				else if((index=onDiamondN(x,y))!=-1
						&&(selectedFirst!=-1&&nearby(selectedFirst,index)&&!game.swappable())) {
					selectedFirst = index;
					showRect = true;
					showUnswappable = true;
				}
				else {
					selectedFirst = -1;
					showRect = false;
					showUnswappable = false;
				}
					
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void paintMatrix(GC gc) {		
		int[][] matrix = game.getMatrix();
		
		for(int i=0;i<Game.SIZE;i++) {
			for(int j=0;j<Game.SIZE;j++) {
				try {
					int index = i*Game.SIZE+j;
					if(index==rotateDiamond) {
						if(rotateIndex==20) rotateIndex = 0;
						gc.drawImage(diamonds[matrix[i][j]-1][rotateIndex++],70+j*64,70+i*64);
					}
					else
						gc.drawImage(diamonds[matrix[i][j]-1][0],70+j*64,70+i*64);
				} catch (SWTException e) {
					System.out.println("Game terminated!");
					System.exit(0);
				}
			}
		}
	}
	
	public void paintScore(GC gc) {
		gc.setFont(scoreFont);
		gc.setAlpha(180);
		gc.setForeground(foregroundColor);
		
		String score = game.getRecord().getScore()+"";
		gc.drawString(score,738,52,true);
	}
	
	public void paintRect(GC gc) {
		gc.setForeground(rectColor);
		int x = selectedFirst%Game.SIZE*64+70;
		int y = selectedFirst/Game.SIZE*64+70;
		gc.drawRoundRectangle(x,y,64,64,4,4);
	}
	
	public void paintUnswappable(GC gc) {
		
	}
	
	protected int onDiamondN(int x,int y) {
		if(x<70||x>582||y<70||y>582) 
			return -1;
		else 
			return ((y-70)/64)*(Game.SIZE)+(x-70)/64;
	}
	
	protected boolean nearby(int f,int s) {
		if(Math.abs(f-s)==8||Math.abs(f-s)==1)
			return true;
		return false;
	}
	
	public int getRotateDiamond() {
		return rotateDiamond;
	}
	
	public boolean getOnDiamond() {
		return onDiamond;
	}
	
	public boolean getShowRect() {
		return showRect;
	}
	
}
