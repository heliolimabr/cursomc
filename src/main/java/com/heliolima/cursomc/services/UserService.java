package com.heliolima.cursomc.services;

import com.heliolima.cursomc.security.UserSS;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Helio
 */
@Service
public class UserService
{
    
    public static UserSS authenticated()
    {
        try
        {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e)
        {
            return null;
        }
        
    }
    
}
