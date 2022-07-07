package com.github.jakub686;

import com.github.jakub686.model.Grid;
import com.github.jakub686.model.GridFog;
import com.github.jakub686.view.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //battle field size row x column
    public static int rows = 10;
    public static int columns = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        //Player 1 ships
        ArrayList<Ship> shipListPlayer1 = new ArrayList<>();

        Ship shipFiveP1 = new Ship(ShipType.AIRCRAFT_CARRIER);
        Ship shipFourP1 = new Ship(ShipType.BATTLESHIP);
        Ship shipThree1P1 = new Ship(ShipType.SUBMARINE);
        Ship shipThree2P1 = new Ship(ShipType.CRUISER);
        Ship shipTwoP1 = new Ship(ShipType.DESTROYER);

        shipListPlayer1.add(shipFiveP1);
        shipListPlayer1.add(shipFourP1);
        shipListPlayer1.add(shipThree1P1);
        shipListPlayer1.add(shipThree2P1);
        shipListPlayer1.add(shipTwoP1);

        //Player 2 ships
        ArrayList<Ship> shipListPlayer2 = new ArrayList<>();

        Ship shipFiveP2 = new Ship(ShipType.AIRCRAFT_CARRIER);
        Ship shipFourP2 = new Ship(ShipType.BATTLESHIP);
        Ship shipThree1P2 = new Ship(ShipType.SUBMARINE);
        Ship shipThree2P2 = new Ship(ShipType.CRUISER);
        Ship shipTwoP2 = new Ship(ShipType.DESTROYER);

        shipListPlayer2.add(shipFiveP2);
        shipListPlayer2.add(shipFourP2);
        shipListPlayer2.add(shipThree1P2);
        shipListPlayer2.add(shipThree2P2);
        shipListPlayer2.add(shipTwoP2);

        //Grid
        String[][] grid1 = new Grid().getGrid(rows + 1, columns + 1);
        String[][] grid2 = new Grid().getGrid(rows + 1, columns + 1);
        String[][] gridFog1 = new GridFog().getGrid(rows + 1, columns + 1);
        String[][] gridFog2 = new GridFog().getGrid(rows + 1, columns + 1);

        //Setting ship for player 1
        System.out.println("Player 1, place your ships on the game field");
        Show.showGrid(grid1);
        new ShipsSetter().shipsSetter(grid1, shipListPlayer1);

        System.out.println("Press Enter and pass the move to another player");
        String anotherPlayer = sc.nextLine();

        //Setting ship for player 2
        System.out.println("Player 2, place your ships to the game field");
        Show.showGrid(grid2);
        if (anotherPlayer.equals(""))
            new ShipsSetter().shipsSetter(grid2, shipListPlayer2);

        System.out.println("Press Enter and pass the move to another player");
        String blankString = sc.nextLine();

        new Shot().shot(grid1, grid2, gridFog1, gridFog2, shipListPlayer1, shipListPlayer2);
    }

}
