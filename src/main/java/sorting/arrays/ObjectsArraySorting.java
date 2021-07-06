package sorting.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ObjectsArraySorting {

    public static void main(String[] args) {
        Point[] ps = new Point[]{new Point(2, 10), new Point(1, 20), new Point(10, 50)};
        Arrays.sort(ps);
        printArray(ps);

        ps = new Point[]{new Point(2, 10), new Point(1, 20), new Point(10, 50)};
        Arrays.sort(ps, new PointComparator());
        printArray(ps);

        Integer[] is = new Integer[]{5, 10, 2, 1, 23, 100};
        Arrays.sort(is, new CustomComparator());
        System.out.println(Arrays.toString(is));

    }

    private static void printArray(Point[] ps) {

        System.out.println("Operation Requested : Printing O/P ");
        for (Point p : ps)
            System.out.println("(" + p.x + "," + p.y + ")");
    }
}

class Point implements Comparable<Point> {

    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;
    }
}

class PointComparator implements Comparator<Point> {

    // Sorting in reverse order
    @Override
    public int compare(Point p1, Point p2) {
        return p2.x - p1.x;
    }
}

class CustomComparator implements Comparator<Integer> {

    // Sorting in even - odd  order
    @Override
    public int compare(Integer i1, Integer i2) {
        return i1 % 2 - i2 % 2;
    }
}