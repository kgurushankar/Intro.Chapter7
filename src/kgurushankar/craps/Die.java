package kgurushankar.craps;

public class Die {
	private int numDots;

	public Die(int numDots) {
		this.numDots = numDots;
	}

	public Die() {
		this(6);
	}

	private int dots;

	public void roll() {
		dots = (int) (Math.random() * numDots) + 1;
	}

	public int getNumDots() {
		return dots;
	}

}
