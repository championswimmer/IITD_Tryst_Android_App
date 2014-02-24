package com.iitd.tryst;

import android.app.Fragment;

import android.net.Uri;
import in.tosc.eventful.activities.MainDrawerActivity;
import in.tosc.eventful.fragments.AboutFragment;
import in.tosc.eventful.fragments.events.EventDaySliderFragment;
import in.tosc.eventful.fragments.events.EventItemSliderFragment;

/**
 * Created by championswimmer on 24/2/14.
 */
public class MainActivity extends MainDrawerActivity
        implements
        DayTwoFragment.OnFragmentInteractionListener,
        DayThreeFragment.OnFragmentInteractionListener,
        DayFourFragment.OnFragmentInteractionListener
{
    @Override
    public void setTopFragments() {
        topFragments = new Fragment[] {
                DayTwoFragment.newInstance("Day 2, 27th Feb", "27"),
                DayThreeFragment.newInstance("Day 3, 28th Feb", "28"),
                DayFourFragment.newInstance("Day 4, 1st Mar", "1"),

        };
    }

    @Override
    public void setTopFragmentNames() {
        topFragmentNames = new String[] {
                "Day 2, 27th Feb",
                "Day 3, 28th Feb",
                "Day 4, 1st Mar",
        };

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
