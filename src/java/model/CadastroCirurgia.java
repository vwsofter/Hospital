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
public class CadastroCirurgia {

    private String Data_cirurgia = "";
    private String hora_cirurgia = "";
    private String feedback = "";
    
    public CadastroCirurgia(){
        
    }

    public CadastroCirurgia(String Data_cirurgia, String hora_cirurgia, String feedback) {
        this.Data_cirurgia = Data_cirurgia;
        this.hora_cirurgia = hora_cirurgia;
        this.feedback = feedback;
    }

    public String getData_cirurgia() {
        return Data_cirurgia;
    }

    public void setData_cirurgia(String Data_cirurgia) {
        this.Data_cirurgia = Data_cirurgia;
    }

    public String getHora_cirurgia() {
        return hora_cirurgia;
    }

    public void setHora_cirurgia(String hora_cirurgia) {
        this.hora_cirurgia = hora_cirurgia;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
