package org.example;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ConverterTest {
    @Test
    public void testConverter() {
        //input in String result in array grid coordinates X,Y

        String[] inputString ={"A","3","A","1"}; //input
        String[] outPutString ={"A","1","A","3"}; //expected
        assertArrayEquals(outPutString,new ConverterUserInputIntoCartesianCoordinates().sortInput(inputString));

        inputString[0] ="B";
        inputString[1] ="3";
        inputString[2] ="A";
        inputString[3] ="3";
        outPutString[0] ="A"; //expected
        outPutString[1] ="3"; //expected
        outPutString[2] ="B"; //expected
        outPutString[3] ="3"; //expected
        assertArrayEquals(outPutString, new ConverterUserInputIntoCartesianCoordinates().sortInput(inputString));
    }
}
