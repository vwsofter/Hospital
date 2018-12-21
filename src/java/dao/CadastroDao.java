package dao;


import model.Cadastro;
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
public class CadastroDao {

    private static ArrayList<Cadastro> cadastros = new ArrayList<>();

    public void add(Cadastro cadastro) {
        cadastros.add(cadastro);
    }
    
    public void add(Cadastro cadastro, int index) {
        cadastros.set(index, cadastro);
    }
    
    public void remove(int index){
        cadastros.remove(index);
    }

    public Cadastro findNome(String nome_completo) {
        for (Cadastro aux : cadastros) {
            if (aux.getNome_completo() == nome_completo) {
                return aux;
            }
        }
        return null;
    }

    public ArrayList<Cadastro> Data() {
        return cadastros;
    }
    
    public Cadastro findByIndice(Integer id){
        if(id < cadastros.size()){
            return cadastros.get(id);
        }
        return null;
    }

}
