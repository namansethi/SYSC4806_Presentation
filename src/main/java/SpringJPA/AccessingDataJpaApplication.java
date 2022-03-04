package SpringJPA;

import SpringJPA.PrimaryAddressBook.AddressBook;
import SpringJPA.PrimaryAddressBook.BuddyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository repository) {
        return (args) -> {
            // save a few customers
            AddressBook book = new AddressBook();
//            book.setId(1L);
            book.addBuddy(new BuddyInfo("Jim", "123 house street", "564651023", "18"));
            book.addBuddy(new BuddyInfo("John", "321 dog ave", "410044501545", "21"));
            book.addBuddy(new BuddyInfo("James", "852 cat road", "6451023485", "35"));

            AddressBook otherBook = new AddressBook();
//            otherBook.setId(2L);
            otherBook.addBuddy(new BuddyInfo("Jamie", "15623 sdaw road", "4513254", "35"));
            otherBook.addBuddy(new BuddyInfo("Jack", "12 dsfds street", "4523145", "45"));

            repository.save(book);
            repository.save(otherBook);
//            repository.save(new BuddyInfo("Jim", "123 house street", "564651023", "18"));
//            repository.save(new BuddyInfo("John", "321 dog ave", "410044501545", "21"));
//            repository.save(new BuddyInfo("James", "852 cat road", "6451023485", "35"));
//            repository.save(new BuddyInfo("Jamie", "15623 sdaw road", "4513254", "35"));
//            repository.save(new BuddyInfo("Jack", "12 dsfds street", "4523145", "45"));



            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
//            for (AddressBook ab : repository.findAll()) {
//                log.info(ab.toString());
//            }
//            log.info("");

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

//            // fetch customers by last name
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//            repository.findByName("J").forEach(bauer -> {
//                log.info(bauer.toString());
//            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}