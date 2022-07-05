package org.example.model;

public class GridFog implements IGrid{

    public static int margin = 6; // margin prevents index out of bounds exception

    @Override
    public String[][] getGrid(int rows, int columns) {

        rows = rows + margin;
        columns = columns + margin;
        String[][] grid = new String[rows][columns];
        grid[0][0] = " ";
        for (int i = 1; i < columns; i++) {
            grid[0][i] = String.valueOf(i);
        }
        char c = 'A';
        for (int i = 1; i < rows; i++) {
            grid[i][0] = String.valueOf(c);
            c++;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                grid[i][j] = "~";
            }
        }
        return grid;
    }
}
