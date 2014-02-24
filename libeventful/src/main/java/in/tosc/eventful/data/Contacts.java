package in.tosc.eventful.data;

import android.content.Context;

/**
 * Created by championswimmer on 24/2/14.
 */
public class Contacts {

    private Context c;
    private String[] contactNames = {""};
    private String[] contactEmails = {""};

    public Contacts (Context context) {
        c = context;
    }

    public void setContactNames (int resId) {
        contactNames = c.getResources().getStringArray(resId);
    }

    public void setContactEmails (int resId) {
        contactEmails = c.getResources().getStringArray(resId);
    }

    public String[] getContactNames () {
        return contactNames;
    }

    public String[] getContactEmails () {
        return contactEmails;
    }

}
