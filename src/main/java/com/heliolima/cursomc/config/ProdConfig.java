package com.heliolima.cursomc.config;

import com.heliolima.cursomc.services.DBService;
import com.heliolima.cursomc.services.EmailService;
import com.heliolima.cursomc.services.SmtpEmailService;
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
@Profile("prod")
public class ProdConfig {
    
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
    
    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }
    
}
