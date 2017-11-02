package br.com.active.reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.active.reservas")
public class ActiveReservasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActiveReservasApplication.class, args);
        
    }
}
