package com.example.recyclesql;

public class modelClass {
    String name,contacts,email;

    public modelClass(String name,String contacts,String email) {
        this.name=name;
        this.contacts=contacts;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
