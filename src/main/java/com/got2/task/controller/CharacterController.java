package com.got2.task.controller;


import com.got2.task.entity.Characterrr;
import com.got2.task.exceptions.NoSuchCharacterException;
import com.got2.task.service.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

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
     * GET  /character/id : get the "id" character. імпортуе героя за зовнішньою айпішкою і сейває в БД і повертає вже збереженого в БД героя
     *
     * @return the ResponseEntity with status 200 (OK) and with body , or with status 404 (Not Found)
     */
    @PostMapping("/outside/{outerId}")
    public Characterrr importCharacterrrByOuterId(@PathVariable Integer outerId) {
        return characterService.importCharacterrrByOuterId(outerId);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCharacter(@PathVariable Integer id) {

        characterService.deleteCharacterrr(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    /**
     * GET  /character/{id}  витягує героя з БД
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/character/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Characterrr> getCharacterById(@PathVariable Integer id) {
        log.info("Fetching character with id of " + id);
        return ResponseEntity.ok().body(characterService.getCharacterrrById(id));
    }

    /**
     * GET  /character/randomfellow  витягує героя з БД
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/character/randomFellow/{id}", produces = APPLICATION_JSON_VALUE)
    @ExceptionHandler({NoSuchCharacterException.class})
    public ResponseEntity<Set<Characterrr>> getRandomFellowById(@PathVariable Integer id) {
        log.info("Fetching character with id of " + id);
        try {
            return ResponseEntity.ok().body(characterService.getCharacterFriendsFromSameBook(id));
        } catch (NoSuchCharacterException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        }
    }


}
