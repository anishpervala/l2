package com.example.demo;

import com.example.demo.dao.ServiceDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ServiceDAOTest {

    private ServiceDAO serviceDAO  = new ServiceDAO() ;

    @Test
    public void testCache(){
        ServiceDAO serviceDAO1 = new ServiceDAO();
        //TEST what was inserted manually.
//        serviceDAO.put("STR1", "str1");
//        serviceDAO.put("STR2", "str2");

        Object e = serviceDAO.get("STRA");
        Object e1 = serviceDAO.get("STRA");
        Object f = serviceDAO1.get("STRB"); //With Different object
        Object f1 = serviceDAO1.get("STRB");
        assertEquals(e, "stra");
        assertEquals(e1, "stra");
        assertEquals(f, "strb");
        assertEquals(f1, "strb");
    }
}
