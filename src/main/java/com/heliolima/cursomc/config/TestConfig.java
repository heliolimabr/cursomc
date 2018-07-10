package com.heliolima.cursomc.config;

import com.heliolima.cursomc.services.DBService;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author Helio
 */
@Configuration
@Profile("test")
public class TestConfig {
    
    @Autowired
    private DBService dbService;
    
    @Bean
    public boolean instatiateDatabase() throws ParseException{
        dbService.instatiateTestDatabase();
        return true;
    }
    
}
