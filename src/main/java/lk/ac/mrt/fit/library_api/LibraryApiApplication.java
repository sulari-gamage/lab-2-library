package lk.ac.mrt.fit.library_api;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApiApplication {

    public static void main(String[] args) {
        // Load .env file and push values into system properties
        // so Spring's ${VAR} placeholders resolve correctly.
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()   // safe in production (env vars set externally)
                .load();

        dotenv.entries().forEach(entry ->
                System.setProperty(entry.getKey(), entry.getValue())
        );

        SpringApplication.run(LibraryApiApplication.class, args);
    }

}