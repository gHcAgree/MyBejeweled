package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.events.*;

import resources.MyImages;

public class ClassicView extends BaseView {

	public ClassicView(MainFrame mf) {
		super(mf);
		setBackground(new Image(mf.getDisplay(),MyImages.DIR+MyImages.HELPBG));
	}
	
	@Override
	public void paintComponents() {
		super.paintComponents();
		
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

}
