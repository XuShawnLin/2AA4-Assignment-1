import java.util.ArrayList;
import java.util.List;

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

        // 3. Setup Board with multiple tiles and nodes
        Board board = new Board();

        // Define a small board for simulation
        // Each tile has some nodes
        HexTile[] tiles = {
                new HexTile(ResourceType.LUMBER, TokenNumber),   // Forest
                new HexTile(ResourceType.BRICK, TokenNumber),   // Hill
                new HexTile(ResourceType.GRAIN, TokenNumber),    // Field
                new HexTile(ResourceType.WOOL, TokenNumber),     // Pasture
                new HexTile(ResourceType.ORE, TokenNumber)      // Mountain
        };

        // Create 14 nodes
        List<Node> allNodes = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            allNodes.add(new Node(i));
        }
    }
}
