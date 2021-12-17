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
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student student1 = new Student("Ahmed","Ahmed@gmail.com" ,LocalDate.of(1999, Month.APRIL,5));
            Student student2 = new Student("Abbas","Abbas@gmail.com",LocalDate.of(1989, Month.FEBRUARY,5));

            repository.saveAllAndFlush(List.of(student1,student2));
        };
    }
}
