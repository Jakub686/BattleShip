package com.github.jakub686;

import com.github.jakub686.model.Grid;
import com.github.jakub686.model.GridFog;
import com.github.jakub686.view.Show;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //battle field size row x column
    public static int rows = 10;
    public static int columns = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Player 1 ships
        ArrayList<Ship> shipListPlayer1 = createPlayer();

        //Player 2 ships
        ArrayList<Ship> shipListPlayer2 = createPlayer();

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

    private static ArrayList<Ship> createPlayer() {
        ArrayList<Ship> shipListPlayer = new ArrayList<>();

        Ship shipFiveP2 = new Ship(ShipType.AIRCRAFT_CARRIER);
        Ship shipFourP2 = new Ship(ShipType.BATTLESHIP);
        Ship shipThree1P2 = new Ship(ShipType.SUBMARINE);
        Ship shipThree2P2 = new Ship(ShipType.CRUISER);
        Ship shipTwoP2 = new Ship(ShipType.DESTROYER);

        shipListPlayer.add(shipFiveP2);
        shipListPlayer.add(shipFourP2);
        shipListPlayer.add(shipThree1P2);
        shipListPlayer.add(shipThree2P2);
        shipListPlayer.add(shipTwoP2);
        return shipListPlayer;
    }

}
