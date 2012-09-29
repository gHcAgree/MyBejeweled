package controller;

import java.util.Random;

import model.Record;
import view.BaseView;
import view.MainFrame;

public class Game implements Runnable {
	private MainFrame frame;
	private Record record;
	private int[][] matrix;
	public static final int TIMELIMIT = 60*1000;
	public static final int SIZE = 8;
	
	protected BaseView view;
	
	public Game() {
		record = new Record();
		matrix = makeMatrix();
	}
	
	
	/**
	 * 
	 * @return a non-clearable matrix
	 */
	public int[][] makeMatrix() {
		int[][] m = new int[SIZE][SIZE];
		Random rand = new Random();
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				m[i][j] = rand.nextInt(7)+1;
			}
		}
		
		return m;
	}
	
	public void go() {
		
	}
	
	public void over() {
		System.exit(0);
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
