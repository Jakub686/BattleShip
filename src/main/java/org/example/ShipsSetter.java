package org.example;

import org.example.view.Show;

import java.util.Locale;
import java.util.Scanner;

public class ShipsSetter {
    public static void shipsSetter(String[][] grid, Ship shipFive,Ship shipFour,Ship shipThree1,Ship shipThree2,Ship shipTwo) {

        shipSetup(shipFive, grid);
        shipSetup(shipFour, grid);
        shipSetup(shipThree1, grid);
        shipSetup(shipThree2, grid);
        shipSetup(shipTwo, grid);
    }

    private static void shipSetup(Ship ship, String[][] grid){

        boolean endCondition;
        do {
            int state = 0;
            endCondition = true;
            System.out.println("Enter the setCoordinates of the " + ship.getShiptype() + " ("+ship.getShiptype().getLength()+")");

            int[] setCoordinates = ConverterUserInputIntoCartesianCoordinates.inputConverterForShipSetting(userInput());
            int row1 = setCoordinates[0];
            int row2 = setCoordinates[2];
            int column1 = setCoordinates[1];
            int column2 = setCoordinates[3];

            //vertical ship set
            endCondition = verticalShipSet(ship, grid, endCondition, setCoordinates, row1, row2, column1, column2);
            //horizontal ship set
            endCondition = horizontalShipSet(ship, grid, endCondition, setCoordinates, row1, row2, column1, column2);

            // if ship not successfully set, then check for errors
            int[] shipCoordinates = ship.getShiptype().getCoordinates();
            if (shipCoordinates[ship.getShiptype().getLength()-1] !=1) {
                endCondition = checkLengthSetErorr(ship,row1,row2,column1,column2);
            }
        } while (endCondition);
    }

    private static boolean horizontalShipSet(Ship ship, String[][] grid, boolean endCondition, int[] setCoordinates, int row1, int row2, int column1, int column2) {
        if (column1 == column2 & row2 == row1 + ship.getShiptype().getLength()-1) {
            grid[row1][column1] = "O";
            grid[row2][column2] = "O";
            for(int i = 1; i < ship.getShiptype().getLength() ; i++)
                grid[row1 + i][column1] = "O";

            endCondition = false;
            new Show().showGrid(grid);
            ship.getShiptype().setCoordinates(new int[] {setCoordinates[0], setCoordinates[1], setCoordinates[0], setCoordinates[1] + 1, setCoordinates[0], setCoordinates[1] + 2, setCoordinates[0], setCoordinates[1] + 3, setCoordinates[0], setCoordinates[2],1,0}); ;// Ship successfully set
        }
        return endCondition;
    }

    private static boolean verticalShipSet(Ship ship, String[][] grid, boolean endCondition, int[] setCoordinates, int row1, int row2, int column1, int column2) {
        if (row1 == row2 & column2 == column1 + ship.getShiptype().getLength()-1) {
            grid[row1][column1] = "O";
            grid[row2][column2] = "O";
            for(int i = 1; i < ship.getShiptype().getLength() ; i++)
                grid[row1][column1 + i] = "O";

            endCondition = false;

            ship.getShiptype().setCoordinates(new int[] {setCoordinates[0], setCoordinates[1], setCoordinates[0], setCoordinates[1] + 1, setCoordinates[0], setCoordinates[1] + 2, setCoordinates[0], setCoordinates[1] + 3, setCoordinates[0], setCoordinates[2],1,0}); ;// Ship successfully set
            new Show().showGrid(grid);
        }
        return endCondition;
    }

    private static boolean checkLengthSetErorr(Ship ship,int row1, int row2, int column1, int column2){
        boolean endCondition = false;

        for(int i = 0 ; i <= ShipType.longestShip; i++){
            if (!(row1 != row2 & column2 != column1 + i) & ship.getShiptype().getLength() == i | !(row2 + i != row1 & column1 != column2) & ship.getShiptype().getLength() == i ) {
                System.out.println("Error! Wrong length of the "+ ship.getShiptype()+"! Try again:");
                endCondition = true;

            }
        }
        return endCondition;
    }

    private static String[] userInput() {
        Scanner sc = new Scanner(System.in);

        String[] inputString = new String[4];

        System.out.println("First row ");
        inputString[0] = sc.nextLine().toUpperCase(Locale.ROOT);

        System.out.println("First column ");
        inputString[1] = sc.nextLine().toUpperCase(Locale.ROOT);

        System.out.println("Second row ");
        inputString[2] = sc.nextLine().toUpperCase(Locale.ROOT);

        System.out.println("Second column");
        inputString[3] = sc.nextLine().toUpperCase(Locale.ROOT);

        return inputString;
    }
}
