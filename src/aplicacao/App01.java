package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Parcela;
import servicos.ContratoServico;
import servicos.PagamentoServico;




public class App01 {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		System.out.println("entre contrato e data");
		System.out.print("Numero");
		Integer numero= sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor do Contrato");
		Double valorContrato= sc.nextDouble();
		
		Contrato contrato= new Contrato(numero, data, valorContrato);
		System.out.print("Entre com o número de parcelas");
		int N= sc.nextInt();
		
		ContratoServico cs= new ContratoServico(new PagamentoServico());
		cs.processandoContrato(contrato, N);
		
		System.out.println("Parcelas:");
		for(Parcela it : contrato.getParcelas()) {
			System.out.println(it);
		}
		
		sc.close();

	}

}
