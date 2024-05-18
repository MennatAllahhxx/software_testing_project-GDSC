package com.fakeshop.pojo;

/**
 * The type Login pojo.
 */
public class LoginPojo {
    private String username;
    private String password;

    /**
     * Instantiates a new Login pojo.
     *
     * @param username the username
     * @param password the password
     */
    public LoginPojo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
