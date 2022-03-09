package no.ntnu.gr12.krrr_project;

import no.ntnu.gr12.krrr_project.DBClasses.Bike;
import no.ntnu.gr12.krrr_project.DBClasses.BikeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class KrrrProjectApplication{

    public static void main(String[] args) {
        SpringApplication.run(KrrrProjectApplication.class, args);
    }

    public void insertDummyData(BikeRepository repository){
        Bike bike = new Bike();
        bike.setBikeId("50500");
        bike.setDescription("Unique red bike");
        repository.save(new Bike());
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
}
