package view;

import model.MyImages;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

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
		timeP = new Point(633,148);
		levelP = new Point(221,468);
		onlineP = new Point(633,468);
		radius = 90;
	}
	
	@Override
	public void paintComponents() {
		
	}
	
	@Override
	public void addListeners() {
		canvas.addMouseMoveListener(new MouseMoveListener() {

			@Override
			public void mouseMove(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.x;
				int y = e.y;
				
				if(settingRect.contains(x,y)) {
					
				}
				else if(helpRect.contains(x,y)) {
					
				}
				else if(aboutRect.contains(x,y) {
					
				}
				else if(exitRect.contains(x,y)) {
					
				}
				   onButton(classicP,x,y)
				   onButton(timeP,x,y)
				   onButton(levelP,x,y)
				   onButton(onlineP,x,y)) {
					mainFrame.getShell().setCursor(new Cursor(mainFrame.getDisplay(),SWT.CURSOR_HAND));
				}
				else {
					mainFrame.getShell().setCursor(null);
				}
					
			}
			
		});
	}
	
	private boolean onButton(Point p,int x,int y) {
		return Math.sqrt(Math.pow(p.x-x,2)+Math.pow(p.y-y,2))<=radius?true:false;
	}
	

}
