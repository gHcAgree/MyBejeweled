package controller;

import view.MainFrame;

public class Game {
	MainFrame frame;
	
	public Game() {
		frame = new MainFrame(this);
	}
	
	public void go() {
		
	}
	
	public void over() {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new Game().go();
	}
}
