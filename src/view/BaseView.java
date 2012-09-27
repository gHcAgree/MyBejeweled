package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BaseView {
	protected Canvas canvas;
	protected Image background;
	protected GC gc;
	
	public BaseView(Display d,Shell sh) {
		canvas = new Canvas(sh,SWT.BORDER);
		setSize(MainFrame.WIDTH,MainFrame.HEIGHT);
	}
	
	public void setBackground(Image img) {
		canvas.setBackgroundImage(img);
	}
	
	public void setSize(int w,int h) {
		if(canvas!=null)
			canvas.setBounds(0,0,w,h);
	}
	
	public void paintSelf() {
		
	}
}
