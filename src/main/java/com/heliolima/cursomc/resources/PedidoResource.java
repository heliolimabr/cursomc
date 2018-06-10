
package com.heliolima.cursomc.resources;

import com.heliolima.cursomc.domain.Pedido;
import com.heliolima.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Helio Lima
 */
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
    
    @Autowired
    private PedidoService service;
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Pedido obj = service.buscar(id);
        return ResponseEntity.ok(obj);
    }

}
