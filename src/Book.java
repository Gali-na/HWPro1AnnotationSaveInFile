public class Book {
    private String authorName;
    private String authorSurname;
    private String authorBookEntryDate;
    private String nameBook;
    @AnnotationForString
    private String allInformationAboutBook = " ";

    public Book(String authorName, String authorSurname, String authorBookEntryDate, String nameBook) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.authorBookEntryDate = authorBookEntryDate;
        this.nameBook = nameBook;
        this.allInformationAboutBook = this.authorName + " " + this.authorSurname + " " + this.authorBookEntryDate + " " + this.nameBook;
    }

    public Book() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getAuthorBookEntryDate() {
        return authorBookEntryDate;
    }

    public void setAuthorBookEntryDate(String authorBookEntryDate) {
        this.authorBookEntryDate = authorBookEntryDate;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAllInformationAboutBook() {
        return allInformationAboutBook;
    }
}
