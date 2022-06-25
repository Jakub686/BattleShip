package org.example;

// Converts input, example A3 into [1][3]. There are many types of input length, examples: A10, A6D6, A10A7, A10D10
public class InputConverter {
    public static int[] inputConverter(String inputString) {
        int[] coordinatesInt = new int[4];
        inputString = inputString.replace(" ", "");

        inputString = sortInputOrder(inputString);
        return converter(inputString, coordinatesInt);
    }

    private static int[] converter(String inputString, int[] coordinatesInt) {
        //A6D9
        char d = 49;
        char l = 65;
        if (inputString.length() == 4) {
            l = convertStringIntoIntCoordinates(inputString, coordinatesInt, l, 10, 0, 2, 2);
            d = convertStringIntoIntCoordinates(inputString, coordinatesInt, d, 9, 1, 3, 3);
        }
        //A6D10
        if (inputString.length() == 5) {
            l = convertStringIntoIntCoordinates(inputString, coordinatesInt, l, 10, 0, 2, 2);
            d = convertStringIntoIntCoordinates(inputString, coordinatesInt, d, 9, 1, 3, 3);
            coordinate10(inputString, coordinatesInt, 3, 4, '0', 3, 10);
        }
        //A10D10
        if (inputString.length() == 6) {
            l = convertStringIntoIntCoordinates(inputString, coordinatesInt, l, 10, 0, 3, 2);
            coordinate10(inputString, coordinatesInt, 1, 2, '0', 1, 10);
            coordinate10(inputString, coordinatesInt, 4, 5, '0', 3, 10);
        }
        //A10
        if (inputString.length() == 3) {
            for (int i = 1; i <= 16; i++, l++) {
                if (inputString.charAt(0) == l) coordinatesInt[0] = i;
                if (inputString.charAt(1) == d) coordinatesInt[1] = i;
            }
            coordinate10(inputString, coordinatesInt, 1, 2, '0', 1, 10);
            coordinate10(inputString, coordinatesInt, 1, 2, '1', 1, 11);
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
        return coordinatesInt;
    }

    private static void coordinate10(String inputString, int[] coordinatesInt, int i2, int i3, char c, int i4, int i5) {
        if (inputString.charAt(i2) == '1' & inputString.charAt(i3) == c) coordinatesInt[i4] = i5;
    }

    private static char convertStringIntoIntCoordinates(String inputString, int[] coordinatesInt, char l, int i2, int i3, int i4, int i5) {
        for (int i = 1; i <= i2; i++, l++) {
            if (inputString.charAt(i3) == l) coordinatesInt[i3] = i;
            if (inputString.charAt(i4) == l) coordinatesInt[i5] = i;
        }
        return l;
    }

    private static String sortInputOrder(String inputString) {
        //A6D6
        String oldString = inputString;
        String newString = "";
        if (oldString.length() == 4) {
            int a = Character.getNumericValue(oldString.charAt(1));
            int b = Character.getNumericValue(oldString.charAt(3));
            if (a > b) {
                int[] tab = {2, 3, 0, 1};
                for (int i = 0; i <= 3; i++)
                    newString = newString + oldString.charAt(tab[i]);

                inputString = newString;
            }
        }

        //D6A6
        if (oldString.length() == 4) {
            int a = Character.getNumericValue(oldString.charAt(0));
            int b = Character.getNumericValue(oldString.charAt(2));
            if (a > b) {
                int[] tab = {2, 3, 0, 1};
                for (int i = 0; i <= 3; i++)
                    newString = newString + oldString.charAt(tab[i]);

                inputString = newString;
            }
        }

        //A10A7
        oldString = inputString;
        newString = "";
        if (oldString.length() == 5) {
            if (oldString.charAt(1) == '1' & oldString.charAt(2) == '0') {
                int a = 10;
                int b = Character.getNumericValue(oldString.charAt(4));
                if (a > b) {

                    int[] tab = {3, 4, 0, 1, 2};
                    for (int i = 0; i <= 4; i++)
                        newString = newString + oldString.charAt(tab[i]);

                    inputString = newString;
                }
            }
        }
        return inputString;
    }
}