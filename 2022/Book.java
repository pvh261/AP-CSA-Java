public class Book {
    private String title;
    private double price;

    public static void main(String[] args) {
        Textbook bio2015 = new Textbook("Biology", 49.75, 2);
        Textbook bio2019 = new Textbook("Biology", 39.75, 3);
        System.out.println(bio2019.getEdition());
        System.out.println(bio2019.getBookInfo());
        System.out.println(bio2019.canSubstituteFor(bio2015));
        System.out.println(bio2015.canSubstituteFor(bio2019));
        Textbook math = new Textbook("Calculus", 45.25, 1);
        System.out.println(bio2015.canSubstituteFor(math));

    }

    public Book(String bookTitle, double bookPrice) {
        title = bookTitle;
        price = bookPrice;
    }

    public String getTitle() {
        return title;
    }
    
    public String getBookInfo() {
        return title + " - " + price;
    }
}

class Textbook extends Book {
    private int editionNumber;

    public Textbook(String title, double price, int edNum) {
        super(title, price);
        editionNumber = edNum;
    }

    public String getBookInfo() {
        return super.getBookInfo() + " - " + editionNumber;
    }

    public int getEdition() {
        return editionNumber;
    }

    public boolean canSubstituteFor(Textbook t) {
        if(t.getTitle() == getTitle() && t.getEdition() <= editionNumber) {
            return true;
        } else {
            return false;
        }
    }
}