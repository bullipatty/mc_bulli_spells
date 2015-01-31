package de.bullipatty.mc.rpg.item.equip.materia.magic;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.bullipatty.mc.rpg.item.equip.skill.Skill;
import de.bullipatty.mc.rpg.item.equip.skill.ThunderSkill;

public class ThunderMateria extends MagicMateria {

	protected ThunderMateria(Player owner) {
		super(Material.ENDER_PEARL, owner);
	}
	
	public static ThunderMateria get(Player owner) {
		return new ThunderMateria(owner);
	}
	
	@Override
	public String getName() {
		return "Blitz Orb";
	}

	@Override
	public Skill getSkill(Player owner) {
		return ThunderSkill.get(owner); 
	}
	
}
