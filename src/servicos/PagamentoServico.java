package servicos;

public class PagamentoServico implements OnelinePagamentoServico {
	private static final double TAXA_PAGAMENTO=0.02;//2%
	private static final double JURO_MENSAL=0.01; //1%
	@Override
	public double taxaPagamento(double quantia) {
		
		return quantia * TAXA_PAGAMENTO;
	}

	@Override
	public double juros(double quantia, int meses) {
		
		return quantia * meses * JURO_MENSAL;
	}
	

}
