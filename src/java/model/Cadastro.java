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
public class Cadastro {

    private String nome_completo = "";
    private String Data_nasc = "";
    private String cpf = "";
    private Integer medico = 0;
    
    public Cadastro(){
        
    }

    public Cadastro(String nome_completo, String Data_nasc, String cpf, Integer medico) {
        this.nome_completo = nome_completo;
        this.Data_nasc = Data_nasc;
        this.cpf = cpf;
        this.medico = medico;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getData_nasc() {
        return Data_nasc;
    }

    public void setData_nasc(String Data_nasc) {
        this.Data_nasc = Data_nasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getMedico() {
        return medico;
    }

    public void setMedico(Integer medico) {
        this.medico = medico;
    }

}
