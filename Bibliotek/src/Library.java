import java.awt.print.Book;
import java.util.ArrayList;

public class Library {
    //Skapar en lista att spara alla böcker i.
    ArrayList<Books> bookList = new ArrayList<>();

    //Funktion som lägger till alla böcker i listan.
    public void addBook(String name, String author, int year) {
        Books newBook = new Books(name, author, year);

        //boklistan.läggTill(Ny bok skapas)
        bookList.add(newBook);
    }

    //Ändrar bokens tillgänglighet om boken finns tillgänglig och användaren vill låna den.
    public boolean loanBook(String loaningBook) {
        for (Books book : bookList) {
            //Om bokens name är samma som användarens input (loaningBook) och boken är tillgänglig ändras tillgängligheten till false.
            if (book.name.equalsIgnoreCase(loaningBook) && book.isAvailable()) {
                book.setAvailable(false);
                return true;
            }
        }
        //
        return false;
    }

    // Letar efter om boken finns i biblioteket.
    public Books searchBooks(String searchBook) {
        for (Books book : bookList) {
            if (book.name.equalsIgnoreCase(searchBook)) {
                return book;
            }
        }
        return null;
    }

    // Skriver ut alla böcker som finns i biblioteket.
    public void displayNewBooks() {
        for (Books book : bookList) {
            System.out.println(book);
        }
    }

    //Kollar igenom listan om boken finns och om den är utlånad (available = false). Om den är false så ändras den till true.
    // Boken är återlämnad. Annars felmeddelande.
    public boolean returnBook(String returnBook) {
        for (Books book : bookList) {
            if (book.name.equalsIgnoreCase(returnBook) && !book.isAvailable()) {
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }

    // Visar alla böcker som är finns i listan som är tillgängliga.
    public void displayBooks() {
        for (Books book : bookList) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }
}

