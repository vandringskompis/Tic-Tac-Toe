import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> pointsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int sum = 0; //summan av alla poäng är 0 från start.


        //While-loopen kör tills någon skriven in en bokstav istället för en siffra.
        while (true) {
            System.out.println("Skriv in poängen. Är du klar så skriv valfri bokstav");

            //Bokstav skrevs in här och då avslutas loopen.
            if (!scanner.hasNextInt()) {
                break;
            }

            //Här skriver användaren in en siffra och den siffran sparas i listan samt plussas ihop med sum.
            int points = scanner.nextInt();
            scanner.nextLine();

            if (points < 0) {
                System.out.println("Negativt tal accepteras ej, vänligen försök igen");
                continue;
            }

            pointsList.add(points);
            sum += points;
        }

        System.out.println("Här är alla poäng: ");

        // For- loopen går igenom listan och vet lägger in alla poäng i points.
        for (int points : pointsList) {
            System.out.print(points + " ");
        }
        System.out.println();

        if (!pointsList.isEmpty()) {

            //Räknar ut vad medelvärdet är av alla poäng. Summman av alla poäng delat med antalet inmatningar av poäng.
            double average = (double) sum / pointsList.size();
            System.out.println("Medelvärdet är: " + average);


            // Med Collections.max hittar vi den högsta poängen i listan.
            int biggest = Collections.max(pointsList);
            System.out.println("Högsta poäng: " + biggest);
        } else {
            System.out.println("Inga poäng angavs");
        }

        scanner.close();
        }
    }
