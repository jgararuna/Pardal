package com.modesteam.pardal.functionals;

import android.support.v4.app.Fragment;

import com.modesteam.pardal.HighwayStretchListFragment;

import junit.framework.TestCase;

/**
 * Created by luisresende on 07/05/15.
 */
public class TestHighwayStretchListFragment extends TestCase{

    public void testShouldGetNewInstanceOfBrandListFragment(){
        Fragment fragment = HighwayStretchListFragment.newInstance("A", "B");
        HighwayStretchListFragment blf = (HighwayStretchListFragment)fragment;
        assertEquals("A",blf.getArguments().getString("param1"));
    }
}
