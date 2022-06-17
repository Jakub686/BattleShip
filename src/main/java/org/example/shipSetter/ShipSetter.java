package org.example.shipSetter;


//import battleship.InputConverter;
//import battleship.Show;

import org.example.InputConverter;
import org.example.view.Grid;

import java.util.Scanner;

public class ShipSetter {
    public static void shipSetup(String[][] grid, int[] shipFive, int[] shipFour, int[] shipThree1, int[] shipThree2, int[] shipTwo) {
        Scanner sc = new Scanner(System.in);
        do {
            boolean endCondition;
            new Grid().show(grid);

            //ship Five
            do {
                int state = 0;
                endCondition = true;
                System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells)");
                String inputString = sc.nextLine();
                int[] coordinates = new InputConverter().inputConverter(inputString);
                int row1 = coordinates[0];
                int row2 = coordinates[2];
                int column1 = coordinates[1];
                int column2 = coordinates[3];
                if (row1 == row2 & column2 == column1 + 4) {
                    grid[row1][column1] = "O";
                    grid[row2][column2] = "O";
                    for(int i = 1;i<5;i++)
                        grid[row1][column1 + i] = "O";

                    endCondition = false;
                    state = 1;
                    new Grid().show(grid);

                    CoordinatesSetter.verticalShipFive(shipFive, coordinates);
                }
                if (column1 == column2 & row2 == row1 + 4) {
                    grid[row1][column1] = "O";
                    grid[row2][column2] = "O";
                    for(int i = 1;i<5;i++)
                        grid[row1][column1 + i] = "O";

                    endCondition = false;
                    state = 1;
                    new Grid().show(grid);
                    CoordinatesSetter.horizontalShipFive(shipFive, coordinates);
                }
                if (state == 0) {
                    int temp = 0;
                    if (row1 == row2 & column2 == column1 + 1 |
                            row1 == row2 & column2 == column1 + 2 |
                            row1 == row2 & column2 == column1 + 3 |
                            row1 == row2 & column2 == column1 + 5 |
                            column1 == column2 & row2 == row1 + 1 |
                            column1 == column2 & row2 == row1 + 2 |
                            column1 == column2 & row2 == row1 + 3 |
                            column1 == column2 & row2 == row1 + 5) {
                        System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                        endCondition = true;
                        temp = 1;
                    }
                    if (!(row1 == row2 & column2 == column1 + 4 & column1 == column2 & row2 == row1 + 4) & temp == 0) {
                        System.out.println("Error! Wrong ship location! Try again:");
                        endCondition = true;
                    }
                }
            } while (endCondition);

            //ship Four
            do {
                int state = 0;
                endCondition = true;
                System.out.println("Enter the coordinates of the Battleship (4 cells):");
                String inputString = sc.nextLine();
                int[] coordinates = new InputConverter().inputConverter(inputString);
                int row1 = coordinates[0];
                int row2 = coordinates[2];
                int column1 = coordinates[1];
                int column2 = coordinates[3];
                if (row1 == row2 & column2 == column1 + 3 & grid[row1 - 1][column1] != "O" & grid[row1 - 1][column1 + 1] != "O" &
                        grid[row1 - 1][column1 + 2] != "O" & grid[row1 + 1][column1 + 3] != "O" & grid[row1 + 1][column1 + 4] != "O" &
                        grid[row1][column1 + 4] != "O" & grid[row1 + 1][column1 + 4] != "O" & grid[row1 + 1][column1 + 3] != "O" &
                        grid[row1 + 1][column1 + 2] != "O" & grid[row1 + 1][column1 + 1] != "O" & grid[row1 + 1][column1] != "O" &
                        grid[row1 + 1][column1 - 1] != "O" & grid[row1][column1 - 1] != "O" & grid[row1 - 1][column1 - 1] != "O") {
                    grid[row1][column1] = "O";
                    grid[row2][column2] = "O";
                    for(int i = 1;i<4;i++)
                        grid[row1][column1 + i] = "O";

                    endCondition = false;
                    state = 1;
                    new Grid().show(grid);
                    CoordinatesSetter.verticalShipFour(shipFour, coordinates);
                }
                if (column1 == column2 & row2 == row1 + 3 & grid[row1 - 1][column1 + 1] != "O" & grid[row1][column1 + 1] != "O" &
                        grid[row1 + 1][column1 + 1] != "O" & grid[row1 + 2][column1 + 1] != "O" & grid[row1 + 3][column1 + 1] != "O" &
                        grid[row1 + 4][column1 + 1] != "O" & grid[row1 + 4][column1] != "O" & grid[row1 + 4][column1 - 1] != "O" &
                        grid[row1 + 3][column1 - 1] != "O" & grid[row1 + 2][column1 - 1] != "O" & grid[row1 + 1][column1 - 1] != "O" &
                        grid[row1][column1 - 1] != "O" & grid[row1 - 1][column1 - 1] != "O" & grid[row1 - 1][column1] != "O") {
                    grid[row1][column1] = "O";
                    grid[row2][column2] = "O";
                    grid[row1 + 1][column1] = "O";
                    grid[row1 + 2][column1] = "O";
                    grid[row1 + 3][column1] = "O";
                    endCondition = false;
                    state = 1;
                    new Grid().show(grid);
                    CoordinatesSetter.horizontalShipFour(shipFour, coordinates);
                }
                if (state == 0) {
                    int temp = 0;
                    if (row1 == row2 & column2 == column1 + 1 |
                            row1 == row2 & column2 == column1 + 2 |
                            row1 == row2 & column2 == column1 + 4 |
                            row1 == row2 & column2 == column1 + 5 |
                            column1 == column2 & row2 == row1 + 1 |
                            column1 == column2 & row2 == row1 + 2 |
                            column1 == column2 & row2 == row1 + 4 |
                            column1 == column2 & row2 == row1 + 5) {
                        System.out.println("Error! Wrong length of the Battleship! Try again:");
                        endCondition = true;
                        temp = 1;
                    }
                    if (!(row1 == row2 & column2 == column1 + 3 | column1 == column2 & row2 == row1 + 3) & temp == 0) {
                        System.out.println("Error! Wrong ship location! Try again:");
                        endCondition = true;
                    }
                    if ((grid[row1 - 1][column1 + 1] == "O" | grid[row1][column1 + 1] == "O" |
                            grid[row1 + 1][column1 + 1] == "O" | grid[row1 + 2][column1 + 1] == "O" | grid[row1 + 3][column1 + 1] == "O" |
                            grid[row1 + 4][column1 + 1] == "O" | grid[row1 + 4][column1] == "O" | grid[row1 + 4][column1 - 1] == "O" |
                            grid[row1 + 3][column1 - 1] == "O" | grid[row1 + 2][column1 - 1] == "O" | grid[row1 + 1][column1 - 1] == "O" |
                            grid[row1][column1 - 1] == "O") | (grid[row1 - 1][column1] == "O" | grid[row1 - 1][column1 + 1] == "O" |
                            grid[row1 - 1][column1 + 2] == "O" | grid[row1 + 1][column1 + 3] == "O" | grid[row1 + 1][column1 + 4] == "O" |
                            grid[row1][column1 + 4] == "O" | grid[row1 + 1][column1 + 4] == "O" | grid[row1 + 1][column1 + 3] == "O" |
                            grid[row1 + 1][column1 + 2] == "O" | grid[row1 + 1][column1 + 1] == "O" | grid[row1 + 1][column1] == "O" |
                            grid[row1 + 1][column1 - 1] == "O" | grid[row1][column1 - 1] == "O" | grid[row1 - 1][column1 - 1] == "O")) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        endCondition = true;
                    }
                }
            } while (endCondition);

