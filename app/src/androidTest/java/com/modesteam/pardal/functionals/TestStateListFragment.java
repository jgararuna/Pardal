package com.modesteam.pardal.functionals;


import android.support.v4.app.Fragment;

import com.modesteam.pardal.StateListFragment;

import junit.framework.TestCase;

/**
 * Created by luisresende on 07/05/15.
 */
public class TestStateListFragment extends TestCase {
    public void testShouldGetNewInstanceOfBrandListFragment(){
        Fragment fragment = StateListFragment.newInstance("A", "B");
        StateListFragment slf = (StateListFragment)fragment;
        assertEquals("A",slf.getArguments().getString("param1"));
    }
}
