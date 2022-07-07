package com.github.jakub686;

import com.github.jakub686.InputConverter.ConverterInputCoordinatesShipSetter;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ConverterTest {
    @Test
    public void testConverter() {
        //input in String result in array grid coordinates X,Y

        String[] inputString ={"A","3","A","1"};
        String[] outPutString ={"A","1","A","3"};
        assertArrayEquals(outPutString,new ConverterInputCoordinatesShipSetter().sortInput(inputString));

        inputString[0] ="B";
        inputString[1] ="3";
        inputString[2] ="A";
        inputString[3] ="3";
        outPutString[0] ="A";
        outPutString[1] ="3";
        outPutString[2] ="B";
        outPutString[3] ="3";
        assertArrayEquals(outPutString, new ConverterInputCoordinatesShipSetter().sortInput(inputString));
    }
}
