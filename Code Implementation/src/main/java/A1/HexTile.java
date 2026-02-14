package A1;

import java.util.ArrayList;
import java.util.List;

/**
 * HexTile class representing a hexagonal tile on the Catan board.
 */
public class HexTile {
	/**
	 * Unique identifier for the tile.
	 */
	public int id;
	/**
	 * Type of resource this tile produces.
	 */
	public ResourceType resource;
	/**
	 * List of nodes (corners) surrounding this tile.
	 */
	public List<Node> nodes;
	/**
	 * List of edges (borders) surrounding this tile.
	 */
	public List<Edge> edges;
	/**
	 * Number token associated with this tile.
	 */
	public TokenNumber tokenNumber;

	/**
	 * Constructor for HexTile.
	 * @param resource The type of resource this tile produces.
	 * @param token The token number for resource production.
	 */
	public HexTile(ResourceType resource, TokenNumber token) {
		this.resource = resource;
		this.tokenNumber = token;
		this.nodes = new ArrayList<>();
		this.edges = new ArrayList<>();
	}

	/**
	 * Constructor with ID, ResourceType, and Token (int).
	 * @param id Unique identifier.
	 * @param resource Type of resource.
	 * @param token Token value.
	 */
	public HexTile(int id, ResourceType resource, int token) {
		this.id = id;
		this.resource = resource;
		this.nodes = new ArrayList<>();
		this.edges = new ArrayList<>();
		if (token != 0) {
			this.tokenNumber = TokenNumber.valueOf("T" + token);
		}
	}
}
