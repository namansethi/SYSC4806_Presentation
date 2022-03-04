package SpringJPA.PrimaryAddressBook;

import javax.swing.*;
import java.util.List;

public class PMenuBar extends JMenuBar {

    private List menu;

    public List getMenu() {
        return menu;
    }

    public void setMenu(List menu) {
        this.menu = menu;
    }

    public void init(){
        //this.add(menu);
    }

}
