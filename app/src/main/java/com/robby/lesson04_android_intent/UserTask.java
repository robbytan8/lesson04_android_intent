package com.robby.lesson04_android_intent;

import android.content.Context;
import android.os.AsyncTask;

/**
 * @author Robby Tan
 */

public class UserTask extends AsyncTask<String, Void, Boolean> {

    private static final String APPROVED_EMAIL = "dummy@dummy.com";
    private static final String APPROVED_PASSWORD = "Dummy555*";
    private Context context;

    public UserTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        ((LoginActivity) context).loginShowStatus(aBoolean);
    }

    @Override
    protected Boolean doInBackground(String... params) {
        if (APPROVED_EMAIL.equals(params[0]) && APPROVED_PASSWORD.equals(params[1])) {
            return true;
        }
        return false;
    }
}
