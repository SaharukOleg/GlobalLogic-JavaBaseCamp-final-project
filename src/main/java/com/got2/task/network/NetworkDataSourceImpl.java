package com.got2.task.network;

import com.got2.task.entity.Book;
import com.got2.task.entity.Characterrr;
import com.got2.task.entity.House;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class NetworkDataSourceImpl implements NetworkDataSource {

    private RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://www.anapioficeandfire.com/api";
    private final HttpEntity<String> entity;

    public NetworkDataSourceImpl() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36");
        entity = new HttpEntity<>("parameters", headers);
    }

    @Override
    public Book getBookById(Integer id) {
        ResponseEntity<Book> exchange = restTemplate.exchange(BASE_URL + "/books/" + id, HttpMethod.GET, entity, Book.class);
        return exchange.getBody();
    }

    @Override
    public Characterrr getCharacterById(Integer id) {
        ResponseEntity<Characterrr> exchange = restTemplate.exchange(BASE_URL + "/characters/" + id, HttpMethod.GET, entity, Characterrr.class);
        return exchange.getBody();
    }

    @Override
    public Characterrr getCharacterByResourcePath(String path) {
        return restTemplate.exchange(path, HttpMethod.GET, entity, Characterrr.class).getBody();
    }

    @Override
    public House getHouseById(Integer id) {
        ResponseEntity<House> exchange = restTemplate.exchange(BASE_URL + "/houses/" + id, HttpMethod.GET, entity, House.class);
        return exchange.getBody();
    }

    @Override
    public House getHouseByResourcePath(String path) {
        ResponseEntity<House> exchange = restTemplate.exchange(path, HttpMethod.GET, entity, House.class);
        return exchange.getBody();
    }
}
