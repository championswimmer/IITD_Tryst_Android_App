package in.tosc.eventful.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Map;

import in.tosc.eventful.R;
import in.tosc.eventful.fragments.AboutFragment;
import in.tosc.eventful.fragments.reachus.ReachUsFragment;

public abstract class MainDrawerActivity
        extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private static String TAG = "MainDrawerActivity";

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    /**
     * Array of fragments to store the top level fragments
     */

    public static Fragment[] topFragments;

    /**
     * String array of names to assign to the top fragments
     */

    public static String[] topFragmentNames;

    /**
     * Map containing the key-value pair values for contacts fragment
     */
    public static Map<String, String> contactsMap;

    /**
     * populate {@link #topFragments} with fragments of your choice
     * <p/>
     * for example
     * <pre>
     *     {@code
     *          topFragments = new android.app.Fragment[]{
     *              AboutFragment.newInstance("A", "A"),
     *              ContactFragment.newInstance("a", "a")
     *          };
     *          topFragmentNames = new String[] {
     *              "About",
     *              "Contact"
     *          };
     *
     *      }
     * </pre>
     */

    public abstract void setTopFragments();

    public abstract void setTopFragmentNames();

    public MainDrawerActivity() {
        topFragments = new Fragment[]{
                AboutFragment.newInstance("A", "A"),
                ReachUsFragment.newInstance("b", "b")
        };
        topFragmentNames = new String[]{
                "About",
                "Reach Us"
        };
        setTopFragmentNames();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);
        setTopFragments();
        if (topFragments.length != topFragmentNames.length) {
            Log.wtf(TAG, "Number of fragments and number of Fragment Names must be same !!!");
        }

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, topFragments[position])
                .commit();
    }

    /**
     * Defines what will be done when fragment is attached with this activity
     * For eg. changing the title of the App
     *
     * @param number The position of the fragment (starts from 1)
     */

    public void onSectionAttached(int number) {
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main_drawer, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
