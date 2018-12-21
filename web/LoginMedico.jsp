<%-- 
    Document   : Login Gerente
    Created on : 29/11/2018, 13:19:24
    Author     : ANA LINA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function validarLoginMedico() {
                if (document.formLoginMedico.txtUsuario.value == "") {
                    alert("Campo Usuário Não Informado");
                    return false;
                }
                if (document.formLoginMedico.txtSenha.value == "") {
                    alert("Campo Senha Não Informado");
                    return false;
                }

                document.formLoginMedico.submit();
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Medico</title>
    </head>
    <body>
        <title>Login Medico</title>
    </head>
<body 
    <table>
        <br><center>Login Medico:</center><br/>
        <div style="text-align: center;">
            <form name="formLoginMedico" action="LogarMedico" method="post">
                <div style="display: inline-block; text-align: left;">
                    <tr> <td>Login:</td>
                        <td> <input type="text" name="txtUsuario" size=20> </td> </tr>

                    <tr> <td>Senha:</td>
                        <td> <input type="text" name="txtSenha" size=20> </td> </tr>
                    </table> 

                    <br>
                    <button onclick="validarLoginMedico();">Entrar</button>

                    </body>
                    </html>
