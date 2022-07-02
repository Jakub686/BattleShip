package org.example;



import org.example.model.Grid;
import org.example.view.Show;

import java.util.Locale;
import java.util.Scanner;

public class Shot implements UserInput{
    public void shot(String[][] grid1, String[][] grid2) {
        boolean endCondition = true;
        do {
            Scanner s = new Scanner(System.in);

            Show.showGridFog(grid2);
            System.out.println("---------------------");

            //Player 1 shot
            Show.showGrid(grid1);
            System.out.println("Player 1, it's your turn:");
            String inputString = s.nextLine();
            int[] coordinates = new ConverterUserInputIntoCartesianCoordinates().inputConverterForShipSetting(userInput());
            int row = coordinates[0];
            int column = coordinates[1];

            //endCondition = player1Shot(grid1, grid2, endCondition, row, column);

            System.out.println();
            System.out.println("Press Enter and pass the move to another player");
            String blankEnter = s.nextLine();

            Show.showGridFog(grid1);
            System.out.println("---------------------");

            //Player 2 shot
            Show.showGrid(grid2);;
            System.out.println("Player 2, it's your turn:");
            inputString = s.nextLine();
            coordinates = new ConverterUserInputIntoCartesianCoordinates().inputConverterForShipSetting(userInput());
            row = coordinates[0];
            column = coordinates[1];
            //endCondition = player2Shot(grid1, grid2, endCondition, row, column);

            System.out.println();
            System.out.println("Press Enter and pass the move to another player");
            blankEnter = s.nextLine();

        } while (endCondition);
    }

