package SpringJPA.PrimaryAddressBook;

import javax.swing.*;

public class PList extends JList {

    private AddressBook addressBook;

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public void init(){
        String[] test = new String[100];
        for (int i = 0; i < addressBook.getBuddies().size(); i++) {
            test[i] = "Name: " + addressBook.getBuddies().get(i);
        }
        this.setListData(test);
    }



}
