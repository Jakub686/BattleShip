package org.example;

public enum ShipType {

    AIRCRAFT_CARRIER(5,new int[11]), BATTLESHIP(4,new int[9]), SUBMARINE(3,new int[7]), CRUISER(3,new int[7]), DESTROYER(2,new int[5]);

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

    public static int longestShip = 5;

}
