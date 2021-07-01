package com.foxconn.license.entity;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//for creating EntityManager (delete method requested)
@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, String>{
    //findBy{attribute}
    //List<User> findByusername(String username);
    User findByusername(String username);
    List<User> removeByusername(String username);


    // nativeQuery = true : using PostgreSql Query
    // JPQL not working for unknown reason
    // @Query("select accounts from accounts")
    @Modifying
    @Query(value = "delete from accounts a where a.username=:username", nativeQuery = true)
    void deleteUserByname(@Param("username") String username);


}
