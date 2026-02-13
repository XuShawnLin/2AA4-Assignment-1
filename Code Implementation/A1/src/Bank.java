package A1;

import java.util.HashMap;
import java.util.Map;

public class Bank {

	private Map<ResourceType, Integer> resourceList; //create original resource list for bank

	/**
	 * Constructor for Bank
	 */
	public Bank() {
		resourceList = new HashMap<>();
		for (ResourceType type : ResourceType.values()) { //add 19 resources per type to map (LUMBER:19, etc)
			resourceList.put(type, 19);
		}
	}


	/**
	 * Checks if bank has needed number of resources
	 */
	public boolean hasResource(ResourceType type, int amount) {
		return resourceList.getOrDefault(type, 0) >= amount;
	}


	/**
	 * Gives needed amound of resources to player
	 */
	public boolean giveResource(ResourceType type, int amount) {
		if (!hasResource(type, amount)) {
			return false; //if there are enough resources
		}

		resourceList.put(type, resourceList.get(type) - amount); //take away from bank
		return true;
	}

	/**
	 * Gets resources player builds
	 */
	public boolean receiveResource(ResourceType type, int amount) {
		resourceList.put(type, resourceList.getOrDefault(type, 0) + amount); //adds back resources to corresponding type
		return true;
	}
}
