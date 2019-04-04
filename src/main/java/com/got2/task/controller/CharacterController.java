package com.got2.task.controller;


import com.got2.task.entity.Characterrr;
import com.got2.task.service.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@RestController
@EnableAutoConfiguration
@RequestMapping("/")
public class CharacterController {

    private final Logger log = LoggerFactory.getLogger(CharacterController.class);

    @Autowired
    CharacterService characterService;



    /**
     * GET /characters - Get all characters
     *
     * @return return all characters
     */
    @GetMapping(path = "/characters")
    public List<Characterrr> getAllCharacter() {
        return characterService.getAllCharacter();
    }


    /**
     * POST  /character : Create a new character.
     *
     * @param characterrr the Characterrr to create
     */
    @PostMapping("/characters")
    public ResponseEntity<Characterrr> createCharacterrr(Characterrr characterrr) throws URISyntaxException {
        if (characterrr.getId() != null) {
            log.error("characterrr id should be null");
        }
        Characterrr result = characterService.save(characterrr); // створити сейв в снервісі
        return ResponseEntity
                .created(new URI("/characters" + result.getId()))
                .body(result);
    }


    /**
     * GET  /character/id : get the "id" character.
     *
     * @return the ResponseEntity with status 200 (OK) and with body , or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public Characterrr CharacterrrById(@PathVariable Integer id) {
        return characterService.getCharacterrrById(id);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCharacter(@PathVariable Integer id) {

        characterService.deleteCharacterrr(id);
        return new ResponseEntity(HttpStatus.OK);
    }




    @GetMapping(value = "/character/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Characterrr> getCharacterById(@PathVariable Integer id) {
        log.info("Fetching character with id of " + id);
        return ResponseEntity.ok().body(characterService.getCharacterrrById(id));
    }


}
