package com.github.jakub686;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ConverterUserInputIntoCartesianCoordinatesTest {

    @Test
    public void testInputConverter() {
        //input in String result in array grid coordinates X,Y

        String[] inputString ={"b","2","b","2"};
        int[] coordinates = {2,2,2,2}; //expected
        //assertArrayEquals(coordinates, ConverterUserInputIntoCartesianCoordinates.inputConverterForShipSetting(inputString));

//        input ="C10";
//        coordinates[0]=3;
//        coordinates[1]=10;
//        assertArrayEquals(coordinates, ConvertsUserInputIntoCartesianCoordinates.inputConverterForShipSetting(input));
//
//        input ="A6D6";
//        coordinates[0]=1;
//        coordinates[1]=6;
//        coordinates[2]=4;
//        coordinates[3]=6;
//        assertArrayEquals(coordinates, ConvertsUserInputIntoCartesianCoordinates.inputConverterForShipSetting(input));
//
//        input ="D6A6";
//        coordinates[0]=1;
//        coordinates[1]=6;
//        coordinates[2]=4;
//        coordinates[3]=6;
//        assertArrayEquals(coordinates, ConvertsUserInputIntoCartesianCoordinates.inputConverterForShipSetting(input));
//
//        input ="A10A7";
//        coordinates[0]=1;
//        coordinates[1]=7;
//        coordinates[2]=1;
//        coordinates[3]=10;
//        assertArrayEquals(coordinates, ConvertsUserInputIntoCartesianCoordinates.inputConverterForShipSetting(input));
//
//        input ="A6D10";
//        coordinates[0]=1;
//        coordinates[1]=6;
//        coordinates[2]=4;
//        coordinates[3]=10;
//        assertArrayEquals(coordinates, ConvertsUserInputIntoCartesianCoordinates.inputConverterForShipSetting(input));
//
//        input ="A10D10";
//        coordinates[0]=1;
//        coordinates[1]=10;
//        coordinates[2]=4;
//        coordinates[3]=10;
//        assertArrayEquals(coordinates, ConvertsUserInputIntoCartesianCoordinates.inputConverterForShipSetting(input));
    }
}

