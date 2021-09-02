package myapp.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table (name = "positions")
public class Position {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column (name="position_id")
private int id;


@Column (name="name")
private String name;
@Column (name="salary")
private int salary;

    @ManyToMany (cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable (name="positions_tasks", joinColumns = @JoinColumn(name="position_id"),
    inverseJoinColumns = @JoinColumn(name = "task_id"))
    private Set<Task> tasksSet;

    public Position() {
    }



    public int getId() {
        return id;
    }

    public Position(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Position(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }


    public void addTask (Task task) {
        if (tasksSet == null) {
            Set <Task> taskSet  = new LinkedHashSet<>();
        } else tasksSet.add(task);
    }

    public void removeTask (Task task) {
        if (tasksSet == null) {
            Set <Task> taskSet  = new LinkedHashSet<>();
        } else tasksSet.remove(task);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Set<Task> getTasksSet() {
        return tasksSet;
    }

    @Override
    public String toString() {
        return "Position:" + name + " Salary:" + salary;
    }
}




