package net.babbster.rain.graphics;

import java.awt.Color;

public class Screen {
	
	private int width;
	private int height;
	
	public int[] pixels;
	
	int time = 0;
	int counter = 0;
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear(){
	
		for(int i =0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	
	}
	
	/**
	 * For modifying pixels
	 */
	public void render(){
		
		counter++;
		
		if(counter % 100 == 0){
			time++;
		}
		
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				Color c = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
				pixels[time + time * width] = c.getRGB();
			}
		}
	}

}
