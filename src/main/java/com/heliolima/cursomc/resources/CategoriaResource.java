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
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Helio Lima
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listar()
    {
         Categoria cat1 = new Categoria(1, "informatica");
         Categoria cat2 = new Categoria(2, "Escritório");
         
         List<Categoria> lista = new ArrayList<>();
         
         lista.add(cat1);
         lista.add(cat2);
        
        return lista;
    }    
}
