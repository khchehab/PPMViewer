package common;

/**
 * A class representing an RGB pixel in an image.
 * 
 * @author Khaled Chehab <khchehab@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Pixel {
	// Constant(s)
	/**
	 * Default maximum RGB value.
	 * 
	 * The default maximum RGB value.
	 * 
	 * @since 1.0
	 */
	public static final int DEFAULT_MAX_RGB_VALUE = 255;
	
	// Instance Fields
	private int _r;
	private int _g;
	private int _b;
	private int _maxVal;
	
	/**
	 * Constructs an empty pixel.
	 * 
	 * Constructs an empty pixel, that initializes the RGB values to 0.
	 * 
	 * @since 1.0
	 */
	public Pixel () {
		_r = 0;
		_g = 0;
		_b = 0;
		_maxVal = DEFAULT_MAX_RGB_VALUE;
	}
	
	/**
	 * Constructs a pixel.
	 * 
	 * Constructs a pixel, initialized to the RGB values.
	 * 
	 * @param r red value
	 * @param g green value
	 * @param b blue value
	 * 
	 * @throws IllegalArgumentException if any of the RGB values are out of bound
	 * 
	 * @since 1.0
	 */
	public Pixel (int r, int g, int b) {
		if (r > DEFAULT_MAX_RGB_VALUE)
			throw new IllegalArgumentException("Red value is out of bounds. (Greater than the maximum allowed value : " + DEFAULT_MAX_RGB_VALUE + ").");
		if (g > DEFAULT_MAX_RGB_VALUE)
			throw new IllegalArgumentException("Green value is out of bounds. (Greater than the maximum allowed value : " + DEFAULT_MAX_RGB_VALUE + ").");
		if (b > DEFAULT_MAX_RGB_VALUE)
			throw new IllegalArgumentException("Blue value is out of bounds. (Greater than the maximum allowed value : " + DEFAULT_MAX_RGB_VALUE + ").");
		
		_r = r;
		_g = g;
		_b = b;
		_maxVal = DEFAULT_MAX_RGB_VALUE;
	}
	
	/**
	 * Constructs a pixel.
	 * 
	 * Constructs a pixel, initialized to the RGB value and with a maximum value for the RGB value.
	 * 
	 * @param r red value
	 * @param g green value
	 * @param b blue value
	 * @param maxValue maximum RGB values
	 * 
	 * @throws IllegalArgumentException if any of the RGB values are out of bound
	 * 
	 * @since 1.0
	 */
	public Pixel (int r, int g, int b, int maxValue) {
		if (r > maxValue)
			throw new IllegalArgumentException("Red value is out of bounds. (Greater than the maximum allowed value : " + maxValue + ").");
		if (g > maxValue)
			throw new IllegalArgumentException("Green value is out of bounds. (Greater than the maximum allowed value : " + maxValue + ").");
		if (b > maxValue)
			throw new IllegalArgumentException("Blue value is out of bounds. (Greater than the maximum allowed value : " + maxValue + ").");
		
		_r = r;
		_g = g;
		_b = b;
		_maxVal = maxValue;
	}
	
	/**
	 * Constructs new pixel from existing pixel.
	 * 
	 * Constructs a new pixel from an existing pixel, copying its RGB values and maximum RGB value.
	 * 
	 * @param o existing pixel
	 * 
	 * @throws NullPointerException if the passed object is null
	 * 
	 * @since 1.0
	 */
	public Pixel (Pixel o) {
		if (o == null)
			throw new NullPointerException("The object passed is a null object.");
		
		this._r = o._r;
		this._g = o._g;
		this._b = o._b;
		this._maxVal = o._maxVal;
	}
	
	/**
	 * Returns the red value of the pixel.
	 * 
	 * Returns the red value of the pixel.
	 * 
	 * @return red value of pixel
	 * 
	 * @since 1.0
	 */
	public int red () {
		return _r;
	}
	
	/**
	 * Returns the green value of the pixel.
	 * 
	 * Returns the green value of the pixel.
	 * 
	 * @return green value of pixel
	 * 
	 * @since 1.0
	 */
	public int green () {
		return _g;
	}
	
	/**
	 * Returns the blue value of the pixel.
	 * 
	 * Returns the blue value of the pixel.
	 * 
	 * @return blue value of pixel
	 * 
	 * @since 1.0
	 */
	public int blue () {
		return _b;
	}
	
	/**
	 * Returns the color of the pixel.
	 * 
	 * Returns the color of the pixel in a Color object.
	 * 
	 * @return color of the pixel
	 * 
	 * @since 1.0
	 */
	public java.awt.Color getColor () {
		return new java.awt.Color (_r, _g, _b);
	}
	/**
	 * Returns the string representation of the pixel.
	 * 
	 * Returns the string representation of the pixel, the format is "(red, green, blue)".
	 * 
	 * @returns string representation of the pixel
	 * 
	 * @since 1.0
	 */
	public String toString () {
		return "(" + _r + ", " + _g + ", " + _b + ")";
	}
}