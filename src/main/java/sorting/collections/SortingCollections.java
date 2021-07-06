package sorting.collections;

import java.util.*;

public class SortingCollections {

    public static void main(String[] args) {
        List<Point> lps = new ArrayList<>();
        lps.add(new Point(1, 10));
        lps.add(new Point(0, 0));
        lps.add(new Point(-1, 0));
        lps.add(new Point(4, 10));
        printList(lps);
        Collections.sort(lps);
        printList(lps);

        Collections.sort(lps, new PointComparator());
        printList(lps);
    }

    private static void printList(List<Point> ls) {

        System.out.println("Operation Requested : Printing O/P ");

        for (Point p : ls)
            System.out.println("Values : " + p.x + "," + p.y);

    }
}

class Point implements Comparable<Point> {

    int x, y;

    Point(int x, int y) {
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
