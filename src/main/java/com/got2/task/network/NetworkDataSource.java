package com.got2.task.network;

import com.got2.task.entity.Book;
import com.got2.task.entity.Characterrr;
import com.got2.task.entity.House;

public interface NetworkDataSource {
    Book getBookById(Integer id);

    Characterrr getCharacterById(Integer id);

    House getHouseById(Integer id);
}
