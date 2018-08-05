package com.heliolima.cursomc.services;

import com.heliolima.cursomc.domain.Estado;
import com.heliolima.cursomc.repositories.EstadoRepository;
import com.heliolima.cursomc.services.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Helio
 */
@Service
public class EstadoService {
    
    @Autowired
    private EstadoRepository repo;
    
    
    public Estado find(Integer id){
        Optional<Estado> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não "
                + "encontrado! Id: " + id + ", Tipo: " + 
                Estado.class.getName())
        );
    }
    
    public List<Estado> findAll(){
        return repo.findAllByOrderByNome();
        
    }
    
}
