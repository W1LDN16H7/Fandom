package com.theknight.fandom.marvel;

public class API {
    private static final String PUBLIC_KEY = "d78f319f8b357759a7b452269f87e91b";
    private static final String PRIVATE_KEY = "1e26b986f656dbc603223d777ac327f2c5bf4b41";
    private static final String API_URL = "https://gateway.marvel.com/v1/public/";
    private static final int RATE_LIMIT = 3000;
    private static final String TS = "1";
    private static final String HASH = "616a18de4c82e31eab56df0f06eb8358";
    private static final String HASH_STRING = "ts=" + TS + "&apikey=" + PUBLIC_KEY + "&hash=" + HASH;


}
