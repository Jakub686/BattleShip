package com.github.jakub686.InputConverter;

public class ConverterInputCoordinatesShot implements IConverterInputCoordinates {
    @Override
    public int[] inputConverterForShipSetting(String[] inputString) {

        int[] coordinatesInt = converter(inputString);

        return coordinatesInt;
    }

    @Override
    public int[] converter(String[] inputString) {
        //Converts user String input ex A4 into cartesian coordinates A4 -> X=1 Y=4

        int[] coordinatesInt = new int[2];;
        coordinatesInt[0]=inputString[0].charAt(0)-64; //if A, will be 1
        coordinatesInt[1]=Integer.parseInt(inputString[1]);


        return coordinatesInt;
    }
}
