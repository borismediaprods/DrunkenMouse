import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main {
	
	/*
	 * 
	 * Drunken Mouse Prank Script.
	 * -> Created by (the one and only) Boris Skurikhin for educational purposes only! Please use with caution.
	 * -> Original idea came from Barnucles who created this effect using Visual C#.
	 * 
	 * ->Date Created: 27 August, 2015 at 0:49 A.M.
	 * ->All components written in Java 7.
   */
	
	public static ExecutorService service = Executors.newFixedThreadPool(1);
	
	public static void main (String[] argumentos) {
		service.execute(new DrunkMouse());
	}
	
}

class DrunkMouse implements Runnable {
	Random random = new Random();
	Robot mouseControl;
	Point mousePosition;
	
	public DrunkMouse(){
		this.mousePosition = MouseInfo.getPointerInfo().getLocation();
	}
	
	public void run() {
		int xAmount = 0;
		int yAmount = 0;
		int moveSpeed = 50; // smaller = faster
		int moveAmount = 30;
		while(true) {
			xAmount = random.nextInt(moveAmount) - 10;
			yAmount = random.nextInt(moveAmount) - 10;
			try {
				mousePosition = MouseInfo.getPointerInfo().getLocation();
				mouseControl = new Robot();
				mouseControl.mouseMove(mousePosition.x + (random.nextBoolean() ? xAmount : -xAmount), 
									   mousePosition.y + (random.nextBoolean() ? yAmount : -yAmount));
			} catch (Exception error) {
				error.printStackTrace();
			}
			try {
				Thread.sleep(moveSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
