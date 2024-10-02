import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Lägger till scanner
        Books books = new Books(); //Länkar filen med klassen Books
        Library library = new Library(); //Länkar filen med klassen Library
        boolean running = true; //Variable till while-loopen. För att kunna ändra om loppens villkor till false i case 5.


        //Här lägger jag till en del böcker i basutbudet av mitt bibliotek.
        library.addBook("Koda", "Anna Koda", 2008);
        library.addBook("Swift", "Jane Swift", 1994);
        library.addBook("Java", "Trey Grey", 2020);
        library.addBook("Hello", "Finnick Love", 2022);
        library.addBook("Notebook", "Max Power", 2003);
        library.addBook("Loving", "Helen June", 1878);
        library.addBook("Swift", "Laura Smith", 2013);
        library.addBook("August", "Lovis Joplin", 1935);


        //While-loop som går igenom 5 olika case.
        while (running) {
            //Menyn som kommer upp i början av loopen och sedan efter varje case är klart, förutom sista case 5 som avslutar loopen.
            System.out.println("Welcome to the Java library! How can we help you today? Write a number: \n " +
                    "1. Add a book to the library \n " +
                    "2. Search for a book by name \n " +
                    "3. List all available books \n " +
                    "4. Return a book \n " +
                    "5. Quit \n");


            if (!scanner.hasNextInt()) {
                // Hantera fallet när det inte är ett heltal
                System.out.println("Det är inte ett heltal! \n");
                scanner.next();
                continue;
            } else {

                //Sparar siffran användaren skriver in och används i switch/case.
                int number = scanner.nextInt();
                scanner.nextLine();

                switch (number) {
                    //Användaren skriver in boktitel, författare och årgång i terminalen.
                    case 1:
                        System.out.println("Please add a book to the library. Write down the following:\n");
                        System.out.println("Name of book:");
                        String bookName = scanner.nextLine();
                        System.out.println("Name of author:");
                        String authorName = scanner.nextLine();
                        System.out.println("Year of publication:");
                        int yearOfPublication = scanner.nextInt();

                        //Det användaren skriver in läggs in i variabler och läggs till i listan som är skapade i Library-filen.
                        library.addBook(bookName, authorName, yearOfPublication);

                        //Funktionen skriver ut alla böcker i terminalen.
                        library.displayNewBooks();

                        //Case 1 avslutas while-loopen börjar igen vid menyn.
                        break;

                    case 2:
                        //Användaren skriver in en boktitel.
                        System.out.println("Which book do you want to search for?");
                        String searchBook = scanner.nextLine();
                        //Funktionen searchBooks letar efter om boktiteln finns med i biblioteket.
                        Books foundBook = library.searchBooks(searchBook);

                        //Om boken finns skrivs den ut att din finns
                        if (foundBook != null) {
                            System.out.println("Book found: \n" + foundBook);
                        } else {
                            //Om boken inte finns så skrivs det ut.
                            System.out.println("Book not found.");
                        }
                        break;

                    case 3:
                        System.out.println("These books are available to loan: \n");
                        //Skriver ut alla böcker som är tillgängliga att lånas ut.
                        library.displayBooks();
                        System.out.println("\n");

                        //Frågar användaren om den vill låna en av böckerna som finns tillgängliga.
                        System.out.println("Do you want to loan a book? Yes or no?");
                        String loanAnswer = scanner.nextLine();

                        //Om användaren skriven in YES så frågar den om vilken bok användaren vill låna.
                        if (loanAnswer.equalsIgnoreCase("yes")) {
                            System.out.println("Which book do you want to loan?");
                            String loaningBook = scanner.nextLine();

                            foundBook = library.searchBooks(loaningBook);
                            // loanBook-funktionen körs. Den ändrar bokens tillgänglighet till false.
                            library.loanBook(loaningBook);

                            if (foundBook != null) {
                                library.loanBook(loaningBook);
                                System.out.println("Thank you! You are now loaning: " + loaningBook + "\n");
                                library.displayNewBooks();
                            } else {
                                System.out.println("Sorry, the book " + loaningBook + " does not exist in our library. \n");
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Whick book do you want to return?");

                        String returnABook = scanner.nextLine();

                        //Kollar om boken finns i listan och om boken är utlånad. Om den är det, skrivs det ut i terminalen att boken har blivit återlämnad.
                        if (library.returnBook(returnABook)) {
                            System.out.println("Thank you! You have successfully returned: " + returnABook + "\n");
                        } else {
                            //Finns boken inte med i listan eller om den är tillgänglig för utlåning så skrivs det ut i terminalen.
                            System.out.println("The book was not found or is already available. \n");
                        }
                        break;

                    case 5:
                        //Case 5 gör att while-loopen avslutas. Genom att ändra running från true till false.
                        running = false;
                        break;

                    default:
                        System.out.println("Ogiltigt val, vänligen försök igen \n");
                        break;

                }
            }

        }
    }
}


