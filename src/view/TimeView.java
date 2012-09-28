package view;

import model.MyImages;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;

public class TimeView extends ClassicView {

	public TimeView(MainFrame mf) {
		super(mf);
		// TODO Auto-generated constructor stub
	}

	public void timerTick() {
		canvas.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent arg0) {
				// TODO Auto-generated method stub
				gc.drawImage(new Image(mainFrame.getDisplay(),MyImages.DIR+MyImages.PROCESSBAR),0,0,520,69,70,600,512,40);
			}
			
		});
	}
	
	@Override
	public void paintComponents() {
		super.paintComponents();
		timerTick();
	}
	
}
