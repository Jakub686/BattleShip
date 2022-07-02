package org.example;

public enum ShipType {
//last index show if ship sunk , before the last one if ship set
    AIRCRAFT_CARRIER(5,new int[12]), BATTLESHIP(4,new int[10]), SUBMARINE(3,new int[8]), CRUISER(3,new int[8]), DESTROYER(2,new int[6]);

    private int length;
    private int[] coordinates;

    ShipType(int length, int[] coordinates) {
        this.length = length;
        this.coordinates = coordinates;
    }

    public int getLength() {
        return length;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public int[] getCoordinates() {
        return coordinates;
    }


    public static int longestShip = 5;

}
