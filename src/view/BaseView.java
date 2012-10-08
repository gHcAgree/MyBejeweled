package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
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
	protected int scoreCounter;
	protected Thread gameThread;
	protected Thread soundThread;
	
	protected Game game;
	
	public BaseView(MainFrame mf) {
		mainFrame = mf;
		canvas = new Canvas(mf.getShell(),SWT.NO_BACKGROUND);    //SWT.DOUBLE_BUFFERED|SWT.NO_BACKGROUND|SWT.NO_REDRAW_RESIZE
		setSize(MainFrame.WIDTH,MainFrame.HEIGHT);
		gc = new GC(canvas);
		scoreCounter = 0;
		
		paintComponents();
		addListeners();
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
	
	public Thread getGameThread() {
		return gameThread;
	}
	
	public void setGameThread(Thread t) {
		gameThread = t;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
}
