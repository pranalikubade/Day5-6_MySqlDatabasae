package com.bridgelabzMySqlDatabase.MySqlDatabase.Controller;

import com.bridgelabzMySqlDatabase.MySqlDatabase.DTO.MessageDTO;
import com.bridgelabzMySqlDatabase.MySqlDatabase.DTO.ResponseDTO;
import com.bridgelabzMySqlDatabase.MySqlDatabase.Repository.MessageRepo;
import com.bridgelabzMySqlDatabase.MySqlDatabase.Service.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class MessageController {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private MessageService messageService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addMessage(@Valid @RequestBody MessageDTO messageDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Data Added Successfully", messageService.addMessage(messageDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


    @GetMapping("/GetAll")
    public ResponseEntity<ResponseDTO> getAllMessage() {
        ResponseDTO responseDTO = new ResponseDTO(" All Data Retrieve Successfully", messageService.findAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/getbyId/{id}")
    public ResponseEntity<ResponseDTO> getbyid(@PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO("Data Fetched Successfully", messageService.getById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateMessage(@PathVariable long id, @RequestBody MessageDTO messageDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Data Updated Successfully", messageService.updateMessage(id, messageDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @DeleteMapping("/DeleteById/{id}")
    public ResponseEntity<ResponseDTO> deleteMessage(@PathVariable long id) {
        boolean deleted = messageService.deleteMessage(id);
        if (deleted) {
            ResponseDTO responseDTO = new ResponseDTO("Data Deleted Successfully", null);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            ResponseDTO responseDTO = new ResponseDTO("Data Not Found", null);
            return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
        }
    }
}
