package kgurushankar.craps;

// Implements the game of Craps logic

public class CrapsGame {
	private int point = 0;
	

	// private enum states { NEW_ROLL, KEEP_ROLLING };

	// private states state = states.NEW_ROLL;

	/** true for Pass false for Don't Pass */
	private boolean bettingMode = true;

	/**
	 * Calculates the result of the next dice roll in the Craps game. The
	 * parameter total is the sum of dots on two dice. point is set to the saved
	 * total, if the game continues, or 0, if the game has ended. Returns 1 if
	 * player won, -1 if player lost, 0 if player continues rolling.
	 */
	public int processRoll(int total) {
		if (bettingMode) {

			if (point == 0) {
				if (total == 7 || total == 11) {
					return 1;
				} else if (total == 2 || total == 3 || total == 12) {
					return -1;
				} else {
					point = total;
					return 0;
				}
			} else if (total == point) {
				point = 0;
				return 1;
			} else if (total == 7) {
				point = 0;
				return -1;
			} else {
				return 0;
			}
		}
		/*
		 * switch (state) { case NEW_ROLL: state = states.KEEP_ROLLING; if
		 * (total == 7 || total == 11) { return 1; } else if (total == 2 ||
		 * total == 3 || total == 12) { return -1; } else { point = total;
		 * return 0; } default: if (total == point) { point = 0; state =
		 * states.NEW_ROLL; return 1; } else if (total == 7) { point = 0; state
		 * = states.NEW_ROLL; return -1; } else { return 0; } }
		 */
		else {
			if (point == 0) {
				if (total == 7 || total == 11) {
					return -1;
				} else if (total == 2 || total == 3) {
					return 1;
				} else if (total == 12) {
					point = 0;
					return 0;
				} else {
					point = total;
					return 0;
				}
			} else if (total == point) {
				point = 0;
				return -1;
			} else if (total == 7) {
				point = 0;
				return 1;
			} else {
				return 0;
			}
		}
	}

	/**
	 * Returns the saved point
	 */
	public int getPoint() {
		return point;
	}

	public void togglemode() {
		bettingMode = !(bettingMode);
	}

	public boolean getMode() {
		return bettingMode;
	}
}
