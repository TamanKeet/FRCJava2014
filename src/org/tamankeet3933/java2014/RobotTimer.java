package org.tamankeet3933.java2014;

/**
 * 
 * @author Taman Keet
 *
 */
public class RobotTimer
{
	private long ElapsedGameTime;
	private long MillisecondsPerFrame;
	private int CurrentFrame;
	private long InitialTime;
	private long Time1;
	private long Time2;
	
	/**
	 * Basic constructor that has to be created at the beginning of the program. Time
	 * since the beginning of the program is calculated since the call of this
	 * constructor.
	 */
	public RobotTimer()
	{
		ElapsedGameTime = 0;
		MillisecondsPerFrame = 0;
		CurrentFrame = 0;
		InitialTime = System.currentTimeMillis();
		Time1 = System.currentTimeMillis();
		Time2 = Time1;
	}
	//This are the getter methods
	
	/**
	 * Getter method for Current Frame
	 * @return The current frame (first frame in the game being 0)
	 */
	public int getCurrentFrame()
	{
		return CurrentFrame;
	}
	
	/**
	 * Gives you the milliseconds per frame that is calculated with the last two calls of Update()
	 * @return The time difference in milliseconds between the last two calls of Update()
	 */
	public long getMillisecondsPerFrame()
	{
		return MillisecondsPerFrame;
	}
	
	/**
	 * Gets the length of the running program
	 * @return The time the program has been running in milliseconds
	 */
	public long getElapsedGameTime()
	{
		return ElapsedGameTime;
	}
	
	/**
	 * It has to be called at the begining of a program loop
	 */
	public void Update()
	{
		Time2 = System.currentTimeMillis();
		CurrentFrame++;
		ElapsedGameTime = System.currentTimeMillis() - InitialTime;
		MillisecondsPerFrame = Math.abs(Time1 - Time2);
		Time1 = System.currentTimeMillis();
	}
	
	public boolean equals(Object objectTwo)
	{
		RobotTimer robotTime2 = (RobotTimer)objectTwo;
		return robotTime2.toString() == toString();
	}
	
	public String toString()
	{
		return "Elapsed Time: " + ElapsedGameTime + 
				"\nMilliseconds Per Frame = " + MillisecondsPerFrame + 
				"\nCurrent Frame: " + CurrentFrame;
	}
}
