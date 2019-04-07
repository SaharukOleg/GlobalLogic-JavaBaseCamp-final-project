package com.got2.task.controller.characterRopositoryTest;

import com.got2.task.TaskApplication;
import com.got2.task.controller.testData.TestData;
import com.got2.task.entity.Characterrr;
import com.got2.task.exceptions.NoSuchCharacterException;
import com.got2.task.network.NetworkDataSourceImpl;
import com.got2.task.repository.CharacterRepository;
import com.got2.task.service.CharacterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)

@SpringBootTest(classes = TaskApplication.class)
public class CharacterTest {


    private CharacterRepository characterRepository = mock(CharacterRepository.class);
    @InjectMocks
    private CharacterService characterService = mock(CharacterService.class);
    private NetworkDataSourceImpl networkDataSourceImp = mock(NetworkDataSourceImpl.class);

    private Characterrr characterrr;
    private Characterrr characterrr1;
    private Characterrr characterrr2;
    Set<Characterrr> characterrrSet = new HashSet<>();


    private static final String METHOD = "getIdFromResource";

    public void init() {
        characterrr = new Characterrr();
        characterrr.setName("Oleg");
        characterrr.setMother("mather");
        characterrr.setBorn("ok");
        characterrr.setId(1);
        List<String> characterrrBooks = new ArrayList<>();
        characterrrBooks.add("https://www.anapioficeandfire.com/api/books/1");
        characterrrBooks.add("https://www.anapioficeandfire.com/api/books/2");
        characterrr.setBooks(characterrrBooks);


        characterrr1 = new Characterrr();
        List<String> characterrr1Books = new ArrayList<>();
        characterrr1Books.add("https://www.anapioficeandfire.com/api/books/1");
        characterrr1Books.add("https://www.anapioficeandfire.com/api/books/2");
        characterrr1.setId(2);
        characterrr1.setBooks(characterrr1Books);
        List<String> listAllegiances = new ArrayList<>();
        listAllegiances.add("olge");
        listAllegiances.add("two");
        listAllegiances.add("ten");


        characterrr2 = new Characterrr();
        List<String> characterrr2Books = new ArrayList<>();
        characterrr2Books.add("https://www.anapioficeandfire.com/api/books/4");
        characterrr2Books.add("https://www.anapioficeandfire.com/api/books/5");
        characterrr2.setId(3);
        characterrr2.setBooks(characterrr2Books);

        characterrrSet.add(characterrr);
        characterrrSet.add(characterrr2);
    }


    @Before
    public void setUp() {
        init();
        MockitoAnnotations.initMocks(this);

    }

    @Test
    @Transactional
    public void saveTest() {
        characterService.save(characterrr);
        assertNotNull(characterrr.getId());
        assertEquals(characterrr.getMother(), "mather");
        assertEquals(characterrr.getBorn(), "ok");

    }


    @Test
    @Transactional
    public void getCharacterFriendsFromSameBookTest() throws Exception {

        when(characterRepository.findById(1)).thenReturn(Optional.of(characterrr));

        when(characterService.getIdFromResource("https://www.anapioficeandfire.com/api/books/1")).thenReturn(1);
        when(characterService.getAllFriendsByAllegiances(characterrr1.getAllegiances())).thenReturn(characterrrSet);

        when(characterService.getCharacterFriendsFromSameBook(1)).thenCallRealMethod();  // Real implementation
        Set<Characterrr> result = characterService.getCharacterFriendsFromSameBook(1);
        assertEquals(result.size(), 2);
    }

    /*@Test
    @Transactional
    public void givenName_whenFindByPersonName_thenReturnCharacterByName() {
        Characterrr characterrr = TestData.generateCharacter(1);
        assert characterrr != null;
        String generateCharacterName = characterrr.getName();
        Characterrr fromDB = characterRepository.getOne(1);
        String CharacterFromDB = fromDB.getName();

        assertEquals(generateCharacterName, CharacterFromDB);
    }*/

    @Test
    @Transactional
    public void getCharacterrrByIdTest() {
        when(characterRepository.findById(1)).thenReturn(Optional.of(characterrr));
        when(characterService.getCharacterrrById(1)).thenCallRealMethod();
        Characterrr result = characterService.getCharacterrrById(1);
        assertEquals(result.getName(), "Oleg");
    }


    @Test(expected = Exception.class)
    @Transactional
    public void getCharacterFriendsFromSameBookForNonExistingCharacterTest() throws NoSuchCharacterException {
        when(characterRepository.findById(179)).thenThrow(new Exception());
        when(characterService.getCharacterFriendsFromSameBook(179)).thenCallRealMethod();  // Real implementation
        characterService.getCharacterFriendsFromSameBook(179);


    }


}
