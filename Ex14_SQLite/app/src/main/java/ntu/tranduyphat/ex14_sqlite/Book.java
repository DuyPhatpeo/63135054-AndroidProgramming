package ntu.tranduyphat.ex14_sqlite;

public class Book {
    int  BookID;
    String BookName;
    int Page;
    float Price;
    String Description;

    public Book(int bookID, String bookName, int page, float price, String description) {
        BookID = bookID;
        BookName = bookName;
        Page = page;
        Price = price;
        Description = description;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public int getPage() {
        return Page;
    }

    public void setPage(int page) {
        Page = page;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
