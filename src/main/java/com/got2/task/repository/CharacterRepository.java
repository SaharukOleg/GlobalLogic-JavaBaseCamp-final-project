package com.got2.task.repository;

import com.got2.task.entity.Characterrr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Characterrr, Integer> {

}
