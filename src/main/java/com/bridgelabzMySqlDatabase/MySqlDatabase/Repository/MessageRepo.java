package com.bridgelabzMySqlDatabase.MySqlDatabase.Repository;

import com.bridgelabzMySqlDatabase.MySqlDatabase.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo  extends JpaRepository<Message,Integer> {
}
