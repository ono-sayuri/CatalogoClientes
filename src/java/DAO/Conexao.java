package DAO;
import java.sql.Connection; //utilizar recursos de conexão
import java.sql.DriverManager; //Drivers do Banco de Dados

public class Conexao {
    public Connection getConexao(){
        //verificar a existência de erros dentro do código
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver"); //aponta o local dos drivers
            return DriverManager.getConnection("jdbc:derby://localhost:1527/bdClientes","root","admim"); //aponta para o BD, nome e senha
        } catch (Exception erro){ 
            //caso a conexão dê errado, exibirá o seguinte erro:
            throw new RuntimeException("Erro de conexão: " +erro.getMessage());
        }
    }
}
