package common;

import java.awt.image.BufferedImage;

/**
 * An interface the contains the methods of properties found in all the colored images.
 * 
 * @author Khaled Chehab <khchehab@gmail.com>
 *
 * @version 1.0
 * @since 1.0
 */
public interface IRGBImageProperties {
	/**
	 * Returns pixel at position (i, j).
	 * 
	 * A method that returns the pixel object and position (i, j).
	 * 
	 * @param i row position
	 * @param j column position
	 * 
	 * @return pixel at (i, j)
	 * 
	 * @since 1.0
	 */
	public Pixel pixelAt (int i, int j);
	
	/**
	 * Sets the pixel at position (i, j) to the new pixel.
	 * 
	 * A method that sets the pixel at position (i, j) to the new pixel p.
	 * 
	 * @param i row position
	 * @param j column position
	 * @param p pixel to set
	 * 
	 * @since 1.0
	 */
	public void setPixel (int i, int j, Pixel p);
	
	/**
	 * Sets the pixel's color at position (i, j) to the new color.
	 * 
	 * A method that sets the pixel's color at position (i, j) to the new color c.
	 * 
	 * @param i row position
	 * @param j column position
	 * @param c color to set
	 * 
	 * @since 1.0
	 */
	public void setPixel (int i, int j, java.awt.Color c);
	
	/**
	 * Sets the pixel's RGB values at position (i, j) to the new RGB values.
	 * 
	 * A method that sets the pixel's RGB values at position (i, j) to the RGB values.
	 * 
	 * @param i row position
	 * @param j column position
	 * @param r new red value
	 * @param g new green value
	 * @param b new blue value
	 * 
	 * @since 1.0
	 */
	public void setPixel (int i, int j, int r, int g, int b);
	
	/**
	 * Returns the image's width.
	 * 
	 * A method that returns that image's width.
	 * 
	 * @return image's width
	 * 
	 * @since 1.0
	 */
	public int width ();
	
	/**
	 * Returns the image's height.
	 * 
	 * A method that returns that image's height.
	 * 
	 * @return image's height
	 * 
	 * @since 1.0
	 */
	public int height ();
	
	/**
	 * Returns the image's maximum RGB value.
	 * 
	 * A method that returns that image's maximum RGB value.
	 * 
	 * @return image's maximum RGB value
	 * 
	 * @since 1.0
	 */
	public int maxValue ();
	
	/**
	 * Returns a BufferedImage object of the ppm image.
	 * 
	 * A method that returns a BufferedImage object representing the ppm image.
	 * 
	 * @return BufferedImage of ppm image
	 * 
	 * @since 1.0
	 */
	public BufferedImage toBufferedImage ();
}