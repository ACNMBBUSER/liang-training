package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student liang = new Student( "Liang", "heng.liang.teng@accenture.com", LocalDate.of(2000, Month.JULY, 26));
            Student terry = new Student("Terry", "terry123@accenture.com", LocalDate.of(2001, Month.OCTOBER, 15));
            repository.saveAll(
                    List.of(liang, terry)
            );
        };
    }
}
