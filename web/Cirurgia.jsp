<%-- 
    Document   : Cirurgia
    Created on : 28/11/2018, 15:55:47
    Author     : ANA LINA
--%>
<%@page import="model.CadastroCirurgia"%>
<%@page import="dao.CirurgiaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    CadastroCirurgia model = null;
    String id = null;
    String perfil = (String) session.getAttribute("perfil");
    try{
        id = request.getParameter("id");
        final Integer indice = Integer.parseInt(id);
        final CirurgiaDao dao = new CirurgiaDao();
        model = dao.findByIndice(indice);//Carregando o usuário
    }catch(Exception ex){
        ex.printStackTrace();
        model = new CadastroCirurgia();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function callServlet() {
                document.forms[0].action = "Cadastrarcirurgia";
                document.forms[0].submit();
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cirurrgia</title>
    </head>
    <body>
    <br><center>Cadastro Cirurgia:</center><br/>
    <div style="text-align: center;">
        <form name="form" method="post">
            <div style="display: inline-block; text-align: left;">
                <table>
                    <%=( id != null ? "<input type=\"hidden\" name=\"id\" value=\""+id+"\" />" : "" )%>
                    <tr> <td>Data Cirurgia: </td>
                        <td> <input type="date" name="data_cirurgia" value="<%= model.getData_cirurgia() %>" <%=(perfil.equals("GERENTE")? "" : "readonly=\"readonly\"")%> size="20"> </td> </tr>
                    <tr> <td>Hora Cirurgia: </td>
                        <td> <input type="text" name="hora_cirurgia" value="<%= model.getHora_cirurgia() %>" <%=(perfil.equals("GERENTE")? "" : "readonly=\"readonly\"")%> size="20"> </td> </tr>
                    <tr> <td>Feedback: </td>
                        <td> <input type="text" name="feedback"value="<%= model.getFeedback() %>" <%=(perfil.equals("MEDICO")? "" : "readonly=\"readonly\"")%> size="60"> </td> </tr>
                </table>  
            </div>
            <br>
            <button onclick="callServlet();">Cadastrar</button>
            </form>
        <hr />
        <a href="<%= request.getServletContext().getContextPath() %>/Cadastrarcirurgia">Listar</a>
    </div>
</body>
</html>
