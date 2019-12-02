package com.example.wsdemo2.repository.user;

import com.example.wsdemo2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true, value="SELECT * FROM USER WHERE USER_ID = :user_id")
    List<User> getCustom(@Param("user_id") String userId);
}
