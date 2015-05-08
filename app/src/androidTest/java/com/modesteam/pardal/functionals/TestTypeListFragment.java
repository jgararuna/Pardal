package com.modesteam.pardal.functionals;

import android.support.v4.app.Fragment;

import com.modesteam.pardal.TypeListFragment;

import junit.framework.TestCase;

/**
 * Created by luisresende on 07/05/15.
 */
public class TestTypeListFragment extends TestCase {

    public void testShouldGetNewInstanceOfTypeListFragment(){
        Fragment fragment = TypeListFragment.newInstance("A", "B");
        TypeListFragment tlf = (TypeListFragment)fragment;
        assertEquals("A",tlf.getArguments().getString("param1"));
    }
}
