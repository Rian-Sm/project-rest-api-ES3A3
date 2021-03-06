package org.example.project.api.users;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public User save(User user){
        this.users.add(user);
        return user;
    }

    public List<User> getAll(){
        return users;
    }

    public User getById(int id){
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public User update(User user){
        User userFound = getById(user.getId());
        int index = users.indexOf(userFound);
        users.set(index, user);

        return user;
    }

    public void delete(User user){
        users.remove(user);
    }



}
