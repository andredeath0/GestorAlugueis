package gestoralugueis;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String login;
    private String senha;
    private String perfil;

    public Usuario(int idUsuario, String nome, String login, String senha, String perfil) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    public int getIdUsuario() { return idUsuario; }
    public String getNome() { return nome; }
    public String getLogin() { return login; }
    public String getSenha() { return senha; }
    public String getPerfil() { return perfil; }

    @Override
    public String toString() {
        return String.format("[%d] %s (%s) - Perfil: %s", idUsuario, nome, login, perfil);
    }
}