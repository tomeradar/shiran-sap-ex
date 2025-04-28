package classes;

import enums.UserType;

public class User {
    private Long id;
    private String name;
    private String email;
    private UserType userType;

    public User(Long id, String name, String email, UserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public UserType getUserType() { return userType; }
}