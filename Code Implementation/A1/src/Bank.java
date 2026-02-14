package A1;

/**
 * Class representing the bank in the game.
 */
public class Bank {
				/**
				 * 
				 */
				public EMap resourceList;
	/**
	 * Constructor for Bank class.
	 */
	public void Bank () {
	}
	/**
	 * Checks if the bank has a specified amount of a resource.
	 * @return True if the bank has the resource, false otherwise.
	 * @param type The type of resource to check.
	 * @param amount The amount of the resource to check.
	 */
	public boolean hasResource(ResourceType type, int amount) {
	}
	/**
	 * Gives a specified amount of a resource to the bank.
	 * @return True if the resource was successfully given, false otherwise.
	 * @param type The type of resource to give.
	 * @param amount The amount of the resource to give.
	 */
	public boolean giveResource(ResourceType type, int amount) {
	}
	/**
	 * Receives a specified amount of a resource from the bank.
	 * @return True if the resource was successfully received, false otherwise.
	 * @param type The type of resource to receive.
	 * @param amount The amount of the resource to receive.
	 */
	public boolean receiveResource(ResourceType type, int amount) {
	}
}
