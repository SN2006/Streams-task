package app.model;

import app.entity.User;

import java.util.Arrays;
import java.util.List;

public class AppModel {

    public List<User> getData(){
        return Arrays.asList(
                new User("Tom", "tom123@mail.com"),
                new User("Alina", "lina_alina@gmail.com"),
                new User("Nick", "n123k@gmail.com"),
                new User("Peter", "petcool@mail.com"),
                new User("John", "jo123@gmail.com")
        );
    }

}
