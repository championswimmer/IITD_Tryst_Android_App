package in.tosc.eventful.fragments.reachus;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.tosc.eventful.R;


/**
 * A simple {@link android.app.Fragment} subclass.
 * Use the {@link ReachUsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReachUsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_LAT = "rlat";
    private static final String ARG_LONG = "rlong";

    // TODO: Rename and change types of parameters
    private String mLat;
    private String mLong;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param rlat Parameter 1.
     * @param rlong Parameter 2.
     * @return A new instance of fragment ReachUsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReachUsFragment newInstance(String rlat, String rlong) {
        ReachUsFragment fragment = new ReachUsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_LAT, rlat);
        args.putString(ARG_LONG, rlong);
        fragment.setArguments(args);
        return fragment;
    }

    public ReachUsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mLat = getArguments().getString(ARG_LAT);
            mLong = getArguments().getString(ARG_LONG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reach_us, container, false);
    }


}
