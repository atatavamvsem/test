package by.gubko.sample.domain;

public class User {
    private String id;

    private final String userName;

    private String firstName;
    private String lastName;

    public User(String userName) {
        this.userName = userName;
    }
}
