<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente" %>
<%@page import="DAO.DAOCliente" %>

<!DOCTYPE html>
<html>
    <body>
        //criar códido jsp
        <%
            try{
                //criar o construtor de clientes
                Cliente cli = new Cliente();
                DAOCliente cld = new DAOCliente();
                
                //pegando o valor passado via "POST do nome, email e senha do cliente do index(navegador)
                //criando uma variável que pega esse valor com o getParameter do index
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");
                
                //verificar se valores são nulos
                if(nome.equals(null) || email.equals(null) || senha.equals(null)){
                    //se for nulo => erro
                    response.sendRedirect("index.jsp");
                } else{
                    //se estiver correto, chama o inserir cliente
                    cli.setNome(nome);
                    cli.setEmail(email);
                    cli.setSenha(senha);
                    //chamar o inserir cliente da DAO
                    cld.inserirCliente(cli);
                    out.print("Cliente inserido com sucesso!");
                    out.print("<meta htttp-equiv='refresh' content='3, url=index.jsp'>");
                }                                                
            } catch(Exception erro){
                //caso ocorra erro ao executar_inserir clientes:
                throw new RuntimeException ("Erro ao executar_inserirClientes: " +erro.getMessage());
            }
        %>    
    </body>
</html>
