package org.example.repository;

import org.example.configuration.DatabaseConnection;
import org.example.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepoImpl implements PersonRepository {

    private final Connection connection;

    public PersonRepoImpl() throws Exception {
        connection = new DatabaseConnection().getConnection();
    }

    @Override
    public void createTable() throws SQLException {
        String queryToCreate = """
                create table if not exists person(
                id serial primary key,
                name varchar(55)  not null,
                age smallint
                );
                """;
        Statement statement = connection.createStatement();
        statement.execute(queryToCreate);
        statement.close();
        System.out.println("table person created!!!");

    }

    @Override
    public void save(Person person) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into person(name, age) values (?,?)");
        ps.setString(1, person.getName());
        ps.setInt(2, person.getAge());
        ps.execute();
        ps.close();
        System.out.println("Go miro bowo");
    }

    @Override
    public List<Person> findAll() throws SQLException {
        List<Person> allPerson = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery("select name from person order by age asc ");
        while (result.next()) {
            Person person = new Person();
            person.setId(result.getLong("id"));
            person.setName(result.getString("name"));
            person.setAge(result.getInt("age"));
            allPerson.add(person);
        }
        return allPerson;
    }

    @Override
    public Person getById(Long id) throws SQLException {
        PreparedStatement person = connection.prepareStatement("select * from person where id = " + id + ";");
        ResultSet result = person.executeQuery();
        while (!result.next()) {
            System.out.println("siuuu");
        }
        Person person11 = new Person();
        person11.setId(result.getLong("id"));
        person11.setName(result.getString("name"));
        person11.setAge(result.getInt("age"));
        return person11;
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("delete from person where id = " + id + ";");
        ps.executeUpdate();
        System.out.println("user with id: " + id + " successfully deleted");
    }

    @Override
    public void deleteAll() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("truncate table person");
        System.out.println("something has deleted");
    }

    @Override
    public void update(Long id, Person newPerson) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("update person set name = ?,age = ? where id = " + id + ";");
        ps.setString(1, newPerson.getName());
        ps.setInt(2, newPerson.getAge());
        ps.executeUpdate();
        System.out.println("siuuuuuu");
    }
}