package login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANA LINA
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Logar", urlPatterns = {"/Logar"})
public class formLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public formLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     *
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    String senha = "123456";
    String nomeGerente = "GERENTE";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String loginWeb = request.getParameter("txtUsuario");
        String senhaWeb = request.getParameter("txtSenha");

        if (loginWeb.trim().equals(nomeGerente) && senhaWeb.trim().equals(senha)) {
            out.println("Logado com sucesso!!!(" + loginWeb + ")   (" + senhaWeb + ")");
            String context = request.getServletContext().getContextPath();
            HttpSession session = request.getSession();
            session.setAttribute("perfil", "GERENTE");
            response.sendRedirect(context + "/PosLoginGerente.jsp");
        } else {
            out.println("Erro ao logar!!!(" + loginWeb + ")   (" + senhaWeb + ")");
        }
   
    }
       
}
  