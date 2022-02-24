package com.cydeo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {

    @Bean
    Car car() {
        Car c = new Car();
        c.setMake("Lexus");
        return c;
    }

      //Direct wiring
//    @Bean
//    Person person(Car car){
//        Person p = new Person();
//        p.setName("Mike");
//        p.setCar(car());
//        return p;
//    }

    //Autowiring
    @Bean
    Person person(Car car) {
        Person p = new Person();
        p.setName("Mike");
        p.setCar(car);
        return p;
    }

}
