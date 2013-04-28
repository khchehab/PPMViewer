package ascii;

import java.awt.image.BufferedImage;

import common.IRGBImageProperties;
import common.Pixel;

/**
 * A class representing an image of type PPM.
 * 
 * @author Khaled Chehab <khchehab@gmail.com>
 * @version 1.0
 * @since 1.0
 *
 */
public class PPM implements IRGBImageProperties {
	// Constants
	/**
	 * Maximum RGB value.
	 * 
	 * The maximum RGB value.
	 * 
	 * @since 1.0
	 */
	public static final int MAX_RGB_VALUE = 255;
	
	// Instance Fields
	private int _width;
	private int _height;
	private int _maxVal;
	private Pixel[][] _pixels;

	/**
	 * Constructs a PPM image from an existing .ppm file.
	 * 
	 * Constructs a PPM image object from a .ppm file that is referred from File f.
	 * 
	 * @param f File object referring to the .ppm file.
	 * 
	 * @since 1.0
	 */
	public PPM (java.io.File f) {
		java.util.Scanner in = null;
		
		try {
			in = new java.util.Scanner (f);
			
			in.nextLine(); // Skip the first line, since its P3, which is the PPM ASCII format
			
			// array that holds the width and height at 0 and 1 respectively
			String[] dims = in.nextLine().trim().split("( )+");
			_width = Integer.parseInt(dims[0]);
			_height = Integer.parseInt(dims[1]);
			
			// gets the maximum RBG value
			_maxVal = Integer.parseInt(in.nextLine().trim());
			
			// reads the RGB values and puts then in the pixel array
			_pixels = new Pixel [_width][_height];
			
			for (int j = 0; j < _height; j++)
				for (int i = 0; i < _width; i++)
					_pixels[i][j] = new Pixel (in.nextInt(), in.nextInt(), in.nextInt());
			
		} catch (java.io.FileNotFoundException e) {
			System.err.println("File was not found. Make sure the file exist.");
			System.err.println("Message: " + e.getMessage());
		} catch (@SuppressWarnings("hiding") java.io.IOException e) {
			System.err.println("File could not be opened.");
			System.err.println("Message: " + e.getMessage());
		} catch (NullPointerException e) {
			System.err.println("Path to the file was null.");
			System.err.println("Message: " + e.getMessage());
		} finally {
			if (in != null)
				in.close();
		}
	}

	/**
	 * Constructs a PPM image from an existing .ppm file.
	 * 
	 * Construct a PPM image object from a .ppm file that is named "filename".
	 * 
	 * @param filename path to file
	 * 
	 * @since 1.0
	 */
	public PPM (String filename) {
		// filename is full path. ie: images/<filename>.ppm
		this(new java.io.File(filename));
	}
	
	/**
	 * Constructs an empty PPM image.
	 * 
	 * Constructs an empty PPM image of size width x height, and with default maximum RGB value.
	 * 
	 * @param width image width
	 * @param height image height
	 * 
	 * @throws IllegalArgumentException if width or height are invalid (<= 0)
	 * 
	 * @since 1.0
	 */
	public PPM (int width, int height) {
		this (width, height, MAX_RGB_VALUE);
	}
	
	/**
	 * Constructs an empty PPM image.
	 * 
	 * Constructs an empty PPM image of size width x height, and with maximum RGB value of maxValue.
	 * 
	 * @param width image width
	 * @param height image height
	 * @param maxValue maximum RGB value
	 * 
	 * @throws IllegalArgumentException if width or height are invalid (<= 0)
	 * 
	 * @since 1.0
	 */
	public PPM (int width, int height, int maxValue) {
		if (width < 1)
			throw new IllegalArgumentException("Width is less than or equal to zero: invalid argument.");
		if (height < 1)
			throw new IllegalArgumentException("Height is less than or equal to zero: invalid argument.");
		
		_width = width;
		_height = height;
		_maxVal = maxValue;
		
		for (int i = 0; i < _width; i++)
			for (int j = 0; j < _height; j++)
				_pixels[i][j] = new Pixel ();
	}
	
	/**
	 * Constructs from an existing PPM image.
	 * 
	 * Constructs a new PPM image from an existing PPM image.
	 * 
	 * @param o existing image
	 * 
	 * @throws NullPointerException if object passed is null
	 * 
	 * @since 1.0
	 */
	public PPM (PPM o) {
		if (o == null)
			throw new NullPointerException("The object passed is null.");
		
		this._width = o._width;
		this._height = o._height;
		this._maxVal = o._maxVal;
		for (int i = 0; i < _width; i++)
			for (int j = 0; j < _height; j++)
				this._pixels[i][j] = o._pixels[i][j];
	}
	
	// Functions from IRGBImageProperties interface
	@Override
	public Pixel pixelAt(int i, int j) {
		return _pixels[i][j];
	}

	@Override
	public void setPixel(int i, int j, Pixel p) {
		_pixels[i][j] = p;
	}

	@Override
	public void setPixel(int i, int j, java.awt.Color c) {
		_pixels[i][j] = new Pixel (c.getRed(), c.getGreen(), c.getBlue()); // here since using color object, assumes max value is 255
	}

	@Override
	public void setPixel(int i, int j, int r, int g, int b) {
		if (_maxVal != MAX_RGB_VALUE)
			_pixels[i][j] = new Pixel (r, g, b, _maxVal);
		else
			_pixels[i][j] = new Pixel (r, g, b);
	}

	@Override
	public int width() {
		return _width;
	}

	@Override
	public int height() {
		return _height;
	}

	@Override
	public int maxValue() {
		return _maxVal;
	}
	
	@Override
	public BufferedImage toBufferedImage () {
		BufferedImage img = new BufferedImage(_width, _height, BufferedImage.TYPE_INT_RGB);
		
		for (int i = 0; i < img.getWidth(); i++)
			for (int j = 0; j < img.getHeight(); j++)
				img.setRGB(i, j, _pixels[i][j].getColor().getRGB());
		
		return img;
	}
}
