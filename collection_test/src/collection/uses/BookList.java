package collection.uses;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class BookList {
    private BookManager bookManager = new BookManager();
    private Scanner sc = new Scanner(System.in);


    public void mainList(){
        while (true) {
            System.out.println("========== 메뉴 ==========");
            System.out.println("1. 책명 추가");
            System.out.println("2. 책명 전체 조회");
            System.out.println("3. 정렬하여 조회");
            System.out.println("4. 작가명으로 검색");
            System.out.println("5. 제목으로 검색");
            System.out.println("6. 책 정보 수정");
            System.out.println("7. 책 삭제");
            System.out.println("0. 프로그램 종료");


            System.out.print("메뉴 선택 : ");
            int list = sc.nextInt();
            sc.nextLine();


            switch (list) {
                case 1:
                    addList();
                    break;
                case 2:
                    selectList();
                    break;
                case 3:
                    sortMenu();
                    break;
                case 4:
                    searchArtist();
                    break;
                case 5:
                    searchTitle();
                    break;
                case 6:
                    updateList();
                    break;
                case 7:
                    removeList();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return; 
//                    System.exit(0);
                default:
                    System.out.println("잘못 선택하셨습니다. 번호를 다시 입력해주세요.");
                    break;
            }
        }
    }
    public void addList() {
        System.out.println("===== 곡 추가 =====");
        System.out.print("작가명 입력 : ");
        String artist = sc.nextLine();
        System.out.print("책명 입력 : ");
        String title = sc.nextLine();

        /* musicManger쪽으로 넘겨준다. */
        BookManager.addList(new BookDTO(title, artist));
    }

    public void selectList() {
        System.out.println("===== 책명 전체 조회 =====");
        List<BookDTO> musicList = bookManager.selectList();

        if (!musicList.isEmpty()) {
            for (BookDTO music : musicList) {
                System.out.println(music);
            }
        } else {
            System.out.println("목록이 존재하지 않습니다.");
        }
    }

    public void sortMenu() {
        System.out.println("===== 정렬 메뉴 =====");
        System.out.println("1. 작가명 오름차순 정렬");
        System.out.println("2. 책명 오름차순 정렬");
        System.out.println("3. 작가명 내림차순 정렬");
        System.out.println("4. 책명 내림차순 정렬");
        System.out.print("메뉴 선택 : ");
        int menu = sc.nextInt();

        ascDesc(menu);
    }

    public void ascDesc(int menu) {
        System.out.println("===== 정렬하여 조회 =====");
        List<BookDTO> musicList = bookManager.selectList();

        if (musicList.isEmpty()) {
            System.out.println("목록이 존재하지 않습니다.");
            return;
        }

        /* 정렬 시 원본 데이터를 변경하므로 사본 데이터를 별도로 생성한다. */
        List<BookDTO> sortList = new ArrayList<>();
        /* musicList값을 sortList에 전체를 옮김 */
        sortList.addAll(musicList);

        if (menu == 1) {
            /* 익명 클래스를 사용할 수도 있다. */
            sortList.sort(new Comparator<BookDTO>() {

                @Override
                public int compare(BookDTO o1, BookDTO o2) {
                    return o1.getTitle().compareTo(o2.getName());
                }

            });
        } else if (menu == 2) {
            /* Comparator를 상속한 클래스를 사용할 수도 있다. */
            sortList.sort(new AscTitle());
        } else if (menu == 3) {
            sortList.sort(new DescArtist());
        } else {
            sortList.sort(new DescTitle());
        }

        for (int i = 0; i < sortList.size(); i++) {
            System.out.println(sortList.get(i));
        }
    }


    public void searchArtist() {
        System.out.println("===== 작가명으로 검색 =====");
        System.out.print("작가명 입력 : ");
        List<BookDTO> searchList = bookManager.searchArtist(sc.nextLine());

        if (!searchList.isEmpty()) {
            for (int i = 0; i < searchList.size(); i++) {
                System.out.println(searchList.get(i));
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    public void searchTitle() {
        System.out.println("===== 책명으로 검색 =====");
        System.out.println("===== 책명으로 검색 =====");
        System.out.print("책명 입력 : ");
        List<BookDTO> searchList = bookManager.searchTitle(sc.nextLine());

        if (!searchList.isEmpty()) {
            for (int i = 0; i < searchList.size(); i++) {
                System.out.println(searchList.get(i));
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }


    public void updateList() {
        System.out.println("===== 책 정보 수정 =====");
        System.out.print("수정할 곡의 number : ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("수정할 작가명 : ");
        String updateArtist = sc.nextLine();
        System.out.print("수정할 책명 : ");
        String updateTitle = sc.nextLine();

        BookDTO updateList = new BookDTO(number, updateArtist, updateTitle);

        if (BookManager.updateList(updateList)) {
            System.out.println("성공적으로 수정되었습니다.");
        } else {
            System.out.println("수정할 곡을 찾지 못했습니다.");
        }
    }

    public void removeList() {
        System.out.println("===== 책 삭제 =====");
        System.out.print("삭제할 책의 number : ");
        if (BookManager.removeList(sc.nextInt())) {
            System.out.println("성공적으로 삭제 되었습니다.");
        } else {
            System.out.println("삭제할 책을 찾지 못했습니다.");
        }
        sc.nextLine();
    }
}
