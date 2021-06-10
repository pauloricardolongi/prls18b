package servicos;

public interface OnelinePagamentoServico {
	double taxaPagamento(double quantia);
	double juros(double quantia, int meses);

}
