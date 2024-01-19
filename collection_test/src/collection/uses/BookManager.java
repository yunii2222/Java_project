package collection.uses;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    /* 음악 목록이 저장 되는 리스트  */
    private static List<BookDTO> bookList = new ArrayList<>();

    /* 곡 추가 */
    public static void addList(BookDTO list) {
        bookList.add(list);
    }

    /* 곡 전체 조회 */
    public List<BookDTO> selectList() {

        return bookList;
    }

    /* 가수명 조회 */
    public List<BookDTO> searchArtist(String name ) {

        /* 가수명을 검색해서 해당 키워드가 포함되는 곡을 리턴하기 위한 리스트 */
        List<BookDTO> searchList = new ArrayList<>();

        for(BookDTO list : bookList) {
            /* String 클래스의 contains() 메소드는 equals() 메소드와 달리 해당 문자 "포함" 여부를 boolean으로 리턴 */
            if(list.getName().contains(name)) {
                searchList.add(list);
            }
        }

        return searchList;
    }

    /* 제목 조회 */
    public List<BookDTO> searchTitle(String title) {

        /* 제목을 검색해서 해당 키워드가 포함되는 곡을 리턴하기 위한 리스트 */
        List<BookDTO> searchList = new ArrayList<>();

        for(BookDTO music : bookList) {
            if(music.getTitle().contains(title)) {
                searchList.add(music);
            }
        }

        return searchList;
    }

    /* 곡 수정  */
    public static boolean updateList(BookDTO updateList){

        BookDTO old = null;

        for(int i = 0; i < bookList.size(); i++) {
            /* bookList에서 id가 일치하는 music 객체를 찾는다. */
            if(bookList.get(i).getNumber() == updateList.getNumber()) {
                /* set 메소드는 수정 전 값을 반환한다. */
                old = bookList.set(i, updateList);
            }
        }

        /* 수정 전 값이 반환 되었으면 잘 수정 되었다는 의미로 true, 여전히 null이면 수정 된 적이 없다는 의미로 false를 반환한다. */
        return old != null;
    }

    /* 곡 삭제  */
    public static boolean removeList(int number) {

        BookDTO old = null;

        for(int i = 0; i < bookList.size(); i++) {
            /* bookList에서 id가 일치하는 music 객체를 찾는다. */
            if(bookList.get(i).getNumber() == number) {
                old = bookList.remove(i);
            }
        }

        return old != null;
    }
}
