package dao;


import model.CadastroMedico;
import java.util.ArrayList;
import model.CadastroCirurgia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ANA LINA
 */
public class MedicoDao {

    private static ArrayList<CadastroMedico> cadastros = new ArrayList<>();
    
    public void add(CadastroMedico cadastro) {
        cadastros.add(cadastro);
    }
    
    public void add(CadastroMedico cadastro, int index) {
        cadastros.set(index, cadastro);
    }
    
    public void remove(int index){
        cadastros.remove(index);
    }

    public CadastroMedico findNome(String nome_completo) {
        for (CadastroMedico aux : cadastros) {
            if (aux.getNome_completo() == nome_completo) {
                return aux;
            }
        }
        return null;
    }
    
    public CadastroMedico findByCRM(Integer crm) {
        for (CadastroMedico aux : cadastros) {
            if (crm.equals(aux.getCrm())) {
                return aux;
            }
        }
        return null;
    }

    public ArrayList<CadastroMedico> Data() {
        return cadastros;
    }
    
    public CadastroMedico findByIndice(Integer id){
        if(id < cadastros.size()){
            return cadastros.get(id);
        }
        return null;
    }
}
