package dao;

import model.CadastroSala;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ANA LINA
 */
public class SalaDao {

    private static ArrayList<CadastroSala> cadastros = new ArrayList<>();

    public void add(CadastroSala cadastro) {
        cadastros.add(cadastro);
    }

    public void add(CadastroSala cadastro, int index) {
        cadastros.set(index, cadastro);
    }

    public void remove(int index) {
        cadastros.remove(index);
    }

    public CadastroSala findSala(Integer sala) {
        for (CadastroSala aux : cadastros) {
            if (aux.getSala().equals(sala)) {
                return aux;
            }
        }
        return null;

    }

    public ArrayList<CadastroSala> Data() {
        return cadastros;
    }
    
    public CadastroSala findByIndice(Integer id){
        if(id < cadastros.size()){
            return cadastros.get(id);
        }
        return null;
    }
}
