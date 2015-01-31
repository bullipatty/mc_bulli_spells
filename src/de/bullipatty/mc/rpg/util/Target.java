package de.bullipatty.mc.rpg.util;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

public abstract class Target {

	public static Target get(Entity target) {
		return new EntityTarget(target);
	}

	public static Target get(Location target) {
		return new LocationTarget(target);
	}

	public static Target get(Block target) {
		return new BlockTarget(target);
	}

/*	public static Target get(Object target) {
		Method[] ma = target.getClass().getMethods();
		for(Method m: ma)
			if(m.getName() == "getLocation" && m.getReturnType() == Location.class)
				return new ObjectTarget(target, m);
		return null;
	}
*/
	public abstract Location getLocation();

	private static class EntityTarget extends Target {
		Entity _target;
		public EntityTarget(Entity target) {
			_target = target;
		}
		public Location getLocation() {
			return _target.getLocation();
		}
	}

	private static class LocationTarget extends Target {
		Location _target;
		public LocationTarget(Location target) {
			_target = target;
		}
		public Location getLocation() {
			return _target;
		}
	}

	private static class BlockTarget extends Target {
		Block _target;
		public BlockTarget(Block target) {
			_target = target;
		}
		public Location getLocation() {
			return _target.getLocation();
		}
	}

	/*
	private static class ObjectTarget extends Target {
		Object _target;
		Method _method;
		public ObjectTarget(Object target, Method method) {
			_target = target;
			_method = method;
		}
		public Location getLocation() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
			return (Location) _method.invoke(_target);
		}
	}
	*/
}
