package com.modesteam.pardal.models;

import com.modesteam.pardal.Pardal;

import junit.framework.TestCase;

import java.sql.SQLException;
import java.util.ArrayList;

import helpers.Condition;
import helpers.GenericPersistence;
import helpers.Operator;
import libraries.NotNullableException;
import models.HighwayStretch;

/**
 * Created by lucaslrt on 04/05/15.
 */
public class HighwayStrechtTest extends TestCase {
    //Metodos Iguais por classe(Mude o nome e os parametros)
    HighwayStretch highway1, highway2;

    public void setUp() throws SQLException, NotNullableException, ClassNotFoundException {
        Pardal.setDatabaseName("database_test.sqlite3.db");
        highway1 = new HighwayStretch(1);
        highway2 = new HighwayStretch(2);
        highway1.save();
        highway2.save();

    }

    public void tearDown() throws SQLException, ClassNotFoundException {
        highway1.delete();
        highway2.delete();
    }

    public void testShouldGetFirstHighwayFromDatabase() throws SQLException, ClassNotFoundException {
        assertEquals(highway1.getId(), HighwayStretch.first().getId());
    }

    public void testShouldGetLastHighwayFromDatabase() throws SQLException, ClassNotFoundException {
        assertEquals(highway2.getId(), HighwayStretch.last().getId());
    }

    public void testShouldGetHighwayFromDatabase() throws SQLException, ClassNotFoundException {
        assertEquals(highway2.getId(), HighwayStretch.get(HighwayStretch.last().getId()).getId());
    }

    public void testShouldCountHighwayFromDatabase() throws SQLException, ClassNotFoundException {
        assertEquals(2, HighwayStretch.count());
    }

    public void testShouldGetAllHighwayFromDatabase() throws SQLException, ClassNotFoundException {
        assertEquals(2, HighwayStretch.getAll().size());
    }

    public void testShouldSaveHighwayFromDatabase() throws SQLException, ClassNotFoundException, NotNullableException {
        assertEquals(2, HighwayStretch.getAll().size());
        HighwayStretch highway3 = new HighwayStretch(3);
        highway3.save();
        assertEquals(3, HighwayStretch.getAll().size());
        highway3.delete();
    }

    public void testShouldDeleteHighwayFromDatabase() throws SQLException, ClassNotFoundException, NotNullableException {
        HighwayStretch highway3 = new HighwayStretch(3);
        highway3.save();
        assertEquals(3, HighwayStretch.getAll().size());
        highway3.delete();
        assertEquals(2, HighwayStretch.getAll().size());
    }
}
