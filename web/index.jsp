<%-- 
    Document   : index
    Created on : 19/11/2018, 15:14:35
    Author     : ANA LINA
--%>

<%@page import="model.CadastroMedico"%>
<%@page import="dao.MedicoDao"%>
<%@page import="model.Cadastro"%>
<%@page import="dao.CadastroDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Cadastro model = null;
    String id = null;
    final MedicoDao medicoDao = new MedicoDao();
    try{
        id = request.getParameter("id");
        final Integer indice = Integer.parseInt(id);
        final CadastroDao dao = new CadastroDao();
        model = dao.findByIndice(indice);//Carregando o usuário
    }catch(Exception ex){
        ex.printStackTrace();
        model = new Cadastro();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function callServlet() {
                document.forms[0].action = "Cadastrar";
                document.forms[0].submit();
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
    </head>
    <body>
    <br><center>Cadastro Cliente:</center><br/>
    <div style="text-align: center;">
        <form name="form" method="post">
            <div style="display: inline-block; text-align: left;">

                <table>
                    <%-- Caso o id seja passado o campo id do tipo hidden é criado  --%>
                    <%=( id != null ? "<input type=\"hidden\" name=\"id\" value=\""+id+"\" />" : "" )%>
                    <tr>
                        <td>Nome Completo:</td>
                        <%-- Passando os dados para o formulário por scriplet  --%>
                        <td> <input type="text" name="nome_completo" value="<%= model.getNome_completo() %>" size=30> </td>
                    </tr>

                    <tr>
                        <td>Data Nasc: </td>
                        <td> <input type="date" name="data_nasc" value="<%= model.getData_nasc() %>" size="20"> </td>
                    </tr>
                    <tr>
                        <td>CPF: </td>
                        <td> <input type="text" name="cpf" value="<%= model.getCpf() %>" size="20"> </td>
                    </tr>
                    <tr>
                        <td>Médico: </td>
                        <td>
                            <select name="medico">
                                <option value="0">Selecione </option>
                                <% for(int i =0; i< medicoDao.Data().size(); i++) { %>
                                    <% CadastroMedico medico = medicoDao.Data().get(i); %>
                                    <option value="<%=medico.getCrm()%>" <%=(model.getMedico().equals(medico.getCrm())? "selected" :"")%>>
                                        <%=medico.getNome_completo()%>
                                    </option>
                                <% } %>
                            </select>
                        </td>
                    </tr> 
                </table>  
            </div>
            <br>
            <button onclick="callServlet();">Cadastrar</button>
        </form>
        <hr />
        <a href="<%= request.getServletContext().getContextPath() %>/Cadastrar">Listar</a>
    </div>
</body>
</html>
