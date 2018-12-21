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
public class CadastroMedico {

    private String nome_completo = "";
    private String Data_nasc = "";
    private Integer crm = 0;
    private Double salario = 0D;
    private String usuario = "";
    private String senha = "";
    
    public CadastroMedico(){
        
    }

    public CadastroMedico(String nome_completo, String Data_nasc, Integer crm, Double salario, String usuario, String senha) {
        this.nome_completo = nome_completo;
        this.Data_nasc = Data_nasc;
        this.crm = crm;
        this.salario = salario;
        this.usuario = usuario;
        this.senha = senha;
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

    public Integer getCrm() {
        return crm;
    }

    public void setCrm(Integer crm) {
        this.crm = crm;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
