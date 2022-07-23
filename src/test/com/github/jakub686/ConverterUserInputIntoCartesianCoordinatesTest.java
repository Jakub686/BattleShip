package com.github.jakub686;

import com.github.jakub686.InputConverter.ConverterInputCoordinatesShipSetter;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ConverterUserInputIntoCartesianCoordinatesTest {

    @Test
    public void testConverterUserInputIntoCartesianCoordinates() {
        //input in String, result in array grid coordinates X,Y

        String[] inputString ={"C","2","A","2"};
        int[] coordinates = {1,2,3,2}; //expected
        assertArrayEquals(coordinates, new ConverterInputCoordinatesShipSetter().inputConverterForShipSetting(inputString));

        inputString[0] ="A";
        inputString[1] ="6";
        inputString[2] ="A";
        inputString[3] ="1";
        coordinates[0]=1;
        coordinates[1]=1;
        coordinates[2]=1;
        coordinates[3]=6;
        assertArrayEquals(coordinates, new ConverterInputCoordinatesShipSetter().inputConverterForShipSetting(inputString));

    }

}

