package org.example.shipSetter;


//import battleship.InputConverter;
//import battleship.Show;

import org.example.InputConverter;
import org.example.view.Grid;

import java.util.Scanner;

public class ShipSetter {
    public static void shipSetup(String[][] grid, int[] shipFive, int[] shipFour, int[] shipThree1, int[] shipThree2, int[] shipTwo) {
        Scanner sc = new Scanner(System.in);

        new Grid().show(grid);

        shipFiveSet(grid, shipFive, sc);

        ShipFourSet(grid, shipFour, sc);

        shipThree1Set(grid, shipThree1, sc);

        shipThree2Set(grid, shipThree2, sc);

        shitTwoSet(grid, shipTwo, sc);
    }

    private static void shitTwoSet(String[][] grid, int[] shipTwo, Scanner sc) {
        boolean endCondition;
        do {
            int state = 0; // if state == 0 show error, after successfully set a ship, state equals 1
            endCondition = true;
            System.out.println("Enter the coordinates of the Destroyer (2 cells):");
            String inputString = sc.nextLine();
            int[] coordinates = new InputConverter().inputConverter(inputString);
            int row1 = coordinates[0];
            int row2 = coordinates[2];
            int column1 = coordinates[1];
            int column2 = coordinates[3];
            //vertical set
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
            //horizontal set
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
                endCondition = shipTwoError(grid, endCondition, row1, row2, column1, column2, temp);
            }
        } while (endCondition);
    }

    private static void shipThree2Set(String[][] grid, int[] shipThree2, Scanner sc) {
        boolean endCondition;
        do {
            int state = 0; // if state == 0 show error, after successfully set a ship, state equals 1
            endCondition = true;
            System.out.println("Enter the coordinates of the Cruiser   (3 cells):");
            String inputString = sc.nextLine();
            int[] coordinates = new InputConverter().inputConverter(inputString);
            int row1 = coordinates[0];
            int row2 = coordinates[2];
            int column1 = coordinates[1];
            int column2 = coordinates[3];
            //vertical set
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
            //horizontal set
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
                endCondition = shipThree2Error(grid, endCondition, row1, row2, column1, column2, temp);
            }
        } while (endCondition);
    }

    private static void shipThree1Set(String[][] grid, int[] shipThree1, Scanner sc) {
        boolean endCondition;
        do {
            int state = 0; // if state == 0 show error, after successfully set a ship, state equals 1
            endCondition = true;
            System.out.println("Enter the coordinates of the Submarine  (3 cells):");
            String inputString = sc.nextLine();
            int[] coordinates = new InputConverter().inputConverter(inputString);
            int row1 = coordinates[0];

            int row2 = coordinates[2];
            int column1 = coordinates[1];
            int column2 = coordinates[3];
            //vertical set
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
            //horizontal set
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
                endCondition = shipThree1Error(grid, endCondition, row1, row2, column1, column2, temp);
            }
        } while (endCondition);
    }

    private static void ShipFourSet(String[][] grid, int[] shipFour, Scanner sc) {
        boolean endCondition;
        do {
            int state = 0; // if state == 0 show error, after successfully set a ship, state equals 1
            endCondition = true;
            System.out.println("Enter the coordinates of the Battleship (4 cells):");
            String inputString = sc.nextLine();
            int[] coordinates = new InputConverter().inputConverter(inputString);
            int row1 = coordinates[0];
            int row2 = coordinates[2];
            int column1 = coordinates[1];
            int column2 = coordinates[3];
            //vertical set
            if (row1 == row2 & column2 == column1 + 3 & grid[row1 - 1][column1] != "O" & grid[row1 - 1][column1 + 1] != "O" &
                    grid[row1 - 1][column1 + 2] != "O" & grid[row1 + 1][column1 + 3] != "O" & grid[row1 + 1][column1 + 4] != "O" &
                    grid[row1][column1 + 4] != "O" & grid[row1 + 1][column1 + 4] != "O" & grid[row1 + 1][column1 + 3] != "O" &
                    grid[row1 + 1][column1 + 2] != "O" & grid[row1 + 1][column1 + 1] != "O" & grid[row1 + 1][column1] != "O" &
                    grid[row1 + 1][column1 - 1] != "O" & grid[row1][column1 - 1] != "O" & grid[row1 - 1][column1 - 1] != "O") {
                grid[row1][column1] = "O";
                grid[row2][column2] = "O";
                for (int i = 1; i < 4; i++)
                    grid[row1][column1 + i] = "O";

                endCondition = false;
                state = 1;
                //new Show().showGrid(grid);
                new Grid().show(grid);
                CoordinatesSetter.verticalShipFour(shipFour, coordinates);
            }
            //horizontal set
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
                //new Show().showGrid(grid);
                new Grid().show(grid);
                CoordinatesSetter.horizontalShipFour(shipFour, coordinates);
            }
            if (state == 0) {
                int temp = 0;
                endCondition = shipFourError(grid, endCondition, row1, row2, column1, column2, temp);
            }
        } while (endCondition);
    }

    private static void shipFiveSet(String[][] grid, int[] shipFive, Scanner sc) {
        boolean endCondition;
        do {
            int state = 0; // if state == 0 show error, after successfully set a ship, state equals 1
            endCondition = true;
            System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells)");
            String inputString = sc.nextLine();
            int[] coordinates = new InputConverter().inputConverter(inputString);
            int row1 = coordinates[0];
            int row2 = coordinates[2];
            int column1 = coordinates[1];
            int column2 = coordinates[3];
            //vertical set
            if (row1 == row2 & column2 == column1 + 4) {
                grid[row1][column1] = "O";
                grid[row2][column2] = "O";
                for (int i = 1; i < 5; i++)
                    grid[row1][column1 + i] = "O";

                endCondition = false;
                state = 1;
                //new Show().showGrid(grid);
                new Grid().show(grid);

                CoordinatesSetter.verticalShipFive(shipFive, coordinates);
            }
            //horizontal set
            if (column1 == column2 & row2 == row1 + 4) {
                grid[row1][column1] = "O";
                grid[row2][column2] = "O";
                for (int i = 1; i < 5; i++)
                    grid[row1][column1 + i] = "O";

                endCondition = false;
                state = 1;
                //new Show().showGrid(grid);
                new Grid().show(grid);
                CoordinatesSetter.horizontalShipFive(shipFive, coordinates);
            }
            endCondition = shipFiveError(endCondition, state, row1, row2, column1, column2);
        } while (endCondition);
    }

    private static boolean shipTwoError(String[][] grid, boolean endCondition, int row1, int row2, int column1, int column2, int temp) {
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
        return endCondition;
    }

    private static boolean shipThree2Error(String[][] grid, boolean endCondition, int row1, int row2, int column1, int column2, int temp) {
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
        return endCondition;
    }

    private static boolean shipThree1Error(String[][] grid, boolean endCondition, int row1, int row2, int column1, int column2, int temp) {
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
        return endCondition;
    }

    private static boolean shipFourError(String[][] grid, boolean endCondition, int row1, int row2, int column1, int column2, int temp) {
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
        return endCondition;
    }

    private static boolean shipFiveError(boolean endCondition, int state, int row1, int row2, int column1, int column2) {
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
        return endCondition;
    }


}
