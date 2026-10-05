package gestoralugueis;

public class Imovel {
    private int idImovel;
    private Vila vila;
    private int numeroApartamento;
    private double valorAluguel;
    private String status;

    public Imovel(int idImovel, Vila vila, int numeroApartamento, double valorAluguel, String status) {
        this.idImovel = idImovel;
        this.vila = vila;
        this.numeroApartamento = numeroApartamento;
        this.valorAluguel = valorAluguel;
        this.status = status;
    }

    public int getIdImovel() { return idImovel; }
    public Vila getVila() { return vila; }
    public int getNumeroApartamento() { return numeroApartamento; }
    public double getValorAluguel() { return valorAluguel; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("[%d] Ap. %d | Vila ID: %d (%s) | Valor: R$ %.2f | Status: %s", 
                idImovel, numeroApartamento, vila.getIdVila(), vila.getBairro(), valorAluguel, status);
    }
}
