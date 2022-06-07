package no.ntnu.gr12.krrr_project;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import no.ntnu.gr12.krrr_project.models.*;
import no.ntnu.gr12.krrr_project.repositories.*;
import no.ntnu.gr12.krrr_project.services.ItemService;
import no.ntnu.gr12.krrr_project.services.ShoppingCartService;
import no.ntnu.gr12.krrr_project.services.UserService;
import org.apache.commons.io.IOUtils;
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
    private ProductRepository productRepository;

    @Autowired ImageRepository imageRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCartService cartService;

    @Autowired
    private ShoppingCartRepository cartRepository;

    @Autowired
    private ItemService itemService;

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

            ShoppingCart testCart = new ShoppingCart();
            testCart.setUser(dave);

            dave.setCart(testCart);


            roleRepository.save(user);
            roleRepository.save(admin);

            userRepository.save(chuck);
            userRepository.save(dave);
            userRepository.save(adminUser);

            cartRepository.save(testCart);
            cartRepository.save(testCart);


            Utils imageDataConverter = new Utils();
            byte[] imageBytes = null;
            Image image = null;

            try{
              Path path = Paths.get("images/commuter.jpg");
              imageBytes = imageDataConverter.imageToByteArray(path.toString(), "jpg");
            } catch (Exception e) {
              e.printStackTrace();
            }

            image = new Image(imageBytes, "jpg", "image/jpg", "Commuter");
            //This image will be assigned id 7.
            imageRepository.save(image);


            Bike bike1 = new Bike("1", "Commuter","",
              7);
            bike1.setDescription("A red bike of model Commuter");
            bike1.setImgData(imageBytes);

            Bike bike2 = new Bike("2");
            bike2.setDescription("Very nice green bike");

            Bike bike3 = new Bike(BikeEnum.BIKE_BLUE.getModelIdString());
            bike3.setDescription("Very ugly pink bike");

            bikeRepository.save(bike1);
            bikeRepository.save(bike2);
            bikeRepository.save(bike3);


            Helmet testHelmet2 = new Helmet();

            itemService.addItem(testHelmet2);
            testCart.addItem(testHelmet2);
            Order order = new Order();
            order.addItem(testHelmet2);
            order.setDestination("Ålesund");
            order.setShippedFlag(false);

            Order order2 = new Order();
            order2.setDestination("Skodje");
            order2.setShippedFlag(false);

            Order order3 = new Order();
            order3.setDestination("USA");
            order3.setShippedFlag(true);

            orderRepository.save(order);
            orderRepository.save(order2);
            orderRepository.save(order3);

            Product product1 = new Product("Canvas Bag", 100);
            product1.setDescription("An environmentally friendly canvas bag.");
            Product product2 = new Product("Bicycle Helmet", 150);
            product2.setDescription("A stylish helmet.");
            Product product3 = new Product("Chalk", 250);
            product3.setDescription("A set of specially developed chalk you can use " +
              "to customize any bike you have loaned from us.");


            try{
              //product1
              product1.setImgData(imageDataConverter.imageToByteArray(
                "images/textile-bag-cropped.jpg", "jpg"));
              //product2
              product2.setImgData(imageDataConverter.imageToByteArray(
                  "images/bike-helmet-cropped.jpg", "jpg"));
              //product3
              product3.setImgData(imageDataConverter.imageToByteArray(
                "images/chalk-cropped.jpg", "jpg"));
            } catch (Exception e) {
              e.printStackTrace();
            }

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);

            logger.info("DONE importing test data");

            int length = (int) StreamSupport.stream(userService.readUsers().spliterator(), false).count();

            logger.info("Repository length : " + length);
        } else {
            logger.info("Users already in the database, not importing anything");
        }
    }
}
