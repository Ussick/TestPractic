package org.example.userRepository;

import java.util.*;
import java.util.stream.Collectors;

public class UserRepository {
    private static List<User> listUsers = new ArrayList<>();


    public static List<User> addUser(User user) {
        listUsers.add(user);
        return listUsers;
    }

    public static List<User> addAllUsers(List<User> userList) {
        listUsers.addAll(userList);
        Set<User> userSet = new HashSet<>(listUsers);
        listUsers.clear();
        listUsers.addAll(userSet);
        listUsers.sort(Comparator.comparingInt(User::getId));
        return listUsers;
    }

    public static List<User> getAllUsers() {
        return listUsers;
    }

    public static List<User> getAllUsersByGender(String gender) {
        if (gender.equals("male")) {
            listUsers = getAllUsers().stream()
                    .sorted(Comparator.comparing(User::getGender)
                            .reversed()).collect(Collectors.toList());
        } else {
            listUsers = getAllUsers().stream()
                    .sorted(Comparator.comparing(User::getGender))
                    .collect(Collectors.toList());
        }
        return listUsers;
    }

    public static int getHowManyUsers() {
        return listUsers.size();
    }

    public static int getHowManyUsersByGender(String gender) {
        return getAllUsers().stream()
                .filter(user -> user.getGender().equals(gender))
                .collect(Collectors.toList()).size();
    }

    public static int getAllAgeUsers() {
        return getAllUsers().stream().mapToInt(user -> user.getAge()).sum();
    }

    public static int getAllAgeUsersByGender(String gender) {
        return getAllUsers().stream().filter(user -> user.getGender().equals(gender)).
                mapToInt(user -> user.getAge()).sum();
    }

    public static double getAverageAgeOfAllUsers() {
        return getAllUsers().stream().mapToInt(user -> user.getAge()).summaryStatistics().getAverage();
    }

    public static double getAverageAgeOfAllUsersByGender(String gender) {
        return getAllUsers().stream().filter(user -> user.getGender().equals(gender)).
                mapToInt(user -> user.getAge()).summaryStatistics().getAverage();
    }
}
