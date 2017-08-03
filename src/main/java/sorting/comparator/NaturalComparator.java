package sorting.comparator;


import java.util.Comparator;

public class NaturalComparator implements Comparator{
    public static final NaturalComparator INSTANCE = new NaturalComparator();

    private NaturalComparator(){
    }

    public int compare(Object left, Object right) {
        assert left != null : "left cannot be null";
        return ((Comparable)left).compareTo(right);
    }
}
