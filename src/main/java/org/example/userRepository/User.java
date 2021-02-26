package org.example.userRepository;

import java.util.Objects;

public class User {
    private int Id;
    private String name;
    private int age;
    private String gender;

    public User() {
    }

    public User(int id, String name, int age, String gender) {
        Id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Id == user.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
