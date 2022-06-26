package org.example;

import org.example.model.Grid;
import org.example.view.Show;

import java.util.Scanner;

public class Main {
    //battle field size row x column
    public static int row = 10;
    public static int column = 10;

    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        String[][] grid1 = new Grid().getGrid(row +1, column +1);
        String[][] grid2 = new Grid().getGrid(row +1, column +1);
        Show.showGrid(grid1);
        Show.showGridFog(grid2);

        //Setting ship for player 1
        System.out.println("Player 1, place your ships on the game field");
        new ShipSetter().shipSetup(grid1, Ships.ship1Five, Ships.ship1Four, Ships.ship1Three1, Ships.ship1Three2, Ships.ship1Two);

        System.out.println("Press Enter and pass the move to another player");
        String anotherPlayer = sc.nextLine();

        //Setting ship for player 2
        System.out.println("Player 2, place your ships to the game field");
        if (anotherPlayer.equals(""))
            new ShipSetter().shipSetup(grid2, Ships.ship2Five, Ships.ship2Four, Ships.ship2Three1, Ships.ship2Three2, Ships.ship2Two);

        System.out.println("Press Enter and pass the move to another player");
        String blankString = sc.nextLine();
    }
}
