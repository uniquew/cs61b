public class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		imgFileName = img;
		mass = m;
	}
	public Planet (Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		imgFileName = p.imgFileName;		
	}

	public double calcDistance(Planet p) {
		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;
		double r_2 = Math.pow(dx, 2) + Math.pow(dy, 2);
		return Math.sqrt(r_2);
	}

	public double calcForceExertedBy(Planet p) {
		double r = calcDistance(p);
		double f = 6.67e-11 * this.mass * p.mass / Math.pow(r, 2);
		return f;
	}

	public double calcForceExertedByX(Planet p) {
		double dx = p.xxPos - this.xxPos;
		double fx = calcForceExertedBy(p) * dx / calcDistance(p);
		return fx;
	}

	public double calcForceExertedByY(Planet p) {
		double dy = p.yyPos - this.yyPos;
		double fy = calcForceExertedBy(p) * dy / calcDistance(p);
		return fy;
	}

	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double netX = 0;
		for (Planet p : allPlanets) {
			if (!this.equals(p)) {
				netX += calcForceExertedByX(p);
			}
		}
		return netX;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double netY = 0;
		for (Planet p : allPlanets) {
			if (!this.equals(p)) {
				netY += calcForceExertedByY(p);
			}
		}
		return netY;
	}

	public void update(double dt, double xForce, double yForce) {
		double ax = xForce / this.mass;
		double ay = yForce / this.mass;
		double vx = this.xxVel + dt * ax;
		double vy = this.yyVel + dt * ay;
		double xPos = this.xxPos + dt * vx;
		double yPos = this.yyPos + dt * vy;
		this.xxVel = vx;
		this.yyVel = vy;
		this.xxPos = xPos;
		this.yyPos = yPos;
	}
}

