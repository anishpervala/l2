package com.example.demo.client;

import com.example.demo.dao.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
public class CacheClient {
    private HashMap<String, Object> map = new LinkedHashMap<>(100);
    @Autowired
    private ServiceDAO serviceDAO;

//    @Cacheable(
//            value = "randomCache",
//            key = "#key")

    //Concept:**Just a tr**:find in the l1 first, if not available , try to find in the FS/l2, if hit? load into l1 from l2 by removing the element
// in the l1 based on LRU strategy. If it is not available in l2? load from DAO.
    //Tried to implement the in memory cache:
    public Object get(String key) {
        if ((map==null && map.size()==0 )
        || (!map.containsKey(key))) {
            if (map.size()<100) { //Say, we wanna limit l1 for 100, then dump into l2 for the remaining
                map.put(key, serviceDAO.get(key));
                return map.get(key);
            }else {
                // try to implement the l2 cache here; Q is how?
            }
        }
        return map.get(key);
    }

    //FILE SYSTEM: rough idea, unsure about the root level of search/create
    public void storeObject(String key, Object value){

        OutputStream ops = null;
        ObjectOutputStream objOps = null;
        try {
            ops = new FileOutputStream("MyEmpFile.txt");
            objOps = new ObjectOutputStream(ops);
            objOps.writeObject(null);
            objOps.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(objOps != null) objOps.close();
            } catch (Exception ex){

            }
        }

    }

    public void displayObjects(){

        InputStream fileIs = null;
        ObjectInputStream objIs = null;
        try {
            fileIs = new FileInputStream("MyEmpFile.txt");
            objIs = new ObjectInputStream(fileIs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(objIs != null) objIs.close();
            } catch (Exception ex){

            }
        }

    }
}
