package org.example;


import org.example.model.Person;
import org.example.repository.PersonRepoImpl;

public class App {
    public static void main( String[] args ) throws Exception {

        Person person = new Person( "Kurmanbek",17 );


        PersonRepoImpl persons = new PersonRepoImpl();
        persons.findAll().forEach( System.out::println );

    }
}
