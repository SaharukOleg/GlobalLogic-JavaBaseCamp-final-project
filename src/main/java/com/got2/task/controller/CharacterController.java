package com.got2.task.controller;


import com.got2.task.entity.Characterrr;
import com.got2.task.exceptions.NoSuchCharacterException;
import com.got2.task.repository.CharacterRepository;
import com.got2.task.service.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@EnableAutoConfiguration
@RequestMapping("/")
public class CharacterController {

    private final Logger log = LoggerFactory.getLogger(CharacterController.class);

    @Autowired
    CharacterService characterService;

    @Autowired
    CharacterRepository characterRepository;

    /**
     * GET /characters - Get all characters
     *
     * @return return all characters
     */
    @GetMapping("/characters") // if after url use ?page=0&size=2 ,  you can see first two characters
    public Page<Characterrr> getAllCharacter(Pageable pageable) {
        return characterService.getAllCharacter(pageable);
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
    @ResponseBody
    public ResponseEntity<Characterrr> importCharacterrrByOuterId(@PathVariable Integer outerId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<Characterrr>(characterService.importCharacterrrByOuterId(outerId), headers, HttpStatus.OK);
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


    @GetMapping(value = "/character/name", produces = APPLICATION_JSON_VALUE) // перевірити
    public Characterrr getCharacterByName(@PathVariable String name) {
        log.info("Fetching character with name of " + name);
        return characterService.getCharacterByName(name);
    }


//    @GetMapping(value = "/character/{id}", produces = APPLICATION_JSON_VALUE)
//    public Page<Characterrr> getCharacterrrById(Integer id, Pageable pageable) {
//
//        log.debug("Request to GetById Character : {}", id);
//
//        return characterService.getCharacterrrById(id, pageable);
//    }


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
