package no.ntnu.gr12.krrr_project;

import no.ntnu.gr12.krrr_project.models.*;
import no.ntnu.gr12.krrr_project.repositories.BikeRepository;
import no.ntnu.gr12.krrr_project.repositories.OrderRepository;
import no.ntnu.gr12.krrr_project.repositories.RoleRepository;
import no.ntnu.gr12.krrr_project.repositories.UserRepository;
import no.ntnu.gr12.krrr_project.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
public class DummyDataInitializer implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger("DummyInit");

    //TODO change it up a little?
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Optional<User> existingChuckUser = userRepository.findByUsername("chuck");
        if (existingChuckUser.isEmpty()) {
            logger.info("Importing test data...");
            User chuck = new User("chuck", "$2a$12$/NoknpFFPDlzL3kBryJfsur0yeYC2JFqAs7Fd79ypMP6PN/mtSYmC");
            chuck.setEmail("I really do love bikes, especially the red shiny ones");
            User dave = new User("dave", "$2a$10$nwbEjYKgcomq2rjUPge2JegqI.y4zEcNqRMPdqwFnd1ytorNCQM/y");
            dave.setEmail("Hello guys, i like chocolate");
            User adminUser = new User("admin","$2a$12$5DYlTUOKnhStF1BTCeDHIOBWyccWKpBjavkcEuU7LdhGP9nSodjHy");
            Role user = new Role("ROLE_USER");
            Role admin = new Role("ROLE_ADMIN");
            chuck.addRole(user);
            chuck.addRole(admin);
            dave.addRole(user);
            adminUser.addRole(admin);

            roleRepository.save(user);
            roleRepository.save(admin);

            userRepository.save(chuck);
            userRepository.save(dave);
            userRepository.save(adminUser);

            //Bike bike1 = new Bike("1");
            Bike bike1 = new Bike("1", "", "src/main/resources/red.jpg");
            bike1.setDescription("Unique red bike!!!");

            Bike bike2 = new Bike("2");
            bike2.setDescription("Very nice green bike");

            Bike bike3 = new Bike(BikeEnum.BIKE_BLUE.getModelIdString());
            bike3.setDescription("Very ugly pink bike");

            bikeRepository.save(bike1);
            bikeRepository.save(bike2);
            bikeRepository.save(bike3);

            Order order = new Order();
            order.setDestination("Ålesund");
            order.setShippedFlag(false);
            order.setItemId("5","5");

            Order order2 = new Order();
            order2.setDestination("Skodje");
            order2.setShippedFlag(false);
            order2.setItemId("4","2");

            Order order3 = new Order();
            order3.setDestination("USA");
            order3.setShippedFlag(true);
            order3.setItemId("6","1");

            orderRepository.save(order);
            orderRepository.save(order2);
            orderRepository.save(order3);

            logger.info("DONE importing test data");

            int length = (int) StreamSupport.stream(userService.readUsers().spliterator(), false).count();

            logger.info("Repository length : " + length);
        } else {
            logger.info("Users already in the database, not importing anything");
        }
    }
}
