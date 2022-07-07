package com.github.jakub686.view;

import com.github.jakub686.model.Grid;

public class Show {

    public static void showGrid(String[][] grid) {
        for (int i = 0; i < grid.length - Grid.margin; i++) {
            for (int j = 0; j < grid.length - Grid.margin; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
