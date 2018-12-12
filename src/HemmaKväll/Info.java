package HemmaKväll;

public class Info {

    private String namn;
    private String price;
    private String age;

    public Info(String... args) {
        this.namn = args[0];
        this.age = args[1];
        this.price = args[2];
    }


    /**
     *  GETTERS & SETTERS START HERE
     */

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getPrice() {
        return price;
    }

    public void setGenre(String genre) {
        this.price = genre;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
