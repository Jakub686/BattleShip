package org.example;

import jdk.swing.interop.SwingInterOpUtils;
import org.example.model.Grid;
import org.example.view.Show;

import java.util.Scanner;

public class ShipsSetter {
    public static void shipsSetter(String[][] grid, Ship shipFive,Ship shipFour,Ship shipThree1,Ship shipThree2,Ship shipTwo) {
        Scanner sc = new Scanner(System.in);

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
            System.out.println("Enter the coordinates of the " + ship.getShiptype() + " ("+ship.getShiptype().getLength()+")");
            int[] coordinates = new ConverterUserInputIntoCartesianCoordinates().inputConverterForShipSetting();
            int row1 = coordinates[0];
            int row2 = coordinates[2];
            int column1 = coordinates[1];
            int column2 = coordinates[3];
            if (row1 == row2 & column2 == column1 + ship.getShiptype().getLength()-1) {
                grid[row1][column1] = "O";
                grid[row2][column2] = "O";
                for(int i = 1 ; i <ship.getShiptype().getLength() ; i++)
                    grid[row1][column1 + i] = "O";

                endCondition = false;
                state = 1; // Ship successfully set
                new Show().showGrid(grid);

            }
            if (column1 == column2 & row2 == row1 + ship.getShiptype().getLength()-1) {
                grid[row1][column1] = "O";
                grid[row2][column2] = "O";
                for(int i = 1 ; i <ship.getShiptype().getLength() ; i++)
                    grid[row1][column1 + i] = "O";

                endCondition = false;
                state = 1;  // Ship successfully set
                new Show().showGrid(grid);
                ship.getShiptype().setCoordinates(new int[] {coordinates[0],coordinates[1],coordinates[0],coordinates[1] + 1,coordinates[0],coordinates[1] + 2,coordinates[0],coordinates[1] + 3,coordinates[0],coordinates[2],coordinates[3]});

            }
            // if ship not successfully set, then check for errors
            if (state == 0) {
                int temp = 0;

                for(int i = 0 ; i <= ShipType.longestShip; i++){
                    if (!(row1 == row2 & column2 == column1 + i) & ship.getShiptype().getLength() == i) {
                        System.out.println("Error! Wrong length of the "+ ship.getShiptype()+"! Try again:");
                        endCondition = true;
                        temp = 1;
                    }
                }

                if (!(row1 == row2 & column2 == column1 + 4 & column1 == column2 & row2 == row1 + 4) & temp == 0) {
                    System.out.println("Error! Wrong ship location! Try again:");
                    endCondition = true;
                }
            }
        } while (endCondition);
    }

}
