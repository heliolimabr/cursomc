package com.heliolima.cursomc.services;

import com.heliolima.cursomc.domain.Cliente;
import com.heliolima.cursomc.repositories.ClienteRepository;
import com.heliolima.cursomc.services.exceptions.ObjectNotFoundException;
import java.util.Arrays;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Helio
 */
@Service
public class AuthService
{
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private BCryptPasswordEncoder pe;
    
    @Autowired
    private EmailService emailService;
    
    private Random rand = new Random();
    
    @Autowired
    private Environment env;
    
    public void sendNewPassword(String email)
    {
        Cliente cliente = clienteRepository.findByEmail(email);
        if(cliente == null)
            throw new ObjectNotFoundException("Email não encontrado");
        
        String newPass = newPassword();
        cliente.setSenha(pe.encode(newPass));
        clienteRepository.save(cliente);
        
        if(Arrays.asList(env.getActiveProfiles()).contains("test"))
            emailService.sendNewPasswordEmail(cliente, newPass);
        else
            emailService.sendNewPasswordEmailHtml(cliente, newPass);
    }

    private String newPassword()
    {
        char[] vet = new char[10];
        for (int i = 0; i < 10; i++)
        {
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar()
    {
        int opt = rand.nextInt(3);
        if(opt == 0) //gera dígito
        {
            return (char) (rand.nextInt(10) + 48);
        }
        else if(opt == 1) //gera letra maiúscula
        {
            return (char) (rand.nextInt(26) + 65);
        }
        else //gera letra minúscula
        {
            return (char) (rand.nextInt(26) + 97);
        }
    }
}
