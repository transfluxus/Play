import play.Play;
import processing.core.PApplet;
import processing.core.PVector;

public class PA extends PApplet {

	Play P;

	@Override
	public void setup() {
		P = Play.start(this);
		P.size(500);
	}

	@Override
	public void draw() {
		// clear();
		// P.circle(P.vec(200, 100), 30);
		PVector p = P.fromAngle(P.center(), (frameCount * 0.01f) % TAU,
				frameCount / 10);
		P.ellipseRot(p, 20, 5, Play.angleTo(P.center(), p));

	}

}
