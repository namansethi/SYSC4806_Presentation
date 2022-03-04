package SpringJPA;

import SpringJPA.PrimaryAddressBook.AddressBook;
import SpringJPA.PrimaryAddressBook.BuddyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServingWebContentApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository repository) {
        return (args) -> {
            // save a few customers
            AddressBook book = new AddressBook();
            book.addBuddy(new BuddyInfo("Jim", "123 house street", "564651023", "18"));
            book.addBuddy(new BuddyInfo("John", "321 dog ave", "410044501545", "21"));
            book.addBuddy(new BuddyInfo("James", "852 cat road", "6451023485", "35"));

            AddressBook otherBook = new AddressBook();
            otherBook.addBuddy(new BuddyInfo("Jamie", "15623 sdaw road", "4513254", "35"));
            otherBook.addBuddy(new BuddyInfo("Jack", "12 dsfds street", "4523145", "45"));

            repository.save(book);
            repository.save(otherBook);


            log.info("Customers found with findAll():");
            log.info("-------------------------------");


            for (AddressBook addressBook : repository.findAll()) {
                for (BuddyInfo buddyInfo : addressBook.getBuddies()) {
                    log.info(buddyInfo.toString());
                }
            }
            log.info("");

            // fetch an individual customer by ID
            AddressBook customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            log.info("");
        };
    }
}