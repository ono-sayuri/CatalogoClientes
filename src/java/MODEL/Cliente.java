package MODEL;

public class Cliente {
    //criar atributos do cliente
    private int id; //insere o id
    private String nome; //insere o nome
    private String email; //insere o e-mail
    private String senha; //insere a senha
    
    //criar os métodos
    //ID
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    //Nome
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    //E-mail
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    //Senha
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
}
