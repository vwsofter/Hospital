package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.CirurgiaDao;
import model.CadastroCirurgia;
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
public class Cadastrarcirurgia extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public CirurgiaDao dao = new CirurgiaDao();

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
            String data_cirurgia = request.getParameter("data_cirurgia");
            String hora_cirurgia = request.getParameter("hora_cirurgia");
            String feedback = request.getParameter("feedback");
          

            if( data_cirurgia!= null && hora_cirurgia  != null ){
                // sessão
                CadastroCirurgia entidade = new CadastroCirurgia(data_cirurgia,hora_cirurgia, feedback);
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
        out.println("Cirurgia cadastrados:");
        out.println("------------------------");
        final String context = request.getServletContext().getContextPath();//Pegando caminho do contexto (começo do endereço)
        for (int i = 0;i <dao.Data().size(); i++) {
            CadastroCirurgia aux = dao.Data().get(i);
            out.println("<br>Data cirurgia: " + aux.getData_cirurgia());
            out.println("<a href=\""+context+"/Cirurgia.jsp?id="+i+"\">Editar</a>");
            out.println("<a href=\""+context+"/Cadastrarcirurgia?id="+i+"&excluir=1\">Excluir</a>");
            out.println("<br> Hora Cirurgia:" + aux.getHora_cirurgia());
            out.println("<br> Feedback: " + aux.getFeedback());
           
            out.println("<br>----------------------------------------------------------------");
        }
        out.println("<br>------------------------");
        out.println("<a href=\""+context+"/Cirurgia.jsp\">Voltar</a>");
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

