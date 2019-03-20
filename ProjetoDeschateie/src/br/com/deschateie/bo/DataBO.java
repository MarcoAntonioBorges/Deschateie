package br.com.deschateie.bo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Classe responsável por validas datas para todas as tabelas
 * possui métodos para valida data, validar data e hora, comparar datas e converter o formato da data
 * @author Deschateie
 * @version 1.0
 * @since 1.0
 * @see ConversaBO
 * @see AgendamentoBO
 * @see UsuarioBO
 * @see ConsultaBO
 *
 */
public class DataBO {
	
	private static Pattern pattern ;
	private static Matcher matcher;
	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas DataBO
	 * Regras avaliadas
	 * 1 Verifica se a data está dentro do padrão brasileiro de datas
	 * @param data Recebe uma String que será data
	 * @return	Retonar uma String informando o erro ou a própria data caso esteja
	 * de acordo com a regra de negocios
	 * @author Deschateie
	 */
	public static String validarData(String data) {
		
		pattern = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$");
		matcher = pattern.matcher(data);
		
		if(!matcher.find()) {
			return "data inválido";
		}
		return data;
	}
	
	
	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas DataBO
	 * Regras avaliadas
	 * 1 Verifica se a data está dentro do padrão brasileiro de datas
	 * 2 Verifica se a hora passada é valida e está dentro do padrãp brasileiro
	 * @param dataHora Recebe uma String que será data e a hora separados por um (-)
	 * @return	Retonar uma String informando o erro ou a própria data e hora caso esteja
	 * de acordo com a regra de negocios
	 * @author Deschateie
	 */
	public static String validaDataHora(String dataHora) {
		
		if (dataHora.length()<10) {
			return "passe a data no formato dd/mm/yyyy ou dd/mm/yyyy-hh:mm";
		}
		String data = dataHora.substring(0, 10);
		
		String regexData = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
		Pattern pattern = Pattern.compile(regexData);
		Matcher matcher = pattern.matcher(data);
		
		if(!matcher.find()) {
			return "data inválido"; 
		}
		String hora = "";
		if (dataHora.length()>10) {
			hora  = dataHora.substring(11, dataHora.length());
			String regexHora = "^([0-1]?[0-9]|[2][0-3]):([0-5][0-9])(:[0-5][0-9])?$";
			pattern = Pattern.compile(regexHora);
			matcher = pattern.matcher(hora);
			
			if (!matcher.find()) {
				return "Horario Invalido";
			}
			return data + "-"+ hora;
		}
		
		
		return data ;
		
	}
	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas DataBO
	 * Regras avaliadas
	 * 1 Verifica se o horario de termino é menor que o de inicio
	 * @param dataInicio Recebe uma String com a hora de inicio
	 * @param dataTermino Recebe uma String com a hora de termino
	 * @return	Retonar uma Stirng informando o erro ou (ok) caso esteja
	 * de acordo com a regra de negocios
	 * @author Deschateie
	 */
	public static String  comparaDatas(String dataInicio,String dataTermino) {
		
		if (dataInicio.length()<10 || dataTermino.length()<10) {
			return "passe as datas no formato dd/mm/yyyy ou dd/mm/yyyy-hh:mm";
		}
		int dia = 0;
		int mes = 0;
		int ano = 0;
		
		int dia2 = 0;
		int mes2 = 0;
		int ano2 = 0;
		
		int hora = 0;
		int minuto = 0;
		
		int hora2 = 0;
		int minuto2 = 0;
		
		dia = Integer.parseInt(dataInicio.substring(0, 2));
		mes = Integer.parseInt(dataInicio.substring(dataInicio.indexOf("/")+1,5));
		ano = Integer.parseInt(dataInicio.substring(6,10));
		hora = Integer.parseInt(dataInicio.substring(11,13));
		minuto = Integer.parseInt(dataInicio.substring(14,16));
		
		dia2 = Integer.parseInt(dataTermino.substring(0, 2));
		mes2 = Integer.parseInt(dataTermino.substring(dataTermino.indexOf("/")+1,5));
		ano2 = Integer.parseInt(dataTermino.substring(6,10));
		hora2 = Integer.parseInt(dataTermino.substring(11,13));
		minuto2 = Integer.parseInt(dataTermino.substring(14,16));
		
		
		
		
		if(ano2<ano) {
			return "O ano de termino nao pode ser menor que o ano de inicio ";
		}else if(mes2<mes) {
				return "O mes de termino nao pode ser menor que o mes de inicio";
			}else if(dia>dia2) {					
					if (hora2<hora) {
						return "O horario de termino precisa ser maior que o horario de inicio";
					}else if(minuto2<minuto) {
						return "Os minuto de termino precisa ser mais que os minutos de inicio";
					}	
				
				}else if(dia2<dia){
					return "O dia do termino nao pode ser menor que o dia do inicio";
				}
		
		 return "ok";


		
	}

	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas DataBO
	 * Regras avaliadas
	 * 1 Verifica se a data e a hora está no formato padrao brasileiro pegando por referencia o horario americado
	 * @param data Recebe uma String que será data mas também pode ser a data e a hora na mesma String
	 * @return	Retonar uma String com a nova data
	 * de acordo com a regra de negocios
	 * @author Deschateie
	 */
	public static String converterFormatoData(String data) {
		
		if (data.length()<10) {
			return "Passe a data no formato DD/MM/YYYY ou  DD/MM/YYYY-HH:MM";
		}
		String ano = data.substring(0,4);
		String mes = data.substring(5,7);
		String dia = data.substring(8,10);
		String novaData = dia +"/"+mes+"/"+ano;
		
		
		if(data.length()>10) {
			String hora = data.substring(11,13);
			String minuto = data.substring(14,16);
			String horario = hora+":"+minuto;
			return novaData+"-"+horario;
			}
		return novaData;
	}
}
