package org.example.model;

public class Grid {
    public String[][] getGrid(int row, int column) {
        String[][] grid = new String[row][column];
        grid[0][0] = " ";
        //grid row
        for (int i = 1; i < column; i++) {
            grid[0][i] = String.valueOf(i);
        }
        //grid column
        char c = 'A';
        for (int i = 1; i < row; i++) {
            grid[i][0] = String.valueOf(c);
            c++;
        }
        //fog of war
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] = "~";
            }
        }
        return grid;
    }
}
