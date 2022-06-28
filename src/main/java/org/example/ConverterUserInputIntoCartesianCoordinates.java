package org.example;

import java.util.Locale;
import java.util.Scanner;

/**
 * Converts input, example A3 into [1][3]. There are many types of input length, examples: A10, A6D6, A10A7, A10D10
 */
public class ConverterUserInputIntoCartesianCoordinates {
    public static int[] inputConverterForShipSetting(String[] inputString) {

        int[] coordinatesInt = new int[4];

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

        sorting(inputString, a, b);

        //D6A6
        a = inputString[0].charAt(0);
        b = inputString[2].charAt(0);

        sorting(inputString, a, b);

        return inputString;
    }

    private static void sorting(String[] inputString, int a, int b) {
        if (a > b) {

            String[] temp = new String[4];
            for (int i = 0; i < inputString.length; i++)
                temp[i] = inputString[i];

            inputString[0] = temp[2];
            inputString[1] = temp[3];
            inputString[2] = temp[0];
            inputString[3] = temp[1];
        }
    }
}
