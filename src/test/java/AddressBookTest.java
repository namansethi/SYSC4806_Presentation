
import SpringJPA.PrimaryAddressBook.AddressBook;
import SpringJPA.PrimaryAddressBook.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {

    private AddressBook book;
    private BuddyInfo test, test2, test3, test4;
    private List<BuddyInfo> list;
    @Before
    public void setUp() throws Exception {
        book = new AddressBook();
        test = new BuddyInfo("Jim", "123 zxcvb street", "564651023", "18");
        test2 = new BuddyInfo("John", "321 qazwsx ave", "410044501545", "21");
        test3 = new BuddyInfo("James", "852 asdf road", "6451023485", "35");
        test4 = new BuddyInfo("Jacob", "951 qwerty way", "123546445","12");
        book.addBuddy(test);
        book.addBuddy(test2);
        book.addBuddy(test3);
        list = new ArrayList<>();
    }

    @Test
    public void testAddBuddy() {
        list = book.getBuddies();
        book.addBuddy(test4);
        list.add(test4);
        assertEquals(list, book.getBuddies());
    }

    @Test
    public void testRemoveBuddy() {
        list = book.getBuddies();
        book.removeBuddy(test);
        list.remove(1);
        assertEquals(list, book.getBuddies());
    }

    @Test
    public void testGetNumBuddies() {
        assertEquals(book.getNumBuddies(), 3);
    }



}