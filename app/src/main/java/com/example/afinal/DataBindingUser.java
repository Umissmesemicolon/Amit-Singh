package com.example.afinal;

public class DataBindingUser extends FragmentBindData {
    String name;
    private int age;
    private boolean active;
    String  imageurl;

    public DataBindingUser(String name, int age, boolean active, String imageurl) {
        this.name = name;
        this.age = age;
        this.active = active;
        this.imageurl = imageurl;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "DataBindingUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                ", imageurl='" + imageurl + '\'' +
                '}';
    }
}
