package Menu;
import java.util.ArrayList;
import Input.Input;

public class Menu extends ArrayList {

    public int getUserChoice() {
        int a;
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i));
        }
        return a =Input.inputinteger("Choose option: ", "Pleas enter choice from 1 to 6");
    }
    
        public int getASKuser() {
        int a;
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + "- " + this.get(i));
        }
        return a = Input.inputASK("Choose option: ", "Please enter option as 1 or 2");
    }
}
