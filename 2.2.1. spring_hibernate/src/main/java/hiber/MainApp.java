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
        userService.add(new User("Ivan", "Petrov", "ivan@mail.ru"), new Car("paz", 152));
        userService.add(new User("Petr", "Ivanov", "petr2@mail.ru"), new Car("zaz", 114));
        userService.add(new User("Ilya", "Kotov", "ilya@mail.ru"), new Car("uaz", 177));
        userService.add(new User("Oleg", "Nilov", "oleg@mail.ru"), new Car("vaz", 136));
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Idcars = " + user.getUsercar());
            System.out.println();
        }
        System.out.println(userService.carUser("zaz", 114));
        context.close();
    }
}
