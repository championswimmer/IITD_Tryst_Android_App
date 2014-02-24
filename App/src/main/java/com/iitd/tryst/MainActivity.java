package com.iitd.tryst;

import android.app.Fragment;

import in.tosc.eventful.activities.MainDrawerActivity;
import in.tosc.eventful.fragments.AboutFragment;
import in.tosc.eventful.fragments.events.EventItemSliderFragment;

/**
 * Created by championswimmer on 24/2/14.
 */
public class MainActivity extends MainDrawerActivity {
    @Override
    public void setTopFragments() {
        topFragments = new Fragment[] {
                AboutFragment.newInstance("a", "a"),
                EventItemSliderFragment.newInstance("a", "a")
        };
    }

    @Override
    public void setTopFragmentNames() {
        topFragmentNames = new String[] {
                "About",
                "Events"
        };

    }
}
