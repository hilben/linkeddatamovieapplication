package main;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import chrriis.dj.nativeswing.swtimpl.components.win32.JWMediaPlayer;



public class PlayerPanel extends JPanel{

	private JPanel PlayerPanel;
	final JWMediaPlayer player;
	
	public PlayerPanel(){
		
		super(new BorderLayout());
		PlayerPanel =  new JPanel(new BorderLayout());
		player = new JWMediaPlayer();
		PlayerPanel.add(player, BorderLayout.CENTER);
		add(PlayerPanel, BorderLayout.CENTER);
		player.setControlBarVisible(true);
		
	}
	
	public void loadMovie(String URL){
		player.load(URL);
	}
	
}
