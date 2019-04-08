package com.got2.task.service;

import com.got2.task.entity.Characterrr;
import com.got2.task.entity.House;
import com.got2.task.exceptions.NoSuchCharacterException;
import com.got2.task.network.NetworkDataSource;
import com.got2.task.repository.CharacterRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@Transactional
public class CharacterService {
    private final Logger log = LoggerFactory.getLogger(CharacterService.class);


    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    NetworkDataSource networkDataSource;


    public Page<Characterrr> getAllCharacters(Pageable pageable) {
        return characterRepository.findAll(pageable);
    }


    public Characterrr save(Characterrr characterrr) {
        log.debug("Request to save Character : {}");
        return characterRepository.save(characterrr);
    }


    public Page getCharacterByName(String name, Pageable pageable) {
        return characterRepository.findCharacterrrByName(name, pageable);
    }


    /**
     * Get one characterrr by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    public Characterrr getCharacterrrById(Integer id) {
        return characterRepository.findById(id).get();
    }


    public Characterrr importCharacterrrByOuterId(Integer outerId) {

        log.debug("Request to GetById Character : {}", outerId);

        Characterrr characterById = networkDataSource.getCharacterById(outerId);

        return characterRepository.save(characterById);
    }


    /**
     * Delete the characterrr by id.
     *
     * @param id the id of the entity
     */
    public void deleteCharacterrr(Integer id) throws NoSuchCharacterException {
        log.debug("Request to delete Character : {}", id);
        try {
            characterRepository.deleteById(id);
        } catch (Exception e) {
            throw new NoSuchCharacterException(String.format("No such Character was found by id: %s", id), e);
        }

    }


    public Set<Characterrr> getCharacterFriendsFromSameBook(Integer characterId) throws NoSuchCharacterException {
        Characterrr requestChar = null;
        try {
            requestChar = characterRepository.findById(characterId).get();
        } catch (Exception e) {
            throw new NoSuchCharacterException(String.format("No such Character was found by id: %s", characterId), e);
        }

        Set<Characterrr> sameBookCharactersFriends = new HashSet<>();

        for (String book : requestChar.getBooks()) {
            Integer bookId = getIdFromResource(book);
            for (Characterrr friend : getAllFriendsByAllegiances(requestChar.getAllegiances())) {
                for (String friendBook : friend.getBooks()) {
                    if (bookId.equals(getIdFromResource(friendBook))) {
                        sameBookCharactersFriends.add(friend);
                    }
                }
            }
        }
        return sameBookCharactersFriends;
    }

    public Integer getIdFromResource(String book) {
        String strId = book.replace("https://www.anapioficeandfire.com/api/books/", "");
        strId = strId.replace("https://anapioficeandfire.com/api/books/", "");
        return Integer.valueOf(strId);
    }

    public Set<Characterrr> getAllFriendsByAllegiances(List<String> allegiances) {
        Set<Characterrr> friends = new HashSet<>();
        for (String allegiance : allegiances) {
            House house = networkDataSource.getHouseByResourcePath(allegiance);
            List<String> swornMembers = house.getSwornMembers();
            for (String memberPath : swornMembers) {
                friends.add(networkDataSource.getCharacterByResourcePath(memberPath));
            }
        }
        return friends;
    }
}