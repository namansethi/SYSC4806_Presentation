package SpringJPA.PrimaryAddressBook;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PMenu {

    List<JMenuItem> items = new ArrayList<JMenuItem>();

    public List<JMenuItem> getItems() {
        return items;
    }

    public void setItems(List<JMenuItem> items) {
        this.items = items;
    }

    public void init(){

    }

}
