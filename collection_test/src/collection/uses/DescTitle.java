package collection.uses;

import java.util.Comparator;

public class DescTitle implements Comparator<BookDTO> {

    @Override
    public int compare(BookDTO o1, BookDTO o2) {
        return o2.getTitle().compareTo(o1.getTitle());
    }
}
