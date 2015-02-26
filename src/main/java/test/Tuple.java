package test;

import java.util.Comparator;

/**
 * Created by rmandada on 27/1/15.
 */
public class Tuple {
    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Comparator<Tuple> comapreWrtX() {
        return new Comparator<Tuple>() {
            @Override public int compare(Tuple o1, Tuple o2) {
                return o1.x < o2.x ? -1: o1.x == o2.x ? 0: 1;
            }
        };
    }

    static Comparator<Tuple> comapreWrtY() {
        return new Comparator<Tuple>() {
            @Override public int compare(Tuple o1, Tuple o2) {
                return o1.y < o2.y ? -1: o1.y == o2.y ? 0: 1;
            }
        };
    }
}
