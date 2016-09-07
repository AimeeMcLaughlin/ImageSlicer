import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Main {

	static int height;
	static int width;
	
	public static void main(String args[]) throws IOException{
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				createGUI();
			}
		});
		
		JButton openfile = new JButton("Open");
		JButton createfiles = new JButton("Create splits");
		readImage();
		
		
		System.out.print("Enter columns:");
		String columns = System.console().readLine();
		int numColumns = Integer.parseInt(columns);
		
		System.out.print("Enter rows:");
		String rows = System.console().readLine();
		int numRows = Integer.parseInt(rows);
		
		writeImages(numColumns, numRows);
		
	  }
	
	private static void createGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("jButton usage demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void readImage()
	{
		BufferedImage image = null;
	    File f = null;

	    //read image file
	    try{
	      f = new File("C:\\Users\\Aimoi\\Pictures\\for puzzle\\fullimage.png");
	      image = ImageIO.read(f);
	    }catch(IOException e){
	      System.out.println("Error: "+e);
	    }
	    height = image.getHeight();
        width = image.getWidth();
	}
	
	
	
	public static void writeImages(int columns, int rows)
	{
		int blockHeight = height/rows;
		int blockWidth= width/columns;
		int count = 0; 
		for(int i = 0; i >= height; i+=blockHeight)
		{
			for(int j = 0; j >= width; j+=blockWidth)
			{
				
				BufferedImage image = null;
				File f = null;
				try{
				      f = new File("D:\\Image\\Output.jpg" + count);
				      ImageIO.write(image, "jpg", f);
				    }catch(IOException e){
				      System.out.println("Error: "+e);
				    }
				
				count++;
			}
		
		}
		
		
	}
	
}

	
	