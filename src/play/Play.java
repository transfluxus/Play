package play;

import java.util.HashMap;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Play {

	private static PApplet parent;

	public static float ellipseA;
	public static float ellipseB;
	public static float circleDia;
	public static float squareSide;

	public static HashMap<String, PImage> imgs = new HashMap<>();

	public Play() {
	}

	public static Play start(PApplet ap) {
		parent = ap;
		return new Play();
	}

	public static PVector randPoint() {
		return new PVector(parent.width, parent.height);
	}

	public static void ellipse(PVector mid) {
		ellipse(mid.x, mid.y);
	}

	public static void ellipse(float x, float y) {
		parent.ellipse(x, y, ellipseA, ellipseB);
	}

	public static void ellipse(PVector mid, float a, float b) {
		ellipse(mid.x, mid.y, a, b);
	}

	public static void ellipse(float x, float y, float a, float b) {
		ellipseA = a;
		ellipseB = b;
		parent.ellipse(x, y, a, b);
	}

	public static void ellipseRot(PVector mid, float angle) {
		ellipseRot(mid.x, mid.y, angle);
	}

	public static void ellipseRot(float x, float y, float angle) {
		parent.pushMatrix();
		parent.translate(x, y);
		parent.rotate(angle);
		parent.ellipse(0, 0, ellipseA, ellipseB);
		parent.popMatrix();
	}

	public static void ellipseRot(PVector mid, float a, float b, float angle) {
		ellipseRot(mid.x, mid.y, a, b, angle);
	}

	public static void ellipseRot(float x, float y, float a, float b,
			float angle) {
		ellipseA = a;
		ellipseB = b;
		parent.pushMatrix();
		parent.translate(x, y);
		parent.rotate(angle);
		parent.ellipse(0, 0, ellipseA, ellipseB);
		parent.popMatrix();
	}

	public static void circle(PVector mid, float dia) {
		circle(mid.x, mid.y, dia);
	}

	public static void circle(float x, float y, float dia) {
		circleDia = dia;
		parent.ellipse(x, y, dia, dia);
	}

	public static void circle(PVector mid) {
		circle(mid.x, mid.y);
	}

	public static void circle(float x, float y) {
		parent.ellipse(x, y, circleDia, circleDia);
	}

	public static void square(PVector p, float side) {
		square(p.y, p.y, side);
	}

	public static void square(float x, float y, float side) {
		squareSide = side;
		parent.rect(x, y, side, side);
	}

	public static void square(PVector p) {
		square(p.x, p.y);
	}

	public static void square(float x, float y) {
		parent.rect(x, y, squareSide, squareSide);
	}

	public static PVector center() {
		return new PVector(parent.width / 2, parent.height / 2);
	}

	public static void line(PVector a, PVector b) {
		parent.line(a.x, a.y, b.x, b.y);
	}

	public static void triangle(PVector a, PVector b, PVector c) {
		parent.triangle(a.x, a.y, b.x, b.y, c.x, c.y);
	}

	public static void bezier(PVector a, PVector b, PVector c, PVector d) {
		parent.bezier(a.x, a.y, b.x, b.y, c.x, c.y, d.x, d.y);
	}

	public static void quad(PVector a, PVector b, PVector c, PVector d) {
		parent.quad(a.x, a.y, b.x, b.y, c.x, c.y, d.x, d.y);
	}

	public static PVector randomCorner() {
		int p = (int) parent.random(4);
		switch (p) {
		case 0:
			return new PVector(0, 0);
		case 1:
			return new PVector(parent.width, 0);
		case 2:
			return new PVector(parent.width, parent.height);
		case 3:
		default:
			return new PVector(0, parent.height);
		}
	}

	public static PVector mousePos() {
		return new PVector(parent.mouseX, parent.mouseY);
	}

	public static void point(PVector pos) {
		parent.point(pos.x, pos.y);
	}

	public static void fade(int color) {
		parent.fill(color);
		parent.rect(-10, -10, parent.width + 10, parent.height + 10);
	}

	public static void fade(int color, int strength) {
		parent.fill(parent.red(color), parent.green(color), parent.blue(color),
				strength);
		parent.rect(-10, -10, parent.width + 10, parent.height + 10);
	}

	public static void size(int sqSize) {
		parent.size(sqSize, sqSize);
	}

	public static PVector vec(float x, float y) {
		return new PVector(x, y);
	}

	public static void shape(PVector... ps) {
		parent.beginShape();
		for (PVector p : ps)
			parent.vertex(p.x, p.y);
		parent.endShape(PApplet.CLOSE);
	}

	public static PVector lerp(PVector a, PVector b, float amt) {
		return lerp(a.x, a.y, b.x, b.y, amt);
	}

	public static PVector lerp(float x1, float y1, float x2, float y2, float amt) {
		return new PVector(PApplet.lerp(x1, x2, amt), PApplet.lerp(y2, y2, amt));
	}

	public static PVector fromAngle(float ang, float length) {
		PVector p = PVector.fromAngle(ang);
		p.mult(length);
		return p;
	}

	public static PVector fromAngle(PVector rel, float ang, float length) {
		PVector p = PVector.fromAngle(ang);
		p.mult(length);
		p.add(rel.x, rel.y, rel.z);
		return p;
	}

	public static float angleTo(PVector from, PVector to) {
		float a = PVector
				.angleBetween(new PVector(1, 0), PVector.sub(to, from));
		if (to.y < from.y)
			a = PApplet.TAU - a;
		return a;
	}

	public static PVector randomLineP(PVector a, PVector b) {
		return randomLineP(a.x, a.y, b.x, b.y);
	}

	public static PVector randomLineP(float x1, float y1, float x2, float y2) {
		return lerp(x1, y1, x2, y2, random());
	}

	public static PVector randomRectP(PVector p, float width, float height) {
		return randomRectP(p.x, p.y, width, height);
	}

	public static PVector randomRectP(float x, float y, float width,
			float height) {
		return new PVector(parent.random(x, x + width), parent.random(y, y
				+ height));
	}

	public static float random() {
		return parent.random(1);
	}

	private static PImage getImage(String imgName) {
		if (imgs.containsKey(imgName))
			return imgs.get(imgName);
		else
			return imgs.put(imgName, parent.loadImage(imgName));
	}

	public static void image(String imgName, PVector pos, float width,
			float height) {
		PImage img = getImage(imgName);
		parent.image(img, pos.x, pos.y, width, height);
	}

	public static void image(String imgName, PVector pos) {
		PImage img = getImage(imgName);
		parent.image(img, pos.x, pos.y);
	}

}
