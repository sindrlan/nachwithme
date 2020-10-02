package nachwithme.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User implements NachObserver {
    private String name;
    private String email;
    private int age;
    private String address;
    private List<User> friends;
    private List<Nach> naches;

    /*
    @args: name, email and address as strings, and the age of the user as an int.
    The constructor of the User class initializes the object.
    We have not added any validation or encapsulation yet.
     */
    public User(String name, String email, String address, int age) {
        super();
        this.setName(name);
        this.setAge(age);
        this.setEmail(email);
        this.setAddress(address);
        this.friends = new ArrayList<>();
        this.naches = new ArrayList<>();
    }

    public User() {
        this.friends = new ArrayList<>();
        this.naches = new ArrayList<>();
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public void createNach(String time) {
        this.naches.add(new Nach(this, this.address, time));
    }

    // Hva gjør denne? Er det for å legge til i lista bare??
    // Ja.
    public void createNach() {
        this.naches.add(new Nach(this));
    }

    public void addNachToUserList(Nach nach) {
        naches.add(nach);
    }

    public void createNach(String address, String time) {
        this.naches.add(new Nach(this, address, LocalDateTime.now().toString()));
    }

    public List<Nach> getNaches() {
        return this.naches;
    }

    public String getEmail() {
        return this.email;
    }

    public int getAge() {
        return this.age;
    }

    public void addNachToUser(final Nach nach) {
        this.naches.add(nach);
    }

    public String getAddress() {
        return this.address;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void update(final ObservableNach nach) {
        Nach nachToUpdate = (Nach) nach;
        System.out.println("I'm going to the nach at " + nachToUpdate.getAddress());
    }

    @Override
    public String toString() {
        return name + " " + age + ", " + address;
    }

    public static void main(String[] args) {
//        User me = new User("Sigbjørn Berdal", "sigbjoern.berdal14@gmail.com", "home", 21);
//        Nach nach = new Nach(me);
//        System.out.println(nach);
        String line = "        String clock = DateTimeFormatter.ofPattern(\"HH:mm\").format(LocalDateTime.now());";
        System.out.println(line.length());
    }
}
