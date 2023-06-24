package com.example.app2;

public class User {
    public String status;
    public UserData data;
    public String message;

    public class UserData{
        public String name;
        public int age;
        public int id;

        public UserData(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getId() {
            return id;
        }
    }

    public String getStatus() {
        return status;
    }

    public UserData getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
