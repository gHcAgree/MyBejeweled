package view;

import model.MyImages;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

public class ClassicView extends BaseView {

	public ClassicView(MainFrame mf) {
		super(mf);
		setBackground(new Image(mf.getDisplay(),MyImages.DIR+MyImages.HELPBG));
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
				
				gc.setFont(new Font(mainFrame.getDisplay(),"Segoe Print",25,SWT.NORMAL));
				gc.setAlpha(180);
				gc.setForeground(new Color(mainFrame.getDisplay(),255,255,255));
				
				gc.drawString("0",738,52,true);
				
				gc.setFont(new Font(mainFrame.getDisplay(),"Segoe Print",15,SWT.NORMAL));
				gc.setAlpha(180);
				gc.setForeground(new Color(mainFrame.getDisplay(),255,255,255));
				
				gc.drawString("Menu",725,435,true);
				
				gc.setFont(new Font(mainFrame.getDisplay(),"Segoe Print",25,SWT.NORMAL));
				gc.setAlpha(180);
				gc.setForeground(new Color(mainFrame.getDisplay(),255,255,255));
				
				gc.drawString("Hint",710,510,true);
			}
			
		});
		
	}

}
