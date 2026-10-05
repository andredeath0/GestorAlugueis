package gestoralugueis;

public class Locatario {
    private int idLocatario;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Locatario(int idLocatario, String nome, String cpf, String telefone, String email) {
        this.idLocatario = idLocatario;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdLocatario() { return idLocatario; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return String.format("[%d] %s | CPF: %s | Tel: %s | Email: %s", 
                idLocatario, nome, cpf, telefone, email);
    }
}
