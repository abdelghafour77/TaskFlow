package com.example.taskflow.repositories;

import com.example.taskflow.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.assignedTo.email = ?1")
    public List<Task> findAllByEmail(String email);

    public boolean existsByName(String name);

}
