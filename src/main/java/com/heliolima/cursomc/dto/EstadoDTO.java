package com.heliolima.cursomc.dto;

import com.heliolima.cursomc.domain.Estado;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Helio
 */
public class EstadoDTO implements Serializable {
    
    private Integer id;
    @NotEmpty(message = "Preenchimento Obrigatório")
    private String nome;

    public EstadoDTO() {
    }
    
    public EstadoDTO(Estado estado){
        this.id = estado.getId();
        this.nome = estado.getNome();
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
