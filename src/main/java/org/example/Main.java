package org.example;

import org.example.model.Grid;
import org.example.view.Show;

import java.util.Scanner;

public class Main {
    //battle field size row x column
    public static int rows = 10;
    public static int columns = 10;

    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        //Player 1 ships
        Ship shipFiveP1 = new Ship(ShipType.AIRCRAFT_CARRIER);
        Ship shipFourP1 = new Ship(ShipType.BATTLESHIP);
        Ship shipThree1P1 = new Ship(ShipType.SUBMARINE);
        Ship shipThree2P1 = new Ship(ShipType.CRUISER);
        Ship shipTwoP1 = new Ship(ShipType.DESTROYER);

        //Player 2 ships
        Ship shipFiveP2 = new Ship(ShipType.AIRCRAFT_CARRIER);
        Ship shipFourP2 = new Ship(ShipType.BATTLESHIP);
        Ship shipThree1P2 = new Ship(ShipType.SUBMARINE);
        Ship shipThree2P2 = new Ship(ShipType.CRUISER);
        Ship shipTwoP2 = new Ship(ShipType.DESTROYER);

        //Grid
        String[][] grid1 = new Grid().getGrid(rows +1, columns +1);
        String[][] grid2 = new Grid().getGrid(rows +1, columns +1);

        //Setting ship for player 1
        System.out.println("Player 1, place your ships on the game field");
        Show.showGrid(grid1);
        new ShipsSetter().shipsSetter(grid1,shipFiveP1,shipFourP1,shipThree1P1,shipThree2P1,shipTwoP1);

        System.out.println("Press Enter and pass the move to another player");
        String anotherPlayer = sc.nextLine();

        //Setting ship for player 2
        System.out.println("Player 2, place your ships to the game field");
        Show.showGrid(grid2);
        if (anotherPlayer.equals(""))
            new ShipsSetter().shipsSetter(grid2,shipFiveP2,shipFourP2,shipThree1P2,shipThree2P2,shipTwoP2);

        System.out.println("Press Enter and pass the move to another player");
        String blankString = sc.nextLine();
    }
}
