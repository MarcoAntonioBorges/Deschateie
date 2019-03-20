package br.com.deschateie.excecao;

public class Excecao extends Exception{
	
	
	public static String tratarExcecao(Exception e) {
		if(e.getClass().getName().equals("java.lang.NumberFormatException")) {
			return "Número inválido";
		}else if(e.getClass().getName().equals("java.sql.SQLException")){
			return "não foi possível conectar ao banco de dados, verifique a conexão";
		}else if (e.getClass().getName().equals("java.lang.StringIndexOutOfBoundsException")) {
			return "faltou informar a hora em alguma data, verificar a data de inicio e termino";
		}else if(e.getClass().getName().equals("java.sql.SQLRecoverableException")){
			return "A conexão com o banco foi encerrada inesperadamente ";
		}else {
			return "mensagem do arquiteto";
		}
	}
	
	
	public static String tratarExecao() {
		return "mensagem do arquiteto";
	}

}
