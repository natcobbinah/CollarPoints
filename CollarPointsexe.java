package CollarPointsGUI;

import javax.swing.SwingUtilities;

public class CollarPointsexe {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CollarPointsMainFrame();
			}
		});
	}

}
