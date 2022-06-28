package Menu;
import java.util.ArrayList;
public class MenuAskUser{
     public boolean askmenu(){
        Menu menu = new Menu();
        boolean option = false;
        menu.add("Yes");
        menu.add("No");
        int choice;
        do{
            choice = menu.getASKuser();
            switch(choice){
                case 1: option = true; break;
                case 2: option = false; break;
            }
        }while(choice != 1 && choice !=2);
        return option;
    }
}
