package resources;

public class MyIcons {
	public static final String DIR = "images/";
	public String[][] ICONS = new String[7][20];
	
	public MyIcons() {
		for(int i=0;i<7;i++) {
			ICONS[i] = new String[20];
			for(int j=0;j<20;j++)
				ICONS[i][j] = DIR+(i+1)+"/"+(i+1)+"_"+(j+1)+".png";
		}
	}
}
