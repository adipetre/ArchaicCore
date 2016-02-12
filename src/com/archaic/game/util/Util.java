package com.archaic.game.util;

import java.util.Random;

public class Util {
	private static final Random rnd = new Random();
	
	public static boolean getRandBool()
	{
		return rnd.nextBoolean();
	}
	
	public static int getRandInt(int maxValue)
	{
		return getRandInt(0, maxValue);
	}
	
	public static int getRandInt(int minPossibleValue, int maxPossibleValue)
	{
		minPossibleValue = Math.abs(minPossibleValue);
		maxPossibleValue = Math.abs(maxPossibleValue);
		if (minPossibleValue > maxPossibleValue)
		{
			int t = minPossibleValue;
			minPossibleValue = maxPossibleValue;
			maxPossibleValue = t;
		}
		return minPossibleValue + rnd.nextInt(maxPossibleValue - minPossibleValue + 1);
	}
	
	public static double getRandDouble()
	{
		return rnd.nextDouble();
	}
}
