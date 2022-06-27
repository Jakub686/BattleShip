package org.example;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Locale;
import java.util.Scanner;

/**
 * Converts input, example A3 into [1][3]. There are many types of input length, examples: A10, A6D6, A10A7, A10D10
 */
public class ConverterUserInputIntoCartesianCoordinates {
    public static int[] inputConverterForShipSetting() {
        Scanner scanner = new Scanner(System.in);

        String[] inputString = new String[4];
        int[] coordinatesInt = new int[4];

        System.out.println("First row ");
        inputString[0] = scanner.nextLine().toUpperCase(Locale.ROOT);

        System.out.println("First column ");
        inputString[1] = scanner.nextLine().toUpperCase(Locale.ROOT);

        System.out.println("Second row ");
        inputString[2] = scanner.nextLine().toUpperCase(Locale.ROOT);

        System.out.println("Second column");
        inputString[3] = scanner.nextLine().toUpperCase(Locale.ROOT);

        //sort input ex. C5C8 into C5C8, first coordinates always have to be smaller then second
        inputString = sortInput(inputString);

        converter(inputString, coordinatesInt);
        return coordinatesInt;
    }

    private static void converter(String[] inputString, int[] coordinatesInt) {
        //Converts user String input ex A4 into cartesian coordinates A4 -> X=1 Y=4

        coordinatesInt[0]=inputString[0].charAt(0)-64;
        coordinatesInt[2]=inputString[0].charAt(0)-64;

        coordinatesInt[1]=Integer.parseInt(inputString[1]);
        coordinatesInt[3]=Integer.parseInt(inputString[3]);
    }

    private static String[] sortInput(String[] inputString) {

        //D8D4
        int a = Integer.parseInt(inputString[1]);
        int b = Integer.parseInt(inputString[3]);

        if (a > b) {

            String[] temp = new String[4];
            for (int i = 0; i < inputString.length; i++)
                temp[i] = inputString[i];

            inputString[0] = temp[2];
            inputString[1] = temp[3];
            inputString[2] = temp[0];
            inputString[3] = temp[1];
        }

        //D6A6
        a = inputString[0].charAt(0);
        b = inputString[2].charAt(0);
        if (a > b) {

            String[] temp = new String[4];
            for (int i = 0; i < inputString.length; i++)
                temp[i] = inputString[i];

            inputString[0] = temp[2];
            inputString[1] = temp[3];
            inputString[2] = temp[0];
            inputString[3] = temp[1];
        }

        return inputString;
    }
}
