package org.example;

/** Converts input, example A3 into [1][3]. There are many types of input length, examples: A10, A6D6, A10A7, A10D10  */
public class ConvertsUserInputIntoCartesianCoordinates {
    public static int[] inputConverter(String inputString) {
        int[] coordinatesInt = new int[4];
        inputString = inputString.replace(" ", "");

        inputString = sortInput(inputString);

        converter(inputString, coordinatesInt);
        return coordinatesInt;
    }

    private static void converter(String inputString, int[] coordinatesInt) {
        //A6D9
        char d = 49;
        char l = 65;
        if (inputString.length() == 4) {
            for (int i = 1; i <= 10; i++, l++) {
                if (inputString.charAt(0) == l) coordinatesInt[0] = i;

                if (inputString.charAt(2) == l) coordinatesInt[2] = i;
            }

            for (int i = 1; i <= 9; i++, d++) {
                if (inputString.charAt(1) == d) coordinatesInt[1] = i;
                if (inputString.charAt(3) == d) coordinatesInt[3] = i;
            }
        }

        //A6D10
        if (inputString.length() == 5) {
            for (int i = 1; i <= 10; i++, l++) {
                if (inputString.charAt(0) == l) coordinatesInt[0] = i;
                if (inputString.charAt(2) == l) coordinatesInt[2] = i;
            }
            for (int i = 1; i <= 9; i++, d++) {
                if (inputString.charAt(1) == d) coordinatesInt[1] = i;
                if (inputString.charAt(3) == d) coordinatesInt[3] = i;
            }
            if (inputString.charAt(3) == '1' & inputString.charAt(4) == '0') coordinatesInt[3] = 10;
        }

        //A10D10
        if (inputString.length() == 6) {
            for (int i = 1; i <= 10; i++, l++) {
                if (inputString.charAt(0) == l) coordinatesInt[0] = i;
                if (inputString.charAt(3) == l) coordinatesInt[2] = i;
            }
            if (inputString.charAt(1) == '1' & inputString.charAt(2) == '0') coordinatesInt[1] = 10;
            if (inputString.charAt(4) == '1' & inputString.charAt(5) == '0') coordinatesInt[3] = 10;
        }

        //A10
        if (inputString.length() == 3) {

            for (int i = 1; i <= 16; i++, l++) {
                if (inputString.charAt(0) == l) coordinatesInt[0] = i;
                if (inputString.charAt(1) == d) coordinatesInt[1] = i;
            }
            if (inputString.charAt(1) == '1' & inputString.charAt(2) == '0') coordinatesInt[1] = 10;
            if (inputString.charAt(1) == '1' & inputString.charAt(2) == '1') coordinatesInt[1] = 11;
        }

        //A6
        if (inputString.length() == 2) {
            for (int i = 1; i <= 16; i++, l++) {
                if (inputString.charAt(0) == l) coordinatesInt[0] = i;
            }
            for (int i = 1; i <= 9; i++, d++) {
                if (inputString.charAt(1) == d) coordinatesInt[1] = i;
            }
        }
    }

    private static String sortInput(String inputString) {
        //A8D4
        String temp = "";
        if (inputString.length() == 4) {
            int a = Character.getNumericValue(inputString.charAt(1));
            int b = Character.getNumericValue(inputString.charAt(3));
            if (a > b) {
                int[] tab = {2, 3, 0, 1};
                for (int i = 0; i <= 3; i++)
                    temp = temp + inputString.charAt(tab[i]);

                inputString = temp;
            }
        }

        //D6A6
        if (inputString.length() == 4) {
            int a = Character.getNumericValue(inputString.charAt(0));
            int b = Character.getNumericValue(inputString.charAt(2));
            if (a > b) {
                int[] tab = {2, 3, 0, 1};
                for (int i = 0; i <= 3; i++)
                    temp = temp + inputString.charAt(tab[i]);

                inputString = temp;
            }
        }

        //A10A7
        if (inputString.length() == 5) {
            if (inputString.charAt(1) == '1' & inputString.charAt(2) == '0') {
                int a = 10;
                int b = Character.getNumericValue(inputString.charAt(4));
                if (a > b) {

                    int[] tab = {3, 4, 0, 1, 2};
                    for (int i = 0; i <= 4; i++)
                        temp = temp + inputString.charAt(tab[i]);

                    inputString = temp;
                }
            }
        }
        return inputString;
    }
}
