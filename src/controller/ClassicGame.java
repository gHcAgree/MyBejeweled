package controller;

import view.ClassicView;

public class ClassicGame extends Game {

	public ClassicGame(ClassicView v) {
		super(v);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		while(view.getGameThread()!=null) {
			while(view.getOnDiamond()) {
				view.getMainFrame().getDisplay().asyncExec(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						view.getCanvas().redraw();
					}
			
				});
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}}}

}
