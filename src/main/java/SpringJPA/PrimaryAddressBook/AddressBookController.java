package SpringJPA.PrimaryAddressBook;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AddressBookController {

    public void launch() {
        String[] contextPaths = new String[]{"app-context.xml"};
        new ClassPathXmlApplicationContext(contextPaths);
    }

    public static void main(String[] args) {
        AddressBookController launcher = new AddressBookController();
        launcher.launch();
    }
}
