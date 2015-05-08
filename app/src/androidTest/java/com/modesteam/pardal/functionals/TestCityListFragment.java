package com.modesteam.pardal.functionals;

import android.support.v4.app.Fragment;

import com.modesteam.pardal.CityListFragment;

import junit.framework.TestCase;

/**
 * Created by luisresende on 07/05/15.
 */
public class TestCityListFragment extends TestCase {

    public void testShouldGetNewInstanceOfBrandListFragment(){
        Fragment fragment = CityListFragment.newInstance("A", "B");
        CityListFragment blf = (CityListFragment)fragment;
        assertEquals("A",blf.getArguments().getString("param1"));
    }
}
