package org.example;


import org.example.model.Person;
import org.example.repository.PersonRepoImpl;

public class App {
    public static void main(String[] args) throws Exception {

        Person person = new Person("Lumberman", 17);
        Person person2 = new Person("Kurt", 1);
        Person person3 = new Person("Kuk", 7);


        PersonRepoImpl persons = new PersonRepoImpl();
        persons.deleteById(2L);
    }
}