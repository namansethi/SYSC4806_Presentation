package SpringJPA.PrimaryAddressBook;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private List<BuddyInfo> buddies;
    int numBuddies;

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public AddressBook() {
        buddies = new ArrayList<>();
        numBuddies = 0;
    }

    public void addBuddy(BuddyInfo buddyInfo) {
        if (buddyInfo != null) {
            this.buddies.add(buddyInfo);
            numBuddies++;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean contains(BuddyInfo buddyInfo) {
        return buddies.contains(buddyInfo);
    }

    public void removeBuddy(BuddyInfo buddyInfo) {
        if (this.buddies.contains(buddyInfo)) {
            buddies.remove(buddyInfo);
            numBuddies--;
        }
    }

    public void removeBuddy(String name) {
        for (BuddyInfo buddy: this.buddies) {
            if(buddy.getName().equals(name)){
                buddies.remove(buddy);
                numBuddies--;
                break;
            }
        }
    }

    public void removeBuddy(int indexToRemove) {
        if((indexToRemove >= 0) && (indexToRemove < this.getNumBuddies())) {
            buddies.remove(indexToRemove);
            this.numBuddies--;
        }
    }

    public int getNumBuddies() {
        return numBuddies;
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }


    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        BuddyInfo buddyOneInfo =  new BuddyInfo("Jim", "123 house street", "564651023", "18");
        BuddyInfo buddyTwoInfo = new BuddyInfo("John", "321 dog ave", "410044501545", "21");
        BuddyInfo buddyThreeInfo =new BuddyInfo("James", "852 cat road", "6451023485", "35");

        addressBook.addBuddy(buddyOneInfo);
        addressBook.addBuddy(buddyTwoInfo);
        addressBook.addBuddy(buddyThreeInfo);

        for (int i = 0; i < addressBook.getNumBuddies(); i++) {
            System.out.println(addressBook.getBuddies().get(i));
        }

        addressBook.removeBuddy(2);

        for (int i = 0; i < addressBook.getNumBuddies(); i++) {
            System.out.println(addressBook.getBuddies().get(i));
        }

        System.out.println(addressBook.toString());


    }

    @Override
    public String toString() {
        String ret =  "AddressBook{" +
                "id=" + id +
                ", numBuddies=" + numBuddies+
                ", Buddies List={ ";

        for (BuddyInfo buddy: buddies) {
            ret = ret + "{";
            ret = ret + buddy.toString();
            ret = ret + "}, ";
        }

        ret += "}";

        return ret;
    }
}