package gestoralugueis;

public class Vila {
    private int idVila;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Vila(int idVila, String endereco, String bairro, String cidade, String estado, String cep) {
        this.idVila = idVila;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public int getIdVila() { return idVila; }
    public String getEndereco() { return endereco; }
    public String getBairro() { return bairro; }
    public String getCidade() { return cidade; }
    public String getEstado() { return estado; }
    public String getCep() { return cep; }

    @Override
    public String toString() {
        return String.format("[%d] Vila - %s, %s - %s/%s (CEP: %s)", 
                idVila, endereco, bairro, cidade, estado, cep);
    }
}