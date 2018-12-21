package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.MedicoDao;
import model.CadastroMedico;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANA LINA
 */
public class Cadastrarmedico extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public MedicoDao dao = new MedicoDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer index = getIndex(request);//Vendo se o indice foir passado
        String excluir = request.getParameter("excluir");
        if(excluir != null && index != null){
            //Processo de excluir
            dao.remove(index);
        }
        
        this.listar(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer index = getIndex(request);//Vendo se o indice foir passado
        
        try{
            String nome_completo = request.getParameter("nome_completo");
            String data_nasc = request.getParameter("data_nasc");
            Integer crm = Integer.parseInt(request.getParameter("crm"));
            Double salario = Double.parseDouble(request.getParameter("salario"));
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");

            if(nome_completo != null && data_nasc != null && crm != null && salario != null && usuario != null && senha != null){
                // sessão
                CadastroMedico entidade = new CadastroMedico(nome_completo, data_nasc, crm, salario, usuario, senha);
                if(index == null){
                    dao.add(entidade);
                }else{
                    dao.add(entidade, index);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        this.listar(request, response);

    }
    
    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<br>------------------------");
        out.println("Medico cadastrados:");
        out.println("------------------------");
        final String context = request.getServletContext().getContextPath();//Pegando caminho do contexto (começo do endereço)
        for (int i = 0;i <dao.Data().size(); i++) {
            CadastroMedico aux = dao.Data().get(i);
            out.println("<br>Nome completo: " + aux.getNome_completo());
            out.println("<a href=\""+context+"/Medico.jsp?id="+i+"\">Editar</a>");
            out.println("<a href=\""+context+"/Cadastrarmedico?id="+i+"&excluir=1\">Excluir</a>");
            out.println("<br> Data nascimento:" + aux.getData_nasc());
            out.println("<br> Crm: " + aux.getCrm());
            out.println("<br> salario: " + aux.getSalario());
            out.println("<br> Usuario: " + aux.getUsuario());
            out.println("<br> senha: " + aux.getSenha());
            out.println("<br>----------------------------------------------------------------");
        }
        out.println("<br>------------------------");
        out.println("<a href=\""+context+"/Medico.jsp\">Voltar</a>");
        out.println("------------------------");
    }
    
    private Integer getIndex(HttpServletRequest request){
        String id = request.getParameter("id");
        Integer index = null;
        if(id != null){
            try{
                index = Integer.parseInt(id);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return index;
    }

}
