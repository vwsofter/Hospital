<%-- 
    Document   : Medico.jsp
    Created on : 27/11/2018, 16:29:31
    Author     : ANA LINA
--%>

<%@page import="dao.MedicoDao"%>
<%@page import="model.CadastroMedico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CadastroMedico model = null;
    String id = null;
    try {
        id = request.getParameter("id");
        final Integer indice = Integer.parseInt(id);
        MedicoDao dao = new MedicoDao();
        model = dao.findByIndice(indice);
    } catch (Exception ex) {
        ex.printStackTrace();
        model = new CadastroMedico();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function callServlet() {
                document.forms[0].action = "Cadastrarmedico";
                document.forms[0].submit();
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Médico</title>
    </head>
    <body    
<br><center>Cadastro Médico:</center><br/>
<div style="text-align: center;">
    <form name="form" method="post">
        <div style="display: inline-block; text-align: left;">
            <%-- Caso o id seja passado o campo id do tipo hidden é criado  --%>
            <%=(id != null ? "<input type=\"hidden\" name=\"id\" value=\"" + id + "\" />" : "")%>
            <table>
                <tr> <td>Nome Completo:</td>
                    <td> <input type="text" name="nome_completo" size=30> </td> </tr>

                <tr> <td>Data Nasc: </td>
                    <td> <input type="date" name="data_nasc" value="<%= model.getData_nasc()%>" size="20"> </td> </tr>
                <tr> <td>CRM: </td>
                    <td> <input type="text" name="crm" value="<%= model.getCrm()%>" size="20"> </td> </tr>  
                <tr> <td>Salario: </td>
                    <td> <input type="text" name="salario" value="<%= model.getSalario()%>" size="20"> </td> </tr> 
                <tr> <td>Usuario:</td>
                    <td> <input type="text" name="usuario" value="<%= model.getUsuario()%>" size=30> </td> </tr>
                <tr> <td>Senha: </td>
                    <td> <input type="password" name="senha" value="<%= model.getSenha()%>" size="20"> </td> </tr>

            </table>  
        </div>
        <br>
        <button onclick="callServlet();">Cadastrar</button>
        <hr />
        <a href="<%= request.getServletContext().getContextPath()%>/Cadastrarmedico">Listar</a>
        </body>
        </html>
