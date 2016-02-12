package com.archaic.game.components;

import com.archaic.game.util.Util;

public enum Gender {
	MALE,
	FEMALE;
	
	// the ratio of males to total population.
	// higher chances for a male to be born if this ratio is smaller than 0.5
	public static Gender getGender( double ratio)
	{
		if (Util.getRandDouble() < ratio) return FEMALE;
		return MALE;
	}
	
	public boolean isMale()
	{
		return this.equals(MALE);
	}
	
	public boolean isFemale()
	{
		return this.equals(FEMALE);
	}
}
