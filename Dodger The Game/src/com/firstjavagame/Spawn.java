package com.firstjavagame;

import java.util.Random;

public class Spawn {
	private handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random r = new Random();
	
	public Spawn(handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 500) {
			scoreKeep = 0;
			hud.setLevl(hud.getLevel() + 1);
			
			if (hud.getLevel() == 2) {
				handler.addObject(new BasicEnemy(r.nextInt(Gamemain.WIDTH-42), r.nextInt(Gamemain.HEIGHT-42), ID.BasicEnemy, handler));
			}
			else if (hud.getLevel() == 3) {
				handler.addObject(new BasicEnemy(r.nextInt(Gamemain.WIDTH-42), r.nextInt(Gamemain.HEIGHT-42), ID.BasicEnemy, handler));
				
			}
			else if (hud.getLevel() == 4) {
				handler.addObject(new BasicEnemy(r.nextInt(Gamemain.WIDTH-42), r.nextInt(Gamemain.HEIGHT-42), ID.BasicEnemy, handler));
				handler.addObject(new Fastenemy(r.nextInt(Gamemain.WIDTH-42), r.nextInt(Gamemain.HEIGHT-42), ID.Fastenemy, handler));
				handler.addObject(new SmartEnemy(r.nextInt(Gamemain.WIDTH-42), r.nextInt(Gamemain.HEIGHT-42), ID.SmartEnemy, handler));
			}
			else if (hud.getLevel() == 5) {
				handler.addObject(new BasicEnemy(r.nextInt(Gamemain.WIDTH-42), r.nextInt(Gamemain.HEIGHT-42), ID.BasicEnemy, handler));
			}
		}
	}
}
