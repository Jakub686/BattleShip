package org.example;

import org.example.view.Grid;
import org.example.view.GridFog;

public class Main
{
    public static void main( String[] args )
    {
        String[][] grid1 = new org.example.model.Grid().getGrid(16, 16);
        String[][] grid2 = new org.example.model.Grid().getGrid(16, 16);

        //TODO musze stworzyc nowy obiekty, bo Grid i GridFog implementuja IGrid, a w interfacie metoda statyczna musi miec cialo, a chyba zalezalo nam na tym aby nie miala ciala
        new Grid().show(grid1);
        new GridFog().show(grid2);
    }
}
