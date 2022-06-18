package org.example;

import org.example.shipSetter.ShipSetter;
import org.example.view.Grid;
import org.example.view.GridFog;

import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        String[][] grid1 = new org.example.model.Grid().getGrid(16, 16);
        String[][] grid2 = new org.example.model.Grid().getGrid(16, 16);

        //TODO musze stworzyc nowy obiekty, bo Grid i GridFog implementuja IGrid, a w interfacie metoda statyczna musi miec cialo, a chyba zalezalo nam na tym aby nie miala ciala
//        new Grid().show(grid1);
//        new GridFog().show(grid2);

        System.out.println("Player 1, place your ships on the game field");
        new ShipSetter().shipSetup(grid1, Ships.ship1Five, Ships.ship1Four, Ships.ship1Three1, Ships.ship1Three2, Ships.ship1Two);

        System.out.println("Press Enter and pass the move to another player");
        Scanner sc = new Scanner(System.in);
        String anotherPlayer = sc.nextLine();
        //Setting ship for player 2
        System.out.println("Player 2, place your ships to the game field");
        if (anotherPlayer.equals(""))
            new ShipSetter().shipSetup(grid2, Ships.ship2Five, Ships.ship2Four, Ships.ship2Three1, Ships.ship2Three2, Ships.ship2Two);
    }
}
