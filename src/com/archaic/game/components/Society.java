package com.archaic.game.components;

import java.util.LinkedHashSet;
import java.util.Set;

import com.archaic.game.living.Animal;

public class Society {
	private Set<Animal> members;
	private TechTree techTree;
	
	
	public Society ()
	{
		members = new LinkedHashSet<Animal>();
		techTree = new TechTree();
		
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
	
	public TechTree getTechsTree()
	{
		return techTree;
	}
	
}
