package com.bycode.flario.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bycode.flario.R;
import com.bycode.flario.listAdapters.DiscussionsAdapter;
import com.bycode.flario.models.localDatabase.Website;


public class DiscussionsFragment extends Fragment {
    private OnFragmentInteractionListener mListener;


    public DiscussionsFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_discussions, container, false);
        initRecyclerView(v);
        return v;
    }

    private void initRecyclerView(View v) {
        RecyclerView items = (RecyclerView) v.findViewById(R.id.discussions_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        items.setHasFixedSize(true);
        items.setLayoutManager(linearLayoutManager);
        DiscussionsAdapter adapter = mListener.getDiscussionsAdapter();
        items.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DiscussionsFragment.OnFragmentInteractionListener) {
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
        Website getWebsite();
        DiscussionsAdapter getDiscussionsAdapter();
    }
}
