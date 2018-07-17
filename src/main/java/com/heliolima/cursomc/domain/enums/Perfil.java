/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heliolima.cursomc.domain.enums;

/**
 *
 * @author Helio Lima
 */
public enum Perfil {
    
    ADMIN(1, "ROLE_ADMIN"),
    CLIENTE(2, "ROLE_CLIENTE");
    
    private int cod;
    private String descricao;
    
    private Perfil(int cod, String desc){
        this.cod = cod;
        this.descricao = desc;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static Perfil toEnum(Integer cod){
        if(cod == null) return null;
        
        for(Perfil x : Perfil.values()){
            if(cod.equals(x.getCod()))
                return x;
        }
        
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
