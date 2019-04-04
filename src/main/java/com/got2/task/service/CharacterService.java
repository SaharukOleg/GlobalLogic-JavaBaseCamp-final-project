package com.got2.task.service;

import com.got2.task.entity.Book;
import com.got2.task.entity.Characterrr;
import com.got2.task.network.NetworkDataSource;
import com.got2.task.repository.CharacterRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private final Logger log = LoggerFactory.getLogger(CharacterService.class);


    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    NetworkDataSource networkDataSource;

    /**
     * @return
     */
    public List<Characterrr> getAllCharacter() {
        return characterRepository.findAll();
    }

    /**
     * @param characterrr
     * @return
     */
    public Characterrr save(Characterrr characterrr) {
        log.debug("Request to save Character : {}");
        return characterRepository.save(characterrr);
    }


    /**
     * Get one characterrr by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    public Characterrr getCharacterrrById(Integer id) {

        log.debug("Request to GetById Character : {}", id);

        Characterrr characterById = networkDataSource.getCharacterById(id);

        return characterRepository.save(characterById);
    }


    /**
     * Delete the characterrr by id.
     *
     * @param id the id of the entity
     */
    public void deleteCharacterrr(Integer id) {
        log.debug("Request to delete Character : {}", id);
        characterRepository.deleteById(id);
    }

}