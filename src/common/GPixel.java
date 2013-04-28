package common;

/**
 * A class representing a grey pixel in an image.
 * 
 * @author Khaled Chehab <khchehab@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class GPixel {
	// Constant(s)
	/**
	 * Default maximum grey value.
	 * 
	 * The default maximum grey value.
	 * 
	 * @since 1.0
	 */
	public static final int DEFAULT_MAX_GREY_VALUE = 255;
	
	// Instance Fields
	private int _g;
	private int _maxVal;
	
	/**
	 * Constructs an empty pixel.
	 * 
	 * Constructs an empty pixel, that initializes the grey values to 0.
	 * 
	 * @since 1.0
	 */
	public GPixel () {
		_g = 0;
		_maxVal = DEFAULT_MAX_GREY_VALUE;
	}
	
	/**
	 * Constructs a pixel.
	 * 
	 * Constructs a pixel, initialized to the grey values.
	 * 
	 * @param g grey value
	 * 
	 * @throws IllegalArgumentException if any of the grey values are out of bound
	 * 
	 * @since 1.0
	 */
	public GPixel (int g) {
		if (g > DEFAULT_MAX_GREY_VALUE)
			throw new IllegalArgumentException("Grey value is out of bounds. (Greater than the maximum allowed value : " + DEFAULT_MAX_GREY_VALUE + ").");
		
		_g = g;
		_maxVal = DEFAULT_MAX_GREY_VALUE;
	}
	
	/**
	 * Constructs a pixel.
	 * 
	 * Constructs a pixel, initialized to the grey value and with a maximum value for the grey value.
	 * 
	 * @param g grey value
	 * @param maxValue maximum grey values
	 * 
	 * @throws IllegalArgumentException if any of the grey values are out of bound
	 * 
	 * @since 1.0
	 */
	public GPixel (int g, int maxValue) {
		if (g > maxValue)
			throw new IllegalArgumentException("Grey value is out of bounds. (Greater than the maximum allowed value : " + maxValue + ").");
		
		_g = g;
		_maxVal = maxValue;
	}
	
	/**
	 * Constructs new pixel from existing pixel.
	 * 
	 * Constructs a new pixel from an existing pixel, copying its grey values and maximum grey value.
	 * 
	 * @param o existing pixel
	 * 
	 * @throws NullPointerException if the passed object is null
	 * 
	 * @since 1.0
	 */
	public GPixel (GPixel o) {
		if (o == null)
			throw new NullPointerException("The object passed is a null object.");
		
		this._g = o._g;
		this._maxVal = o._maxVal;
	}
	
	/**
	 * Returns the grey value of the pixel.
	 * 
	 * Returns the grey value of the pixel.
	 * 
	 * @return grey value of pixel
	 * 
	 * @since 1.0
	 */
	public int grey () {
		return _g;
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
		return new java.awt.Color (_g, _g, _g);
	}
	/**
	 * Returns the string representation of the pixel.
	 * 
	 * Returns the string representation of the pixel, the format is "(grey)".
	 * 
	 * @returns string representation of the pixel
	 * 
	 * @since 1.0
	 */
	public String toString () {
		return "(" + _g + ")";
	}
}