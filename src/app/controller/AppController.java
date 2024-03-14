package app.controller;

import app.entity.User;
import app.model.AppModel;
import app.util.Constants;
import app.view.AppView;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class AppController {

    private final AppModel model = new AppModel();
    private final AppView view = new AppView();

    public void runApp(){
        view.output(handleData());
    }

    public String handleData(){
        Stream<User> userStream = model.getData().stream();
        StringBuilder builder = new StringBuilder(
                "Users whose email has substring '" + Constants.substringToFound + "':\n"
        );
        AtomicInteger counter = new AtomicInteger();
        userStream
                .filter(user -> user.getEmail().contains(Constants.substringToFound))
                .forEach(user -> builder.append(counter.incrementAndGet())
                        .append(") ")
                        .append(user)
                        .append("\n"));
        if (counter.get() == 0)
            return "There are no users whose email has substring '" + Constants.substringToFound + "'";
        return builder.toString();
    }

}
