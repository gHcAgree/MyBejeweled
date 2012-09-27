package view;

import model.MyImages;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MenuView extends BaseView {

	public MenuView(Display d,Shell sh) {
		super(d,sh);
		setBackground(new Image(d,MyImages.DIR+MyImages.MENU));
	}

}
