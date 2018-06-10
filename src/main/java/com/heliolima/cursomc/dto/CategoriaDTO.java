
package com.heliolima.cursomc.dto;

import com.heliolima.cursomc.domain.Categoria;
import java.io.Serializable;

/**
 *
 * @author Helio Lima
 */
public class CategoriaDTO implements Serializable {
    
    private Integer id;
    private String nome;

    public CategoriaDTO() {
    }
    
    public CategoriaDTO(Categoria obj){
        id = obj.getId();
        nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
