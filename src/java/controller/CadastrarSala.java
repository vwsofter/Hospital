package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.SalaDao;
import model.CadastroSala;
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
public class CadastrarSala extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public SalaDao dao = new SalaDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

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
        Integer index = getIndex(request);
         try{
            Integer andar= Integer.parseInt(request.getParameter("andar"));
             Integer sala= Integer.parseInt(request.getParameter("numero"));
             
             
             if(andar != null && sala != null){
                // sessão
                CadastroSala entidade = new CadastroSala(andar,sala);
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
        out.println("Salas Cadastradas:");
        out.println("------------------------");
       final String context = request.getServletContext().getContextPath();//Pegando caminho do contexto (começo do endereço)
        for (int i = 0;i <dao.Data().size(); i++) {
             CadastroSala aux = dao.Data().get(i);
 out.println("<br>Andar: " + aux.getAndar());
            out.println("<a href=\""+context+"/Sala.jsp?id="+i+"\">Editar</a>");
            out.println("<a href=\""+context+"/CadastrarSala?id="+i+"&excluir=1\">Excluir</a>");
            out.println("<br> Sala:" + aux.getSala());
            
            out.println("<br>----------------------------------------------------------------");
        }
        out.println("<br>------------------------");
        out.println("<a href=\""+context+"/Sala.jsp\">Voltar</a>");
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
