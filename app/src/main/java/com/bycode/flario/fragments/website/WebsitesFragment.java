package com.bycode.flario.fragments.website;

import android.content.Context;
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

import com.bycode.flario.R;
import com.bycode.flario.fragments.main.AddWebsiteDialogFragment;
import com.bycode.flario.listAdapters.WebsitesAdapter;



public class WebsitesFragment extends Fragment {
    private OnFragmentInteractionListener mListener;


    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView(view);


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
        return inflater.inflate(R.layout.fragment_websites, container, false);
    }

    private void initRecyclerView(View v) {
        RecyclerView items = (RecyclerView) v.findViewById(R.id.websites_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        items.setHasFixedSize(true);
        items.setLayoutManager(linearLayoutManager);
        WebsitesAdapter adapter = mListener.getWebsiteAdapter();
        items.setAdapter(adapter);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
        WebsitesAdapter getWebsiteAdapter();
    }
}
