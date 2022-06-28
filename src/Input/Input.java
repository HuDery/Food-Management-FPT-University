package Input;

import Code.Food;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Input extends Food {

    public static int inputinteger(String name, String error) {
        Scanner sc = new Scanner(System.in);
        int integer;
        do {
            try {
                System.out.print(name);
                integer = Integer.parseInt(sc.nextLine());
                if (integer < 0 || integer > 6) {
                    throw new Exception();
                }
                return integer;
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (true);
    }
////////////////////////////////////////////////////////////////////////////////

    public static double inputdouble(String name, String error) {
        Scanner sc = new Scanner(System.in);
        double b;
        do {
            try {
                System.out.print(name);
                b = Double.parseDouble(sc.nextLine());
                if (b <= 0) {
                    throw new Exception();
                }
                return b;
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (true);
    }
//////////////////////////////////////////////////////////////////////////////////

    public static String inputstring(String name, String error) {
        Scanner sc = new Scanner(System.in);
        String arr;
        do {
            try {
                System.out.print(name);
                arr = sc.nextLine();
                if (arr.isEmpty() || arr.isBlank()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (true);
        return arr;
    }
/////////////////////////////////////////////////////////////////////////////////

    public static String inputStringWith_REGEX(String name, String ktra, String error) {
        String a;
        boolean kt;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(name);
            a = sc.nextLine().trim();
            if (a.isEmpty() || a.isBlank()) {
                System.out.println("ID can not empty/blank");
            } else {
                kt = a.matches(ktra);
                if (a.length() == 0 || kt == false || a.isEmpty()) {
                    System.out.println(error);
                } else {
                    return a;
                }
            }
        }
    }
////////////////////////////////////////////////////////////////////////////////////

    public static String inputStringWith_RegexDATE(String name, String ktra, String error) {
        String a;
        boolean kt;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(name);
            a = sc.nextLine().trim();
            if (a.isEmpty() || a.isBlank()) {
                System.out.println("Date can not empty/blank");
            } else {
                kt = a.matches(ktra);
                if (a.length() == 0 || !kt) {
                    System.out.println("Invalid date");
                    System.out.println(error);
                }else {
                    return a;
                }
            }
        }
    }
//////////////////////////////////////////////////////////////////////////////////

    public static int inputASK(String name, String error) {
        Scanner sc = new Scanner(System.in);
        int integer;
        do {
            try {
                System.out.print(name);
                integer = Integer.parseInt(sc.nextLine());
                if (integer != 1 && integer != 2) {
                    throw new Exception();
                }
                return integer;
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (true);
    }
////////////////////////////////////////////////////////////////////////////////////

    public static int ktrDate(String nd) {
        try {
            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
//            sf.setLenient(false);
            Date dd = sf.parse(nd);
            if (dd.compareTo(sf.parse(sf.format(date))) >= 0) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
//////////////////////////////////////////////////////////////////////////////////////

    public static String inputFielName() {
        System.out.println("Your file will be saved as 'file.txt' ");
        String fileName = inputstring("Only enter name of File: ", "Name of file can't be empty/blank").toUpperCase();
        if (!fileName.endsWith(".txt")) {
            fileName = fileName + ".txt";
        }
        return fileName;
    }

//////////////////////////////////////////////////////////////////////////////////////
    public static int Place_Option(String name, String error, int min, int max) {
        Scanner sc = new Scanner(System.in);
        if (min > max) {
            int tmp = max;
            min = max;
            max = tmp;
        }
        int n;
        while (true) {
            try {
                System.out.print(name);
                n = Integer.parseInt(sc.nextLine().trim());
                if (n < min || n > max) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public static void Choose_Place() {
        System.out.println("PLACE OF FOOD");
        System.out.println("1.Freezer");
        System.out.println("2.Cooler compartment");
        System.out.println("3.Freezing shelf");
    }
}
