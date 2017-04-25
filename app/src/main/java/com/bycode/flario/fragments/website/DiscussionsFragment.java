package com.bycode.flario.fragments.website;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

        FloatingActionButton floatingActionButton = (FloatingActionButton) v.findViewById(R.id.add_discussion_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener.getWebsite().getLogged()) {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    CreateDiscussionFragment createDiscussionFragment = new CreateDiscussionFragment();
                    ft.replace(R.id.relativelayout_for_fragment, createDiscussionFragment);
                } else {
                    mListener.showToast(R.string.not_logged, Toast.LENGTH_SHORT);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    LoginWebsiteDialogFragment addWebsiteDialogFragment = LoginWebsiteDialogFragment.newInstance();
                    addWebsiteDialogFragment.show(ft, "TEST");
                }

            }
        });

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
        void showToast(int text_id, int length);
    }
}
