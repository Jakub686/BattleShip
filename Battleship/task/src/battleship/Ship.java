package org.example;

public class Ship {

    private ShipType shiptype;
    private ShipType coordinates;

    public Ship(ShipType shiptype) {
        this.shiptype = shiptype;
    }

    public ShipType getShiptype() {
        return shiptype;
    }

    public void setShiptype(ShipType shiptype) {
        this.shiptype = shiptype;
    }

    public ShipType getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ShipType coordinates) {
        this.coordinates = coordinates;
    }
}
