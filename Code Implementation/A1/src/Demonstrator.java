import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrator class for the Catan game implementation.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Setup Bank
        Bank bank = new Bank();

        // 2. Setup 4 Players
        Player p1 = new Player("Shawn");
        Player p2 = new Player("Sabrina");
        Player p3 = new Player("Subha");
        Player p4 = new Player("Ahmed");
        Player[] players = {p1, p2, p3, p4};

        // 3. Setup Board
        Board board = new Board();

        // 4. Create 19 HexTiles (18 resource tiles + 1 desert for Robber)
        // Standard Catan distribution: 4 Lumber, 4 Grain, 4 Wool, 3 Brick, 3 Ore, 1 Desert
        HexTile[] tiles = {
                new HexTile(0, ResourceType.LUMBER, 11),
                new HexTile(1, ResourceType.LUMBER, 3),
                new HexTile(2, ResourceType.LUMBER, 6),
                new HexTile(3, ResourceType.LUMBER, 4),
                new HexTile(4, ResourceType.GRAIN, 5),
                new HexTile(5, ResourceType.GRAIN, 9),
                new HexTile(6, ResourceType.GRAIN, 10),
                new HexTile(7, ResourceType.GRAIN, 8),
                new HexTile(8, ResourceType.WOOL, 2),
                new HexTile(9, ResourceType.WOOL, 12),
                new HexTile(10, ResourceType.WOOL, 9),
                new HexTile(11, ResourceType.WOOL, 10),
                new HexTile(12, ResourceType.BRICK, 4),
                new HexTile(13, ResourceType.BRICK, 5),
                new HexTile(14, ResourceType.BRICK, 6),
                new HexTile(15, ResourceType.ORE, 3),
                new HexTile(16, ResourceType.ORE, 8),
                new HexTile(17, ResourceType.ORE, 11),
                new HexTile(18, null, 0)  // Desert tile for Robber (no resource, no token)
        };

        // Add all tiles to the board
        for (HexTile tile : tiles) {
            board.addTile(tile);
        }

        // 5. Create 18 Nodes (simplified board without harbours)
        List<Node> allNodes = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            Node node = new Node(i);
            allNodes.add(node);
            board.addNode(node);
        }

        // 6. Create 27 Edges (simplified board without harbours)
        List<Edge> allEdges = new ArrayList<>();
        for (int i = 0; i < 27; i++) {
            Edge edge = new Edge(i);
            allEdges.add(edge);
            board.addEdge(edge);
        }

        // 7. Associate nodes with tiles (simplified mapping for 18 nodes)
        // Each tile gets one node associated with it
        for (int t = 0; t < tiles.length && t < allNodes.size(); t++) {
            tiles[t].addNode(allNodes.get(t));
        }

        System.out.println("Board setup complete!");
        System.out.println("Tiles: " + board.getTiles().size());
        System.out.println("Nodes: " + board.getNodes().size());
        System.out.println("Edges: " + board.getEdges().size());
    }
}
