package com.heliolima.cursomc.config;

import com.heliolima.cursomc.services.DBService;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author Helio
 */
@Configuration
@Profile("dev")
public class DevConfig {
    
    @Autowired
    private DBService dbService;
    
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;
    
    @Bean
    public boolean instatiateDatabase() throws ParseException{
        if(!strategy.equals("create"))
            return false;
        
        dbService.instatiateTestDatabase();
        return true;
    }
    
}
