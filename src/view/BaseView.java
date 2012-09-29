package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;

import controller.Game;

import resources.MyIcons;

public class BaseView {
	protected Canvas canvas;
	protected Image background;
	protected GC gc;
	protected MainFrame mainFrame;
	public static final MyIcons DIAMONDS = new MyIcons();
	protected int scoreCounter;
	protected Thread gameThread;
	protected Thread soundThread;
	
	protected Game game;
	
	public BaseView(MainFrame mf) {
		mainFrame = mf;
		canvas = new Canvas(mf.getShell(),SWT.FILL);
		setSize(MainFrame.WIDTH,MainFrame.HEIGHT);
		gc = new GC(canvas);
		scoreCounter = 0;
		
		paintComponents();
		addListeners();
	}
	
	public void setBackground(Image img) {
		canvas.setBackgroundImage(img);
	}
	
	public void setSize(int w,int h) {
		if(canvas!=null)
			canvas.setBounds(0,0,w,h);
	}
	
	public void paintComponents() {
		
	}
	
	public void addListeners() {
		
	}
	
	protected boolean onBack(int x, int y) {
		Rectangle rect = new Rectangle(740,600,135,60);
		if(rect.contains(x,y)) return true;
		return false;
	}
	
	protected boolean onHint() {
		return false;
	}
	
	protected boolean onMenu() {
		return false;
	}

	protected void changeCursor(boolean b) {
		if(b)
			mainFrame.getShell().setCursor(new Cursor(mainFrame.getDisplay(),SWT.CURSOR_HAND));
		else
			mainFrame.getShell().setCursor(null);
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
