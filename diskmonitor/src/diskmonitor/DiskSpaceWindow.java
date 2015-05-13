package diskmonitor;

import javax.swing.*;

public class DiskSpaceWindow extends JFrame 
	implements DiskSpaceListener {
	
	private JProgressBar progress = new JProgressBar();
	
	public DiskSpaceWindow() {
		this.setTitle("Espaco em disco");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 60);
		this.setAlwaysOnTop(true);
		this.add(progress);
		this.setVisible(true);
	}

	@Override
	public void diskSpaceChange(DiskSpaceEvent evt) {		
		double total = (evt.getFree() + evt.getUsed());
		int percentual = (int) (evt.getUsed() / total * 100);
		
		System.out.println(percentual);
		
		progress.setValue(percentual);		
	}

}
