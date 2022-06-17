package battleship.shipSetter;

public class CoordinatesSetter {
    public static void verticalHorizontalShipTwo(int[] shipTwo, int[] coordinates) {
        for (int i = 0; i < 4; i++)
            shipTwo[i] = coordinates[i];
    }

    public static void horizontalShipThree(int[] shipThree2, int[] coordinates) {
        shipThree2[0] = coordinates[0];
        shipThree2[1] = coordinates[1];
        shipThree2[2] = coordinates[0] + 1;
        shipThree2[3] = coordinates[1];
        shipThree2[4] = coordinates[2];
        shipThree2[5] = coordinates[3];
    }

    public static void verticalShipThree(int[] shipThree1, int[] coordinates) {
        shipThree1[0] = coordinates[0];
        shipThree1[1] = coordinates[1];
        shipThree1[2] = coordinates[0];
        shipThree1[3] = coordinates[1] + 1;
        shipThree1[4] = coordinates[2];
        shipThree1[5] = coordinates[3];
    }

    public static void horizontalShipFour(int[] shipFour, int[] coordinates) {
        shipFour[0] = coordinates[0];
        shipFour[1] = coordinates[1];
        shipFour[2] = coordinates[0] + 1;
        shipFour[3] = coordinates[1];
        shipFour[4] = coordinates[0] + 2;
        shipFour[5] = coordinates[1];
        shipFour[6] = coordinates[2];
        shipFour[7] = coordinates[3];
    }

    public static void verticalShipFour(int[] shipFour, int[] coordinates) {
        shipFour[0] = coordinates[0];
        shipFour[1] = coordinates[1];
        shipFour[2] = coordinates[0];
        shipFour[3] = coordinates[1] + 1;
        shipFour[4] = coordinates[0];
        shipFour[5] = coordinates[1] + 2;
        shipFour[6] = coordinates[2];
        shipFour[7] = coordinates[3];
    }

    public static void horizontalShipFive(int[] shipFive, int[] coordinates) {
        shipFive[0] = coordinates[0];
        shipFive[1] = coordinates[1];
        shipFive[2] = coordinates[0] + 1;
        shipFive[3] = coordinates[1];
        shipFive[4] = coordinates[0] + 2;
        shipFive[5] = coordinates[1];
        shipFive[6] = coordinates[0] + 3;
        shipFive[7] = coordinates[1];
        shipFive[8] = coordinates[2];
        shipFive[9] = coordinates[3];
    }

    public static void verticalShipFive(int[] shipFive, int[] coordinates) {
        shipFive[0] = coordinates[0];
        shipFive[1] = coordinates[1];
        shipFive[2] = coordinates[0];
        shipFive[3] = coordinates[1] + 1;
        shipFive[4] = coordinates[0];
        shipFive[5] = coordinates[1] + 2;
        shipFive[6] = coordinates[0];
        shipFive[7] = coordinates[1] + 3;
        shipFive[8] = coordinates[2];
        shipFive[9] = coordinates[3];
    }
}
