package view;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

import controller.*;

import resources.MyImages;

public class MenuView extends BaseView {

	private Rectangle helpRect;
	private Rectangle settingRect;
	private Rectangle aboutRect;
	private Rectangle exitRect;
	private Point classicP;
	private Point timeP;
	private Point levelP;
	private Point onlineP;
	private int radius;
	
	public MenuView(MainFrame mf) {
		super(mf);
		setBackground(new Image(mf.getDisplay(),MyImages.DIR+MyImages.MENU));
		
		settingRect = new Rectangle(42,604,140,60);
		helpRect = new Rectangle(228,637,140,60);
		aboutRect = new Rectangle(540,637,140,60);
		exitRect = new Rectangle(726,604,140,60);
		
		classicP = new Point(221,148);
		timeP = new Point(660,148);
		levelP = new Point(221,468);
		onlineP = new Point(660,468);
		radius = 90;
	}
	
	@Override
	public void addListeners() {
		canvas.addMouseMoveListener(new MouseMoveListener() {

			@Override
			public void mouseMove(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.x;
				int y = e.y;
				
				gc.setFont(new Font(mainFrame.getDisplay(),"楷体",40,SWT.BOLD));
				gc.setAlpha(50);
				gc.setForeground(new Color(mainFrame.getDisplay(),255,255,255));
				
				if(settingRect.contains(x,y)) {
					gc.drawString("设置选项", 342, 285,true);
					changeCursor(true);
				}
				else if(helpRect.contains(x,y)) {
					gc.drawString("帮助信息", 342, 285,true);
					changeCursor(true);
				}
				else if(aboutRect.contains(x,y)) {
					gc.drawString("关于游戏", 342, 285,true);
					changeCursor(true);
				}
				else if(exitRect.contains(x,y)) {
					gc.drawString("退出游戏", 342, 285,true);
					changeCursor(true);
				}
				   
				else if(onButton(classicP,x,y)) {
					gc.drawString("经典模式", 342, 285,true);
					changeCursor(true);	
				}
				else if(onButton(timeP,x,y)) {
					gc.drawString("时间模式", 342, 285,true);
					changeCursor(true);
				}
				else if(onButton(levelP,x,y)) {
					gc.drawString("冒险闯关", 342, 285,true);
					changeCursor(true);	
				}
				else if(onButton(onlineP,x,y)) {
					gc.drawString("联网对战", 342, 285,true);
					changeCursor(true);	
				}
				else {
					canvas.redraw();
					changeCursor(false);
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
				
				if(settingRect.contains(x,y)) {
					
				}
				else if(helpRect.contains(x,y)) {
					
				}
				else if(aboutRect.contains(x,y)) {
					
				}
				else if(exitRect.contains(x,y)) {
					System.exit(0);
				}
				   
				else if(onButton(classicP,x,y)) {
					canvas.dispose();
					changeCursor(false);
					mainFrame.setView(new ClassicView(mainFrame));
					
					game = new ClassicGame();
					gameThread = new Thread(game);
					gameThread.start();
				}
				else if(onButton(timeP,x,y)) {
					canvas.dispose();
					changeCursor(false);
					mainFrame.setView(new TimeView(mainFrame));
					
					game = new TimeGame();
					gameThread = new Thread(game);
					gameThread.start();
				}
				else if(onButton(levelP,x,y)) {
					
				}
				else if(onButton(onlineP,x,y)) {
					
				}
				else {
				}
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	private boolean onButton(Point p,int x,int y) {
		return Math.sqrt(Math.pow(p.x-x,2)+Math.pow(p.y-y,2))<=radius?true:false;
	}
	

}
