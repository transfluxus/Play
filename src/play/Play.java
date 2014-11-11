package play;

import java.util.HashMap;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

/**
 * Play makes stuff easier
 * 
 * @author Ramin
 *
 */
public class Play {

	private static PApplet parent;

	private static float ellipseA;
	private static float ellipseB;
	private static float circleDia;
	private static float squareSide;

	private static HashMap<String, PImage> imgs = new HashMap<>();

	/**
	 * Initialize Play with this method
	 * 
	 * @param ap
	 *            pass your sketch like usual with 'this'
	 * @return a Play object(not necessary tho)
	 */
	public static Play start(PApplet ap) {
		parent = ap;
		return new Play();
	}

	/**
	 * A random point in the frame
	 * 
	 * @return a random PVector
	 */
	public static PVector randPoint() {
		return new PVector(parent.width, parent.height);
	}

	/**
	 * lazy ellipse draw. Uses the previously set a,b
	 * 
	 * @param pos
	 *            position to draw
	 */
	public static void ellipse(PVector pos) {
		ellipse(pos.x, pos.y);
	}

	/**
	 * lazy ellipse draw. Uses the previously set a,b
	 * 
	 * @param x
	 *            x-coordinate
	 * @param y
	 *            y-coordinate
	 */
	public static void ellipse(float x, float y) {
		parent.ellipse(x, y, ellipseA, ellipseB);
	}

	/**
	 * draws an ellipse Sets a,b for lazy repeat
	 * 
	 * @param pos
	 *            position
	 * @param a
	 *            a
	 * @param b
	 *            b
	 */
	public static void ellipse(PVector pos, float a, float b) {
		ellipse(pos.x, pos.y, a, b);
	}

	/**
	 * Sets a,b for lazy repeat
	 * 
	 * @param x
	 *            x-position
	 * @param y
	 *            y-position
	 * @param a
	 *            a
	 * @param b
	 *            b
	 */
	public static void ellipse(float x, float y, float a, float b) {
		ellipseA = a;
		ellipseB = b;
		parent.ellipse(x, y, a, b);
	}

	/**
	 * Draws a rotated ellipse. Uses the previously defined a,b.
	 * 
	 * @param pos
	 *            ellipse position
	 * @param angle
	 *            rotation angle
	 */
	public static void ellipseRot(PVector pos, float angle) {
		ellipseRot(pos.x, pos.y, angle);
	}

	/**
	 * Draws a rotated ellipse. Also uses the previously defined a,b.
	 * 
	 * @param x
	 *            x-position
	 * @param y
	 *            y-position
	 * @param angle
	 *            rotation angle
	 */
	public static void ellipseRot(float x, float y, float angle) {
		parent.pushMatrix();
		parent.translate(x, y);
		parent.rotate(angle);
		parent.ellipse(0, 0, ellipseA, ellipseB);
		parent.popMatrix();
	}

	/**
	 * Draws a rotated ellipse.Sets the a,b for lazy repeat
	 * 
	 * @param pos
	 *            ellipse position
	 * @param angle
	 *            rotation angle
	 */

	public static void ellipseRot(PVector mid, float a, float b, float angle) {
		ellipseRot(mid.x, mid.y, a, b, angle);
	}

	/**
	 * Draws a rotated ellipse.Sets the a,b for lazy repeat
	 * 
	 * @param x
	 *            x-position
	 * @param y
	 *            y-position
	 * @param a
	 *            a
	 * @param b
	 *            b
	 * @param angle
	 *            rotation angle
	 */
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

	/**
	 * Draws a circle at the given position. Sets the diameter for lazy repeat
	 * 
	 * @param pos
	 *            position of the circle
	 * @param dia
	 *            diameter(or radius,... depends on the ellipseMode)
	 */
	public static void circle(PVector pos, float dia) {
		circle(pos.x, pos.y, dia);
	}

	/**
	 * Draws a circle at the given position. Sets the diameter for lazy repeat
	 * 
	 * 
	 * @param x
	 *            x-position
	 * @param y
	 *            y-position
	 * @param dia
	 *            diameter(or radius,... depends on the ellipseMode)
	 */
	public static void circle(float x, float y, float dia) {
		circleDia = dia;
		parent.ellipse(x, y, dia, dia);
	}

	/**
	 * Draws a circle at the given position. Uses the previously set diameter
	 * 
	 * @param pos
	 *            position
	 */
	public static void circle(PVector pos) {
		circle(pos.x, pos.y);
	}

