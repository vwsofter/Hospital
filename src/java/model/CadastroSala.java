package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANA LINA
 */
public class CadastroSala {

    private Integer andar = 0;
    private Integer sala = 0;

    public CadastroSala(){
    
    } 
    public CadastroSala(Integer andar, Integer sala) {
        this.andar = andar;
        this.sala = sala;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public Integer getSala() {
        return sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

}
