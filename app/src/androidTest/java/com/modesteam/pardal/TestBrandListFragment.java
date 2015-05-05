package com.modesteam.pardal;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;

import com.modesteam.pardal.BrandListFragment;

import junit.framework.TestCase;

/**
 * Created by rafael on 05/05/15.
 */
public class TestBrandListFragment extends TestCase {

    public void testShouldGetNewInstanceOfBrandListFragment(){
        Fragment fragment = BrandListFragment.newInstance("A","B");
        BrandListFragment blf = (BrandListFragment)fragment;
        assertEquals("A",blf.getArguments().getString("param1"));
    }
}
