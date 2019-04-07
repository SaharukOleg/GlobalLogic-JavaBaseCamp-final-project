package com.got2.task.controller.testData;

import com.got2.task.entity.Characterrr;

public class TestData {


    public static Characterrr generateCharacter(Integer character) {
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
