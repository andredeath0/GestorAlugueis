package gestoralugueis;

public class Contrato {
    private int idContrato;
    private Imovel imovel;
    private Locatario locatario;
    private Usuario usuario;
    private String dataInicio;
    private String dataFim;
    private double valorMensal;
    private String statusContrato;

    public Contrato(int idContrato, Imovel imovel, Locatario locatario, Usuario usuario, 
                    String dataInicio, String dataFim, double valorMensal, String statusContrato) {
        this.idContrato = idContrato;
        this.imovel = imovel;
        this.locatario = locatario;
        this.usuario = usuario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorMensal = valorMensal;
        this.statusContrato = statusContrato;
        
        if (statusContrato.equalsIgnoreCase("Ativo")) {
            this.imovel.setStatus("Ocupado");
        }
    }

    public int getIdContrato() { return idContrato; }
    public Imovel getImovel() { return imovel; }
    public Locatario getLocatario() { return locatario; }
    public Usuario getUsuario() { return usuario; }
    public String getDataInicio() { return dataInicio; }
    public String getDataFim() { return dataFim; }
    public double getValorMensal() { return valorMensal; }
    public String getStatusContrato() { return statusContrato; }

    @Override
    public String toString() {
        return String.format("Contrato #%d | Ap. %d | Inquilino: %s | Valor: R$ %.2f | Status: %s | Op: %s", 
                idContrato, imovel.getNumeroApartamento(), locatario.getNome(), valorMensal, statusContrato, usuario.getNome());
    }
}
