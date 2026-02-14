package A1;

/**
 * Class representing a player's action to build structures in the game.
 */
public class BuildStructure {
	private Player player;

	/**
	 * Constructor for BuildStructure class.
	 * @param p The player performing the build action.
	 */
	public BuildStructure(Player p) {
		this.player = p;
	}

	/**
	 * Attempts to build a settlement.
	 * @return True if settlement is successfully built, false otherwise.
	 */
	public boolean buildSettlement() {
		return false;
	}

	/**
	 * Attempts to build a city.
	 * @return True if city is successfully built, false otherwise.
	 */
	public boolean buildCity() {
		return false;
	}

	/**
	 * Attempts to build a road.
	 * @return True if road is successfully built, false otherwise.
	 */
	public boolean buildRoad() {
		return false;
	}

	/**
	 * Awards victory points to the player based on built structures.
	 */
	public void giveVPs() {
	}
}
