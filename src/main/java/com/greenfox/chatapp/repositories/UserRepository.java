package com.greenfox.chatapp.repositories;
import com.greenfox.chatapp.model.Userka;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Userka, Integer>{

}
