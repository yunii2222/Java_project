package collection.uses;

public class BookDTO {

    private static int nextId = 1;

    private int number;
    private String title;
    private String name;

    public BookDTO(String title, String author) {
        this.number = BookDTO.nextId++;
        this.title = title;
        this.name = name;
    }

    public BookDTO(int number, String title, String author) {
        this.number = number;
        this.title = title;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + name + '\'' +
                '}';
    }
}
