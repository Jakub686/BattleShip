package org.example;

import org.example.view.Grid;
import org.example.view.GridFog;

import java.util.Scanner;

public class Shot {
    public static void shot(String[][] grid1, String[][] grid2) {
        boolean endCondition = true;
        do {
            Scanner s = new Scanner(System.in);

            //Playe 1, shot at playere 2

            new GridFog().show(grid2);
            System.out.println("---------------------");

            new Grid().show(grid1);
            System.out.println("Player 1, it's your turn:");
            String inputString = s.nextLine();
            int[] coordinates = new InputConverter().inputConverter(inputString);
            int row = coordinates[0];
            int column = coordinates[1];

            if (grid2[row][column].equals("O") & row < 11 & row > 0 & column < 11 & column > 0) {
                grid2[row][column].equals("X");
                boolean msgCondition = true;

                for(int i =0,j=1; i<=8 ; i=i+2,j=j+2){
                    if (row == Ships.ship2Five[i] & column == Ships.ship2Five[j]) {
                        Ships.ship2Five[i] = 0;
                        Ships.ship2Five[i+1] = 0;
                    }
                }


                if (Ships.ship2Five[10] == 0 & Ships.ship2Five[0] == 0 & Ships.ship2Five[1] == 0 & Ships.ship2Five[2] == 0 & Ships.ship2Five[3] == 0 & Ships.ship2Five[4] == 0 & Ships.ship2Five[5] == 0 & Ships.ship2Five[6] == 0 & Ships.ship2Five[7] == 0 & Ships.ship2Five[8] == 0 & Ships.ship2Five[9] == 0) {
                    System.out.println("You sank a ship! Specify a new target:");
                    Ships.ship2Five[10] = 1;
                    msgCondition = false;
                }

                for(int i =0,j=1; i<=7 ; i=i+2,j=j+2){
                    if (row == Ships.ship2Four[i] & column == Ships.ship2Four[j]) {
                        Ships.ship2Four[i] = 0;
                        Ships.ship2Four[i+1] = 0;
                    }
                }

                if (Ships.ship2Four[8] == 0 & Ships.ship2Four[0] == 0 & Ships.ship2Four[1] == 0 & Ships.ship2Four[2] == 0 & Ships.ship2Four[3] == 0 & Ships.ship2Four[4] == 0 & Ships.ship2Four[5] == 0 & Ships.ship2Four[6] == 0 & Ships.ship2Four[7] == 0) {
                    System.out.println("You sank a ship! Specify a new target:");
                    Ships.ship2Four[8] = 1;
                    msgCondition = false;
                }

                for(int i =0,j=1; i<=5 ; i=i+2,j=j+2){
                    if (row == Ships.ship2Three1[i] & column == Ships.ship2Three1[j]) {
                        Ships.ship2Three1[i] = 0;
                        Ships.ship2Three1[i+1] = 0;
                    }
                }

                if (Ships.ship2Three1[6] == 0 & Ships.ship2Three1[0] == 0 & Ships.ship2Three1[1] == 0 & Ships.ship2Three1[2] == 0 & Ships.ship2Three1[3] == 0 & Ships.ship2Three1[4] == 0 & Ships.ship2Three1[5] == 0) {
                    System.out.println("You sank a ship! Specify a new target:");
                    Ships.ship2Three1[6] = 1;
                    msgCondition = false;
                }

                for(int i =0,j=1; i<=5 ; i=i+2,j=j+2){
                    if (row == Ships.ship2Three2[i] & column == Ships.ship2Three2[j]) {
                        Ships.ship2Three2[i] = 0;
                        Ships.ship2Three2[i+1] = 0;
                    }
                }

                if (Ships.ship2Three2[6] == 0 & Ships.ship2Three2[0] == 0 & Ships.ship2Three2[1] == 0 & Ships.ship2Three2[2] == 0 & Ships.ship2Three2[3] == 0 & Ships.ship2Three2[4] == 0 & Ships.ship2Three2[5] == 0) {
                    System.out.println("You sank a ship! Specify a new target:");
                    Ships.ship2Three2[6] = 1;
                    msgCondition = false;
                }

                for(int i =0,j=1; i<=3 ; i=i+2,j=j+2){
                    if (row == Ships.ship2Two[i] & column == Ships.ship2Two[j]) {
                        Ships.ship2Two[i] = 0;
                        Ships.ship2Two[i+1] = 0;
                    }
                }

                if (Ships.ship2Two[4] == 0 & Ships.ship2Two[0] == 0 & Ships.ship2Two[1] == 0 & Ships.ship2Two[2] == 0 & Ships.ship2Two[3] == 0) {
                    System.out.println("You sank a ship! Specify a new target:");
                    Ships.ship2Two[4] = 1;
                    msgCondition = false;
                }

                if (msgCondition == true) {
                    System.out.println("You hit a ship! Try again:");
                }
            }

            if (grid2[row][column] == "~" & row < 11 & row > 0 & column < 11 & column > 0) {
                grid2[row][column] = "M";
                //new Show().showGridFog(grid2);
                new GridFog().show(grid2);
                System.out.println("---------------------");
                //new Show().showGrid(grid1);
                new Grid().show(grid1);
                System.out.println("You missed.");
            }

            if (row > 10 | column > 10 | row < 1 | column < 1) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");

            }

            if (Ships.ship2Five[10] == 1 & Ships.ship2Four[8] == 1 & Ships.ship2Three1[6] == 1 & Ships.ship2Three2[6] == 1 & Ships.ship2Two[4] == 1) {
                endCondition = false;
                System.out.println("You sank the last ship. You won. Congratulations!");
            }

            System.out.println();
            System.out.println("Press Enter and pass the move to another player");
            String blankEnter = s.nextLine();


            new GridFog().show(grid1);
            System.out.println("---------------------");
            ;
            new Grid().show(grid2);
            System.out.println("Player 2, it's your turn:");
            inputString = s.nextLine();
            coordinates = new InputConverter().inputConverter(inputString);
            row = coordinates[0];
            column = coordinates[1];
            if (grid1[row][column] == "O" & row < 11 & row > 0 & column < 11 & column > 0) {
                grid1[row][column] = "X";
                boolean msgCondition = true;

                for(int i =0,j=1; i<=8 ; i=i+2,j=j+2){
                    if (row == Ships.ship1Five[i] & column == Ships.ship1Five[j]) {
                        Ships.ship1Five[i] = 0;
                        Ships.ship1Five[i+1] = 0;
                    }
                }

                if (Ships.ship1Five[10] == 0 & Ships.ship1Five[0] == 0 & Ships.ship1Five[1] == 0 & Ships.ship1Five[2] == 0 & Ships.ship1Five[3] == 0 & Ships.ship1Five[4] == 0 & Ships.ship1Five[5] == 0 & Ships.ship1Five[6] == 0 & Ships.ship1Five[7] == 0 & Ships.ship1Five[8] == 0 & Ships.ship1Five[9] == 0) {
                    System.out.println("You sank a ship! Specify a new target:");
                    Ships.ship1Five[10] = 1;
                    msgCondition = false;
                }

                for(int i =0,j=1; i<=6 ; i=i+2,j=j+2){
                    if (row == Ships.ship1Four[i] & column == Ships.ship1Four[j]) {
                        Ships.ship1Four[i] = 0;
                        Ships.ship1Four[i+1] = 0;
                    }
                }

                if (Ships.ship1Four[8] == 0 & Ships.ship1Four[0] == 0 & Ships.ship1Four[1] == 0 & Ships.ship1Four[2] == 0 & Ships.ship1Four[3] == 0 & Ships.ship1Four[4] == 0 & Ships.ship1Four[5] == 0 & Ships.ship1Four[6] == 0 & Ships.ship1Four[7] == 0) {
                    System.out.println("You sank a ship! Specify a new target:");
                    Ships.ship1Four[8] = 1;
                    msgCondition = false;
                }

                for(int i =0,j=1; i<=4 ; i=i+2,j=j+2){
                    if (row == Ships.ship1Three1[i] & column == Ships.ship1Three1[j]) {
                        Ships.ship1Three1[i] = 0;
                        Ships.ship1Three1[i+1] = 0;
                    }
                }

                if (Ships.ship1Three1[6] == 0 & Ships.ship1Three1[0] == 0 & Ships.ship1Three1[1] == 0 & Ships.ship1Three1[2] == 0 & Ships.ship1Three1[3] == 0 & Ships.ship1Three1[4] == 0 & Ships.ship1Three1[5] == 0) {
                    System.out.println("You sank a ship! Specify a new target:");
                    Ships.ship1Three1[6] = 1;
                    msgCondition = false;
                }

                for(int i =0,j=1; i<=4 ; i=i+2,j=j+2){
                    if (row == Ships.ship1Three2[i] & column == Ships.ship1Three2[j]) {
                        Ships.ship1Three2[i] = 0;
                        Ships.ship1Three2[i+1] = 0;
                    }
                }

                if (Ships.ship1Three2[6] == 0 & Ships.ship1Three2[0] == 0 & Ships.ship1Three2[1] == 0 & Ships.ship1Three2[2] == 0 & Ships.ship1Three2[3] == 0 & Ships.ship1Three2[4] == 0 & Ships.ship1Three2[5] == 0) {
                    System.out.println("You sank a ship! Specify a new target:");
                    Ships.ship1Three2[6] = 1;
                    msgCondition = false;
                }

                for(int i =0,j=1; i<=2 ; i=i+2,j=j+2){
                    if (row == Ships.ship1Two[i] & column == Ships.ship1Two[j]) {
                        Ships.ship1Two[i] = 0;
                        Ships.ship1Two[i+1] = 0;
                    }
                }

                if (Ships.ship1Two[4] == 0 & Ships.ship1Two[0] == 0 & Ships.ship1Two[1] == 0 & Ships.ship1Two[2] == 0 & Ships.ship1Two[3] == 0) {
                    System.out.println("You sank a ship! Specify a new target:");
                    Ships.ship1Two[4] = 1;
                    msgCondition = false;
                }

                if (msgCondition == true) {
                    System.out.println("You hit a ship! Try again:");
                }
            }

            if (grid1[row][column] == "~" & row < 11 & row > 0 & column < 11 & column > 0) {
                grid1[row][column] = "M";

                new GridFog().show(grid1);
                System.out.println("---------------------");

                new Grid().show(grid2);
                System.out.println("You missed.");
            }

            if (row > 10 | column > 10 | row < 1 | column < 1)
                System.out.println("Error! You entered the wrong coordinates! Try again:");

            if (Ships.ship1Five[10] == 1 & Ships.ship1Four[8] == 1 & Ships.ship1Three1[6] == 1 & Ships.ship1Three2[6] == 1 & Ships.ship1Two[4] == 1) {
                endCondition = false;
                System.out.println("You sank the last ship. You won. Congratulations!");
            }

            System.out.println();
            System.out.println("Press Enter and pass the move to another player");
            blankEnter = s.nextLine();

        } while (endCondition);
    }
}