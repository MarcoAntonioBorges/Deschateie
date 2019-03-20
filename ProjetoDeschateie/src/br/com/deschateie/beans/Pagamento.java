package br.com.deschateie.beans;


public class Pagamento implements Comparable<Pagamento> {
	private int codPagamento;
	private int codPsiOnline;
	private int codPaciente;
	private int codConsulta;
	private int codFormaPagamento;
	private double valorConsulta;
	private String dataPagamento;
	private int qtdeParcelas;
	private double valorDesconto;
	
	public Pagamento() {
		
	}
	
	
	public Pagamento(int codPagamento, int codConsulta,int codPsiOnline, int codPaciente, int codFormaPagamento,
			double valorConsulta, String dataPagamento, int qtdeParcelas, double valorDesconto) {
		super();
		setCodPagamento(codPagamento);
		setCodPsiOnline(codPsiOnline);
		setCodPaciente(codPaciente);
		setCodConsulta(codConsulta);
		setCodFormaPagamento(codFormaPagamento);
		setValorConsulta(valorConsulta);
		setDataPagamento(dataPagamento);
		setQtdeParcelas(qtdeParcelas);
		setValorDesconto(valorDesconto);
	}

	
	public void setAll(int codPagamento, int codPsiOnline, int codPaciente, int codConsulta, int codFormaPagamento,
			double valorConsulta, String dataPagamento, int qtdeParcelas, double valorDesconto) {
		setCodPagamento(codPagamento);
		setCodPsiOnline(codPsiOnline);
		setCodPaciente(codPaciente);
		setCodConsulta(codConsulta);
		setCodFormaPagamento(codFormaPagamento);
		setValorConsulta(valorConsulta);
		setDataPagamento(dataPagamento);
		setQtdeParcelas(qtdeParcelas);
		setValorDesconto(valorDesconto);
	}

	

	public String getAll() {
		return "Codigo Pagamento :" + codPagamento + "\n"+
				"Codigo PsiOnline :" + codPsiOnline + "\n"+
				"Codigo Paciente :"+ codPaciente + "\n"+
				"Codigo Consulta :" + codConsulta + "\n"+
				"Codigo Forma Pagamento :" + codFormaPagamento +"\n"+
				"Valor Consulta :" + valorConsulta + "\n"+
				"Data Pagamento :" + dataPagamento + "\n"+
				"Quantidade de Parcelas : " + qtdeParcelas + "\n"+
				"Valor Desconto :" + valorDesconto ;
	}


	public int getCodPagamento() {
		return codPagamento;
	}




	public void setCodPagamento(int codPagamento) {
		this.codPagamento = codPagamento;
	}




	public int getCodPsiOnline() {
		return codPsiOnline;
	}




	public void setCodPsiOnline(int codPsiOnline) {
		this.codPsiOnline = codPsiOnline;
	}




	public int getCodPaciente() {
		return codPaciente;
	}




	public void setCodPaciente(int codPaciente) {
		this.codPaciente = codPaciente;
	}




	public int getCodConsulta() {
		return codConsulta;
	}




	public void setCodConsulta(int codConsulta) {
		this.codConsulta = codConsulta;
	}




	public int getCodFormaPagamento() {
		return codFormaPagamento;
	}




	public void setCodFormaPagamento(int codFormaPagamento) {
		this.codFormaPagamento = codFormaPagamento;
	}




	public double getValorConsulta() {
		return valorConsulta;
	}




	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}




	public String getDataPagamento() {
		return dataPagamento;
	}




	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}




	public int getQtdeParcelas() {
		return qtdeParcelas;
	}




	public void setQtdeParcelas(int qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}




	public double getValorDesconto() {
		return valorDesconto;
	}




	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}




	@Override
	public int compareTo(Pagamento o) {
		if (codPagamento < o.codPagamento) {
			return -1;
		}else if(codPagamento>o.codPagamento) {
			return 1;
		}else {
			return 0;
		}
	}

}
