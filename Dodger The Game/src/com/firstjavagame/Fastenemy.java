package com.firstjavagame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Fastenemy extends GameObject {

	private handler handler;
	
	public Fastenemy(int x, int y, ID id, handler handler) {
		super(x, y, id);
		this.handler = handler;
		velX = 3;
		velY = 8;
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 12, 12);
	}
	
	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Gamemain.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Gamemain.WIDTH - 32) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 12, 12, 0.03f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, 12, 12);
	}

}
