package collection.uses;

import java.awt.print.Book;
import java.util.Comparator;

public class DescArtist implements Comparator<BookDTO> {


    @Override
    public int compare(BookDTO o1, BookDTO o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
