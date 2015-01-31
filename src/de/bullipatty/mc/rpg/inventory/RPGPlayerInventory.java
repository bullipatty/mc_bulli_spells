package de.bullipatty.mc.rpg.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class RPGPlayerInventory extends AlphaInventory implements
		PlayerInventory {
	
	private PlayerInventory _playerInventory = null;

	public RPGPlayerInventory(InventoryHolder owner) {
		super(owner, InventoryType.PLAYER);
		// TODO Auto-generated constructor stub
		_playerInventory = (PlayerInventory) getInventory();
	}

	@Override
	public int clear(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return _playerInventory.clear(arg0, arg1);
	}

	@Override
	public ItemStack[] getArmorContents() {
		// TODO Auto-generated method stub
		return _playerInventory.getArmorContents();
	}

	@Override
	public ItemStack getBoots() {
		// TODO Auto-generated method stub
		return _playerInventory.getBoots();
	}

	@Override
	public ItemStack getChestplate() {
		// TODO Auto-generated method stub
		return _playerInventory.getChestplate();
	}

	@Override
	public int getHeldItemSlot() {
		// TODO Auto-generated method stub
		return _playerInventory.getHeldItemSlot();
	}

	@Override
	public ItemStack getHelmet() {
		// TODO Auto-generated method stub
		return _playerInventory.getHelmet();
	}

	@Override
	public ItemStack getItemInHand() {
		// TODO Auto-generated method stub
		return _playerInventory.getItemInHand();
	}

	@Override
	public ItemStack getLeggings() {
		// TODO Auto-generated method stub
		return _playerInventory.getLeggings();
	}

	@Override
	public void setArmorContents(ItemStack[] arg0) {
		// TODO Auto-generated method stub
		_playerInventory.setArmorContents(arg0);
	}

	@Override
	public void setBoots(ItemStack arg0) {
		// TODO Auto-generated method stub
		_playerInventory.setBoots(arg0);
	}

	@Override
	public void setChestplate(ItemStack arg0) {
		// TODO Auto-generated method stub
		_playerInventory.setChestplate(arg0);
	}

	@Override
	public void setHeldItemSlot(int arg0) {
		// TODO Auto-generated method stub
		_playerInventory.setHeldItemSlot(arg0);
	}

	@Override
	public void setHelmet(ItemStack arg0) {
		// TODO Auto-generated method stub
		_playerInventory.setHelmet(arg0);
	}

	@Override
	public void setItemInHand(ItemStack arg0) {
		// TODO Auto-generated method stub
		_playerInventory.setItemInHand(arg0);
	}

	@Override
	public void setLeggings(ItemStack arg0) {
		// TODO Auto-generated method stub
		_playerInventory.setLeggings(arg0);
	}
	
	@Override
	public HumanEntity getHolder() {
		// TODO Auto-generated method stub
		return (HumanEntity) super.getHolder();
	}

}
