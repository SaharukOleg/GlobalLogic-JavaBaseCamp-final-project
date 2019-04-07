package com.got2.task.repository;

import com.got2.task.entity.Characterrr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CharacterRepository extends JpaRepository<Characterrr, Integer> {
    Characterrr findCharacterrrByName(@Param("name") String name);
//
//    Page<Characterrr> findById(@Param("id") Integer id, Pageable pageable);

    List<Characterrr> findAllOrderByName(Pageable pageable);

    Page<Characterrr> findAll(Pageable pageable);


}
