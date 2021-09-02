package myapp.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table (name="tasks")
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="task_id")
    private int taskId;

    @Column(name="description")
    private String taskDescription;

    @ManyToMany (cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinTable (name="positions_tasks", joinColumns = @JoinColumn(name="task_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id"))
    private Set<Position> positionsSet;


    public Task () {
    }

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void addPosition (Position position) {
        if (positionsSet == null) {
            Set<Position> positionSet  = new LinkedHashSet<>();
        } else positionsSet.add(position);
    }

    public void removePosition (Position position) {
        if (positionsSet == null) {
            Set<Position> positionSet  = new LinkedHashSet<>();
        } else positionsSet.remove(position);
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Set<Position> getPositionsSet() {
        return positionsSet;
    }

    @Override
    public String toString() {
        return taskDescription;
    }
}



