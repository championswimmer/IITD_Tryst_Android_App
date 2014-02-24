package in.tosc.eventful.fragments.contacts;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.haarman.listviewanimations.swinginadapters.AnimationAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingRightInAnimationAdapter;
import in.tosc.eventful.R;
import in.tosc.eventful.data.Contacts;
import in.tosc.eventful.utils.GoogleCardsAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link android.app.Fragment} subclass.
 * Use the {@link in.tosc.eventful.fragments.contacts.ContactGoogleCardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactGoogleCardFragment extends Fragment {

    private final static String TAG = "ContactFragment";

    private static final String ARG_CONTACT_NAMES = "contact_names";
    private static final String ARG_CONTACT_EMAILS = "contact_emails";

    private String[] contactNames;
    private String[] contactEmails;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param contacts The contacts object.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactGoogleCardFragment newInstance(Contacts contacts) {
        ContactGoogleCardFragment fragment = new ContactGoogleCardFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_CONTACT_NAMES, contacts.getContactNames());
        args.putStringArray(ARG_CONTACT_EMAILS, contacts.getContactEmails());
        fragment.setArguments(args);
        return fragment;
    }

    public ContactGoogleCardFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d(TAG, "onCreate called");
        if (getArguments() != null) {
            contactNames = getArguments().getStringArray(ARG_CONTACT_NAMES);
            contactEmails = getArguments().getStringArray(ARG_CONTACT_EMAILS);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Log.d(TAG, "onCreateView called");

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_contact_googlecard, container, false);
        List<String> contactList = new ArrayList<String>();
        //TODO: Get these from the xml files
        for (String mContactItem : contactNames) {
            //Log.d(TAG, mContactItem);
            contactList.add(mContactItem);
        }
        GoogleCardsAdapter mAdapter = new GoogleCardsAdapter(getActivity().getApplicationContext(), contactList);
        ListView contactsListView = (ListView) rootView.findViewById(R.id.list_contacts_googlecard);
        AnimationAdapter animAdapter = new SwingRightInAnimationAdapter(mAdapter);
        animAdapter.setAbsListView(contactsListView);
        contactsListView.setAdapter(animAdapter);
        return rootView;
    }


}
