package org.example;


import org.example.InputConverter.ConverterInputCoordinatesShot;
import org.example.view.Show;

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

            System.out.println();
            System.out.println("Press Enter and pass the move to another player");
            blankEnter = s.nextLine();

        } while (endCondition);
    }

    //TODO recaftor this method
    private static boolean Shot(String[][] opponentGrid, String[][] gridFog, boolean endCondition, int row, int column, List<Ship> shipList) {
        if (opponentGrid[row][column].equals("O") & row < opponentGrid.length & row > 0 & column < opponentGrid.length & column > 0) {

            opponentGrid[row][column] = "X";
            gridFog[row][column] = "X";
            boolean msgCondition = true;

//            resetCoordinates(row, column, 8, shipList.get(0).getShiptype().getCoordinates());
//            msgCondition = shipFiveSunk(msgCondition, shipList.get(0).getShiptype().getCoordinates());
//
//            resetCoordinates(row, column, 7, shipList.get(1).getShiptype().getCoordinates());
//            msgCondition = shipFourSunk(msgCondition, shipList.get(1).getShiptype().getCoordinates());

//            resetCoordinates(row, column, 5, shipListPlayer2.get(2).getShiptype().getCoordinates());
//            msgCondition = shipThreeSunk(msgCondition, shipListPlayer2.get(2).getShiptype().getCoordinates());
//
//            resetCoordinates(row, column, 5, shipListPlayer2.get(3).getShiptype().getCoordinates());
//            msgCondition = shipThreeSunk(msgCondition, shipListPlayer2.get(3).getShiptype().getCoordinates());
//
//            resetCoordinates(row, column, 3, shipListPlayer2.get(4).getShiptype().getCoordinates());
//            msgCondition = shipTwoSunk(msgCondition, shipListPlayer2.get(4).getShiptype().getCoordinates());

            shipHit(msgCondition);
        }

        shotMissed(gridFog, opponentGrid, row, column);

        enteredWrongCoordinates(row, column);

        horizontalShipSunkCheck(gridFog,shipList);

        //if last ship is sunk game is over
        endCondition = lastShipSunkPlayer(endCondition, shipList);
        return endCondition;
    }

    public static void horizontalShipSunkCheck(String[][] gridFog, List<Ship> shipList) {
        boolean isShipSunk = false;
        loop: for (int i = 0; i < shipList.size(); i++) {
            int[] shipCoordinates = shipList.get(i).getShiptype().getCoordinates();
            Ship ship = shipList.get(i);
            for (int j = 0; j < ship.getShiptype().getLength()+2; ) {
                 if(gridFog[shipCoordinates[j]][shipCoordinates[j+1]].equals("X")){
                     isShipSunk = true;
                 }else{
                     isShipSunk = false;
                     break;
                 }
                 j=j+2;
            }
        }
        if(isShipSunk)
        System.out.println("ship is sunk " );

    }

    private static boolean lastShipSunkPlayer(boolean endCondition, List<Ship> shipListPlayer) {

        //int ifShipSunk = shipListPlayer.get(0).getShiptype().getCoordinate(shipListPlayer.get(0).getShiptype().getCoordinates().length - 1);

        for (int i = 0; i < shipListPlayer.size(); i++) {
            if (shipListPlayer.get(0).getShiptype().isSunk() == 1) {
                endCondition = false;
            } else {
                endCondition = true;
            }
        }

        if (endCondition == false)
            System.out.println("You sank the last ship. You won. Congratulations!");

//        if (shipListPlayer.get(0).getShiptype().isSunk() == 1 & shipListPlayer.get(1).getShiptype().isSunk() == 1 & shipListPlayer.get(2).getShiptype().isSunk() == 1 & shipListPlayer.get(3).getShiptype().isSunk() == 1 & shipListPlayer.get(4).getShiptype().isSunk() == 1) {
//            endCondition = false;
//            System.out.println("You sank the last ship. You won. Congratulations!");
//        }
        return endCondition;
    }

//    private static void resetCoordinates(int row, int column, int i2, int[] ship1Five) {
//        for (int i = 0, j = 1; i <= i2; i = i + 2, j = j + 2) {
//            if (row == ship1Five[i] & column == ship1Five[j]) {
//                ship1Five[i] = 0;
//                ship1Five[i + 1] = 0;
//            }
//        }
//    }

//    private static boolean shipFiveSunk(boolean msgCondition, int[] ship1Five) {
//        if (ship1Five[10] == 0 & ship1Five[0] == 0 & ship1Five[1] == 0 & ship1Five[2] == 0 & ship1Five[3] == 0 & ship1Five[4] == 0 & ship1Five[5] == 0 & ship1Five[6] == 0 & ship1Five[7] == 0 & ship1Five[8] == 0 & ship1Five[9] == 0) {
//            System.out.println("You sank a ship! Specify a new target:");
//            ship1Five[10] = 1;
//            msgCondition = false;
//        }
//        return msgCondition;
//    }
//
//    private static boolean shipTwoSunk(boolean msgCondition, int[] ship1Two) {
//        if (ship1Two[4] == 0 & ship1Two[0] == 0 & ship1Two[1] == 0 & ship1Two[2] == 0 & ship1Two[3] == 0) {
//            System.out.println("You sank a ship! Specify a new target:");
//            ship1Two[4] = 1;
//            msgCondition = false;
//        }
//        return msgCondition;
//    }

    private static void shotMissed(String[][] opponentGrid, String[][] currentPlayerGrid, int row, int column) {
        if ("~".equals(currentPlayerGrid[row][column]) & row < opponentGrid.length & row > 0 & column < opponentGrid.length & column > 0) {
            opponentGrid[row][column] = "M";
            currentPlayerGrid[row][column] = "M";

            System.out.println("You missed.");
        }
    }

//    private static boolean lastShipSunkPlayer2(boolean endCondition) {
//        if (Ships.ship2Five[10] == 1 & Ships.ship2Four[8] == 1 & Ships.ship2Three1[6] == 1 & Ships.ship2Three2[6] == 1 & Ships.ship2Two[4] == 1) {
//            endCondition = false;
//            System.out.println("You sank the last ship. You won. Congratulations!");
//        }
//        return endCondition;
//    }

//    private static boolean shipFourSunk(boolean msgCondition, int[] ship2Four) {
//        if (ship2Four[8] == 0 & ship2Four[0] == 0 & ship2Four[1] == 0 & ship2Four[2] == 0 & ship2Four[3] == 0 & ship2Four[4] == 0 & ship2Four[5] == 0 & ship2Four[6] == 0 & ship2Four[7] == 0) {
//            System.out.println("You sank a ship! Specify a new target:");
//            ship2Four[8] = 1;
//            msgCondition = false;
//        }
//        return msgCondition;
//    }
//
//    private static boolean shipThreeSunk(boolean msgCondition, int[] ship2Three2) {
//        if (ship2Three2[6] == 0 & ship2Three2[0] == 0 & ship2Three2[1] == 0 & ship2Three2[2] == 0 & ship2Three2[3] == 0 & ship2Three2[4] == 0 & ship2Three2[5] == 0) {
//            System.out.println("You sank a ship! Specify a new target:");
//            ship2Three2[6] = 1;
//            msgCondition = false;
//        }
//        return msgCondition;
//    }

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
