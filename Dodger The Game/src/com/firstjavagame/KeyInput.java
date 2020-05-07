package com.firstjavagame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput (handler handler) {
		this.handler = handler;

		keyDown[0]=false;
		keyDown[1]=false;
		keyDown[2]=false;
		keyDown[3]=false;
	}
	

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
	
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject TempObject = handler.object.get(i);
			
			if (TempObject.getId() == ID.Player) {
				//key events for player 1
				if (key == KeyEvent.VK_W) {TempObject.setVelY(-5); keyDown[0]=true;}
				if (key == KeyEvent.VK_S) {TempObject.setVelY(5); keyDown[1]=true;}
				if (key == KeyEvent.VK_D) {TempObject.setVelX(5); keyDown[2]=true;}
				if (key == KeyEvent.VK_A) {TempObject.setVelX(-5); keyDown[3]=true;}
				
			}
			
		}
		
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
		
	}
	
	
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
	
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject TempObject = handler.object.get(i);
			
			if (TempObject.getId() == ID.Player) {
				//key events for player 1
				if (key == KeyEvent.VK_W) keyDown[0]=false; //TempObject.setVelY(0);
				if (key == KeyEvent.VK_S) keyDown[1]=false;//TempObject.setVelY(0);
				if (key == KeyEvent.VK_D) keyDown[2]=false;//TempObject.setVelX(0);
				if (key == KeyEvent.VK_A) keyDown[3]=false;//TempObject.setVelX(0);
				
				//vertical movement
				if (!keyDown[0] && !keyDown[1]) TempObject.setVelY(0); 
				//horizontal movement
				if (!keyDown[2] && !keyDown[3]) TempObject.setVelX(0);
			}
			
		}
		
	}
	
}//main ending bracket
