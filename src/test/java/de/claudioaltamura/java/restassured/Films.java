package de.claudioaltamura.java.restassured;

import java.util.Collection;

public record Films(int count, Film next, Film previous, Collection<Film> results) {}
