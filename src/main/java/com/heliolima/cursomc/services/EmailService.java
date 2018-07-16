package com.heliolima.cursomc.services;

import com.heliolima.cursomc.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author Helio
 */
public interface EmailService {
    
    void sendOrderConfirmationEmail(Pedido obj);
    
    void sendEmail(SimpleMailMessage msg);
}
