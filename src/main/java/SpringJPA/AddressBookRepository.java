package SpringJPA;

import java.util.List;

import SpringJPA.PrimaryAddressBook.AddressBook;
import SpringJPA.PrimaryAddressBook.BuddyInfo;
import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

    //List<BuddyInfo> findByName(String Name);

    AddressBook findById(long id);

}

