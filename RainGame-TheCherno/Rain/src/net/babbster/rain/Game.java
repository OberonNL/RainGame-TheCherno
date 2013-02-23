package net.babbster.rain;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	public static int height = 300;
	public static int width  = height / 16 * 9;
	public static int scale  = 3;
	
	private Thread thread;
	private boolean running = false;
	private JFrame frame;
	
	public Game(){
		Dimension size = new Dimension(width * scale, height * scale);
		this.setPreferredSize(size);
		
		frame = new JFrame();
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this, "Game");
		thread.start();
	}
	
	public synchronized void stop(){
		running = false;
		try{
			thread.join();
		}
		catch(InterruptedException error){
			error.printStackTrace();
		}
	}

	@Override
	public void run() {
		// Game loop
		while(running){
			System.out.println("Runing");
		}
	}
    public static void main(String[] args){
    	Game game = new Game();
    	game.frame.setResizable(false);
    	game.frame.setTitle("Rain");
    	game.frame.add(game);
    	game.frame.pack();
    	game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	game.frame.setVisible(true);
    	game.start();
    }
}
