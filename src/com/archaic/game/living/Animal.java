package com.archaic.game.living;

import com.archaic.game.components.Attributes;
import com.archaic.game.components.Gender;
import com.archaic.game.components.Society;

public class Animal {
	private static final int AGE_NEWBORN = 1;
	private Attributes attributes;
	private int age;
	private Gender gender;
	private Society society;

	public static class Builder {
		private Attributes attributes;
		private int age;
		private Gender gender;
		private Society society;
		public Builder() {
			attributes = new Attributes.Builder().build();
		}
		public Builder setAttributes(Attributes attributes)
		{
			this.attributes = attributes;
			return this;
		}
		
		public Builder setGender(Gender gender) {
			this.gender = gender;
			return this;
		}

		public Animal create()
		{
			return new Animal(this);
		}
		
		public Builder createChild(Society society)
		{
			this.age = AGE_NEWBORN;
			this.society = society;
			this.gender = Gender.getGender(society.getMemberSexRatio());
			Attributes raceattributes = new Attributes.Builder().
					buildInRange(society.getTechsTree().getMinAttributes(), society.getTechsTree().getMaxAttributes());
			this.attributes = new Attributes.Builder().
					buildInRange(raceattributes, attributes);
			return this;
		}
		
		public Builder createChild(Society society, Animal mother, Animal father)
		{
			if (mother.getGender() != father.getGender())
			{
				this.attributes = new Attributes.Builder().
						buildInRange(mother.getAttributes(), father.getAttributes());
				return createChild(society);
			}
			//this really shouldn't be the case - how did this happen?
			return createChild(society);
		}
	}
	private Animal(Builder builder) {
		this.setAttributes(builder.attributes);
		this.setAge(builder.age);
		this.setGender(builder.gender);
		this.society = builder.society;
		
	}
	public Society getSociety() {
		return society;
	}
	public void setSociety(Society society) {
		if (this.society!=society && this.society!=null)
			this.society.removeMember(this);
		this.society = society;
	}
	public void clearSociety() {
		society = null;
		
	}
	public Gender getGender() {
		return gender;
	}
	private void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
}
