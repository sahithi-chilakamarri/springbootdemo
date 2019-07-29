package com.stackroute.repository;

import com.stackroute.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//Extending jpa repository to handle all database operationns
public interface MuzixRepository extends JpaRepository<Muzix,Integer> {
    //This is used to get the tracks by only giving the name
    @Query("SELECT t FROM Track t WHERE name = ?1")
    //Method is implemented in the service
    List<Muzix> getTrackByName(String name);

}
