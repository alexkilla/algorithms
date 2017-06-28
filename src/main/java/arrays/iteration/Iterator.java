package arrays.iteration;

public interface Iterator {

    void first();

    void last();

    boolean isDone();

    void next();

    void previous();

    Object current();
}
