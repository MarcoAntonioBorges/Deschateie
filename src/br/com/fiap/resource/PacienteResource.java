package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.dao.impl.PacienteDAOImpl;
import br.com.fiap.entity.Paciente;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/paciente")
public class PacienteResource {

	public PacienteDAO dao;
	
	public PacienteResource() {
		dao = new PacienteDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Paciente> listar() {
		return dao.listar();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Paciente bucarPorCodigo(@PathParam("codigo") int codigo) {
		try {
			return dao.buscar(codigo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Paciente paciente, @Context UriInfo info) {
		UriBuilder builder = info.getAbsolutePathBuilder();
		builder.path(Integer.toString(paciente.getCodigo()));
		try {
			dao.cadastrar(paciente);
			dao.commit();
			return Response.created(builder.build()).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.TEXT_PLAIN)
	public String remover(@PathParam("codigo") int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
			return "Removido com sucesso!";
		} catch (CodigoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Ocorreu um erro ao tentar remover!";
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Ocorreu um erro ao tentar remover!";
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{codigo}")
	public Response atualizar(@PathParam("codigo") int codigo, Paciente paciente) {
		try {
			paciente.setCodigo(codigo);
			dao.alterar(paciente);
			dao.commit();
			return Response.ok().build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
}
