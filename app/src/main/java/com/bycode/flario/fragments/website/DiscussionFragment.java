package com.bycode.flario.fragments.website;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bycode.flario.R;
import com.bycode.flario.listAdapters.PostsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscussionFragment extends Fragment {
    private DiscussionFragment.OnFragmentInteractionListener mListener;


    public DiscussionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_discussion, container, false);
        initRecyclerView(v);
        return v;
    }

    private void initRecyclerView(View v) {
        RecyclerView items = (RecyclerView) v.findViewById(R.id.discussion_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        items.setHasFixedSize(true);
        items.setLayoutManager(linearLayoutManager);
        PostsAdapter adapter = mListener.getPostAdapter();
        items.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DiscussionFragment.OnFragmentInteractionListener) {
            mListener = (DiscussionFragment.OnFragmentInteractionListener) context;
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
        PostsAdapter getPostAdapter();
    }
}
