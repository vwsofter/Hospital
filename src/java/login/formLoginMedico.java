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
import dao.MedicoDao;
import model.CadastroMedico;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogarMedico", urlPatterns = {"/LogarMedico"})
public class formLoginMedico extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public MedicoDao dao = new MedicoDao();

    public formLoginMedico() {
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String loginWeb = request.getParameter("txtUsuario");
        String senhaWeb = request.getParameter("txtSenha");
        Boolean Resp = false;

        for (CadastroMedico aux : dao.Data()) {
            if (loginWeb.trim().equals(aux.getUsuario()) && senhaWeb.trim().equals(aux.getSenha())) {
                Resp = true;
            } else {
                out.println("Erro ao logar!!! f(" + loginWeb + ")   (" + senhaWeb + ")");
            }
        }

        if (Resp == true) {
            HttpSession session = request.getSession();
            session.setAttribute("perfil", "MEDICO");
            out.println("Logado com sucesso!!!(" + loginWeb + ")   (" + senhaWeb + ")");
        } else {
            out.println("Erro ao logar!!! f(" + loginWeb + ")   (" + senhaWeb + ")");
        }
    }
}
