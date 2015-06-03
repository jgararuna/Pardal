package com.modesteam.pardal.helpers;

import com.modesteam.pardal.ThreadData;

import junit.framework.TestCase;

/**
 * Created by luisresende on 03/06/15.
 */
public class TestThreadData extends TestCase {

    public void setUp(){
        ThreadData threadData = new ThreadData();
        Thread thread = new Thread(threadData);
        thread.start();
    }

    public void testShouldGetNewInstanceOfThread(){
        ThreadData threadDataInstance = null;
        threadDataInstance = new ThreadData();
        assertNotNull(threadDataInstance);
    }

    public void testShouldPreLoadTypeContent(){
        
    }
}
