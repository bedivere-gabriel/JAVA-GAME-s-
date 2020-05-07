package com.firstjavagame;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH = 100;
	private int greenValue = 255;
	Gamemain frames;
	private int score = 0;
	private int level = 1;
	
	public void tick() {
		HEALTH = (int) Gamemain.clamp(HEALTH, 0, 100);
		greenValue = (int) Gamemain.clamp(greenValue, 0, 255);
		greenValue = HEALTH*2;
		
		score ++;
	}
	
	public void render(Graphics g) {
		//health
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 28);
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect((int)15, (int)15, (int) (HEALTH *2), 28);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 28);
	
		g.drawString("Score: " + score, 16, 64 );
		g.drawString("Level " + level, 16, 80);
		g.drawString("FPS: " + frames, 16, 100);
		
	}
	
	public void score(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevl(int level) {
		this.level = level;
	}
}
