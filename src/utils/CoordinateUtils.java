package utils;

public class CoordinateUtils {
    public static double length(Coordinate a) {
        return Math.sqrt(dotProduct(a, a));
    }

    public static Coordinate norm(Coordinate a) {
        return new Coordinate(a.getX().doubleValue() / length(a), a.getY().doubleValue() / length(a));
    }

    public static Coordinate minus(Coordinate a, Coordinate b) {
        return new Coordinate(a.getX().doubleValue() - b.getX().doubleValue(),
                a.getY().doubleValue() - b.getY().doubleValue());
    }

    public static double euclideanDistance(Coordinate a, Coordinate b) {
        return length(minus(a, b));
    }

    public static double dotProduct(Coordinate a, Coordinate b) {
        return a.getX().doubleValue() * b.getX().doubleValue() + a.getY().doubleValue() * b.getY().doubleValue();
    }
}