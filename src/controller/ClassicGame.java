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
		int k=0;
		while(view.getGameThread()!=null) {
			k = (++k)%20;
			view.paintMatrix(k);
			view.paintScore();
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