<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOCliente" %>
<%@page import="MODEL.Cliente" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Cadastro</title>
    </head>
    <body>
        <h1>Alterar Cadastro</h1>
        <form method="post" action="executar_alterarClientes.jsp">
            <label for="id">ID: </label><br>
            <input type="text" name="id" value="<%=request.getParameter("id")%>" readonly/><br>
            <label for="nome">Nome do Cliente: </label><br>
            <input type="text" name="nome" value="<%=request.getParameter("nome")%>" required/><br>
            <label for="email">E-mail: </label><br>
            <input type="text" name="email" value="<%=request.getParameter("email")%>" required/><br>
            <label for="senha"> Senha: </label><br>
            <input type="password" name="senha" required/><br>
            <input type="submit" value="ALTERAR CLIENTE"/><br><br>
        </form>
            <a href="/CatalogoClientes">Voltar para a página inicial</a>
    </body>
</html>
