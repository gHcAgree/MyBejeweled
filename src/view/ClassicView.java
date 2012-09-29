package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.events.*;

import controller.Game;

import resources.MyImages;

public class ClassicView extends BaseView {
	
	protected boolean[] onDiamond;
	protected int rotateDiamond;

	public ClassicView(MainFrame mf) {
		super(mf);
		setBackground(new Image(mf.getDisplay(),MyImages.DIR+MyImages.HELPBG));
		
		int number = Game.SIZE*Game.SIZE-1;
		onDiamond = new boolean[number];
		for(int i=0;i<number;i++)
				onDiamond[i] = false;
		
		rotateDiamond = -1;
	}
	
	@Override
	public void paintComponents() {	
		canvas.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent arg0) {
				// TODO Auto-generated method stub
				gc.drawImage(new Image(mainFrame.getDisplay(),MyImages.DIR+MyImages.BOARD), 70, 70);
				gc.drawImage(new Image(mainFrame.getDisplay(),MyImages.DIR+MyImages.SCOREPOD), 680, 50);
				gc.drawImage(new Image(mainFrame.getDisplay(),MyImages.DIR+MyImages.HINTBG), 685, 420);
				gc.drawImage(new Image(mainFrame.getDisplay(),MyImages.DIR+MyImages.HINT), 701, 491);
				
				gc.setFont(new Font(mainFrame.getDisplay(),"Segoe Print",15,SWT.NORMAL));
				gc.setAlpha(180);
				gc.setForeground(new Color(mainFrame.getDisplay(),255,255,255));
				
				gc.drawString("Menu",725,435,true);
				
				gc.setFont(new Font(mainFrame.getDisplay(),"Segoe Print",25,SWT.NORMAL));
				gc.setAlpha(180);
				gc.setForeground(new Color(mainFrame.getDisplay(),255,255,255));
				
				gc.drawString("Hint",710,510,true);
				
				gc.drawImage(new Image(mainFrame.getDisplay(),MyImages.DIR+MyImages.BACKTOMENU), 740, 600);
				
				paintMatrix();

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
				if((index=onDiamondN(x,y))!=-1)
					rotateDiamond = index;
				else
					rotateDiamond = -1;
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
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void paintMatrix() {		
		int[][] matrix = game.getMatrix();
		
		for(int i=0;i<Game.SIZE;i++) {
			for(int j=0;j<Game.SIZE;j++) {
				try {
					gc.drawImage(new Image(mainFrame.getDisplay(),DIAMONDS.ICONS[matrix[i][j]-1][0]),70+j*64,70+i*64);
				} catch (SWTException e) {
					System.out.println("Game terminated!");
					System.exit(0);
				}
			}
		}
	}
	
	public void paintScore() {
		gc.setFont(new Font(mainFrame.getDisplay(),"Segoe Print",25,SWT.ITALIC));
		gc.setAlpha(180);
		gc.setForeground(new Color(mainFrame.getDisplay(),255,255,255));
		
		String score = game.getRecord().getScore()+"";
		gc.drawString(score,738,52,true);
	}
	
	protected int onDiamondN(int x,int y) {
		if(x<70||x>582||y<70||y>582) 
			return -1;
		else 
			return ((y-70)/64)*(Game.SIZE)+(x-70)/64;
	}

}
