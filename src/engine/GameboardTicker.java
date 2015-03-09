package engine;

import gamecomponents.Gameboard;

import java.util.TimerTask;

public class GameboardTicker extends TimerTask{
	
	private Gameboard gameboard;
	
	private GameEngine gameEngine;
	
	public GameboardTicker(Gameboard gameboard, GameEngine gameEngine){
		this.gameboard = gameboard;
		this.gameEngine = gameEngine;
	}
	
	@Override
	public void run() {
		this.gameboard.tick();
		if(!this.gameboard.isGameRunning()){
			this.gameEngine.endGame(this.gameboard.getEndGameMessage());
		}
		
	}

}
