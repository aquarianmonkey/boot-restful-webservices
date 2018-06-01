package com.dairyfarm;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@ComponentScan(basePackages = "hello")
public class App
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );

        SpringApplication.run(App.class, args);

    }

//    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx)
    {
        return args -> {
            System.out.println("Let's inpect the beans by boot");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);

            for(String beanName : beanNames){
                System.out.println(beanName);
            }
        };

    }


}
