package A1;

/**
 * Class representing a player's action to build structures in the game.
 */
public class BuildStructure {
	private Player player;

	private Bank bank;
	/**
	 * Constructor for BuildStructure class.
	 * @param p The player performing the build action.
	 * @param bank The bank instance.
	 */
	public BuildStructure(Player p, Bank bank) {
		this.player = p;
		this.bank = bank;
	}

	/**
	 * Attempts to build a settlement.
	 * @param node The node where to build.
	 * @return True if settlement is successfully built, false otherwise.
	 */
	public boolean buildSettlement(Node node) {
		return false;
	}

	/**
	 * Attempts to build a city.
	 * @param node The node where to build.
	 * @return True if city is successfully built, false otherwise.
	 */
	public boolean buildCity(Node node) {
		return false;
	}

	/**
	 * Attempts to build a road.
	 * @param edge The edge where to build.
	 * @return True if road is successfully built, false otherwise.
	 */
	public boolean buildRoad(Edge edge) {
		return false;
	}

	/**
	 * Awards victory points to the player based on built structures.
	 */
	public void giveVPs() {
	}
}
