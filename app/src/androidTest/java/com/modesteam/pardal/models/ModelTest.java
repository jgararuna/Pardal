package com.modesteam.pardal.models;

import com.modesteam.pardal.Pardal;

import junit.framework.TestCase;

import java.sql.SQLException;

import helpers.Condition;
import helpers.Operator;
import libraries.NotNullableException;
import models.Model;


/**
 * Created by laerciojunior on 04/05/15.
 */
public class ModelTest  extends TestCase {
        Model model1, model2;
        public void setUp() throws SQLException, NotNullableException, ClassNotFoundException {
            Pardal.getInstance().setDatabaseName("database_test.sqlite3.db");
            model1 = new Model("model1",true,1,1);
            model2 = new Model("model2",false,2,2);
            model1.save();
            model2.save();

        }
        public void tearDown() throws SQLException, ClassNotFoundException {
            model1.delete();
            model2.delete();
        }
        public void testShouldGetFirstmodelFromDatabase() throws SQLException, ClassNotFoundException {
            assertEquals(model1.getName(), Model.first().getName());
            assertEquals(model1.getBrand(), Model.first().getBrand());
            assertEquals(model1.getIdType(),Model.first().getIdType());
            assertEquals(model1.getId(), Model.first().getId());
        }

        public void testShouldGetLastmodelFromDatabase() throws SQLException, ClassNotFoundException {
            assertEquals(model2.getName(), Model.last().getName());
            assertEquals(model2.getBrand(), Model.last().getBrand());
            assertEquals(model2.getIdType(),Model.last().getIdType());
            assertEquals(model2.getId(), Model.last().getId());
        }

        public void testShouldCountmodelFromDatabase() throws SQLException, ClassNotFoundException {
            assertEquals(2, Model.count());
        }

        public void testShouldGetAllmodelFromDatabase() throws SQLException, ClassNotFoundException {
            assertEquals(2, Model.getAll().size());
        }

        public void testShouldSavemodelFromDatabase() throws SQLException, ClassNotFoundException, NotNullableException {
            assertEquals(2, Model.getAll().size());
            Model model3 = new Model("model3",false,3,3);
            model3.save();
            assertEquals(3, Model.getAll().size());
            model3.delete();
        }

        public void testShouldDeletemodelFromDatabase() throws SQLException, ClassNotFoundException, NotNullableException {
            Model model3 = new Model("model3",false,3,3);
            model3.save();
            assertEquals(3, Model.getAll().size());
            model3.delete();
            assertEquals(2, Model.getAll().size());
        }

        public void testShouldGetWheremodelFromDatabase() throws SQLException, ClassNotFoundException, NotNullableException {
            Condition condition = new Condition(new Model(),"name", Operator.EQUAL,"model1");
            assertEquals(model1.getName(), Model.getWhere(condition).get(0).getName());
        }

}
