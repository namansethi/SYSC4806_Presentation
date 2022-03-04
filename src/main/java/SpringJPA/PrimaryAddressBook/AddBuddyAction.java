package SpringJPA.PrimaryAddressBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBuddyAction implements ActionListener {

    private AddressBook addressBook;
    private JTextField name;
    private JTextField address;
    private JTextField phoneNumber;
    private JTextField age;
    private PList plist;

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public JTextField getName() {
        return name;
    }

    public void setName(JTextField name) {
        this.name = name;
    }

    public JTextField getAddress() {
        return address;
    }

    public void setAddress(JTextField address) {
        this.address = address;
    }

    public JTextField getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(JTextField phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public JTextField getAge() {
        return age;
    }

    public void setAge(JTextField age) {
        this.age = age;
    }

    public PList getPlist() {
        return plist;
    }

    public void setPlist(PList plist) {
        this.plist = plist;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addressBook.addBuddy(new BuddyInfo(name.getText(), address.getText(), phoneNumber.getText(), age.getText()));
        plist.init();
    }
}
