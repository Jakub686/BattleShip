package org.example;

import org.example.view.Grid;

public class Main
{
    public static void main( String[] args )
    {
        String[][] grid1 = new org.example.model.Grid().getGrid(16, 16);
        String[][] grid2 = new org.example.model.Grid().getGrid(16, 16);
        Grid.showGrid(grid1);
        Grid.showGridFog(grid2);
    }
}
