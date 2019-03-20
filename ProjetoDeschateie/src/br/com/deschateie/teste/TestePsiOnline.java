package br.com.deschateie.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.deschateie.beans.PsiOnline;
import br.com.deschateie.bo.PsiOnlineBO;
import br.com.deschateie.dao.PsiOnlineDAO;
import br.com.deschateie.excecao.Excecao;

public class TestePsiOnline {

	public static void main(String[] args) {

		try {
	//		System.out.println(PsiOnlineBO.pesquisarPsicologoOnline(11).getAll());
			
			
//			System.out.println(PsiOnlineBO.novoPsicologoOnline
//					(new PsiOnline(855, "Emanuel",
//					"manubolao@man1221u.com.br","01/01/2012",
//					"manuBola2123o", "manuu", 2,"c:", "masculino",
//					1298234, "psicologia","ahahahahah",
//					11976311305l, 395.89, "manha", "Video",
//					3, 45)));
			
			
			//VERIFICAR ESSE EXLUIR
		//	System.out.println(PsiOnlineBO.excluirPsicologoOnline(855));
			
			List<PsiOnline> lista = new ArrayList<PsiOnline>();
			
			PsiOnlineDAO dao = new PsiOnlineDAO();
			lista = PsiOnlineBO.pesquisarPsicologosOnlineTemporario();
			
			for (PsiOnline psiOnline : lista) {
				System.out.println(psiOnline.getAll());
			}
					
//			System.out.println(PsiOnlineBO.AlterarDadosPsicologo(new PsiOnline(855, "Emanuel",
//					"manubolao@man1221u.com.br","01/01/2000",
//					"manuBola2123o", "manuu", 2,"c:", "outro",
//					1298234, "psiquiatra","testestestestes",
//					11976311305l, 250.22, "manhã, tarde e noite", "texto",
//					3, 45)));
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
