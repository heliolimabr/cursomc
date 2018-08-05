package com.heliolima.cursomc.resources;

import com.heliolima.cursomc.domain.Cidade;
import com.heliolima.cursomc.domain.Estado;
import com.heliolima.cursomc.dto.CidadeDTO;
import com.heliolima.cursomc.dto.EstadoDTO;
import com.heliolima.cursomc.services.CidadeService;
import com.heliolima.cursomc.services.EstadoService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Helio
 */
@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {
    
    @Autowired
    private EstadoService service;
    
    @Autowired
    private CidadeService cidadeService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EstadoDTO>> findAll(){
        List<Estado> list = service.findAll();
        
        List<EstadoDTO> listDTO = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
        
        return ResponseEntity.ok(listDTO);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{estado_id}/cidades")
    public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable int estado_id){
        List<Cidade> list = cidadeService.findAll(estado_id);
        
        List<CidadeDTO> listDTO = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
        
        return ResponseEntity.ok(listDTO);
    }
}
