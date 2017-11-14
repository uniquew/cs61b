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
	}
	public Planet (Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		imgFileName = p.imgFileName;		
	}

	public double calcDistance(Planet p) {
		double dx = Math.abs(this.xxPos - p.xxPos);
		double dy = Math.abs(this.yyPos - p.yyPos);
		double r_2 = Math.pow(dx, 2) + Math.pow(dy, 2);
		return Math.sqrt(r_2);
	}
}
