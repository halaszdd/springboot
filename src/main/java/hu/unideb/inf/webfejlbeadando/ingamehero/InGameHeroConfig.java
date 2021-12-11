package hu.unideb.inf.webfejlbeadando.ingamehero;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InGameHeroConfig {

    @Bean
    CommandLineRunner commandLineRunner(InGameHeroRepository repository) {
        return args -> {
            InGameHero xiao = new InGameHero(
                    "Xiao",
                    5,
                    "male",
                    "Anemo",
                    "Alatus Nemeseos"
            );
            InGameHero childe = new InGameHero(
                    "Childe",
                    5,
                    "male",
                    "Hydro",
                    "Monoceros Caeli"
            );

            repository.saveAll(
                    List.of(xiao, childe)
            );
        };
    }
}
