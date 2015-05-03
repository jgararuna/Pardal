package com.modesteam.pardal.models;

import junit.framework.TestCase;

import java.sql.SQLException;

import models.City;

/**
 * Created by luisresende on 03/05/15.
 */
public class CityTest extends TestCase {

    public void testShouldGetFirstCityFromDatabase() throws SQLException, ClassNotFoundException {
        assertEquals(City.get(1).getName(), City.first().getName());
    }

    public void testShouldGetLastCityFromDatabase() throws SQLException, ClassNotFoundException {
        assertEquals("XAMBIOA", City.last().getName());
    }


}
