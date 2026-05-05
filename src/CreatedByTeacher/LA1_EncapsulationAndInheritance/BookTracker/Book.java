package CreatedByTeacher.LA1_EncapsulationAndInheritance.BookTracker;

public class Book {

    public String title;
    public String author;
    public int yearPublished;

    public Book(){
        this.title = "Unknown";
        this.author = "Unknown";
        this.yearPublished = 0;
    }

    public Book(String title, String author, int yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

}
