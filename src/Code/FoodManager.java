package Code;

import Menu.Menu;
import Input.Input;

public class FoodManager {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add("\nWelcome to Food Management - @ 2021 by <SE150233 - Le Ha Duy >");
        menu.add("Select the options below:");
        menu.add("1-Add Food");
        menu.add("2-Search Food by Name");
        menu.add("3-Remove Food by ID");
        menu.add("4-Print all Food with sort day");
        menu.add("5-Save Food to File");
        menu.add("6-Quit");
        FoodList list = new FoodList();
        int choice;
        do {
            choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    System.out.println("------------ ADD NEW FOOD -----------");
                    list.addFood();
                    break;
                case 2:
                    System.out.println("------------ SEARCH FOOD BY NAME -----------");
                    list.searchName();
                    break;
                case 3:
                    System.out.println("------------ REMOVE FOOD BY ID -----------");
                    list.removeFood();
                    break;
                case 4:
                    list.printWithSortDay();
                    break;
                case 5:
                    System.out.println("------------ SAVE FOOD TO FILE -----------");
                    String a = Input.inputFielName();
                    list.saveFile(a);
                    break;
            }
        } while (choice > 0 && choice < 6);
    }
}
