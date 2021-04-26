package com.restfulapi.restful.repository;
import com.restfulapi.restful.entity.User;
import java.util.List;
import com.restfulapi.restful.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
    User findByEmail(String email);
}