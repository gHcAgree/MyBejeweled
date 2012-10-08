package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.*;

public class MainFrame {
	private Display display;
	private Shell shell;
	private BaseView view;
	public static final int WIDTH=900;
	public static final int HEIGHT=700;
	
	public MainFrame() {
		display = new Display();
		shell = new Shell(display,SWT.CLOSE|SWT.MIN|SWT.CENTER); 
		shell.setText("My Bejeweled");
		shell.setSize(WIDTH,HEIGHT);
		shell.open();
		
		view = new MenuView(this);
		
		shell.addDisposeListener(new DisposeListener() {  
		    public void widgetDisposed(DisposeEvent e) {  
		        display.dispose(); 
		        view.setGameThread(null);
		        System.exit(0);  
		    }  
		});
		
		while (!shell.isDisposed()) {
		    if (!display.readAndDispatch()) 
			display.sleep ();
		}
		display.dispose ();
	}

	public Display getDisplay() {
		return display;
	}

	public Shell getShell() {
		return shell;
	}

	public BaseView getView() {
		return view;
	}

	public void setView(BaseView view) {
		this.view = view;
	}
	
}
