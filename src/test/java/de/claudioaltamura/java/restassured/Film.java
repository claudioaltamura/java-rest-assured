package de.claudioaltamura.java.restassured;

import java.util.Date;

public record Film(
    String title,
    String episode_id,
    String opening_crawl,
    String director,
    String producer,
    Date release_date,
    String[] species,
    String[] starships,
    String[] vehicles,
    String[] characters,
    String[] planets,
    String url,
    Date created,
    Date edited) {}
