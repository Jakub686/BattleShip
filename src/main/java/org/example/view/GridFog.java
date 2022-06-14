package org.example.view;

public class GridFog implements IGrid {

    @Override
    public void show(String[][] grid) {

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (grid[i][j] == "~" | grid[i][j] == "O") {
                    System.out.print("~" + " ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
