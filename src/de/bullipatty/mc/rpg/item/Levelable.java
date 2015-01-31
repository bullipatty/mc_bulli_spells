package de.bullipatty.mc.rpg.item;

import org.bukkit.inventory.ItemStack;

public abstract class Levelable extends Item {
	
	@SuppressWarnings("unused")
	private long _exp = 0;
	private long _expToNext = 0;
	private int _lvl = 0;

	public Levelable(ItemStack item) {
		super(item);
	}
	
	public void addExp(long amount) {
		_exp += amount;
		_expToNext -= amount;
		long expToNext = getExpToLvl(_lvl+1);
		if(_expToNext<0 && expToNext != 0) {
			_lvl++;
			_expToNext += expToNext;
		}
		else if(expToNext == 0) {
			_expToNext = 0;
		}
			
	}
	
	public abstract long getExpToLvl(int lvl);
	
}
