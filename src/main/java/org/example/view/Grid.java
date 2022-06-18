package org.example.view;

public class Grid implements IGrid  {

    @Override
     public  void show(String[][] grid) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
