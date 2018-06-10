
package com.heliolima.cursomc.services;


import com.heliolima.cursomc.domain.Pedido;
import com.heliolima.cursomc.repositories.PedidoRepository;
import com.heliolima.cursomc.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Helio Lima
 */
@Repository
public class PedidoService {

    @Autowired
    private PedidoRepository repo;
    
    public Pedido buscar(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não "
                + "encontrado! Id: " + id + ", Tipo: " + 
                Pedido.class.getName())
        );
    }
}
