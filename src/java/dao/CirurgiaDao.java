package dao;


import model.CadastroCirurgia;
import java.util.ArrayList;
import model.Cadastro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ANA LINA
 */
public class CirurgiaDao {

    private static ArrayList<CadastroCirurgia> cadastros = new ArrayList<>();

    public void add(CadastroCirurgia cadastro) {
        cadastros.add(cadastro);
    }
    
    public void add(CadastroCirurgia cadastro, int index) {
        cadastros.set(index, cadastro);
    }
    
    public void remove(int index){
        cadastros.remove(index);
    }

    public CadastroCirurgia findFeedback(String feedback) {
        for (CadastroCirurgia aux : cadastros) {
            if (aux.getFeedback().equals(feedback)) {
                return aux;
            }
        }
        return null;
    }

    public ArrayList<CadastroCirurgia> Data() {
        return cadastros;
    }
    
    public CadastroCirurgia findByIndice(Integer id){
        if(id < cadastros.size()){
            return cadastros.get(id);
        }
        return null;
    }

}
