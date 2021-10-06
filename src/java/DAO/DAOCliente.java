package DAO;
import MODEL.Cliente; //get e set do Cliente
import java.sql.Connection; //abrir conexão
import java.sql.PreparedStatement; //instruções SQL com parâmetros
import java.sql.Statement; //instruções SQL
import java.sql.ResultSet; //receber o resultado da busca do BD
import java.util.ArrayList; //exibir os resultados do ResultSet

public class DAOCliente {
    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Cliente> lista = new ArrayList<>();
    
    //criar construtor de conexão
    public DAOCliente(){
        conn = new Conexao().getConexao();
    }
    
    //criar o método de inserir um novo cliente
    public void inserirCliente (Cliente cliente){
        //receber a instrução SQL
        String sql = "INSERT INTO tb_clientes (nome, email,senha) VALUES (?,?,?)";
        //verificar a existência de erros
        try{
            //passar a String para o prepareStatement e a conexão
            stmt = conn.prepareStatement(sql);
            //passar os valores dos parâmetros
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            //executar instrução
            stmt.execute();
            //fechar conexão
            stmt.close();
        } catch (Exception erro){
            //caso ocorra erro ao inserir o cliente, exibe-se o seguinte erro:
            throw new RuntimeException ("Erro ao inserir cliente: " +erro.getMessage());
        }
    }
    
    //criar o método de listar os clientes
    public ArrayList <Cliente> listarClientes(){
        //receber a instrução SQL
        String sql = "SELECT * FROM tb_clientes";
        //verificar a existência de erros
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //criar estrutura de repetição para carregar linha por linha do Array
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                lista.add(cliente);
            }                  
        } catch (Exception erro){
            //caso ocorra erro ao listar o cliente, aparecerá:
            throw new RuntimeException ("Erro ao listar cliente: " +erro.getMessage());
        }
        return lista;
    }
    
    //criar método para consultar cliente pelo nome
    public ArrayList<Cliente> listarClientesNome(String valor){
        //receber a instrução SQL
        String sql = "SELECT * FROM tb_clientes WHERE nome LIKE '%" + valor + "%'";
        //verificar a existência de erro
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //criar estrutura de repetição para carregar linha por linha do Array
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                lista.add(cliente);
            }                  
        } catch (Exception erro){
            //caso ocorra erro ao listar o cliente, aparecerá:
            throw new RuntimeException ("Erro ao listar cliente: " +erro.getMessage());
        }
        return lista;    
    }  
    
    //criar método para atualizar cliente
    public void atualizarCliente(Cliente cliente){
        //verificar a existência de erro
        try{
            String sql = "UPDATE tb_clientes SET nome = ?, email = ?, senha = ?" + "WHERE id = ?";
            //passar a string para o prepareStatement e a conexão
            stmt = conn.prepareStatement(sql);
            //passar os valores dos parâmetros
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            stmt.setInt(4, cliente.getId());
            //executar a instrução
            stmt.execute();
            //fechar a conexão
            stmt.close();
        } catch (Exception erro){
            //caso ocorra erro ao atualizar cliente, aparecerá:
            throw new RuntimeException ("Erro ao atualizar cliente: " +erro.getMessage());
        }
    }
    
    //método para excluir cliente
    public void excluirCliente(int valor){
        //verificar a existência de erro
        try{
            //receber instrução SQL
            String sql = "DELETE FROM tb_clientes WHERE id = " +valor;
            //passar conexão para o statement
            st = conn.createStatement();
            //executar instrução SQL
            st.execute(sql);
            //fechar conexão
            st.close();
        } catch (Exception erro){
            //caso ocorra erro ao excluir cliente, aparecerá:
            throw new RuntimeException ("Erro ao excluir cliente: " +erro.getMessage());
        }
    }
    
}
