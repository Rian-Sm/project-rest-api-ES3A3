package org.example.project.api.users;

public class UserResponse {
    public int id;
    public String nome;
    public String email;

    public UserResponse(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public UserResponse(User user){
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
    }
}
