package SpringJPA;

import SpringJPA.PrimaryAddressBook.AddressBook;
import SpringJPA.PrimaryAddressBook.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AddressBookWebController {

    @Autowired
    private AddressBookRepository repository;

    @GetMapping("/BuddiesForAddressBook/JSON")
    public Optional<AddressBook> getBuddiesForAddressBook(@RequestParam(value = "id", defaultValue = "1") Long id){
        Optional<AddressBook> addressBook = repository.findById(id);
        return addressBook;
    }

    @GetMapping("/AddressBook/JSON")
    public Iterable<AddressBook> getAllAddressBooks(){

        Iterable<AddressBook> addressBooks = repository.findAll();

        return addressBooks;
    }

    @PostMapping("/AddressBook/new")
    public AddressBook addBuddy(){
            return repository.save(new AddressBook());
    }


    @PostMapping("/BuddiesForAddressBook/{id}")
    public AddressBook addBuddy(@PathVariable(value = "id") Long id, @RequestBody BuddyInfo buddyInfo){
        Optional<AddressBook> addressBook = repository.findById(id);
        if(addressBook.isPresent()){
            addressBook.get().addBuddy(buddyInfo);
            return repository.save(addressBook.get());
        }
        else {
            throw new NullPointerException();
        }
    }

    @DeleteMapping("/BuddiesForAddressBook/{id}")
    public AddressBook deleteBuddy(@PathVariable(value = "id") Long id, @RequestBody BuddyInfo buddy){
        Optional<AddressBook> addressBook = repository.findById(id);
        if(addressBook.isPresent()){
            addressBook.get().removeBuddy(buddy.getName());
            return repository.save(addressBook.get());
        }
        else {
            throw new NullPointerException();
        }
    }


    /*
    To Add or remove a buddy, send a post/delete request with a body with the following format
    {
        "name": "johnny",
        "address": "1564 dsasda way",
        "phoneNumber": "123451239",
        "age": "22"
    }
     */


}

