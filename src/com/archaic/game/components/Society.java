package com.archaic.game.components;

import java.util.LinkedHashSet;
import java.util.Set;

import com.archaic.game.living.Animal;

public class Society {
	private Set<Animal> members;
	private Attributes minAttributes;
	private Attributes maxAttributes;
	
	public Society ()
	{
		members = new LinkedHashSet<Animal>();
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
	}
	
	public Set<Animal> getMembers()
	{			
		return members;
	}
	
	public void addMember(Animal animal)
	{			
		members.add(animal);
		animal.setSociety(this);
	}
	public void removeMember(Animal animal)
	{
		
		members.remove(animal);
		animal.clearSociety();
	}
	
	public int getMembersSize()
	{
		return members.size();
	}
	
	// returns ratio of males to total population
	public double getMemberSexRatio()
	{
		if (members == null || getMembersSize() < 1) return 0;
		int males = 0;
		for (Animal member : members)
		{
			if (member.getGender().isMale())
				males++;
		}
		return (double)males / getMembersSize();
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
}
