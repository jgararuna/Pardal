package com.modesteam.pardal.instrumentation;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.view.View;
import android.widget.FrameLayout;
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
    public void testShouldSelectWelcome(){
        this.mActivity = getActivity();
        openDrawerOptionAt(0);
    }
    public void testShouldSelectShowRanking(){
        this.mActivity = getActivity();
        openDrawerOptionAt(1);
    }
    public void testShouldSelectShowCategories(){
        this.mActivity = getActivity();
        openDrawerOptionAt(2);
    }
    public void testShouldSelectShowCredits(){
        this.mActivity = getActivity();
        openDrawerOptionAt(3);
    }

    public void openListFragment(int position){
        this.mActivity = getActivity();
        openDrawerOptionAt(2);
        Fragment fragment = this.mActivity.getSupportFragmentManager().findFragmentById(R.id.container);
        mInstrumentation.waitForIdleSync();
        ListView listView = (ListView) ((FrameLayout) fragment.getView().findViewById(R.id.category_list_view)).getChildAt(0);
        TouchUtils.clickView(this,listView.getChildAt(position));
    }


    public void testShouldShowStateList(){
        this.mActivity = getActivity();
        openListFragment(0);
    }
    public void testShouldShowCityList(){
        this.mActivity = getActivity();
        openListFragment(1);
    }
    public void testShouldShowHighWayStretchList(){
        this.mActivity = getActivity();
        openListFragment(2);
    }

//  public void testShouldShowModelList(){
//        this.mActivity = getActivity();
//        openListFragment(3);
//  }

    public void testShouldShowTypeList(){
        this.mActivity = getActivity();
        openListFragment(4);
    }
    public void testShouldShowBrandList(){
        this.mActivity = getActivity();
        openListFragment(5);
    }

    public void openDetailFragment(int position, int positionCategory, int view){
        this.mActivity = getActivity();
        openDrawerOptionAt(2);

        Fragment fragment = this.mActivity.getSupportFragmentManager().findFragmentById(R.id.container);
        mInstrumentation.waitForIdleSync();
        ListView listView = (ListView) ((FrameLayout) fragment.getView().findViewById(R.id.category_list_view)).getChildAt(0);
        TouchUtils.clickView(this,listView.getChildAt(positionCategory));

        Fragment fragment2 = this.mActivity.getSupportFragmentManager().findFragmentById(R.id.container);
        mInstrumentation.waitForIdleSync();
        ListView listView2 = (ListView) ((FrameLayout) fragment2.getView().findViewById(view)).getChildAt(0);
        TouchUtils.clickView(this,listView2.getChildAt(position));
    }
    public void testShouldShowStateDetail(){
        this.mActivity = getActivity();
        openDetailFragment(1,0,R.id.state_list_view);
    }
    public void testShouldShowCityDetail(){
        this.mActivity = getActivity();
        openDetailFragment(1,1,R.id.city_list_view);
    }
    public void testShouldShowHighWayStretchDetail(){
        this.mActivity = getActivity();
        openDetailFragment(1,2,R.id.highway_list_view);
    }
//    public void testShouldShowModelDetail(){
//        this.mActivity = getActivity();
//        openDetailFragment(1,3,R.id.model_list_view);
//    }
    public void testShouldShowTypeDetail(){
        this.mActivity = getActivity();
        openDetailFragment(1,4,R.id.type_list_view);
    }
    public void testShouldShowBrandDetail(){
        this.mActivity = getActivity();
        openDetailFragment(1,5,R.id.brand_list_view);
    }
}
