package model;

public class Record {
	private int score;
	private String player;
	
	public Record() {
		this(0,"N/A");
	}
	
	public Record(int s,String p) {
		score = s; player = p;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
}
