package br.com.fiap.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.dao.impl.PacienteDAOImpl;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Paciente;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class ConsultaPacienteTeste {

	private static PacienteDAO dao;

	@BeforeAll
	public static void iniciar() {
		dao = new PacienteDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}

	@Test
	void testeLista() {
		List<Paciente> pacientes = dao.listar();
		
		for (Paciente paciente : pacientes) {
			System.out.println("===>PACIENTE COD: " + paciente.getCodigo());
			System.out.println("===>PACIENTE NAME: " +paciente.getNome());
		}
		
		assertEquals("", pacientes);
	}

	@Test
	void cadastrar() {
		try {
			dao.cadastrar(new Paciente("TESTE", Calendar.getInstance(), Genero.MASCULINO));
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Paciente pa1 = null;
		try {
			pa1 = dao.buscar(4);
		} catch (CodigoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("=====> PACIENTE: " + pa1.getCodigo());
		System.out.println("=====> NOME: " + pa1.getNome());
		
		assertNotNull(pa1);
	}
	
}
