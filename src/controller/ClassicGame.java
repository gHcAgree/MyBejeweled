package controller;

import org.eclipse.swt.SWTException;

import view.ClassicView;

public class ClassicGame extends Game {

	public ClassicGame(ClassicView v) {
		super(v);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		while(view.getGameThread()!=null) {
				view.getMainFrame().getDisplay().asyncExec(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						if(view.getOnDiamond()||view.getShowRect()) {
							try {
								view.getCanvas().redraw();
							} catch(SWTException e) {
								view.setGameThread(null);
							}
						}
					}
			
				});
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	}

}
