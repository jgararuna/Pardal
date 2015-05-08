package com.modesteam.pardal.functionals;

import android.support.v4.app.Fragment;

import com.modesteam.pardal.ModelListFragment;

import junit.framework.TestCase;

/**
 * Created by luisresende on 07/05/15.
 */
public class TestModelListFragment extends TestCase {

    public void testShouldGetNewInstanceOfBrandListFragment(){
        Fragment fragment = ModelListFragment.newInstance("A", "B");
        ModelListFragment blf = (ModelListFragment)fragment;
        assertEquals("A",blf.getArguments().getString("param1"));
    }
}
