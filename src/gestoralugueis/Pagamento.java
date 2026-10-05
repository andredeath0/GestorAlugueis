package gestoralugueis;

public class Pagamento {
    private int idPagamento;
    private Contrato contrato;
    private Usuario usuario;
    private String dataPagamento;
    private double valorPago;
    private String statusPagamento;

    public Pagamento(int idPagamento, Contrato contrato, Usuario usuario, 
                     String dataPagamento, double valorPago, String statusPagamento) {
        this.idPagamento = idPagamento;
        this.contrato = contrato;
        this.usuario = usuario;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
        this.statusPagamento = statusPagamento;
    }

    public int getIdPagamento() { return idPagamento; }
    public Contrato getContrato() { return contrato; }
    public Usuario getUsuario() { return usuario; }
    public String getDataPagamento() { return dataPagamento; }
    public double getValorPago() { return valorPago; }
    public String getStatusPagamento() { return statusPagamento; }

    @Override
    public String toString() {
        return String.format("Pagamento #%d | Contrato #%d | Data: %s | Valor: R$ %.2f | Status: %s", 
                idPagamento, contrato.getIdContrato(), dataPagamento, valorPago, statusPagamento);
    }
}
