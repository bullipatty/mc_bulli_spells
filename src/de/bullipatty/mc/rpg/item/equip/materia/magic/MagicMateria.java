package de.bullipatty.mc.rpg.item.equip.materia.magic;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import de.bullipatty.mc.rpg.item.equip.materia.Materia;
import de.bullipatty.mc.rpg.item.equip.skill.Skill;

public abstract class MagicMateria extends Materia{
	
	protected MagicMateria(Material material, Player owner) {
		super(material, owner);
	}

	public abstract Skill getSkill(Player owner);
}
