package de.bullipatty.mc.rpg.inventory;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class SpellInventory implements Inventory {
	
	private Inventory _inventory = null;
	
	private ItemStack[] _slots = null;
	
	public SpellInventory (InventoryHolder owner, int size) {
		_inventory = Bukkit.createInventory(owner, size, "SpellInventory");
		_slots = new ItemStack[size];
	}

	@Override
	public HashMap<Integer, ItemStack> addItem(ItemStack... arg0)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return _inventory.addItem(arg0);
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(int arg0) {
		// TODO Auto-generated method stub
		return _inventory.all(arg0);
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(Material arg0)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return _inventory.all(arg0);
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(ItemStack arg0) {
		// TODO Auto-generated method stub
		return _inventory.all(arg0);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		_slots = new ItemStack[_inventory.getSize()];
		_inventory.clear();
	}

	@Override
	public void clear(int arg0) {
		// TODO Auto-generated method stub
		_slots[arg0] = null;
		_inventory.clear(arg0);
	}

	@Override
	public boolean contains(int arg0) {
		// TODO Auto-generated method stub
		return _inventory.contains(arg0);
	}

	@Override
	public boolean contains(Material arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return _inventory.contains(arg0);
	}

	@Override
	public boolean contains(ItemStack arg0) {
		// TODO Auto-generated method stub
		return _inventory.contains(arg0);
	}

	@Override
	public boolean contains(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return _inventory.contains(arg0, arg1);
	}

	@Override
	public boolean contains(Material arg0, int arg1)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return _inventory.contains(arg0, arg1);
	}

	@Override
	public boolean contains(ItemStack arg0, int arg1) {
		// TODO Auto-generated method stub
		return _inventory.contains(arg0, arg1);
	}

	@Override
	public boolean containsAtLeast(ItemStack arg0, int arg1) {
		// TODO Auto-generated method stub
		return _inventory.contains(arg0, arg1);
	}

	@Override
	public int first(int arg0) {
		// TODO Auto-generated method stub
		return _inventory.first(arg0);
	}

	@Override
	public int first(Material arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return _inventory.first(arg0);
	}

	@Override
	public int first(ItemStack arg0) {
		// TODO Auto-generated method stub
		return _inventory.first(arg0);
	}

	@Override
	public int firstEmpty() {
		// TODO Auto-generated method stub
		return _inventory.firstEmpty();
	}

	@Override
	public ItemStack[] getContents() {
		// TODO Auto-generated method stub
		return _inventory.getContents();
	}

	@Override
	public InventoryHolder getHolder() {
		// TODO Auto-generated method stub
		return _inventory.getHolder();
	}

	@Override
	public ItemStack getItem(int arg0) {
		// TODO Auto-generated method stub
		if(_slots[arg0] != null)
			return _slots[arg0];
		return _inventory.getItem(arg0);
	}

	@Override
	public int getMaxStackSize() {
		// TODO Auto-generated method stub
		return _inventory.getMaxStackSize();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return _inventory.getName();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return _inventory.getSize();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return _inventory.getTitle();
	}

	@Override
	public InventoryType getType() {
		// TODO Auto-generated method stub
		return _inventory.getType();
	}

	@Override
	public List<HumanEntity> getViewers() {
		// TODO Auto-generated method stub
		return _inventory.getViewers();
	}

	@Override
	public ListIterator<ItemStack> iterator() {
		// TODO Auto-generated method stub
		return _inventory.iterator();
	}

	@Override
	public ListIterator<ItemStack> iterator(int arg0) {
		// TODO Auto-generated method stub
		return _inventory.iterator(arg0);
	}

	@Override
	public void remove(int arg0) {
		// TODO Auto-generated method stub
		_inventory.remove(arg0);
	}

	@Override
	public void remove(Material arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		_inventory.remove(arg0);
	}

	@Override
	public void remove(ItemStack arg0) {
		// TODO Auto-generated method stub
		_inventory.remove(arg0);
	}

	@Override
	public HashMap<Integer, ItemStack> removeItem(ItemStack... arg0)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return _inventory.removeItem(arg0);
	}

	@Override
	public void setContents(ItemStack[] arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		_inventory.setContents(arg0);
	}

	@Override
	public void setItem(int arg0, ItemStack arg1) {
		// TODO Auto-generated method stub
		_inventory.setItem(arg0, arg1);
	}

	@Override
	public void setMaxStackSize(int arg0) {
		// TODO Auto-generated method stub
		_inventory.setMaxStackSize(arg0);
	}

}
