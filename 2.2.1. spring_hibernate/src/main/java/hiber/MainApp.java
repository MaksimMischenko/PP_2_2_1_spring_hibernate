package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.addUser(new User("User1", "Lastname1", "user1@mail.ru",
                new Car("LADA", 2110)));
        userService.addUser(new User("User2", "Lastname2", "user2@mail.ru",
                new Car("Audi", 6)));
        userService.addUser(new User("User3", "Lastname3", "user3@mail.ru",
                new Car("BMW", 5)));
        userService.addUser(new User("User4", "Lastname4", "user4@mail.ru",
                new Car("Mazda", 3)));

        List<User> users = userService.getFromUsers();
        for (User user1 : users) {
            System.out.println("Id = " + user1.getId());
            System.out.println("First Name = " + user1.getFirstName());
            System.out.println("Last Name = " + user1.getLastName());
            System.out.println("Email = " + user1.getEmail());
            System.out.println("model= " + user1.getCar());
            System.out.println();
        }
        context.close();
    }
}
