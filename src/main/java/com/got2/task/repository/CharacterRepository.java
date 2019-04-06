package com.got2.task.repository;

import com.got2.task.entity.Characterrr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CharacterRepository extends JpaRepository<Characterrr, Integer> {

//    Page<Characterrr> findByName(@Param("name") String name, Pageable pageable);
//
//    Page<Characterrr> findById(@Param("id") Integer id, Pageable pageable);

    Page<Characterrr> findAll(Pageable pageable);


}
