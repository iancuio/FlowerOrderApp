package com.iancuio.flowerorder.utils.viewPager.viewPagerAdapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;
    private List<Integer> titleList;
    private List<Integer> imageList;
    private List<Integer> resourceList;

    public ScreenSlidePagerAdapter(FragmentManager fragmentManager, List<Fragment> fragmentList) {
        super(fragmentManager);

        this.fragmentList = fragmentList;
    }

    public ScreenSlidePagerAdapter(FragmentManager fragmentManager, List<Fragment> fragmentList, List<Integer> resourceList) {
        super(fragmentManager);

        this.fragmentList = fragmentList;
        this.resourceList = resourceList;
    }

    public ScreenSlidePagerAdapter(FragmentManager fragmentManager, List<Fragment> fragmentList, List<Integer> titleList, List<Integer> imageList) {
        super(fragmentManager);

        this.fragmentList = fragmentList;
        this.titleList = titleList;
        this.imageList = imageList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() { return fragmentList.size(); }

    public View getTabView(int position, int tabResId, Context context) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View view = LayoutInflater.from(context).inflate(tabResId, null);

//        switch (tabResId) {
//            case R.layout.tab_core_custom_view: {
//                ImageView imageView = view.findViewById(R.id.imageView_coreTab_tabImage);
//
//                imageView.setImageDrawable(context.getResources().getDrawable(resourceList.get(position)));
//
//                break;
//            }
//            case R.layout.tab_dot_custom_view: {
//                ImageView imageView = view.findViewById(R.id.imageView_tabDot_dot);
//
//                imageView.setImageDrawable(context.getResources().getDrawable(resourceList.get(position)));
//
//                break;
//            }
//            case R.layout.tab_title_custom_view: {
//                TextView textView = view.findViewById(R.id.textView_tabTitleCustomView_title);
//
//                textView.setText(resourceList.get(position));
//
//                break;
//            }
//        }

        return view;
    }
}