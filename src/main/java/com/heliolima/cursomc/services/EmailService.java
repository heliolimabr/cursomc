package com.heliolima.cursomc.services;

import com.heliolima.cursomc.domain.Cliente;
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

    public void sendNewPasswordEmail(Cliente cliente, String newPass);
    
    public void sendNewPasswordEmailHtml(Cliente cliente, String newPass);
}
