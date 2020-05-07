package com.firstjavagame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Gamemain extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;
	
	private Thread thread;
	private boolean running = false;
	private Random r;
	private handler handler;
	private HUD hud; 
	private Spawn spawner;
	
	public Gamemain() {
		handler = new handler();
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "GAME", this);
		
		hud = new HUD();
		spawner = new Spawn(handler, hud);		
		r = new Random();
		handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
		handler.addObject(new BasicEnemy(r.nextInt(Gamemain.WIDTH), r.nextInt(Gamemain.HEIGHT), ID.BasicEnemy, handler));
		
	}	
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		//game loop
		this.requestFocus();
		long LastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - LastTime)/ns;
			LastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) 
				render();
				frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
			if (HUD.HEALTH == 0) {
				stop();
				
			}
		}
		//end of game loop
		stop();
	}
	
	private void tick() {
		handler.tick();
		hud.tick();
		spawner.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		} 
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0,0, WIDTH,HEIGHT);
		
		handler.render(g);
		hud.render(g);
		
		g.dispose();
		bs.show();
		
	}
	
	public static float clamp(float x, float min, float max) {
		if (x >= max)
			return x = max;
		else if (x <= min )
			return x = min;
		else
			return x;
	}
	
	public static void main (String args[] ) {
		new Gamemain();
	}
}
