package incantations;

import java.util.List;

public class ConvexHullDriver {
    public static void main(String[] args) {

    }

    public static List<Point> getConvexHull(List<Point> points){

        // Find the bottommost point
        long ymin = points.get(0).getY();
        int min = 0;
        for (int i = 1; i < points.size(); i++)
        {
            long y = points.get(i).getY();

            // Pick the bottom-most or chose the left
            // most point in case of tie
            if ((y < ymin) || (ymin == y &&
                    points.get(i).getX() < points.get(min).getX()))
                ymin = points.get(i).getY(); min = i;
        }

        // Place the bottom-most point at first position
        Point tmp = points.get(0);
        points.set(0,points.get(min));
        points.set(min,tmp);


        return null;
    }
}

class Point{
    private long x;
    private long y;
    Point(long x, long y){
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}

