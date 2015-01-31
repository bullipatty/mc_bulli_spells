package de.bullipatty.mc.rpg.item.equip.weapon;

import org.bukkit.Material;

import de.bullipatty.mc.rpg.item.equip.Slotted;

public abstract class Weapon extends Slotted {

	public Weapon(Material material) {
		super(material);
		// TODO Auto-generated constructor stub
	}
	
	public int getDamage() {
		return 0;
	}

}
