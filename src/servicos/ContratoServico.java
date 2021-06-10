package servicos;

import java.util.Calendar;

import java.util.Date;

import entidades.Contrato;
import entidades.Parcela;

public class ContratoServico {
	
	private OnelinePagamentoServico onlinePagamentoServico;

	public ContratoServico(OnelinePagamentoServico onlinePagamentoServico) {
		this.onlinePagamentoServico= onlinePagamentoServico;
		
	}
	public void processandoContrato(Contrato contrato, int meses) {
		//parcelaBasica=600/2= 200
		double parcelaBasica= contrato.getValorTotal()/ meses;
		for ( int i=1; i<= meses; i++) {
			double taxaAtualizada= parcelaBasica + onlinePagamentoServico.juros(parcelaBasica,i);//200 x 1% x1 =202.00
			//parcelaBasica=202
			double fullQuota = taxaAtualizada + onlinePagamentoServico.taxaPagamento(taxaAtualizada);//ful Quota=200+ 2%=206.04
			
			//fullCota= 206.04
			
			Date dataVencimento = addMeses(contrato.getData(), i);
			contrato.getParcelas().add(new Parcela(dataVencimento, fullQuota));
		}
		
	}
	private Date addMeses(Date date, int N) {
		Calendar calendar= Calendar.getInstance(); 
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();
	}
}
