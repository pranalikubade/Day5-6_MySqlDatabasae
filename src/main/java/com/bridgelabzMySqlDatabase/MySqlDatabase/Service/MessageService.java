package com.bridgelabzMySqlDatabase.MySqlDatabase.Service;

import com.bridgelabzMySqlDatabase.MySqlDatabase.DTO.MessageDTO;
import com.bridgelabzMySqlDatabase.MySqlDatabase.Exception.CustomException;
import com.bridgelabzMySqlDatabase.MySqlDatabase.Model.Message;
import com.bridgelabzMySqlDatabase.MySqlDatabase.Repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    public Message addMessage(MessageDTO messageDTO) {
        Message messageData =new Message(messageDTO);
        return messageRepo.save(messageData);
    }

    public Message getById(long id) {
        return messageRepo.findById((int) id).orElseThrow(() -> new CustomException("Message With Id:"+id + " Not Present"));
    }

    public Message updateMessage(long id, MessageDTO messageDTO) {
        Message messageData = getById(id);
        if (messageData != null){
            messageData.updateMessage(messageDTO);
            return messageRepo.save(messageData);
        }
        return null;
    }

    public List<Message> findAll() {
        return messageRepo.findAll();
    }

    public boolean deleteMessage(long id) {
        // Check if the message exists
        if (messageRepo.existsById((int) id)) {
            messageRepo.deleteById((int) id);
            return true; // Deletion successful
        }
        return false; // Message not found
    }

}
