package me.formacion;
/*
import me.formacion.DAO.PersistenceFactory;
import me.formacion.DAO.PersistenceManager;
import me.formacion.model.Medico;*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
//@Controller
@SpringBootApplication
@EnableAutoConfiguration
public class App {
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        
        SpringApplication
        	.run(App.class, args);
    }
    public App() {
    }
}
