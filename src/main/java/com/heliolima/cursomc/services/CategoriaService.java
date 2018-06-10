
package com.heliolima.cursomc.services;

import com.heliolima.cursomc.domain.Categoria;
import com.heliolima.cursomc.repositories.CategoriaRepository;
import com.heliolima.cursomc.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Helio Lima
 */
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;
    
    public Categoria buscar(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não "
                + "encontrado! Id: " + id + ", Tipo: " + 
                Categoria.class.getName())
        );
    }
    
    public Categoria insert(Categoria obj)
    {
        obj.setId(null);
        return repo.save(obj);
    }
    
}
