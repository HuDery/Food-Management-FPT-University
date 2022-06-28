package Code;

import Input.Input;
import Menu.MenuAskUser;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;

public class FoodList extends ArrayList<Food> {

    Food list = new Food();

    public FoodList() {
        super();
    }
////////////////////////////////////////////////////////////////////////////////////// HAM KTR DUP

    public Food searchbyID(String arr) {
        arr = arr.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equals(arr)) {
                return this.get(i);
            }
        }
        return null;
    }

///////////////////////////////////////////////////////////////////////////////////////// HAM ADD
    public void addFood() {
        double newweight;
        String newid, newname, newtype, newplace = null, newdate;
        boolean ktrID = false;
        boolean ask = true;
        int pos;
        int place_op;
        do {
            do {
                newid = Input.inputStringWith_REGEX("ID of Food (Sxx): ", "[S][\\d]{2}", "Only enter ID according to the form [Sxx] with x is a positive integer number");
                ktrID = searchbyID(newid) != null;
                if (ktrID) {
                    System.out.println("ID is duplicated!!!");
                }
            } while (ktrID == true);
            newname = Input.inputstring("Name of Food: ", "Name cannot be empty/blank").toUpperCase();
            newweight = Input.inputdouble("Weight of Food(kg): ", "Please enter Weight is a number greater than 0 and Weight cannot be empty/blank");
            newtype = Input.inputstring("Type of Food: ", "Type cannot be empty/blank").toUpperCase();
            Input.Choose_Place();
            place_op = Input.Place_Option("Choose a place to store food: ", "Only choice from 1 to 3", 1, 3);
            if (place_op == 1) {
                newplace = ("Freezer");
            } else if (place_op == 2) {
                newplace = ("Cooler compartment");
            } else if (place_op == 3) {
                newplace = ("Freezing shelf");
            }
            do {
                do {
                    newdate = Input.inputStringWith_RegexDATE("Date of Food(dd/mm/2021): ", "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(2021)$", "Please enter the correct date and must be in the format (dd/mm/2021)");
                    if (newdate.equals("31/04/2021")) {
                        System.out.println("April do not have 31 days");
                    } else if (newdate.equals("31/06/2021")) {
                        System.out.println("June do not have 31 days");
                    } else if (newdate.equals("31/09/2021")) {
                        System.out.println("September do not have 31 days");
                    } else if (newdate.equals("31/11/2021")) {
                        System.out.println("November do not have 31 days");
                    } else if (newdate.equals("30/02/2021") || newdate.equals("31/02/2021")) {
                        System.out.println("February does not have 30 and 31 days");
                    }
                } while (newdate.equals("31/04/2021") || newdate.equals("31/06/2021") || newdate.equals("31/09/2021") || newdate.equals("31/11/2021") || newdate.equals("30/02/2021") || newdate.equals("31/02/2021"));
                pos = Input.ktrDate(newdate);
                if (pos < 0) {
                    System.out.println("Input date must be greater than current date");
                }
            } while (pos != 1);

            Food fd = new Food(newid, newname, newweight, newtype, newplace, newdate);
            if (this.add(fd) == true) {
                System.out.println("Added Successfully!");
            }
            MenuAskUser sc = new MenuAskUser();
            System.out.println("Are you want to continue adding another food?");
            ask = sc.askmenu();
            System.out.println();
        } while (ask == true);
    }

/////////////////////////////////////////////////////////////////////////////////////// HAM SEARCH
    public void searchName() {
        boolean check = false;
        boolean ask = true;
        do {
            if (this.isEmpty()) {
                System.out.println("Empty list!!");
            } else {
                String newName = Input.inputstring("Name of Food you want to search: ", "Name cannot be empty/blank").trim().toUpperCase();
                list.outputTable();
                for (int i = 0; i < this.size(); i++) {
                    if (this.get(i).getName().contains(newName)) {
                        System.out.println(this.get(i));
                        System.out.println("|---------------|---------------|---------------|---------------|-------------------|---------------|");
                        check = true;
                    }
                }
            }
            if (!check) {
                System.out.println("Your food does not exist because the List Of Food table does not return the name of the food you want to search");
            }
            System.out.println();
            MenuAskUser sc = new MenuAskUser();
            System.out.println("Are you want to continue searching another food?");
            ask = sc.askmenu();
        } while (ask == true);
    }

////////////////////////////////////////////////////////////////////////////////////// HAM REMOVE
    public void removeFood() {
        boolean ask = true;
        if (this.isEmpty()) {
            System.out.println("Empty list!!");
        } else {
            String newID = Input.inputStringWith_REGEX("ID of Food (Sxx): ", "[S][\\d]{2}", "Only enter ID according to the form [Sxx] with x is a positive integer number");
            Food fd = this.searchbyID(newID);
            if (fd != null) {
                MenuAskUser sc = new MenuAskUser();
                System.out.println("Are you want to remove this food?");
                ask = sc.askmenu();
                if (ask) {
                    this.remove(fd);
                    System.out.println("Remove successfully");
                } else {
                    System.out.println("Remove fail");
                }
            } else {
                System.out.println("This food have ID " + "[" + newID + "]" + " does not exist");
            }
        }
    }

//////////////////////////////////////////////////////////////////////////////////// HAM SAVE FILE
    public void saveFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Food fd : this) {
                bw.write(fd.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("File Saved!!!");
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

////////////////////////////////////////////////////////////////////////////////////// HAM SORTDAY
    public void printWithSortDay() {
        if (this.isEmpty()) {
            System.out.println("Empty list");
        } else {
            Collections.sort(this, new Comparator<Food>() {
                int d;

                @Override
                public int compare(Food d1, Food d2) {
                    SimpleDateFormat Date = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        d = Date.parse(d2.getDate()).compareTo(Date.parse(d1.getDate()));
                    } catch (ParseException ex) {
                        System.out.println(ex);
                    }
                    return d;
                }
            });

            list.outputTable();
        }
        for (Food fd : this) {
            System.out.println(fd.toString());
            System.out.println("|---------------|---------------|---------------|---------------|-------------------|---------------|");
        }
    }
}