    @Override
    public String[] userInput() {
        Scanner sc = new Scanner(System.in);

        String[] inputString = new String[4];
        inputString[2]="0";
        inputString[3]="0";


        System.out.println("Row ");
        inputString[0] = sc.nextLine().toUpperCase(Locale.ROOT);

        System.out.println("Column ");
        inputString[1] = sc.nextLine().toUpperCase(Locale.ROOT);

        return inputString;
    }

//    private static boolean player2Shot(String[][] grid1, String[][] grid2, boolean endCondition, int row, int column) {
//        if ("O".equals(grid1[row][column]) & row < grid1.length & row > 0 & column < grid1.length & column > 0) {
//            grid1[row][column] = "X";
//            boolean msgCondition = true;
//
////            resetCoordinates(row, column, 8, Ships.ship1Five);
////            msgCondition = shipFiveSunk(msgCondition, Ships.ship1Five);
////
////            resetCoordinates(row, column, 6, Ships.ship1Four);
////            msgCondition = shipFourSunk(msgCondition, Ships.ship1Four);
////
////            resetCoordinates(row, column, 4, Ships.ship1Three1);
////            msgCondition = shipThreeSunk(msgCondition, Ships.ship1Three1);
////
////            resetCoordinates(row, column, 4, Ships.ship1Three2);
//////            msgCondition = shipThreeSunk(msgCondition, Ships.ship1Three2);
//////
//////            resetCoordinates(row, column, 2, Ships.ship1Two);
//////            msgCondition = shipTwoSunk(msgCondition, Ships.ship1Two);
////
////            shitHit(msgCondition);
////        }
////
////        shotMissed(grid1, grid2, row, column);
////
////        enteredWrongCoordinates(row, column);
////
////        endCondition = lastShipSunkPlayer1(endCondition);
////        return endCondition;
//    }
//
//    private static boolean player1Shot(String[][] grid1, String[][] grid2, boolean endCondition, int row, int column) {
//        if (grid2[row][column].equals("O") & row < grid1.length & row > 0 & column < grid1.length & column > 0) {
//
//            boolean msgCondition = true;
//
////            resetCoordinates(row, column, 8, Ships.ship2Five);
////            msgCondition = shipFiveSunk(msgCondition, Ships.ship2Five);
////
////            resetCoordinates(row, column, 7, Ships.ship2Four);
////            msgCondition = shipFourSunk(msgCondition, Ships.ship2Four);
////
////            resetCoordinates(row, column, 5, Ships.ship2Three1);
////            msgCondition = shipThreeSunk(msgCondition, Ships.ship2Three1);
////
////            resetCoordinates(row, column, 5, Ships.ship2Three2);
////            msgCondition = shipThreeSunk(msgCondition, Ships.ship2Three2);
////
////            resetCoordinates(row, column, 3, Ships.ship2Two);
////            msgCondition = shipTwoSunk(msgCondition, Ships.ship2Two);
//
////            shitHit(msgCondition);
////        }
////
////        shotMissed(grid2, grid1, row, column);
////
////        enteredWrongCoordinates(row, column);
////
////        endCondition = lastShipSunkPlayer2(endCondition);
////        return endCondition;
//    }
//
//    private static boolean lastShipSunkPlayer1(boolean endCondition) {
////        if (Ships.ship1Five[10] == 1 & Ships.ship1Four[8] == 1 & Ships.ship1Three1[6] == 1 & Ships.ship1Three2[6] == 1 & Ships.ship1Two[4] == 1) {
////            endCondition = false;
////            System.out.println("You sank the last ship. You won. Congratulations!");
////        }
//        return endCondition;
//    }
//
//    private static void resetCoordinates(int row, int column, int i2, int[] ship1Five) {
//        for (int i = 0, j = 1; i <= i2; i = i + 2, j = j + 2) {
//            if (row == ship1Five[i] & column == ship1Five[j]) {
//                ship1Five[i] = 0;
//                ship1Five[i + 1] = 0;
//            }
//        }
//    }
//
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
//
//    private static void shotMissed(String[][] grid1, String[][] grid2, int row, int column) {
//        if ("~".equals(grid1[row][column]) & row < grid1.length & row > 0 & column < grid1.length & column > 0) {
//            grid1[row][column] = "M";
////
////            new GridFog().show(grid1);
////            System.out.println("---------------------");
////
////            new Grid().show(grid2);
////            System.out.println("You missed.");
////        }
//    }
//
////    private static boolean lastShipSunkPlayer2(boolean endCondition) {
////        if (Ships.ship2Five[10] == 1 & Ships.ship2Four[8] == 1 & Ships.ship2Three1[6] == 1 & Ships.ship2Three2[6] == 1 & Ships.ship2Two[4] == 1) {
////            endCondition = false;
////            System.out.println("You sank the last ship. You won. Congratulations!");
////        }
////        return endCondition;
////    }
//
////    private static boolean shipFourSunk(boolean msgCondition, int[] ship2Four) {
////        if (ship2Four[8] == 0 & ship2Four[0] == 0 & ship2Four[1] == 0 & ship2Four[2] == 0 & ship2Four[3] == 0 & ship2Four[4] == 0 & ship2Four[5] == 0 & ship2Four[6] == 0 & ship2Four[7] == 0) {
////            System.out.println("You sank a ship! Specify a new target:");
////            ship2Four[8] = 1;
////            msgCondition = false;
////        }
////        return msgCondition;
////    }
//
////    private static boolean shipThreeSunk(boolean msgCondition, int[] ship2Three2) {
////        if (ship2Three2[6] == 0 & ship2Three2[0] == 0 & ship2Three2[1] == 0 & ship2Three2[2] == 0 & ship2Three2[3] == 0 & ship2Three2[4] == 0 & ship2Three2[5] == 0) {
////            System.out.println("You sank a ship! Specify a new target:");
////            ship2Three2[6] = 1;
////            msgCondition = false;
////        }
////        return msgCondition;
////    }
////
////    private static void shitHit(boolean msgCondition) {
////        if (msgCondition) {
////            System.out.println("You hit a ship! Try again:");
////        }
////    }
////
////    private static void enteredWrongCoordinates(int row, int column) {
////        if (row > 10 | column > 10 | row < 1 | column < 1) {
////            System.out.println("Error! You entered the wrong coordinates! Try again:");
////
////        }
////    }
}
