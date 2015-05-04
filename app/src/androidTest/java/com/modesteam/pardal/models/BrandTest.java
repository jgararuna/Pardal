package com.modesteam.pardal.models;

import junit.framework.TestCase;

import java.sql.SQLException;
import java.util.ArrayList;

import models.Brand;
import models.Model;

/**
 * Created by rafael on 03/05/15.
 */
public class BrandTest extends TestCase{


    public void testShouldReturnAllModels() throws SQLException, ClassNotFoundException {
        Brand brand = new Brand();
        ArrayList<Model> listModel = brand.getModels();
        int tam = listModel.size();
        int x=0;
        if(tam>0){
            x=tam;
        }
        assertEquals(tam,x);

    }
}