            //ship Three 1
            do {
                int state = 0;
                endCondition = true;
                System.out.println("Enter the coordinates of the Submarine  (3 cells):");
                String inputString = sc.nextLine();
                int[] coordinates = new InputConverter().inputConverter(inputString);
                int row1 = coordinates[0];
                int row2 = coordinates[2];
                int column1 = coordinates[1];
                int column2 = coordinates[3];
                if (row1 == row2 & column2 == column1 + 2 & grid[row1 - 1][column1] != "O" & grid[row1 - 1][column1 + 1] != "O" &
                        grid[row1 - 1][column1 + 2] != "O" & grid[row1 - 1][column1 + 3] != "O" &
                        grid[row1][column1 + 3] != "O" & grid[row1 + 1][column1 + 3] != "O" &
                        grid[row1 + 1][column1 + 2] != "O" & grid[row1 + 1][column1 + 1] != "O" & grid[row1 + 1][column1] != "O" &
                        grid[row1 + 1][column1 - 1] != "O" & grid[row1][column1 - 1] != "O" & grid[row1 - 1][column1 - 1] != "O") {
                    grid[row1][column1] = "O";
                    grid[row2][column2] = "O";
                    grid[row1][column1 + 1] = "O";
                    grid[row1][column1 + 2] = "O";
                    endCondition = false;
                    state = 1;
                    new Grid().show(grid);
                    CoordinatesSetter.verticalShipThree(shipThree1, coordinates);
                }
                if (column1 == column2 & row2 == row1 + 2 & grid[row1 - 1][column1 + 1] != "O" & grid[row1][column1 + 1] != "O" &
                        grid[row1 + 1][column1 + 1] != "O" & grid[row1 + 2][column1 + 1] != "O" & grid[row1 + 3][column1 + 1] != "O" &
                        grid[row1 + 3][column1] != "O" &
                        grid[row1 + 3][column1 - 1] != "O" & grid[row1 + 2][column1 - 1] != "O" & grid[row1 + 1][column1 - 1] != "O" &
                        grid[row1][column1 - 1] != "O" & grid[row1 - 1][column1 - 1] != "O" & grid[row1 - 1][column1] != "O") {
                    grid[row1][column1] = "O";
                    grid[row2][column2] = "O";
                    grid[row1 + 1][column1] = "O";
                    grid[row1 + 2][column1] = "O";
                    endCondition = false;
                    state = 1;
                    new Grid().show(grid);
                    CoordinatesSetter.horizontalShipThree(shipThree1, coordinates);
                }
                if (state == 0) {
                    int temp = 0;
                    if (row1 == row2 & column2 == column1 + 1 |
                            row1 == row2 & column2 == column1 + 3 |
                            row1 == row2 & column2 == column1 + 4 |
                            row1 == row2 & column2 == column1 + 5 |
                            column1 == column2 & row2 == row1 + 1 |
                            column1 == column2 & row2 == row1 + 3 |
                            column1 == column2 & row2 == row1 + 4 |
                            column1 == column2 & row2 == row1 + 5) {
                        System.out.println("Error! Wrong length of the Submarine! Try again:");
                        endCondition = true;
                        temp = 1;
                    }
                    if (!(row1 == row2 & column2 == column1 + 2 | column1 == column2 & row2 == row1 + 2) & temp == 0) {
                        System.out.println("Error! Wrong ship location! Try again:");
                        endCondition = true;
                    }
                    if ((grid[row1 - 1][column1 + 1] == "O" | grid[row1][column1 + 1] == "O" |
                            grid[row1 + 1][column1 + 1] == "O" | grid[row1 + 2][column1 + 1] == "O" | grid[row1 + 3][column1 + 1] == "O" |
                            grid[row1 + 3][column1] == "O" | grid[row1 + 3][column1 - 1] == "O" | grid[row1 + 2][column1 - 1] == "O" |
                            grid[row1 + 1][column1 - 1] == "O" | grid[row1][column1 - 1] == "O") | (grid[row1 - 1][column1] == "O" |
                            grid[row1 - 1][column1 + 1] == "O" | grid[row1 - 1][column1 + 2] == "O" & grid[row1 + 1][column1 + 3] == "O" |
                            grid[row1][column1 + 3] == "O" | grid[row1 + 1][column1 + 3] == "O" | grid[row1 + 1][column1 + 2] == "O" |
                            grid[row1 + 1][column1 + 1] == "O" | grid[row1 + 1][column1] == "O" | grid[row1 + 1][column1 - 1] == "O" |
                            grid[row1][column1 - 1] == "O" | grid[row1 - 1][column1 - 1] == "O")) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        endCondition = true;
                    }
                }
            } while (endCondition);

            //ship Three 2
            do {
                int state = 0;
                endCondition = true;
                System.out.println("Enter the coordinates of the Cruiser   (3 cells):");
                String inputString = sc.nextLine();
                int[] coordinates = new InputConverter().inputConverter(inputString);
                int row1 = coordinates[0];
                int row2 = coordinates[2];
                int column1 = coordinates[1];
                int column2 = coordinates[3];
                if (row1 == row2 & column2 == column1 + 2 & grid[row1 - 1][column1] != "O" & grid[row1 - 1][column1 + 1] != "O" &
                        grid[row1 - 1][column1 + 2] != "O" & grid[row1 - 1][column1 + 3] != "O" &
                        grid[row1][column1 + 3] != "O" & grid[row1 + 1][column1 + 3] != "O" &
                        grid[row1 + 1][column1 + 2] != "O" & grid[row1 + 1][column1 + 1] != "O" & grid[row1 + 1][column1] != "O" &
                        grid[row1 + 1][column1 - 1] != "O" & grid[row1][column1 - 1] != "O" & grid[row1 - 1][column1 - 1] != "O") {
                    grid[row1][column1] = "O";
                    grid[row2][column2] = "O";
                    grid[row1][column1 + 1] = "O";
                    grid[row1][column1 + 2] = "O";
                    endCondition = false;
                    state = 1;
                    new Grid().show(grid);
                    CoordinatesSetter.verticalShipThree(shipThree2, coordinates);
                }
                if (column1 == column2 & row2 == row1 + 2 & grid[row1 - 1][column1 + 1] != "O" & grid[row1][column1 + 1] != "O" &
                        grid[row1 + 1][column1 + 1] != "O" & grid[row1 + 2][column1 + 1] != "O" & grid[row1 + 3][column1 + 1] != "O" &
                        grid[row1 + 3][column1] != "O" &
                        grid[row1 + 3][column1 - 1] != "O" & grid[row1 + 2][column1 - 1] != "O" & grid[row1 + 1][column1 - 1] != "O" &
                        grid[row1][column1 - 1] != "O" & grid[row1 - 1][column1 - 1] != "O" & grid[row1 - 1][column1] != "O") {
                    grid[row1][column1] = "O";
                    grid[row2][column2] = "O";
                    grid[row1 + 1][column1] = "O";
                    grid[row1 + 2][column1] = "O";
                    endCondition = false;
                    state = 1;
                    new Grid().show(grid);
                    CoordinatesSetter.horizontalShipThree(shipThree2, coordinates);
                }
                if (state == 0) {
                    int temp = 0;
                    if (row1 == row2 & column2 == column1 + 1 |
                            row1 == row2 & column2 == column1 + 3 |
                            row1 == row2 & column2 == column1 + 4 |
                            row1 == row2 & column2 == column1 + 5 |
                            column1 == column2 & row2 == row1 + 1 |
                            column1 == column2 & row2 == row1 + 3 |
                            column1 == column2 & row2 == row1 + 4 |
                            column1 == column2 & row2 == row1 + 5) {
                        System.out.println("Error! Wrong length of the Cruiser ! Try again:");
                        endCondition = true;
                        temp = 1;
                    }
                    if (!(row1 == row2 & column2 == column1 + 2 | column1 == column2 & row2 == row1 + 2) & temp == 0) {
                        System.out.println("Error! Wrong ship location! Try again:");
                        endCondition = true;
                    }
                    if ((grid[row1 - 1][column1 + 1] == "O" | grid[row1][column1 + 1] == "O" |
                            grid[row1 + 1][column1 + 1] == "O" | grid[row1 + 2][column1 + 1] == "O" | grid[row1 + 3][column1 + 1] == "O" |
                            grid[row1 + 3][column1] == "O" | grid[row1 + 3][column1 - 1] == "O" | grid[row1 + 2][column1 - 1] == "O" |
                            grid[row1 + 1][column1 - 1] == "O" | grid[row1][column1 - 1] == "O") | (grid[row1 - 1][column1] == "O" |
                            grid[row1 - 1][column1 + 1] == "O" | grid[row1 - 1][column1 + 2] == "O" & grid[row1 + 1][column1 + 3] == "O" |
                            grid[row1][column1 + 3] == "O" | grid[row1 + 1][column1 + 3] == "O" | grid[row1 + 1][column1 + 2] == "O" |
                            grid[row1 + 1][column1 + 1] == "O" | grid[row1 + 1][column1] == "O" | grid[row1 + 1][column1 - 1] == "O" |
                            grid[row1][column1 - 1] == "O" | grid[row1 - 1][column1 - 1] == "O")) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        endCondition = true;
                    }
                }
            } while (endCondition);

            //ship Two
            do {
                int state = 0;
                endCondition = true;
                System.out.println("Enter the coordinates of the Destroyer (2 cells):");
                String inputString = sc.nextLine();
                int[] coordinates = new InputConverter().inputConverter(inputString);
                int row1 = coordinates[0];
                int row2 = coordinates[2];
                int column1 = coordinates[1];
                int column2 = coordinates[3];
                if (row1 == row2 & column2 == column1 + 1 & grid[row1 - 1][column1] != "O" & grid[row1 - 1][column1 + 1] != "O" &
                        grid[row1 - 1][column1 + 2] != "O" & grid[row1][column1 + 2] != "O" &
                        grid[row1 + 1][column1 + 2] != "O" & grid[row1 + 1][column1 + 1] != "O" & grid[row1 + 1][column1] != "O" &
                        grid[row1 + 1][column1 - 1] != "O" & grid[row1][column1 - 1] != "O" & grid[row1 - 1][column1 - 1] != "O") {
                    grid[row1][column1] = "O";
                    grid[row2][column2] = "O";
                    grid[row1][column1 + 1] = "O";
                    endCondition = false;
                    state = 1;
                    new Grid().show(grid);

                    CoordinatesSetter.verticalHorizontalShipTwo(shipTwo, coordinates);
                }
                if (column1 == column2 & row2 == row1 + 1 & grid[row1 - 1][column1 + 1] != "O" & grid[row1][column1 + 1] != "O" &
                        grid[row1 + 1][column1 + 1] != "O" & grid[row1 + 2][column1 + 1] != "O" &
                        grid[row1 + 2][column1] != "O" &
                        grid[row1 + 2][column1 - 1] != "O" & grid[row1 + 1][column1 - 1] != "O" &
                        grid[row1][column1 - 1] != "O" & grid[row1 - 1][column1 - 1] != "O" & grid[row1 - 1][column1] != "O") {
                    grid[row1][column1] = "O";
                    grid[row2][column2] = "O";
                    grid[row1 + 1][column1] = "O";
                    endCondition = false;
                    state = 1;
                    new Grid().show(grid);

                    CoordinatesSetter.verticalHorizontalShipTwo(shipTwo, coordinates);
                }
                if (state == 0) {
                    int temp = 0;
                    if (row1 == row2 & column2 == column1 + 2 |
                            row1 == row2 & column2 == column1 + 3 |
                            row1 == row2 & column2 == column1 + 4 |
                            row1 == row2 & column2 == column1 + 5 |
                            column1 == column2 & row2 == row1 + 2 |
                            column1 == column2 & row2 == row1 + 3 |
                            column1 == column2 & row2 == row1 + 4 |
                            column1 == column2 & row2 == row1 + 5) {
                        System.out.println("Error! Wrong length of the Battleship! Try again:");
                        endCondition = true;
                        temp = 1;
                    }
                    if (!(row1 == row2 & column2 == column1 + 1 | column1 == column2 & row2 == row1 + 1) & temp == 0) {
                        System.out.println("Error! Wrong ship location! Try again:");
                        endCondition = true;
                    }
                    if (grid[row1 - 1][column1] == "O" | grid[row1 - 1][column1 + 1] == "O" |
                            grid[row1 - 1][column1 + 2] == "O" | grid[row1][column1 + 2] == "O" |
                            grid[row1 + 1][column1 + 2] == "O" | grid[row1 + 1][column1 + 1] == "O" | grid[row1 + 1][column1] == "O" |
                            grid[row1 + 1][column1 - 1] == "O" | grid[row1][column1 - 1] == "O" | grid[row1 - 1][column1 - 1] == "O" |
                            grid[row1 - 1][column1 + 1] == "O" | grid[row1][column1 + 1] == "O" |
                            grid[row1 + 1][column1 + 1] == "O" | grid[row1 + 2][column1 + 1] == "O" |
                            grid[row1 + 2][column1] == "O" | grid[row1 + 2][column1 - 1] == "O" | grid[row1 + 1][column1 - 1] == "O" |
                            grid[row1][column1 - 1] == "O" | grid[row1 - 1][column1 - 1] == "O" | grid[row1 - 1][column1] == "O") {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        endCondition = true;
                    }
                }
            } while (endCondition);
        } while (false);
    }


}