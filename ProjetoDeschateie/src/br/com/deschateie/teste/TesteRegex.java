package br.com.deschateie.teste;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TesteRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub public static void main(String[] args) {

        String data = "12/01/1997";
        Pattern pattern = Pattern.compile("(\\d{2})(/)(\\d{2})(/)(\\d{4})");
        Matcher matcher = pattern.matcher(data);

        if (matcher.matches()) {

            String dia = matcher.group(1);
            String mes = matcher.group(3);
            String ano = matcher.group(5);

            String separador1 = matcher.group(2);
            String separador2 = matcher.group(4);

            System.out.println(dia + mes + ano);
        }
    

	}

}
