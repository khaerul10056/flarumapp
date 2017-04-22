package com.bycode.flarum.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bycode.flarum.Presenters.WebsitesPresenter;
import com.bycode.flarum.R;
import com.bycode.flarum.listAdapters.WebsitesAdapter;
import com.bycode.flarum.models.localDatabase.Website;

import java.util.ArrayList;



public class WebsitesFragment extends Fragment implements WebsitesPresenter.WebsitesPresenterListener{
    private WebsitesAdapter adapter;


    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView(view);

        WebsitesPresenter websitesPresenter = new WebsitesPresenter(this, getActivity());
        websitesPresenter.getWebsites();

        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.add_website_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                AddWebsiteDialogFragment addWebsiteDialogFragment = AddWebsiteDialogFragment.newInstance();
                addWebsiteDialogFragment.show(ft, "TEST");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_websites, container, false);
    }

    private void initRecyclerView(View v) {
        RecyclerView items = (RecyclerView) v.findViewById(R.id.websites_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        items.setHasFixedSize(true);
        items.setLayoutManager(linearLayoutManager);
        adapter = new WebsitesAdapter();
        items.setAdapter(adapter);
    }

    @Override
    public void websitesReady(ArrayList<Website> websites) {
        for (Website website : websites) {
            adapter.addWebsite(website);
        }
    }

}