	/**
	 * Draws a circle at the given position. Uses the previously set diameter
	 * 
	 * @param x
	 *            x-position
	 * @param y
	 *            y-position
	 */
	public static void circle(float x, float y) {
		parent.ellipse(x, y, circleDia, circleDia);
	}

	/**
	 * Draws a square at the given position. Sets the square side length for
	 * lazy repeat
	 * 
	 * @param p
	 *            The position
	 * @param side
	 *            sidelength
	 */
	public static void square(PVector p, float side) {
		square(p.y, p.y, side);
	}

	/**
	 * Draws a square at the given position.Sets the square side length for lazy
	 * repeat
	 * 
	 * @param x
	 *            x-position
	 * @param y
	 *            y-position
	 * @param side
	 *            sidelength
	 */
	public static void square(float x, float y, float side) {
		squareSide = side;
		parent.rect(x, y, side, side);
	}

	/**
	 * Draws a square at the given position. Uses the previously set sidelength
	 * 
	 * @param p
	 *            position
	 */
	public static void square(PVector p) {
		square(p.x, p.y);
	}

	/**
	 * Draws a square at the given position. Uses the previously set sidelength
	 * 
	 * @param x
	 *            x-position
	 * @param y
	 *            y-position
	 */
	public static void square(float x, float y) {
		parent.rect(x, y, squareSide, squareSide);
	}

	/**
	 * The center of the frame
	 * 
	 * @return center as a PVector
	 */
	public static PVector center() {
		return new PVector(parent.width / 2, parent.height / 2);
	}

	/**
	 * Draws a line from a to b
	 * 
	 * @param a
	 * @param b
	 */
	public static void line(PVector a, PVector b) {
		parent.line(a.x, a.y, b.x, b.y);
	}

	/**
	 * Draws a triangle between a,b and c
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */
	public static void triangle(PVector a, PVector b, PVector c) {
		parent.triangle(a.x, a.y, b.x, b.y, c.x, c.y);
	}

	/**
	 * Draws a bezier curve
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 */
	public static void bezier(PVector a, PVector b, PVector c, PVector d) {
		parent.bezier(a.x, a.y, b.x, b.y, c.x, c.y, d.x, d.y);
	}

	/**
	 * draws a quad
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 */
	public static void quad(PVector a, PVector b, PVector c, PVector d) {
		parent.quad(a.x, a.y, b.x, b.y, c.x, c.y, d.x, d.y);
	}

	/**
	 * Returns a random framecorner
	 * 
	 * @return
	 */
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

	/**
	 * Returns the location of the mouse as a PVector
	 * 
	 * @return mouseposition
	 */
	public static PVector mouse() {
		return new PVector(parent.mouseX, parent.mouseY);
	}

	/**
	 * Draws a point
	 * 
	 * @param pos
	 */
	public static void point(PVector pos) {
		parent.point(pos.x, pos.y);
	}

	/**
	 * Draws a fullframe recangle.Preferably with non-full opacity
	 * 
	 * @param color
	 *            rectangle color
	 */
	public static void fade(int color) {
		parent.pushStyle();
		parent.fill(color);
		parent.rect(-10, -10, parent.width + 10, parent.height + 10);
		parent.popStyle();
	}

	/**
	 * Draws a fullframe recangle.
	 * 
	 * @param color
	 *            color
	 * @param opactity
	 *            opactity
	 */
	public static void fade(int color, int opactity) {
		parent.fill(parent.red(color), parent.green(color), parent.blue(color),
				opactity);
		parent.rect(-10, -10, parent.width + 10, parent.height + 10);
	}

	/**
	 * A frame in square size
	 * 
	 * @param sqSize
	 *            width&height of the frame
	 */
	public static void size(int sqSize) {
		parent.size(sqSize, sqSize);
	}

	/**
	 * Fast PVector creation
	 * 
	 * @param x
	 *            x-coordinate
	 * @param y
	 *            y-coordinate
	 * @return a PVector at x,y
	 */
	public static PVector vec(float x, float y) {
		return new PVector(x, y);
	}

	/**
	 * Draws a closing PShape with the given points
	 * 
	 * @param ps
	 *            Shapepoints
	 */
	public static void shape(PVector... ps) {
		parent.beginShape();
		for (PVector p : ps)
			parent.vertex(p.x, p.y);
		parent.endShape(PApplet.CLOSE);
	}

