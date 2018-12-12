package HemmaKväll;

import java.util.ArrayList;
import java.util.Scanner;

public class Hemmakväll {
    private static Scanner scanner = new Scanner(System.in);
    private static ContentList contentList = new ContentList();

    public static void main(String [] args){
        int choice = 0;
        int age = 0;


        System.out.println("Välkommen till Nihads Hemmakväll!\nHur gammal är du?");
        age = scanner.nextInt();


        printInstruction();
        while (true){
            System.out.println("Skriv in ditt val:");
            choice = scanner.nextInt();

            switch (choice){
                case 0:
                    printInstruction();
                    break;
                case 1:
                    contentList.printChosenList();
                    break;
                case 2:
                    // Show available movies...
                    contentList.showAvailableMovies();

                    System.out.println("\n[i] Vilken film vill du ha?");

                    int c = scanner.nextInt();


                    Film f =  contentList.getFilmList().get(c - 1);

                    if(age < Integer.parseInt(f.getAge())) {
                        System.err.println("[!!] Du är för ung för att kolla på den här filmen");
                        break;
                    }

                    // Add from the movie list to the chosen list IF YOU'RE OLD ENOUGH
                    contentList.addChosenFilm(f);
                    break;
                case 3:
                    // Show available movies...
                    contentList.showAvailableSeries();

                    System.out.println("\n[i] Vilken serie vill du ha kära barn?");

                    int d = scanner.nextInt();

                    Series s =  contentList.getSeriesList().get(d - 1);

                    if(age < Integer.parseInt(s.getAge())) {
                        System.err.println("[!!] Du är för ung för att kolla den här serien");
                        break;
                    }

                    // Add from the movie list to the chosen list IF YOU'RE OLD ENOUGH
                    contentList.addChosenSeries(s);
                    break;
                case 4:
                    System.out.println("\nSka du ta bort en serie eller film? (0=serie/1=film)");
                    int itemType = scanner.nextInt();

                    switch (itemType) {
                        case 0:
                            if(contentList.printChosenSeries() == 0) {
                                break;
                            }

                            System.out.println("Vilken serie vill du ta bort?");
                            System.out.println(contentList.removeChosenSeries(scanner.nextInt() - 1));
                            break;
                        case 1:
                            if(contentList.printChosenFilms() == 0) {
                                break;
                            }

                            System.out.println("Vilken film vill du ta bort?");
                            System.out.println(contentList.removeChosenFilm(scanner.nextInt() - 1));
                            break;
                    }
                    break;
                case 5:
                    break;
                case 6:
                    // Total of all movies
                    ArrayList<Film> y = contentList.getChosenMovies();
                    ArrayList<Series> x = contentList.getChosenSeries();

                    if(y.size() > 0 || x.size() > 0) {
                        int total = 0;

                        System.out.println("======== RECEIPT ========\nDu har köpt:\n");
                        for(Film fm : y) {
                            total += Integer.parseInt(fm.getPrice());
                            System.out.println("\t" + fm.getNamn());
                        }
                        for(Series fm : x) {
                            total += Integer.parseInt(fm.getPrice());
                            System.out.println("\t" + fm.getNamn());
                        }

                        System.out.println("\nYOUR TOTAL IS: " + total + "kr\n");


                        System.out.println("Tack för att ni handlade på Nihads Hemmakväll jävla barn");
                        System.exit(0);
                    } else {
                        System.err.println("[!!] DU HAR INGET I DIN KUNDVAGN KÄRA BARN");
                    }
                    break;
                case 7:
                    System.out.println("Hejdå");
                    System.exit(0);
                    break;

            }
        }

    }


    /**
     * Print the menu with all available options
     */
    public static void printInstruction(){
        System.out.println("\nVälj: ");
        System.out.println("\t 0 - Visa alternativ.");
        System.out.println("\t 1 - Visa handlingslistan.");

        System.out.println("\t 2 - Lägg till filmer");
        // [DONE] When press 2 show movie list and choose one from there.

        System.out.println("\t 3 - Lägg till serier");
        System.out.println("\t 4 - Ta bort i handlingslistan.");
        System.out.println("\t 6 - gå till kassan");
        System.out.println("\t 7 - hejdå.");

    }


    /**
     * Remove an item from your list
     */
    // TODO: FIX PLS YE?
    public static void removeItem() {



        // Have the function return the status (wether you've deleted or nah) and print it.

    }

}
