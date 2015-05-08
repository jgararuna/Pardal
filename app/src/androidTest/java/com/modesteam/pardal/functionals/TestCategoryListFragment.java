package com.modesteam.pardal.functionals;


import android.support.v4.app.Fragment;

import com.modesteam.pardal.CategoryListFragment;

import junit.framework.TestCase;

public class TestCategoryListFragment extends TestCase {

    public void testShouldGetNewInstanceOfBrandListFragment(){
        Fragment fragment = CategoryListFragment.newInstance("A","B");
        CategoryListFragment blf = (CategoryListFragment)fragment;
        assertEquals("A",blf.getArguments().getString("param1"));
    }
}
