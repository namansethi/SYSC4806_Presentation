package SpringJPA;

import SpringJPA.PrimaryAddressBook.AddressBook;
import SpringJPA.PrimaryAddressBook.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewWebController {

    @Autowired
    private AddressBookRepository repository;

    @GetMapping("/BuddiesForAddressBook")
    public String greeting(@RequestParam(name="id", required=false, defaultValue="1") String id, Model model) {
        AddressBook book =  repository.findById(Long.parseLong(id));
        model.addAttribute("buddies", book.getBuddies());

        return "BuddiesForAddressBook";

    }

    @GetMapping("/AddressBook")
    public String address(Model model) {
//        AddressBook book =  repository.findById(Long.parseLong(id));
        model.addAttribute("addressBooks", repository.findAll());

        return "AddressBook";

    }

}