package com.navigation;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.navigation.fragment.AwesomeFragment;
import com.navigation.fragment.BarStyle;
import com.navigation.fragment.DrawableUtils;
import com.navigation.fragment.DrawerFragment;
import com.navigation.fragment.NavigationFragment;
import com.navigation.fragment.Style;

/**
 * Created by listen on 2018/1/12.
 */

public class TestStatusBarFragment extends AwesomeFragment {

    public static String fromCharCode(int... codePoints) {
        return new String(codePoints, 0, codePoints.length);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_status_bar, container, false);

        TextView tagView = root.findViewById(R.id.tag);
        tagView.setText(getDebugTag());

        root.findViewById(R.id.pop_to_root).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationFragment navigationFragment = getNavigationFragment();
                if (navigationFragment != null) {
                    navigationFragment.popToRootFragment();
                }
            }
        });

        root.findViewById(R.id.toggle_drawer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerFragment drawerFragment = getDrawerFragment();
                if (drawerFragment != null) {
                    drawerFragment.toggleMenu();
                }
            }
        });

        root.findViewById(R.id.status_bar_style).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNavigationFragment().pushFragment(new StatusBarStyleFragment());
            }
        });


        root.findViewById(R.id.status_bar_hidden).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getNavigationFragment().pushFragment(new StatusBarHiddenFragment());
            }
        });


        root.findViewById(R.id.status_bar_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNavigationFragment().pushFragment(new StatusBarColorFragment());
            }
        });

        root.findViewById(R.id.no_toolbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNavigationFragment().pushFragment(new NoToolBarFragment());
            }
        });

        root.findViewById(R.id.toolbar_color_transition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNavigationFragment().pushFragment(new ToolBarColorTransitionFragment());
            }
        });

        root.findViewById(R.id.view_pager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNavigationFragment().pushFragment(new ViewPagerFragment());
            }
        });

        root.findViewById(R.id.coordinator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNavigationFragment().pushFragment(new CoordinatorFragment());
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle("状态栏");
        if (isNavigationRoot()) {
            Drawable icon = DrawableUtils.fromFont(getContext(), "FontAwesome", fromCharCode(61641), 24, -1 );
            setToolbarLeftButton(icon, "Menu", true, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DrawerFragment drawerFragment = getDrawerFragment();
                    if (drawerFragment != null) {
                        drawerFragment.toggleMenu();
                    }
                }
            });
        }
    }

    @Override
    protected void onCustomStyle(Style style) {
        style.setToolBarStyle(BarStyle.LightContent);
    }

    @Override
    protected boolean hidesBottomBarWhenPushed() {
        return false;
    }

}