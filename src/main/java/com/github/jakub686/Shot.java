package com.github.jakub686;


import com.github.jakub686.InputConverter.ConverterInputCoordinatesShot;
import com.github.jakub686.view.Show;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Shot implements UserInput {
    public void shot(String[][] grid1, String[][] grid2, String[][] gridFog1, String[][] gridFog2, List<Ship> shipListPlayer1, List<Ship> shipListPlayer2) {
        boolean endCondition = true;
        do {
            Scanner s = new Scanner(System.in);

            Show.showGrid(gridFog1);
            System.out.println("---------------------");

            //Player 1 shot
            Show.showGrid(grid1);
            System.out.println("Player 1, it's your turn:");

            int[] coordinates = new ConverterInputCoordinatesShot().inputConverterForShipSetting(userInput());
            int row = coordinates[0];
            int column = coordinates[1];

            endCondition = Shot(grid2, gridFog1, endCondition, row, column, shipListPlayer2);
            if(endCondition==false)
                break;

            System.out.println();
            System.out.println("Press Enter and pass the move to another player");

            String blankEnter = s.nextLine();

            Show.showGrid(gridFog2);
            System.out.println("---------------------");

            //Player 2 shot
            Show.showGrid(grid2);
            System.out.println("Player 2, it's your turn:");

            coordinates = new ConverterInputCoordinatesShot().inputConverterForShipSetting(userInput());
            row = coordinates[0];
            column = coordinates[1];
            endCondition = Shot(grid1, gridFog2, endCondition, row, column, shipListPlayer1);
            if(endCondition==false)
                break;

            System.out.println();
            System.out.println("Press Enter and pass the move to another player");
            blankEnter = s.nextLine();

        } while (endCondition);
    }


    private static boolean Shot(String[][] opponentGrid, String[][] gridFog, boolean endCondition, int row, int column, List<Ship> shipList) {
        if (opponentGrid[row][column].equals("O") & row < opponentGrid.length & row > 0 & column < opponentGrid.length & column > 0) {

            opponentGrid[row][column] = "X";
            gridFog[row][column] = "X";

            boolean msgCondition = true;
            shipHit(msgCondition);
        }

        shotMissed(gridFog, opponentGrid, row, column);

        enteredWrongCoordinates(row, column);

        ShipSunkCheck(gridFog, shipList);

        //if last ship is sunk game is over
        endCondition = lastShipSunk(endCondition, shipList);
        return endCondition;
    }

    public static void ShipSunkCheck(String[][] gridFog, List<Ship> shipList) {
        boolean isShipSunk = false;
        for (int i = 0; i < shipList.size(); i++) {
            int[] shipCoordinates = shipList.get(i).getShiptype().getCoordinates();
            Ship ship = shipList.get(i);

            for (int j = 0, k = 0; j < ship.getShiptype().getLength(); j++) {
                if (gridFog[shipCoordinates[k]][shipCoordinates[k + 1]].equals("X")) {
                    isShipSunk = true;
                } else {
                    isShipSunk = false;
                    break;
                }
                k = k + 2;
            }

            //TODO refactor
            if (isShipSunk & ship.getShiptype().isSunk()==0) {
                int[] coordinates = ship.getShiptype().getCoordinates();
                coordinates[coordinates.length-1] = 1; //ship sunk
                ship.getShiptype().setCoordinates(coordinates);
                System.out.println("You sunk a ship!");
            }
        }
    }

    private static boolean lastShipSunk(boolean endCondition, List<Ship> shipList) {

        boolean islastShipSunk = false;
        for (int i = 0; i < shipList.size(); i++) {

            if (shipList.get(i).getShiptype().isSunk()==1) {
                islastShipSunk = true;
            } else {
                islastShipSunk = false;
                break;
            }
        }

        if (islastShipSunk == true) {

            System.out.println("You sank the last ship. You won. Congratulations!");
            endCondition = false;
        }
        return endCondition;

    }

    private static void shotMissed(String[][] opponentGrid, String[][] currentPlayerGrid, int row, int column) {
        if ("~".equals(currentPlayerGrid[row][column]) & row < opponentGrid.length & row > 0 & column < opponentGrid.length & column > 0) {
            opponentGrid[row][column] = "M";
            currentPlayerGrid[row][column] = "M";

            System.out.println("You missed.");
        }
    }

    private static void shipHit(boolean msgCondition) {
        if (msgCondition) {
            System.out.println("You hit a ship!");
        }
    }

    private static void enteredWrongCoordinates(int row, int column) {
        if (row > Main.rows | column > Main.columns | Main.rows < 1 | Main.columns < 1) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
        }
    }

    @Override
    public String[] userInput() {
        Scanner sc = new Scanner(System.in);

        String[] inputString = new String[4];

        System.out.println("Row ");
        inputString[0] = sc.nextLine().toUpperCase(Locale.ROOT);

        System.out.println("Column ");
        inputString[1] = sc.nextLine().toUpperCase(Locale.ROOT);

        inputString[2] = "0";
        inputString[3] = "0";

        return inputString;
    }
}
