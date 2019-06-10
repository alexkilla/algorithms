package collectionspractice;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InsteadOfStreams {
    public static void main(String[] args) {
        ArrayList collection = (ArrayList) Collections.emptyList();
        //collection.stream().toArray(String[]::new);
        //collection.stream().toArray(String[]::new);

        collection.stream().max(Comparator.naturalOrder()).get();
    }
}
