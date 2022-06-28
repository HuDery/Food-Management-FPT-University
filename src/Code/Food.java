package Code;

import java.text.SimpleDateFormat;

public class Food {

    private String id;
    private String name;
    private double weight;
    private String type;
    private String place;
    private String date;

    public Food() {
    }

    public Food(String id, String name, double weight, String type, String place, String date) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    public String getPlace() {
        return place;
    }

    public String getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return output();
    }

    public String output() {
        String out = String.format("|%-15s|%-15s|%-15s|%-15s|%-19s|%-15s|", id, name, weight, type, place, date);
        return out;
    }
    
    public void outputTable() {
        System.out.println("|---------------|---------------|---------------|---------------|-------------------|---------------|");
        System.out.printf("|%-41s%-58s| \n", "", "LIST OF FOOD");
        System.out.println("|---------------|---------------|---------------|---------------|-------------------|---------------|");
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-19s|%-15s| \n", "ID ", "Name ", "Weight (kg) ", "Type ", "Place ", "Date ");
        System.out.println("|---------------|---------------|---------------|---------------|-------------------|---------------|");
    }
}
