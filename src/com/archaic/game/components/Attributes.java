package com.archaic.game.components;

import java.util.EnumMap;
import java.util.Map;

import com.archaic.game.util.Util;

public class Attributes {
	private Map<Attribute, Integer> attributes = new EnumMap<Attribute,Integer>(Attribute.class);
	
	private static final Integer ATTRIBUTE_STEP_VALUE = 1000;
	public static final Integer DEFAULT_ATTRIBUTE_VALUE = 10 * ATTRIBUTE_STEP_VALUE;
	public static class Builder {
		private Map<Attribute, Integer> attributes;
		
		public Builder() {
			attributes = new EnumMap<Attribute,Integer>(Attribute.class);
			for(Attribute attr : Attribute.values())
			{
				attributes.put(attr, DEFAULT_ATTRIBUTE_VALUE);
			}
		}
		public Builder attribute(Attribute attr, Integer value)
		{
			attributes.put(attr, value);
			return this;
		}
		
		public Attributes build()
		{
			return new Attributes(this);
		}
		
		public Attributes buildInRange(Attributes first, Attributes second)
		{
			for(Attribute attr : Attribute.values())
			{
				int attrValue = Util.getRandInt(first.getAttribute(attr), second.getAttribute(attr)) / ATTRIBUTE_STEP_VALUE
						* ATTRIBUTE_STEP_VALUE;
				attributes.put(attr, attrValue);
			}
			return build();
		}
	}
	
	private Attributes(Builder builder) {
		attributes.putAll(builder.attributes);
	}
	
	public int getAttribute(Attribute attribute)
	{
		return attributes.get(attribute);
	}
	
	public void setAttribute(Attribute attribute, int value)
	{
		attributes.put(attribute, value);
	} 
}
