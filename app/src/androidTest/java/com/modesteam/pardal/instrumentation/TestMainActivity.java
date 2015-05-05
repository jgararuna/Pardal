package com.modesteam.pardal.instrumentation;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.view.View;
import android.widget.ListView;

import com.modesteam.pardal.MainActivity;
import com.modesteam.pardal.R;

/**
 * Created by rafael on 05/05/15.
 */
public class TestMainActivity extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;
    private Instrumentation mInstrumentation;

    public TestMainActivity(){
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(false);
        this.mActivity = getActivity();
        this.mInstrumentation = getInstrumentation();
    }

    public void openDrawerOptionAt(int position){
        Fragment fragment = this.mActivity.getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        DrawerLayout drawerLayout = (DrawerLayout)this.mActivity.findViewById(R.id.drawer_layout);
        if(!drawerLayout.isDrawerOpen(GravityCompat.START)){
            View v = fragment.getView().focusSearch(View.FOCUS_RIGHT);
            TouchUtils.clickView(this,v);
        }
        ListView listView = (ListView)fragment.getView();
        TouchUtils.clickView(this,listView.getChildAt(position));
    }

    public void testShouldSelectShowCategories(){
        this.mActivity = getActivity();
        openDrawerOptionAt(2);
    }
}
