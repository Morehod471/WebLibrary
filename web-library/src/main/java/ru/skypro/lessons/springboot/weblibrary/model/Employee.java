package ru.skypro.lessons.springboot.weblibrary.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int salary;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;

    public Employee() {
    }

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee(Integer id, String name, int salary, Position position) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
