package de.bullipatty.mc.rpg.item.equip.skill;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.bullipatty.mc.rpg.item.Item;

public abstract class Skill extends Item {

	protected Skill(Material material, Player owner) {
		super(material, owner);
	}

}
