package org.example.project.api.projeto;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.example.project.api.funcionario.FuncionarioResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Path("project")
public class ProjetoResource {
    private static ProjetoRepository projRepository = new ProjetoRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid ProjetoRequest request){
        if(request.data_inicio.isBefore(request.data_fim) || request.data_inicio.isAfter(LocalDate.now()))
            return Response.status(Status.EXPECTATION_FAILED).build();

        Projeto projeto = new Projeto(request.titulo, request.data_inicio, request.data_fim, request.id_departamento);
        projRepository.create(projeto);

        return Response.status(Status.CREATED).entity(new ProjetoResponse(projeto)).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index(){
        List<ProjetoResponse> projList = projRepository.getAll().stream()
                .map(proj -> new ProjetoResponse(proj)).collect(Collectors.toList());

        return Response.status(Status.OK).entity(projList).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") int id){
        Projeto proj = projRepository.getProjetoById(id);
        if (proj == null)
            return Response.status(Status.NOT_FOUND).build();

        return Response.status(Status.OK).entity(new ProjetoResponse(proj)).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id,@Valid ProjetoRequest request){
        Projeto proj = projRepository.getProjetoById(id);
        if (proj == null)
            return Response.status(Status.NOT_FOUND).build();

        Projeto newProj = new Projeto(id, request.titulo, request.data_inicio, request.data_fim, request.id_departamento );
        projRepository.update(newProj);

        return Response.status(Status.OK).entity(new ProjetoResponse(newProj)).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id){
        Projeto proj = projRepository.getProjetoById(id);
        if (proj == null)
            return Response.status(Status.NOT_FOUND).build();

        projRepository.delete(proj);

        return Response.status(Status.NO_CONTENT).build();
    }


}
