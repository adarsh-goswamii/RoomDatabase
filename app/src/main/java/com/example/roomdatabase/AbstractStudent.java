package com.example.roomdatabase;

/**
 * We wont always need the whole student entity many times we will be just interested in
 * some particular field lets say name and email. For that we have to first create a class with
 * the required field and then a method in studentdao.
 */
public class AbstractStudent {
    private String name, email;

    public AbstractStudent(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
