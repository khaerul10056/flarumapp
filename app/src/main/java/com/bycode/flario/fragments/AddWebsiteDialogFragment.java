package com.bycode.flario.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.bycode.flario.R;
import com.bycode.flario.listAdapters.WebsitesAdapter;
import com.bycode.flario.models.localDatabase.Website;
import com.bycode.flario.utils.URLValidator;

/**
 * Created by michal on 22.04.2017.
 */

public class AddWebsiteDialogFragment extends DialogFragment implements AdapterView.OnItemSelectedListener {
    private String http = "http://";
    private WebsitesFragment.OnFragmentInteractionListener mListener;

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
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_website_dialog, null);

        // Get the layout inflater
        Spinner spinner = (Spinner) view.findViewById(R.id.http_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.http_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText address = (EditText) getDialog().findViewById(R.id.address_url);
                        String full_url = http+address.getText().toString();

                        URLValidator urlValidator = new URLValidator();
                        full_url = urlValidator.getValidURL(full_url);

                        Website website = new Website();
                        website.setAddress(full_url);
                        website.save();

                        mListener.addWebsite(website);


                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AddWebsiteDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                http = "http://";
                break;
            case 1:
                http = "https://";
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WebsitesFragment.OnFragmentInteractionListener) {
            mListener = (WebsitesFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void addWebsite(Website website);
        WebsitesAdapter getWebsiteAdapter();
    }
}
