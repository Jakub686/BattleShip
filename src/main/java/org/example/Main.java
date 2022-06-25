package org.example;

import org.example.model.Grid;
import org.example.view.Show;

public class Main
{
    public static void main( String[] args )
    {
        String[][] grid1 = new Grid().getGrid(16, 16);
        String[][] grid2 = new Grid().getGrid(16, 16);
        Show.showGrid(grid1);
        Show.showGridFog(grid2);
    }
}
