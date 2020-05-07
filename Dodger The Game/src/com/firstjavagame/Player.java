package com.firstjavagame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	handler handler;
	
	public Player(int x, int y, ID id, handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 15, 15);
	}
	
	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		x = Gamemain.clamp(x, 0, Gamemain.WIDTH -49);
		y = Gamemain.clamp(y, 0, Gamemain.HEIGHT -72);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.blue, 15, 15, 0.1f, handler));
		collision();
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i ++) {
			GameObject TempObj = handler.object.get(i);
			
			if (TempObj.getId() == ID.BasicEnemy || TempObj.getId() == ID.Fastenemy || TempObj.getId() == ID.SmartEnemy) {
				//collision code
				if (getBounds().intersects(TempObj.getBounds())) {
					HUD.HEALTH -= 1;
				}
			}
			
		}
	}
	
	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, 15, 15);

		
	}

}
