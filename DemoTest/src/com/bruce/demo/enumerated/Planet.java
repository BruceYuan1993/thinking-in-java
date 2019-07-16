package com.bruce.demo.enumerated;

public enum Planet {
	MERCURY(3.302e+23, 2.439E6), 
	VENUS(4.869E+24, 6.052e6), 
	EARTH(5.975e+24, 6.378e6), 
	MARS(6.419e+23, 3.393e6),
	JUPITER(1.899e+27, 7.149e7),
	SATURN(5.685e+26, 6.027e7),
	URANUS(8.683e+25, 2.556e7),
	NEPTUNE(1.024e+26, 2.477e7)
	;
	private final double mass;
	private final double redius;
	private final double surfaceGravity;

	private static final double G = 6.67300E-11;

	Planet(double mass, double redius) {
		this.mass = mass;
		this.redius = redius;
		surfaceGravity = G * mass / (redius * redius);
	}

	public double getMass() {
		return mass;
	}

	public double getRedius() {
		return redius;
	}

	public double getSurfaceGravity() {
		return surfaceGravity;
	}

	public double surfaceWeight(double mass) {
		return mass * surfaceGravity;
	}
	
	public static void main(String[] args) {
		Planet[] planets = Planet.values();
		for (Planet planet : planets) {
			System.out.printf("Weight on %s is %f%n"
					, planet ,planet.surfaceWeight(175.00));
		}
	}
}
