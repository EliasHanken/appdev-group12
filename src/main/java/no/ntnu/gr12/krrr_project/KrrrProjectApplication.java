package no.ntnu.gr12.krrr_project;

import no.ntnu.gr12.krrr_project.models.Bike;
import no.ntnu.gr12.krrr_project.repositories.BikeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KrrrProjectApplication{

    public static void main(String[] args) {
        SpringApplication.run(KrrrProjectApplication.class, args);
    }

    /*
    mvn spring-boot:run
     */

    public static void insertDummyData(BikeRepository repository){
        Bike bike1 = new Bike("1");
        bike1.setDescription("Unique red bike");

        Bike bike2 = new Bike("2");
        bike2.setDescription("Very nice green bike");

        Bike bike3 = new Bike("7");
        bike3.setDescription("Very ugly pink bike");

        repository.save(bike1);
        repository.save(bike2);
        repository.save(bike3);
    }



    /*
    @Bean
    public CommandLineRunner run(BikeRepository repository){
        return (args -> {
            insertDummyData(repository);
            System.out.println(repository.findAll());
        });
    }

     */

    /**
     * Create configuration for Swagger - turn off some Spring-default APIs etc
     * @return Swagger config
     */
    /*
    @Bean
    public Docket getSwaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // We can say that we want to include only APIs under a specific URL. But we skip that, because
                // here all the APIs which are created by us use the no.ntnu package
                // See some examples of URL matching rules here:
                // https://stackoverflow.com/questions/2952196/ant-path-style-patterns
//				.paths(PathSelectors.ant("/products/**"))
                .apis(RequestHandlerSelectors.basePackage("no.ntnu"))
                .build()
                .apiInfo(describeApi());
    }

    private ApiInfo describeApi() {
        return new ApiInfo(
                "AppDev example 02",
                "Example on how to generate Swagger documentation for a Spring Boot project. Used in course IDATA2306 Application development",
                "1.0",
                "https://github.com/strazdinsg/app-dev",
                new Contact(null, null, null),
                "MIT License",
                "https://github.com/strazdinsg/app-dev/blob/main/LICENSE",
                Collections.emptyList()
        );
    }

     */
}
