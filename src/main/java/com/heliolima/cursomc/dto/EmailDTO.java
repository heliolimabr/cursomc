package com.heliolima.cursomc.dto;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Helio
 */
public class EmailDTO implements Serializable
{
    @NotEmpty(message = "Preenchimento Obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    public EmailDTO()
    {
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
    
    
}
