package SpringJPA.PrimaryAddressBook;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;


public class AddressBookView extends JFrame{

    List panelComponents;

    private PList list;
    private PButton addButton;
    private PButton removeButton;


    public AddressBookView() {
    }


    public PList getList() {
        return list;
    }

    public void setList(PList list) {
        this.list = list;
    }

    public List getPanelComponents() {
        return panelComponents;
    }

    public void setPanelComponents(List panelComponents) {
        this.panelComponents = panelComponents;
    }

    public void init() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridLayout(0, 1));
        setVisible(true);


        for (Iterator iter = panelComponents.iterator();
             iter.hasNext();) {
            Component component = (Component) iter.next();
            add(component);
        }
    }

}
