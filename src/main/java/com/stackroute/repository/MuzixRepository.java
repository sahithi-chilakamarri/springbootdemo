package com.stackroute.repository;

import com.stackroute.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repository which extends the Jpa Repository
@Repository
public interface MuzixRepository extends JpaRepository<Muzix,Integer> {
    //Query annotation for retrieving data
    @Query(value = "select m from Muzix m where m.name=?1")
    public List<Muzix> trackByName(String name);
}
