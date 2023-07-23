package com.bridgelabzMySqlDatabase.MySqlDatabase.Model;

import com.bridgelabzMySqlDatabase.MySqlDatabase.DTO.MessageDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TableInfo")
@Data    //Instead of @Getter and @Setter
@NoArgsConstructor      // Instead of Default Constructor

public class Message {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    private LocalDate DueDate;

    private boolean completed;


    public Message(MessageDTO messageDTO) {
        this.updateMessage(messageDTO);
    }

    public void updateMessage(MessageDTO messageDTO) {
        this.title = messageDTO.title;
        this.description = messageDTO.description;
        this.DueDate = messageDTO.DueDate;
        this.completed = messageDTO.completed;
    }

}
