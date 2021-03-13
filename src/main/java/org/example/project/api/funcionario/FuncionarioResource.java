package org.example.project.api.funcionario;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.List;
import java.util.stream.Collectors;

@Path("employee")
public class FuncionarioResource {

    private static FuncionarioRepository funcRepository = new FuncionarioRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Create(@Valid  FuncionarioRequest request) {
        Funcionario funcionario = new Funcionario(request.CPF, request.nome, request.email, request.id_departamento);
        if (funcRepository.cpfEqual(funcionario) == true){
            return Response.status(Status.CONFLICT).build();
        }
        funcRepository.save(funcionario);

        return Response.status(Status.CREATED)
                .entity(new FuncionarioResponse(funcionario))
                .build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index() {
        List<FuncionarioResponse> funcList = funcRepository.getAll()
                .stream().map(func -> new FuncionarioResponse(func))
                .collect(Collectors.toList());
        return Response.status(Status.OK).entity(funcList).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") int id){
        Funcionario func = funcRepository.getFuncionarioById(id);
        if (func == null){
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.status(Status.OK).entity(new FuncionarioResponse(func)).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id,@Valid FuncionarioRequest request){
        Funcionario func = funcRepository.getFuncionarioById(id);
        if (func == null){
            return Response.status(Status.NOT_FOUND).build();
        }

        Funcionario newFunc = new Funcionario(id, request.CPF, request.nome, request.email, request.id_departamento);
        funcRepository.update(newFunc);

        return Response.status(Status.OK)
                .entity(new FuncionarioResponse(newFunc))
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id){
        Funcionario func = funcRepository.getFuncionarioById(id);
        if (func == null){
            return Response.status(Status.NOT_FOUND).build();
        }
        funcRepository.delete(func);
        return Response.status(Status.NO_CONTENT).build();
    }
}
