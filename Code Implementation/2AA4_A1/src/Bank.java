
package 2AA4_A1;

public class Bank {
	private Map<ResourceType, Integer> resourceList = null;

	public void Bank () {
		resourceList = new EnumMap<>(ResourceType.class);

        for (ResourceType type : ResourceType.values()) {
            resourceList.put(type, 19);
        }
	}

	public boolean hasResource(ResourceType type, int amount) {
		return resourceList.containsKey(type) && resourceList.get(type) >= amount;
	}

	public boolean giveResource(ResourceType type, int amount) {
		if (!hasResource(type, amount)) {
            return false;
        }
        resourceList.put(type, resourceList.get(type) - amount);
        return true;
	}

	public boolean receiveResource(ResourceType type, int amount) {
		resourceList.put(type, resourceList.get(type) + amount);
	}

	public int getAmount(ResourceType type) {
        return resourceList.get(type);
    }
}