	/**
	 * A shape-vertex
	 * 
	 * @param p
	 */
	public static void vertex(PVector p) {
		parent.vertex(p.x, p.y);
	}

	/**
	 * Lerp between two vectors
	 * 
	 * @param a
	 *            vector a
	 * @param b
	 *            vector b
	 * @param amt
	 *            amt
	 * @return new PVector in between a and b
	 */
	public static PVector lerp(PVector a, PVector b, float amt) {
		return lerp(a.x, a.y, b.x, b.y, amt);
	}

	/**
	 * Lerp between 2 locations
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param amt
	 * @return A PVector in between x1,y2 & x2,y2
	 */
	public static PVector lerp(float x1, float y1, float x2, float y2, float amt) {
		return new PVector(PApplet.lerp(x1, x2, amt), PApplet.lerp(y2, y2, amt));
	}

	/**
	 * Creates a PVector from an angle and magnitude
	 * 
	 * @param ang
	 *            angle
	 * @param length
	 *            length(magnitude)
	 * @return a brand new PVector
	 */
	public static PVector fromAngle(float ang, float length) {
		PVector p = PVector.fromAngle(ang);
		p.mult(length);
		return p;
	}

	/**
	 * Creates a PVector from an angle and magnitude and a given reference point
	 * so its like: rel.x+cos(ang)*length , rel.y+sin(ang)*length
	 * 
	 * @param rel
	 *            relative point
	 * @param ang
	 *            angle
	 * @param length
	 *            length (magnitude)
	 * @return a brand new PVectpr
	 */
	public static PVector fromAngle(PVector rel, float ang, float length) {
		PVector p = PVector.fromAngle(ang);
		p.mult(length);
		p.add(rel.x, rel.y, rel.z);
		return p;
	}

	/**
	 * Gives the angle going from one vector to another
	 * 
	 * @param from
	 *            starting vector
	 * @param to
	 *            ending vector
	 * @return an angle
	 */
	public static float angleTo(PVector from, PVector to) {
		float a = PVector
				.angleBetween(new PVector(1, 0), PVector.sub(to, from));
		if (to.y < from.y)
			a = PApplet.TAU - a;
		return a;
	}

	/**
	 * Gives a random point in between two points
	 * 
	 * @param a
	 * @param b
	 * @return a PVector between a and b
	 */
	public static PVector randomLineP(PVector a, PVector b) {
		return randomLineP(a.x, a.y, b.x, b.y);
	}

	/**
	 * Gives a random point in between two points
	 * 
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return a random point between x1,y1 and x2,y2
	 */
	public static PVector randomLineP(float x1, float y1, float x2, float y2) {
		return lerp(x1, y1, x2, y2, random());
	}

	/**
	 * Gives a random point in a rectangle
	 * 
	 * @param p
	 *            rect position
	 * @param width
	 * @param height
	 * @return a PVector in the rectangle
	 */
	public static PVector randomRectP(PVector p, float width, float height) {
		return randomRectP(p.x, p.y, width, height);
	}

	/**
	 * Gives a random point in a rectangle
	 * 
	 * 
	 * @param x
	 *            x-pos of the rectangle
	 * @param y
	 *            y-pos of the rectangle
	 * @param width
	 * @param height
	 * @return a PVector in the rectangle
	 */
	public static PVector randomRectP(float x, float y, float width,
			float height) {
		return new PVector(parent.random(x, x + width), parent.random(y, y
				+ height));
	}

	/**
	 * A random number between 0 and 1
	 * 
	 * @return
	 */
	public static float random() {
		return parent.random(1);
	}

	private static PImage getImage(String imgName) {
		if (imgs.containsKey(imgName))
			return imgs.get(imgName);
		else
			return imgs.put(imgName, parent.loadImage(imgName));
	}

	/**
	 * draws an image. no loadImage required
	 * 
	 * @param imgName
	 * @param pos
	 * @param width
	 * @param height
	 */
	public static void image(String imgName, PVector pos, float width,
			float height) {
		PImage img = getImage(imgName);
		parent.image(img, pos.x, pos.y, width, height);
	}

	/**
	 * draws an image. no loadImage required
	 * 
	 * @param imgName
	 * @param pos
	 */
	public static void image(String imgName, PVector pos) {
		PImage img = getImage(imgName);
		parent.image(img, pos.x, pos.y);
	}

}
