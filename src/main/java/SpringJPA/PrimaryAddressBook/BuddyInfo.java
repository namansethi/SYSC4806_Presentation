package SpringJPA.PrimaryAddressBook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;
    private String address;
    private String phoneNumber;
    private String age;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BuddyInfo(String name, String homeAddress, String phoneNumber, String age) {
        this.name = name;
        this.address = homeAddress;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public BuddyInfo(BuddyInfo buddy) {
        this.name = buddy.getName();
        this.address = buddy.getAddress();
        this.phoneNumber = buddy.getPhoneNumber();
        this.age = buddy.getAge();
    }

    public BuddyInfo() {

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return this.name + ", " + this.address + ", " + this.phoneNumber + ", " + this.age;
    }

}
