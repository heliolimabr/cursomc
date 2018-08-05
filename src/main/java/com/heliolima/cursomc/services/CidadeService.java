package com.heliolima.cursomc.services;

import com.heliolima.cursomc.domain.Cidade;
import com.heliolima.cursomc.repositories.CidadeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Helio
 */
@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository repo;
    
    public List<Cidade> findAll(Integer estado_id){
        return repo.findCidades(estado_id);
    }
    
}
