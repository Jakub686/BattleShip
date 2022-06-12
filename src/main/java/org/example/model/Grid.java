package org.example.model;

public class Grid {
    public String[][] getGrid(int row, int column) {
        String[][] grid = new String[row + 1][column + 1];
        grid[0][0] = " ";
        for (int i = 1; i < column + 1; i++) {
            grid[0][i] = String.valueOf(i);
        }
        char c = 'A';
        for (int i = 1; i < row + 1; i++) {
            grid[i][0] = String.valueOf(c);
            c++;
        }
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < column + 1; j++) {
                grid[i][j] = "~";
            }
        }
        return grid;
    }
}
