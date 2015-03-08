package engine;

import gamecomponents.Gameboard;

import java.util.TimerTask;

public class GameboardTicker extends TimerTask{
	
	private Gameboard gameboard;
	
	public GameboardTicker(Gameboard gameboard){
		this.gameboard = gameboard;
	}
	
	@Override
	public void run() {
		this.gameboard.tick();
		
	}

}
