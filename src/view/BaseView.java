package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;

public class BaseView {
	protected Canvas canvas;
	protected Image background;
	protected GC gc;
	protected MainFrame mainFrame;
	
	public BaseView(MainFrame mf) {
		mainFrame = mf;
		canvas = new Canvas(mf.getShell(),SWT.BORDER);
		setSize(MainFrame.WIDTH,MainFrame.HEIGHT);
		
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
}
