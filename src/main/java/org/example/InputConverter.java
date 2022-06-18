package org.example;

// Converts input, example A3 into [1][3]. There are many types of input length, examples: A10, A6D6, A10A7, A10D10
public class InputConverter {
    public static int[] inputConverter(String inputString) {
        int[] coordinatesInt = new int[4];
        inputString = inputString.replace(" ", "");

        //sorting input order ex. A10A7 -> A7A10
        inputString = sortInputOrder(inputString);

        //converting input String into int[] coordinates
        return converter(inputString, coordinatesInt);
    }

    private static int[] converter(String inputString, int[] coordinatesInt) {
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
        return coordinatesInt;
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
