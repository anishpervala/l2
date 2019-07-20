package com.example.demo.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Random;

@Repository
public class ServiceDAO implements Service {
    private static final Logger log = LoggerFactory.getLogger(ServiceDAO.class);
    private static HashMap<String, Object> map = new HashMap<>(100);

    static {
        //Pre load the map; acts as a data layer
        Random r = new Random();
        do{
        int i = r.nextInt( 9999) + 1;
        map.put("STR"+i, "str"+i);}
        while(map.size()<1000);

        //To verify from the main application.
        map.put("STRA", "stra");
        map.put("STRB", "strb");
        map.put("STRC", "strc");
        map.put("STRD", "strd");
        map.put("STRE", "stre");
        map.put("STRF", "strf");
        map.put("STRG", "strg");
        map.put("STRH", "strh");
        map.put("STRI", "stri");
        map.put("STRJ", "strj");
        map.put("STRK", "strk");
    }

    @Override
    public Object get(String key) {
        log.info(String.format("Inside DAO with a key%s", key));
        return map.get(key);
    }

    @Override
    public void put(String key, Object value)
    {
        map.put(key, value);
    }

}