<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOCliente" %>
<%@page import="MODEL.Cliente" %>

<%
  try{
      //criando construtor de cliente
      Cliente cli = new Cliente();
      DAOCliente cld = new DAOCliente();
      
      //passando os valores para cli <cliente>
      cli.setNome(request.getParameter("nome"));
      cli.setEmail(request.getParameter("email"));
      cli.setSenha(request.getParameter("senha"));
      //id vem como string => converter para int
      cli.setId(Integer.parseInt(request.getParameter("id")));
      //passando para o método
      cld.atualizarCliente(cli);
      //voltar para a página
      out.print("Cliente alterado com sucesso!");
      out.print("<meta http-equiv='refresh' content='3 url=consultar_clientes>");
  } catch (Exception erro){
      //se ocorrer erro ao alterar cliente, aparecerá:
      throw new RuntimeException("Errp ao alterar cliente: "+erro.getMessage());
  }
%>
