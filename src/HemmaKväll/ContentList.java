package HemmaKväll;

import java.util.ArrayList;

public class ContentList {
    private ArrayList<Film> filmList = new ArrayList<Film>();
    private ArrayList<Film> chosenFilms = new ArrayList<>(7);

    private ArrayList<Series> seriesList = new ArrayList<>();
    private ArrayList<Series> chosenSeries = new ArrayList<>(7);


    /**
     * Constructor
     */
    public ContentList() {
        String[] Film = {
                // TITEL::ÅLDER::PRIS
                "Johnny English::10::400",
                "Superhjältarna 2::5::700",
                "Guardians of the Galaxy::12::100",
                "The nun::18::20",
                "En oväntad vänskap::12::5",
                "Hunger Games::15::900",
                "X-Men::12::69"
        };

        String[] Series = {
                // TITEL::ÅLDER::PRIS
                "Mr. Robot::18::300",
                "Game of Thrones::18::600",
                "Dora the Explorer::3::20",
                "Grey's Anatomy::12::150",
                "Preacher::18::460",
                "The Walking Dead::15::500",
                "How I Met Your Mother::10::800"
        };

        // Fill list
        for(int i = 0; i < Film.length; i++) {
            this.filmList.add(new Film(Film[i].split("::")));
            this.seriesList.add(new Series(Series[i].split("::")));
        }
    }



    /**
     * Add an item after selection
     *
     * @param item The movie that the user chose from the list
     */
    public void addChosenFilm(Film item){
        chosenFilms.add(item);
    }

    public void addChosenSeries(Series item) {
        chosenSeries.add(item);
    }




    /**
     * Show the shopping cart basically, all chosen items so far
     */
    public void printChosenList() {
        int sLength = chosenSeries.size();
        int fLength = chosenFilms.size();

        int tLength = sLength + fLength;

        System.out.println("Du har " + tLength + " varor i din handlingslista");

        int i = 0;

        for(int j = 0; j < chosenSeries.size(); j++) {
            System.out.println((i += 1) + ". " + chosenSeries.get(j).getNamn());
        }

        for(int j = 0; j < chosenFilms.size(); j++) {
            System.out.println((i += 1) + ". " + chosenFilms.get(j).getNamn());
        }
    }



    public int printChosenFilms() {
        if(chosenFilms.size() == 0) {
            System.out.println("[i] Du har inga valda filmer");
            return 0;
        }

        for(int j = 0; j < chosenFilms.size(); j++) {
            System.out.println(j + 1 + ". " + chosenFilms.get(j).getNamn());
        }

        return 1;
    }

    public int printChosenSeries() {
        if(chosenSeries.size() == 0) {
            System.out.println("[i] Du har inga valda serier");
            return 0;
        }

        for(int j = 0; j < chosenSeries.size(); j++) {
            System.out.println(j + 1 + ". " + chosenSeries.get(j).getNamn());
        }

        return 1;
    }



    /**
     * Remove an item from the shopping cart
     *
     * @param item The integer 'code' for the movie that should be removed
     * @return Returns a string that says wether or not the item was removed
     */
    // TODO: ADD SHIT FOR SERIES LIST
    public String removeChosenFilm(int item) {
        String status = "[+] Du är dum i huvudet";

        // If it's in bounds, delete it
        if(item < chosenFilms.size() && item >= 0) {

            status = "[i] Du har tagit bort \"" + chosenFilms.get(item).getNamn() + "\" från din lista";
            chosenFilms.remove(item);

        }

        return status;
    }

    public String removeChosenSeries(int item) {
        String status = "[+] Du är dum i huvudet";

        // If it's in bounds, delete it
        if(item < chosenSeries.size() && item >= 0) {

            status = "[i] Du har tagit bort \"" + chosenSeries.get(item).getNamn() + "\" från din lista";
            chosenSeries.remove(item);

        }

        return status;
    }




    /**
     * Print a list of all the movies in the 'database'
     */
    public void showAvailableMovies() {
        System.out.format("\n%1$46s \n", "==========[ Filmer ]===========");
        for(int i = 0; i < filmList.size(); i++) {
            // Split and make an object out of it (maybe not?)
            Film f =  filmList.get(i);
            System.out.format("%1d %2$25s : %3$8s : %4$4s\n", i + 1, f.getNamn(), f.getAge(), f.getPrice());

        }
    }
    public void showAvailableSeries() {
        System.out.format("\n%1$46s \n", "==========[ Serier ]===========");
        for(int i = 0; i < seriesList.size(); i++) {
            // Split and make an object out of it (maybe not?)
            Series f =  seriesList.get(i);
            System.out.format("%1d %2$25s : %3$8s : %4$4s\n", i + 1, f.getNamn(), f.getAge(), f.getPrice());

        }
    }




    /**
     * Show the shopping cart
     * @return Returns a list of chosen
     */
    public ArrayList<Film> getChosenMovies() {
        return this.chosenFilms;
    }

    public ArrayList<Series> getChosenSeries() {
        return this.chosenSeries;
    }







    /**
     * Show the list of movies
     *
     * @return Returns the list of all the movies
     */
    public ArrayList<Film> getFilmList() {
        return this.filmList;
    }

    public ArrayList<Series> getSeriesList() {
        return this.seriesList;
    }
}


