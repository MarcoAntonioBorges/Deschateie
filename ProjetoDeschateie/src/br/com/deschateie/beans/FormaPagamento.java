package br.com.deschateie.beans;

public class FormaPagamento implements Comparable<FormaPagamento>{
	private int codFormaPagamento;
	private String formaPagamento;
	
	
	
	
	public FormaPagamento(int codFormaPagamento, String formaPagamento) {
		super();
		setCodFormaPagamento(codFormaPagamento);
		setFormaPagamento(formaPagamento);
	}
	
	public FormaPagamento() {
		
	}
	
	public void setAll(int codFormaPagamento, String formaPagamento) {
		setCodFormaPagamento(codFormaPagamento);
		setFormaPagamento(formaPagamento);
	}
	
	
	
	public String getAll() {
		return "codigo forma pagamento : " + codFormaPagamento + "\n"+
				"Forma Pagamento : " + formaPagamento ;
	}

	public int getCodFormaPagamento() {
		return codFormaPagamento;
	}
	public void setCodFormaPagamento(int codFormaPagamento) {
		this.codFormaPagamento = codFormaPagamento;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public int compareTo(FormaPagamento o) {
		if (this.codFormaPagamento< o.getCodFormaPagamento()) {
			return -1;
		}else if(this.codFormaPagamento> o.getCodFormaPagamento()) {
			return 1;
		}else {
			return 0;
		}
	
	}
	
}
