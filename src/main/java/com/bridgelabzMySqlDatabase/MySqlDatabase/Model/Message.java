package com.bridgelabzMySqlDatabase.MySqlDatabase.Model;

import com.bridgelabzMySqlDatabase.MySqlDatabase.DTO.MessageDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "TableInfo")
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    private LocalDate DueDate;

    private boolean completed;

    public Message() {

    }

    public Message(MessageDTO messageDTO) {
        this.updateMessage(messageDTO);
    }

    public void updateMessage(MessageDTO messageDTO) {
        this.title = messageDTO.title;
        this.description = messageDTO.description;
        this.DueDate= messageDTO.DueDate;
        this.completed= messageDTO.completed;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return DueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        DueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

