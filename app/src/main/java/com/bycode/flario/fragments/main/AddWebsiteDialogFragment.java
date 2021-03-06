package com.bycode.flario.fragments.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.bycode.flario.Presenters.WebsiteInfoPresenter;
import com.bycode.flario.R;
import com.bycode.flario.models.WebsiteInfo;
import com.bycode.flario.models.WebsiteInfoAttributes;
import com.bycode.flario.models.WebsiteInfoResponse;
import com.bycode.flario.models.localDatabase.Website;
import com.bycode.flario.utils.URLValidator;

import java.util.List;

/**
 * Created by michal on 22.04.2017.
 */

public class AddWebsiteDialogFragment extends DialogFragment implements AdapterView.OnItemSelectedListener, WebsiteInfoPresenter.WebsiteInfoPresenterListener {
    private String http = "http://";
    private AddWebsiteDialogFragment.OnFragmentInteractionListener mListener;
    private String fullUrl;
    private ProgressBar progressBar;

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

        final WebsiteInfoPresenter websiteInfoPresenter = new WebsiteInfoPresenter(this, getActivity());

        progressBar = (ProgressBar) getActivity().findViewById(R.id.pb_websites);

        Spinner spinner = (Spinner) view.findViewById(R.id.http_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.http_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        builder.setView(view)
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        progressBar.setVisibility(View.VISIBLE);

                        EditText address = (EditText) getDialog().findViewById(R.id.address_url);
                        String full_url = http+address.getText().toString();

                        URLValidator urlValidator = new URLValidator();
                        fullUrl = urlValidator.getValidURL(full_url);

                        List<Website> websitesLocale = Website.find(Website.class, "address = ?", fullUrl);

                        if (websitesLocale.isEmpty()) {
                            websiteInfoPresenter.getWebsiteInfo(fullUrl);
                        }


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
            mListener = (AddWebsiteDialogFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void websiteInfoReady(WebsiteInfoResponse websiteInfoResponse) {
        WebsiteInfo websiteInfo = websiteInfoResponse.getData();
        WebsiteInfoAttributes websiteInfoAttributes = websiteInfo.getAttributes();

        Website website = new Website();
        website.setAddress(fullUrl);
        website.setTitle(websiteInfoAttributes.getTitle());
        website.setLogged(false);
        website.setWelcomeTitle(websiteInfoAttributes.getWelcomeTitle());
        website.setWelcomeMessage(websiteInfoAttributes.getWelcomeMessage());
        website.setShowWelcomeMessage(false);
        website.save();

        progressBar.setVisibility(View.INVISIBLE);

        mListener.addWebsite(website);
        mListener.showToast(R.string.added, Toast.LENGTH_SHORT);

        mListener = null;

    }

    @Override
    public void websiteInfoFailed(String error) {

        mListener.sendModal(R.string.error, R.string.website_not_exists);
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void addWebsite(Website website);
        void sendModal(int title_id, int text_id);
        void showToast(int text_id, int length);
    }
}
