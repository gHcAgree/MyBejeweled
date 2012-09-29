package controller;

import view.ClassicView;

public class ClassicGame extends Game {

	public ClassicGame(ClassicView v) {
		super(v);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(view.getGameThread()!=null) {
			//view.paintMatrix();
			//view.paintScore();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//view.getCanvas().redraw();
		}
	}

}
