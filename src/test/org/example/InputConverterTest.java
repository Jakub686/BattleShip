package org.example;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InputConverterTest {

    @Test
    public void testInputConverter() {

        String input ="A6";
        int[] coordinates = {1,6,0,0,0,0};
        assertArrayEquals(coordinates, InputConverter.inputConverter(input));

        input ="C10";
        coordinates[0]=3;
        coordinates[1]=10;
        assertArrayEquals(coordinates, InputConverter.inputConverter(input));

        input ="A6D6";
        coordinates[0]=1;
        coordinates[1]=6;
        coordinates[2]=4;
        coordinates[3]=6;
        assertArrayEquals(coordinates, InputConverter.inputConverter(input));

        input ="D6A6";
        coordinates[0]=1;
        coordinates[1]=6;
        coordinates[2]=4;
        coordinates[3]=6;
        assertArrayEquals(coordinates, InputConverter.inputConverter(input));

        input ="A10A7";
        coordinates[0]=1;
        coordinates[1]=7;
        coordinates[2]=1;
        coordinates[3]=10;
        assertArrayEquals(coordinates, InputConverter.inputConverter(input));

        input ="A6D10";
        coordinates[0]=1;
        coordinates[1]=6;
        coordinates[2]=4;
        coordinates[3]=10;
        assertArrayEquals(coordinates, InputConverter.inputConverter(input));

        input ="A10D10";
        coordinates[0]=1;
        coordinates[1]=10;
        coordinates[2]=4;
        coordinates[3]=10;
        assertArrayEquals(coordinates, InputConverter.inputConverter(input));

    }
}

