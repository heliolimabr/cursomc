/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heliolima.cursomc.resources;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.heliolima.cursomc.domain.Categoria;
import com.heliolima.cursomc.dto.CategoriaDTO;
import com.heliolima.cursomc.services.CategoriaService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/**
 *
 * @author Helio Lima
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    
    @Autowired
    private CategoriaService service;
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Categoria> find(@PathVariable Integer id)
    {
        Categoria obj = service.find(id);
        return ResponseEntity.ok(obj);
    }    
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDto)
    {
        Categoria obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDto, @PathVariable Integer id)
    {
        Categoria obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    } 
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> findAll()
    {
        List<Categoria> list = service.findAll();
        //convertendo uma lista em outra
        List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        
        return ResponseEntity.ok(listDTO);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/page")
    public ResponseEntity<Page<CategoriaDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page, 
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
            @RequestParam(value = "direction", defaultValue = "ASC") String direction)
    {
        Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
        //convertendo uma lista em outra
        Page<CategoriaDTO> listDTO = list.map(obj -> new CategoriaDTO(obj));
        
        return ResponseEntity.ok(listDTO);
    }
}
