package com.heliolima.cursomc.services;

import com.heliolima.cursomc.domain.Pedido;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author Helio
 */
public interface EmailService {
    
    void sendOrderConfirmationEmail(Pedido obj);
    
    void sendEmail(SimpleMailMessage msg);
    
    void sendOrderConfirmationHtmlEmail(Pedido obj);
    
    void sendHtmlEmail(MimeMessage msg);
}
