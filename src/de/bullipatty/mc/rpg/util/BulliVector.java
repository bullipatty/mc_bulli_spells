package de.bullipatty.mc.rpg.util;

import org.bukkit.util.Vector;

public class BulliVector extends org.bukkit.util.Vector {
	
	public BulliVector(Vector v) {
		super();
        setX(v.getX());
        setY(v.getY());
        setZ(v.getZ());
	}
	
	public BulliVector spinV(double a, Vector axis) {
		
		if(a == 0) return this;
		
		normalize();
		Vector v = axis.clone().normalize();
		
		double c = Math.cos(a);
		double s = Math.sin(a);
		double t = 1d-c;
		double n1 = v.getX();
		double n2 = v.getY();
		double n3 = v.getZ();
		
		setX(n1*n1*t+c + n1*n2*t-n3*s + n1*n3*t+n2*s);
		setY(n1*n2*t+n3*s + n2*n2*t+c + n2*n3*t-n1*s);
		setZ(n1*n3*t-n2*s + n2*n3*t+n1*s + n3*n3*t+c);
		
		normalize();
		
		return this;
		
	}
	
	public BulliVector spinTo(double angle, double tollerance, Vector to) {
		
		Vector v = to.clone().normalize();
		float diffence = angle(v);
		
		if(angle == 0 || diffence < tollerance) return this;
		
		if(diffence < angle) angle = diffence;
		v = crossProduct(v);
		BulliVector tmp1 = new BulliVector(this).spinV(angle, v);
		BulliVector tmp2 = new BulliVector(this).spinV(-angle, v);
		if (tmp1.angle(to) <= tmp2.angle(to)) 
			spinV(angle, v);
		else 
			spinV(-angle, v);
		
		return this;
		
	}
	
	public BulliVector spinTo(double m, Vector to) {
		
		double length = this.length();
		Vector v = this.getMidpoint(to).normalize();
		this.normalize().multiply(m).add(v).normalize().multiply(length).setY(v.getY());
		
		return this;
		
	}
	
}
