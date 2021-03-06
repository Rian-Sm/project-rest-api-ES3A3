package org.example.project.api.departamento;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.List;
import java.util.stream.Collectors;

@Path("department")
public class DepartamentoResource {

    private static DepartamentoRepository depRepository = new DepartamentoRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(DepartamentoRequest request){
        Departamento dep = new Departamento(request.nome, request.sigla);
        depRepository.save(dep);

        return Response.status(Status.CREATED)
                .entity(new DepartamentoResponse(dep))
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index () {
        List<DepartamentoResponse> depResponses = depRepository.getAll()
                .stream().map(dep -> new DepartamentoResponse(dep))
                .collect(Collectors.toList());

        return Response.status(Status.OK)
                .entity(depResponses)
                .build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") int id){
        Departamento dep = depRepository.getDepartamentoByid(id);
        if (dep == null){
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.status(Status.OK).entity(new DepartamentoResponse(dep)).build();
    }

}
