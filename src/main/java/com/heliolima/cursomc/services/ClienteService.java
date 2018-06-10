
package com.heliolima.cursomc.services;

import com.heliolima.cursomc.domain.Cliente;
import com.heliolima.cursomc.repositories.ClienteRepository;
import com.heliolima.cursomc.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Helio Lima
 */
@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repo;
    
    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não "
                + "encontrado! Id: " + id + ", Tipo: " + 
                Cliente.class.getName())
        );
    }

}
