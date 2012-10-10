package controller;

import java.util.Random;

import model.Record;
import view.ClassicView;

public class Game implements Runnable {
	protected Record record;
	protected int[][] matrix;
	public static final int TIMELIMIT = 60*1000;
	public static final int SIZE = 8;
	
	protected ClassicView view;
	
	public Game(ClassicView v) {
		view = v;
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
	
	public void setMatrixItem(int item,int value) {
		int x = item/SIZE;
		int y = item%SIZE;
		matrix[x][y] = value;
	}
	
	public boolean swappable() {
		return false;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
