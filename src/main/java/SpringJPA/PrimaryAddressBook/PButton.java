package SpringJPA.PrimaryAddressBook;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PButton extends JButton {

    private ActionListener actionListener;

    public ActionListener getActionListener() {
        return actionListener;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public void init(){
        this.addActionListener(actionListener);
    }


}
