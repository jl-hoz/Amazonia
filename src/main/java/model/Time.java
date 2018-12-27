package model;

import java.util.Random;

import javafx.scene.control.Button;

public class Time extends Thread{
	
	@Override
	public void run() {
		try {
			sleep(generateRandomTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return random int with 0 to 3000 range.
	 */
	public int generateRandomTime() {
		Random x = new Random();
		return x.nextInt(3000) + 1;
	}
	
}
