package de.bullipatty.mc.rpg.util;

import org.bukkit.Material;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class SpellRecipe extends ShapelessRecipe{
	
	private ItemStack _result = new ItemStack(Material.BOOK_AND_QUILL);

	public SpellRecipe(ItemStack result) {
		super(result);
		addIngredient(Material.BOOK);
		addIngredient(Material.BOOK_AND_QUILL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack getResult() {
		// TODO Auto-generated method stub
		return _result;
	}
	

	public void setResultFor(CraftingInventory inv) {
		// TODO Auto-generated method stub
	}

}
