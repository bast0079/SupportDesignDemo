package example.nerdery.supportlibrarydemo.ui;


import android.os.Bundle;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import example.nerdery.supportlibrarydemo.R;
import example.nerdery.supportlibrarydemo.adapters.ViewPagerAdapter;
import example.nerdery.supportlibrarydemo.callbacks.SnackbarPizzaCallback;
import example.nerdery.supportlibrarydemo.listeners.ChainedAnimationListener;
import example.nerdery.supportlibrarydemo.listeners.SnackbarActionListener;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    @InjectView(R.id.navigation_view) NavigationView mNavigationView;
    @InjectView(R.id.spicoli_view_pager) ViewPager mViewPager;
    @InjectView(R.id.spicoli_tab_layout) TabLayout mTabLayout;
    @InjectView(R.id.toolbar) Toolbar mToolbar;
    @InjectView(R.id.coordinator_layout) CoordinatorLayout mCoordinatorLayout;
    @InjectView(R.id.fab_main) FloatingActionButton mFabMain;
    @InjectView(R.id.fab_sub1) FloatingActionButton mFabSub1;
    @InjectView(R.id.fab_sub2) FloatingActionButton mFabSub2;
    @InjectView(R.id.fab_sub3) FloatingActionButton mFabSub3;

    private boolean areSubFabsVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initializeNavigationItemsListener();
        initializeToolbar();
        initializeViewPager();
        initializeVars();
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case android.R.id.home:
               mDrawerLayout.openDrawer(GravityCompat.START);
               return true;
       }
        return super.onOptionsItemSelected(item);
    }

    private void initializeNavigationItemsListener(){
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_sub_item_1:
                                Snackbar
                                        .make(mDrawerLayout, "You gonna eat that last slice of 'za?", Snackbar.LENGTH_LONG)
                                        .setAction("Yes", new SnackbarActionListener(MainActivity.this))
                                        .setCallback(new SnackbarPizzaCallback(MainActivity.this))
                                        .show();
                                return true;

                            default:
                                return true;
                        }
                    }
                });
    }

    @OnClick(R.id.fab_main) void mainFabClick(){
        if(!areSubFabsVisible){
            showSubFabs();
            areSubFabsVisible = true;
        }
        else{
            closeSubFabs();
            areSubFabsVisible = false;
        }

    }

    @OnClick(R.id.fab_sub1) void fabSub1Click(){

    }

    @OnClick(R.id.fab_sub2) void fabSub2Click(){

    }

    @OnClick(R.id.fab_sub3) void fabSub3Click(){

    }

    private void showSubFabs(){
        Animation thirdAnimation = new ScaleAnimation(0.5f,1.0f,0.5f,1.0f,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        thirdAnimation.setDuration(25);
        thirdAnimation.setAnimationListener(new ChainedAnimationListener(mFabSub3, null, null, View.VISIBLE));

        Animation secondAnimation = new ScaleAnimation(0.5f,1.0f,0.5f,1.0f,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        secondAnimation.setDuration(25);
        secondAnimation.setAnimationListener(new ChainedAnimationListener(mFabSub2, mFabSub3, thirdAnimation, View.VISIBLE));

        Animation firstAnimation = new ScaleAnimation(0.5f,1.0f,0.5f,1.0f,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        firstAnimation.setDuration(25);
        firstAnimation.setAnimationListener(new ChainedAnimationListener(mFabSub1, mFabSub2, secondAnimation, View.VISIBLE));
        mFabSub1.startAnimation(firstAnimation);

    }

    private void closeSubFabs(){
        Animation thirdAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        thirdAnimation.setDuration(25);
        thirdAnimation.setAnimationListener(new ChainedAnimationListener(mFabSub1, null, null, View.GONE));

        Animation secondAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        secondAnimation.setDuration(25);
        secondAnimation.setAnimationListener(new ChainedAnimationListener(mFabSub2, mFabSub1, thirdAnimation, View.GONE));

        Animation firstAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        firstAnimation.setDuration(25);
        firstAnimation.setAnimationListener(new ChainedAnimationListener(mFabSub3, mFabSub2, secondAnimation, View.GONE));
        mFabSub3.startAnimation(firstAnimation);
    }

    private void initializeToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar !=  null){
            supportActionBar.setHomeAsUpIndicator(R.mipmap.ic_menu_drawer);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initializeViewPager(){
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initializeVars(){
        areSubFabsVisible = false;
    }

}
