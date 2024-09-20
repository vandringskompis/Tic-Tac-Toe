public class Books {
    String name;
    String author;
    int year;
    boolean available;


    //Konstruktor till Books. Böcker är på default available/tillgängliga för utlåning.
    public Books(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.available = true;

    }

    // Dubbelkollar att alla böcker är available.
    public Books() {
        this.available = true;
    }

    //Returnerar om boken är available eller inte. Antingen true eller false.
    public boolean isAvailable() {
        return available;
    }

    //Används för att ändra om availability till true eller false.
    public void setAvailable(boolean available) {
        this.available = available;
    }

    //toString som skriver ut alla böcker med boktitel, författare, årgång samt om den är tillgänglig att låna eller inte.
    @Override
    public String toString() {
        return "Name of book: " + name + "\n" +
                "Author: " + author + "\n" +
                "Year of publication: " + year + "\n" +
                "Available to loan: " + available + ".\n";
    }
}





