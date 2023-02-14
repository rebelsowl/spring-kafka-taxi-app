package com.example.taxiapp.data;

import java.awt.*;

public class CoordinateConverter {

    public static String pointToString(Point point) {
        return point.getX() + ":" + point.getY();
    }

    public static Point stringToPoint(String coordinates) {
        String[] splitCoordinate = coordinates.split(":");
        Point point = new Point();
        point.setLocation(Double.parseDouble(splitCoordinate[0]), Double.parseDouble(splitCoordinate[1]));

        return point;
    }

}
