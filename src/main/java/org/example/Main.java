package org.example;

import org.example.view.Grid;
import org.example.view.GridFog;

public class Main
{
    public static void main( String[] args )
    {
        String[][] grid1 = new org.example.model.Grid().getGrid(16, 16);
        String[][] grid2 = new org.example.model.Grid().getGrid(16, 16);
        new Grid().show(grid1);
        new GridFog().show(grid2);
    }
}
