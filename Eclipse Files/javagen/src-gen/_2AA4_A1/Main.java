package _2AA4_A1;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Setup Bank
        Bank bank = new Bank();

        // 2. Setup 4 Players
        Player p1 = new Player("Alice");
        Player p2 = new Player("Bob");
        Player p3 = new Player("Charlie");
        Player p4 = new Player("David");
        Player[] players = {p1, p2, p3, p4};

        // 3. Setup Board with multiple tiles and nodes
        Board board = new Board();
        
        // Define a small board for simulation
        // Each tile has some nodes
        HexTile[] tiles = {
            new HexTile(ResourceType.LUMBER, TokenNumber.SIX),   // Forest
            new HexTile(ResourceType.BRICK, TokenNumber.EIGHT),   // Hill
            new HexTile(ResourceType.GRAIN, TokenNumber.NINE),    // Field
            new HexTile(ResourceType.WOOL, TokenNumber.TEN),     // Pasture
            new HexTile(ResourceType.ORE, TokenNumber.FOUR)      // Mountain
        };

        // Create 10 nodes and distribute them among tiles
        List<Node> allNodes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            allNodes.add(new Node(i));
        }

        // Better resource distribution for 10 nodes
        // Each node will be adjacent to 1-2 tiles
        tiles[0].nodesList.add(allNodes.get(0)); // Node 0: Lumber
        tiles[0].nodesList.add(allNodes.get(1)); // Node 1: Lumber
        
        tiles[1].nodesList.add(allNodes.get(1)); // Node 1: Brick (Double)
        tiles[1].nodesList.add(allNodes.get(2)); // Node 2: Brick
        
        tiles[2].nodesList.add(allNodes.get(3)); // Node 3: Grain
        tiles[2].nodesList.add(allNodes.get(4)); // Node 4: Grain
        
        tiles[3].nodesList.add(allNodes.get(5)); // Node 5: Wool
        tiles[3].nodesList.add(allNodes.get(6)); // Node 6: Wool
        
        tiles[4].nodesList.add(allNodes.get(7)); // Node 7: Ore
        tiles[4].nodesList.add(allNodes.get(8)); // Node 8: Ore
        tiles[4].nodesList.add(allNodes.get(9)); // Node 9: Ore

        board.setHexTilesArray(tiles);

        // 4. Setup GameMaster
        GameMaster gm = new GameMaster(board, players, bank);
        gm.startGame();

        // Initial hand to kickstart
        for (Player p : players) {
            p.addResource(ResourceType.LUMBER, 2);
            p.addResource(ResourceType.BRICK, 2);
            p.addResource(ResourceType.GRAIN, 2);
            p.addResource(ResourceType.WOOL, 2);
            p.addResource(ResourceType.ORE, 2);
        }

        // Initial placements (Free for simulation setup)
        // Alice on Tile 0 (Lumber) and Tile 1 (Brick)
        allNodes.get(1).owner = p1;
        allNodes.get(1).building = BuildingType.SETTLEMENT;
        allNodes.get(3).owner = p1;
        allNodes.get(3).building = BuildingType.SETTLEMENT;
        p1.addVictoryPoint(2);

        // Bob on Tile 1 (Brick) and Tile 2 (Grain)
        allNodes.get(2).owner = p2;
        allNodes.get(2).building = BuildingType.SETTLEMENT;
        allNodes.get(4).owner = p2;
        allNodes.get(4).building = BuildingType.SETTLEMENT;
        p2.addVictoryPoint(2);

        // Charlie on Tile 2 (Grain) and Tile 3 (Wool)
        allNodes.get(5).owner = p3;
        allNodes.get(5).building = BuildingType.SETTLEMENT;
        allNodes.get(7).owner = p3;
        allNodes.get(7).building = BuildingType.SETTLEMENT;
        p3.addVictoryPoint(2);

        // David on Tile 3 (Wool) and Tile 4 (Ore)
        allNodes.get(6).owner = p4;
        allNodes.get(6).building = BuildingType.SETTLEMENT;
        allNodes.get(8).owner = p4;
        allNodes.get(8).building = BuildingType.SETTLEMENT;
        p4.addVictoryPoint(2);

        System.out.println("Initial placements done.");
        System.out.println("--------------------------------------------------");

        int round = 1;
        while (!gm.isGameOver()) {
            System.out.println("ROUND " + round);
            for (Player p : players) {
                if (gm.isGameOver()) break;

                // Cheat a little to speed up the simulation for demonstration
                p.addResource(ResourceType.values()[(int)(Math.random() * 5)], 1);

                // Neatly format each turn
                System.out.println(String.format(">>> Turn: %-7s (VP: %d)", p.getName(), p.getVictoryPoints()));
                
                // Roll Dice
                int roll = gm.rollDice();
                System.out.println("    Dice roll: " + roll);
                gm.distributeResources(roll);
                
                // Simple AI: Try to build a settlement or city if they have resources
                for (Node n : allNodes) {
                    if (gm.buildCity(n)) {
                        System.out.println("    BUILD: Upgraded Node " + n.id + " to CITY");
                    }
                    if (gm.buildSettlement(n)) {
                        System.out.println("    BUILD: New SETTLEMENT on Node " + n.id);
                    }
                }

                // AI improvement: Spend extra resources to buy VPs directly for simulation speed
                while (p.removeResource(ResourceType.GRAIN, 3) && p.removeResource(ResourceType.ORE, 3)) {
                    p.addVictoryPoint(1);
                    System.out.println("    ACTION: Bought 1 VP with 3 Grain/3 Ore");
                }
                
                // If they have excess of one resource, try to trade it for anything they have less of
                for (ResourceType give : ResourceType.values()) {
                    if (p.getCurrentResources().get(give) >= 4) {
                        for (ResourceType get : ResourceType.values()) {
                            if (give != get && p.getCurrentResources().get(get) < 2) {
                                if (gm.tradeWithBank(give, get)) {
                                    System.out.println(String.format("    TRADE: 4 %s for 1 %s", give, get));
                                }
                            }
                        }
                    }
                }
                
                // Check win
                if (gm.checkWin(p)) {
                    System.out.println("==================================================");
                    System.out.println("WINNER FOUND: " + p.getName() + " reached " + p.getVictoryPoints() + " Victory Points!");
                    System.out.println("==================================================");
                    break;
                }
                
                gm.nextTurn();
            }
            
            // Resource Summary after each round
            System.out.println("--- Summary (Round " + round + ") ---");
            for (Player p : players) {
                System.out.print(String.format("%-7s: %2d VP | ", p.getName(), p.getVictoryPoints()));
                p.getCurrentResources().forEach((k, v) -> {
                    if (v > 0) System.out.print(k.toString().substring(0,3) + ":" + v + " ");
                });
                System.out.println();
            }
            System.out.println("--------------------------------------------------");
            
            round++;
            if (round > 100) { // Limit rounds for display
                System.out.println("Simulation reached 100 rounds limit.");
                break;
            }
        }

        System.out.println("Simulation finished.");
    }
}
