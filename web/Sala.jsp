
<%-- 
    Document   : Sala.jsp
    Created on : 21/11/2018, 14:56:41
    Author     : ANA LINA
--%>
<%@page import="model.CadastroSala"%>
<%@page import="dao.SalaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%
    CadastroSala model = null;
    String id = null;
    try{
        id = request.getParameter("id");
        final Integer indice = Integer.parseInt(id);
        final SalaDao  dao = new SalaDao();
        model = dao.findByIndice(indice);//Carregando o usuário
    }catch(Exception ex){
        ex.printStackTrace();
        model = new CadastroSala();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function callServlet() {
                document.forms[0].action = "CadastrarSala";
                document.forms[0].submit();
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sala</title>
    </head>
    <body>
    <br><center>Cadastro Sala:</center><br/>
    <div style="text-align: center;">
        <form name="form" method="post">
            <div style="display: inline-block; text-align: left;">
                <table>
                    <%=( id != null ? "<input type=\"hidden\" name=\"id\" value=\""+id+"\" />" : "" )%>
                    <tr> <td>Andar:</td>
                        <td> <input type="text" name="andar" value="<%= model.getAndar() %>" size=30> </td> </tr>
                    <tr> <td>Número: </td>
                        <td> <input type="text" name="numero" value="<%= model.getSala() %>"size="20"> </td> </tr>  
                </table>  
            </div>
            <br>
            <button onclick="callServlet();">Cadastrar</button>
            </form>
        <hr />
        <a href="<%= request.getServletContext().getContextPath() %>/CadastrarSala">Listar</a>
    </div>
</body>
</html>
