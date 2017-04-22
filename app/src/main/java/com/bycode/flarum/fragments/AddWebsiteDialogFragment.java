package com.bycode.flarum.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;

import com.bycode.flarum.R;
import com.bycode.flarum.models.localDatabase.Website;

/**
 * Created by michal on 22.04.2017.
 */

public class AddWebsiteDialogFragment extends DialogFragment {

    public AddWebsiteDialogFragment() {

    }

    public static AddWebsiteDialogFragment newInstance() {

        Bundle args = new Bundle();

        AddWebsiteDialogFragment fragment = new AddWebsiteDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.add_website_dialog, null))
                // Add action buttons
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText address = (EditText) getDialog().findViewById(R.id.address_url);

                        Website website = new Website();
                        website.setAddress(address.getText().toString());
                        website.save();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AddWebsiteDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }


}
