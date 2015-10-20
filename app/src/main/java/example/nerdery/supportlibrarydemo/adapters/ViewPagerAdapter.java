package example.nerdery.supportlibrarydemo.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import example.nerdery.supportlibrarydemo.fragments.SpicoliListFragment;


/**
 * Created by sbastin on 10/15/15.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentList;
    private List<String> mFragmentTitles;

    public ViewPagerAdapter(FragmentManager manager){
        super(manager);
        mFragmentList = initFragments();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }

    private List<Fragment> initFragments(){
        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();

        fragments.add(SpicoliListFragment.newInstance(SpicoliListFragment.class));
        titles.add("List 1");
        fragments.add(SpicoliListFragment.newInstance(SpicoliListFragment.class));
        titles.add("List 2");
        fragments.add(SpicoliListFragment.newInstance(SpicoliListFragment.class));
        titles.add("List 3");

        mFragmentTitles = titles;

        return fragments;
    }
}
