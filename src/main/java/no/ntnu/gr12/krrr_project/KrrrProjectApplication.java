package no.ntnu.gr12.krrr_project;

import no.ntnu.gr12.krrr_project.DBClasses.Bike;
import no.ntnu.gr12.krrr_project.DBClasses.BikeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KrrrProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KrrrProjectApplication.class, args);
    }

    public void insertDummyData(BikeRepository repository){
        Bike bike = new Bike();
        bike.setBikeId("50500");
        bike.setDescription("Unique red bike");
        repository.save(new Bike());
    }

    @Bean
    public CommandLineRunner run(BikeRepository repository){
        return (args -> {
            insertDummyData(repository);
            System.out.println(repository.findAll());
        });
    }
}
