package com.archaic.game.components;

public class TechTree {
	private Attributes minAttributes;
	private Attributes maxAttributes;
	private Integer minMaturityAge;
	private Integer maxMaturityAge;
	public TechTree()
	{
		setMinAttributes(new Attributes.Builder().build());
		setMaxAttributes(new Attributes.Builder().
				attribute(Attribute.STRENGTH, 2 * Attributes.DEFAULT_ATTRIBUTE_VALUE).
				attribute(Attribute.CHARISMA, 2 * Attributes.DEFAULT_ATTRIBUTE_VALUE).
				attribute(Attribute.CONSTITUTION, 2 * Attributes.DEFAULT_ATTRIBUTE_VALUE).
				attribute(Attribute.DEXTERITY, 2 * Attributes.DEFAULT_ATTRIBUTE_VALUE).
				attribute(Attribute.FORTITUDE, 2 * Attributes.DEFAULT_ATTRIBUTE_VALUE).
				attribute(Attribute.INTELLIGENCE, 2 * Attributes.DEFAULT_ATTRIBUTE_VALUE).
				attribute(Attribute.LUCK, 2 * Attributes.DEFAULT_ATTRIBUTE_VALUE).
				attribute(Attribute.PERCEPTION, 2 * Attributes.DEFAULT_ATTRIBUTE_VALUE).
				attribute(Attribute.WILLPOWER, 2 * Attributes.DEFAULT_ATTRIBUTE_VALUE).
				attribute(Attribute.WISDOM, 2 * Attributes.DEFAULT_ATTRIBUTE_VALUE).
				build());
		setMinMaturityAge(18);
		setMaxMaturityAge(30);
	}
	public Attributes getMinAttributes() {
		return minAttributes;
	}
	public void setMinAttributes(Attributes minAttributes) {
		this.minAttributes = minAttributes;
	}
	public Attributes getMaxAttributes() {
		return maxAttributes;
	}
	public void setMaxAttributes(Attributes maxAttributes) {
		this.maxAttributes = maxAttributes;
	}
	public Integer getMinMaturityAge() {
		return minMaturityAge;
	}
	public void setMinMaturityAge(Integer minMaturityAge) {
		this.minMaturityAge = minMaturityAge;
	}
	public Integer getMaxMaturityAge() {
		return maxMaturityAge;
	}
	public void setMaxMaturityAge(Integer maxMaturityAge) {
		this.maxMaturityAge = maxMaturityAge;
	}
}
