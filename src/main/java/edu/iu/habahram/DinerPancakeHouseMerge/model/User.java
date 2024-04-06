package edu.iu.habahram.DinerPancakeHouseMerge.model;

public class User {
    public String username;
    public String email;
    public String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Username: " + username + ", Email: " + email + ", Password: " + password;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User user)) {
            return false;
        }
        return user.username.equals(username) && user.email.equals(email) && user.password.equals(password);
    }
}
