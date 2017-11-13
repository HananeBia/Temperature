package fr.emse.majeureinfo.springbootintro.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConsoleGreetingService implements GreetingService{


    @Override
    public void greet(String name) {

        System.out.println("Hello "+name+"!");
    }
    @Bean
    public CommandLineRunner greetingCommandLine(GreetingService greetingService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                greetingService.greet("Spring");
            }
        };
    }
}
