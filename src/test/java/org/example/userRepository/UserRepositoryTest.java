package org.example.userRepository;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserRepositoryTest {
    List<User> expected = new ArrayList<>();
    List<User> actual = new ArrayList<>();

    String gender = "male";

    @Test
    public void shouldAddOneUser() {
        User user = new User(0, "Vasya", 33, "male");
        UserRepository.getAllUsers().clear();
        UserRepository.addUser(user);
        expected.add(user);
        actual = UserRepository.getAllUsers();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddAllUsers() {
        User user0 = new User(0, "Vasya", 33, "male");
        User user1 = new User(1, "Lena", 21, "female");
        User user2 = new User(2, "Petya", 48, "male");
        User user3 = new User(3, "Lisa", 19, "female");
        UserRepository.getAllUsers().clear();
        UserRepository.addAllUsers(List.of(user0, user1, user2, user3));
        expected.addAll(List.of(user0, user1, user2, user3));
        actual = UserRepository.getAllUsers();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetAllUsers() {
        User user0 = new User(0, "Vasya", 33, "male");
        User user1 = new User(1, "Lena", 21, "female");
        User user2 = new User(2, "Petya", 48, "male");
        User user3 = new User(3, "Lisa", 19, "female");
        UserRepository.getAllUsers().clear();
        UserRepository.addAllUsers(List.of(user0, user1, user2, user3));
        expected.addAll(List.of(user0, user1, user2, user3));
        actual = UserRepository.getAllUsers();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetAllUsersByGender() {
        User user0 = new User(0, "Vasya", 33, "male");
        User user1 = new User(1, "Lena", 21, "female");
        User user2 = new User(2, "Petya", 48, "male");
        User user3 = new User(3, "Lisa", 19, "female");
        UserRepository.getAllUsers().clear();
        UserRepository.addAllUsers(List.of(user0, user1, user2, user3));
        expected.addAll(List.of(user0, user2, user1, user3));
        actual = UserRepository.getAllUsersByGender(gender);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetHowManyUsers() {
        User user0 = new User(0, "Vasya", 33, "male");
        User user1 = new User(1, "Lena", 21, "female");
        User user2 = new User(2, "Petya", 48, "male");
        UserRepository.getAllUsers().clear();
        UserRepository.addAllUsers(List.of(user0, user1, user2));
        int actualSize = UserRepository.getHowManyUsers();

        assertEquals(3, actualSize);
    }

    @Test
    public void shouldGetHowManyUsersByGender() {
        User user0 = new User(0, "Vasya", 33, "male");
        User user1 = new User(1, "Lena", 21, "female");
        User user2 = new User(2, "Petya", 48, "male");
        UserRepository.getAllUsers().clear();
        UserRepository.addAllUsers(List.of(user0, user1, user2));
        int actualSize = UserRepository.getHowManyUsersByGender(gender);

        assertEquals(2, actualSize);
    }

    @Test
    public void shouldGetAllAgeUsers() {
        User user0 = new User(0, "Vasya", 33, "male");
        User user1 = new User(1, "Lena", 21, "female");
        User user2 = new User(2, "Petya", 48, "male");
        UserRepository.getAllUsers().clear();
        UserRepository.addAllUsers(List.of(user0, user1, user2));
        int actualAge = UserRepository.getAllAgeUsers();

        assertEquals(102, actualAge);
    }

    @Test
    public void shouldGetAllAgeUsersByGender() {
        User user0 = new User(0, "Vasya", 33, "male");
        User user1 = new User(1, "Lena", 21, "female");
        UserRepository.getAllUsers().clear();
        UserRepository.addAllUsers(List.of(user0, user1));
        int actualAge = UserRepository.getAllAgeUsersByGender(gender);

        assertEquals(33, actualAge);
    }

    @Test
    public void shouldGetAverageAgeOfAllUsers() {
        User user0 = new User(0, "Vasya", 33, "male");
        User user1 = new User(1, "Lena", 21, "female");
        UserRepository.getAllUsers().clear();
        UserRepository.addAllUsers(List.of(user0, user1));
        double actualAge = UserRepository.getAverageAgeOfAllUsers();

        assertEquals(27.0, actualAge, 0);
    }

    @Test
    public void shouldGetAverageAgeOfAllUsersByGender() {
        User user0 = new User(0, "Vasya", 33, "male");
        User user1 = new User(1, "Lena", 21, "female");
        User user2 = new User(2, "Petya", 48, "male");
        User user3 = new User(3, "Lisa", 19, "female");
        UserRepository.getAllUsers().clear();
        UserRepository.addAllUsers(List.of(user0, user1, user2, user3));
        double actualAge = UserRepository.getAverageAgeOfAllUsersByGender(gender);

        assertEquals(40.5, actualAge, 0);
    }
}
