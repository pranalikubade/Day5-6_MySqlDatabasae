package com.bridgelabzMySqlDatabase.MySqlDatabase.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class MessageDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-z,A-Z, ]{2,}$",message = "Title pattern Mismatch")
    @NotEmpty(message = "Title can not be Empty")
    public String title;

    @NotEmpty(message = "Description can not be Empty")
    public String description;
    public LocalDate DueDate;

    public boolean completed;





}
