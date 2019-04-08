package com.got2.task.controller.testData;

import com.got2.task.TaskApplication;
import com.got2.task.entity.Characterrr;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Component
public class TestData {


    public Characterrr generateCharacter(Integer character) {
        switch (character) {
            case 1:
                Characterrr character1 = new Characterrr();
                character1.setName("Aemon Blackfyre");
                return character1;
            case 2:
                Characterrr character2 = new Characterrr();
                character2.setName("Anakin Skywalker");
                return character2;
        }
        return null;
    }
}
