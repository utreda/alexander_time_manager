package com.adaming.project.alexander_time_manager;

import com.adaming.project.alexander_time_manager.model.Mount;
import com.adaming.project.alexander_time_manager.model.User;
import com.adaming.project.alexander_time_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AlexanderTimeManagerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AlexanderTimeManagerApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Jurick Yllondeil");
        User user2 = new User("Sjendo Pendragon");
        User user3 = new User("Kurtys Lunae");
        List<User> users = new ArrayList<>(Arrays.asList(user1, user2, user3));
        for (User user : users) {
            this.userService.register(user);
        }
    }
}
