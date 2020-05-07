package com.firstjavagame;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{

	private int width, heigth;
	private float life;
	private float alpha = 1;
	private handler handler;
	private Color color;
	
	public Trail(float x, float y, ID id, Color color, int width, int height, float life, handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.heigth = height;
		this.life = life;
		
	}

	@Override
	public void tick() {
		if (alpha > life) {
			alpha -= (life - 0.0001f);
		}
		else handler.removeObjecct(this);
		
	}

	@Override
	public void render(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	g2d.setComposite(makeTransparent(alpha));
	
	g.setColor(color);
	g.fillRect((int)x, (int)y, width, heigth);
	
	g2d.setComposite(makeTransparent(1));
	}

	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type, alpha));
	}
	
	@Override
	public Rectangle getBounds() {
		
		return null;
	}

}
