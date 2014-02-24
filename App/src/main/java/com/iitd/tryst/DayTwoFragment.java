package com.iitd.tryst;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link android.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.iitd.tryst.DayTwoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link com.iitd.tryst.DayTwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class DayTwoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String[] eventNames, eventVenues, eventCategories, eventDates, eventContacts;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DayTwoFragment newInstance(String param1, String param2) {
        DayTwoFragment fragment = new DayTwoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public DayTwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_day, container, false);
        eventCategories = getResources().getStringArray(R.array.event_category);
        eventDates = getResources().getStringArray(R.array.event_dates);
        eventNames = getResources().getStringArray(R.array.event_names);
        eventVenues = getResources().getStringArray(R.array.event_venues);
        eventContacts = getResources().getStringArray(R.array.event_contacts);

        final String[] finalEnames = new String[100];
        final String[] finalECategories = new String[100];
        final String[] finalEVenues = new String[100];
        final String[] finalEContacts = new String[100];
        int len = 0;
        for (int i =0, j=0; i < eventNames.length; i++) {
            if (eventDates[i].equalsIgnoreCase("27")) {
                finalEnames[j]=eventNames[i];
                finalECategories[j]=eventCategories[i];
                finalEVenues[j]=eventVenues[i];
                finalEContacts[j]=eventContacts[i];
                j++; len++;
            }
        }

        ListView eventList = (ListView) rootView.findViewById(R.id.day_event_list);
        final int finalLen = len;
        ListAdapter mAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return finalLen;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View vi = view;
                if (vi == null) {
                    vi = inflater.inflate(R.layout.day_event_item, null);
                    TextView eName = (TextView) vi.findViewById(R.id.event_name);
                    TextView eVenue = (TextView) vi.findViewById(R.id.event_venue);
                    TextView eCategory = (TextView) vi.findViewById(R.id.event_category);
                    TextView eContact = (TextView) vi.findViewById(R.id.event_contact);

                    eName.setText(finalEnames[i]);
                    eCategory.setText(finalECategories[i]);
                    eVenue.setText(finalEVenues[i]);
                    eContact.setText(finalEContacts[i]);

                }

                return vi;
            }
        };

        eventList.setAdapter(mAdapter);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
