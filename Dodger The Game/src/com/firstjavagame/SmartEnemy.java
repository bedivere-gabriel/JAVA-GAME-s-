package com.firstjavagame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

	private handler handler;
	private GameObject player;
	
	public SmartEnemy(int x, int y, ID id, handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		for(int i = 0;i<handler.object.size();i++) {
			if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
			}
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 15, 15);
	}
	
	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() -16;
		float diffY = y - player.getY() -16;
		
		float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		
		velX = (float) ((-1.0/distance)*diffX);
		velY = (float) ((-1.0/distance)*diffY);
		
		//if(y <= 0 || y >= Gamemain.HEIGHT - 32) velY *= -1;
		//if(x <= 0 || x >= Gamemain.WIDTH - 32) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.pink, 15, 15, 0.03f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect((int)x, (int)y, 15, 15);
	}

}
