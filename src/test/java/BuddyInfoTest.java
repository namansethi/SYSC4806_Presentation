import SpringJPA.PrimaryAddressBook.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {


    private BuddyInfo test;
    @Before
    public void setUp() throws Exception {
        test = new BuddyInfo("Jim", "123 zxcvb street", "564651023", "18");
    }

    @Test
    public void testBuddyInfoCopy() {
        BuddyInfo copy = new BuddyInfo(test);
        assertEquals(copy.toString(), test.toString());
    }

    @Test
    public void testGetSetAge() {
        assertEquals(test.getAge(), "18");
        test.setAge("25");
        assertEquals(test.getAge(), "25");
    }

    @Test
    public void testGetSetPhoneNumber() {
        assertEquals(test.getPhoneNumber(), "564651023");
        test.setPhoneNumber("4589553614");
        assertEquals(test.getPhoneNumber(), "4589553614");
    }

    @Test
    public void testGetSetAddress() {
        assertEquals(test.getAddress(), "123 zxcvb street");
        test.setAddress("321 qazwsx ave");
        assertEquals(test.getAddress(), "321 qazwsx ave");
    }

    @Test
    public void testGetSetName() {
        assertEquals(test.getName(), "Jim");
        test.setName("James");
        assertEquals(test.getName(), "James");
    }

    @Test
    public void testToString() {
        assertEquals(test.toString(), "Jim, 123 zxcvb street, 564651023, 18");
    }



}