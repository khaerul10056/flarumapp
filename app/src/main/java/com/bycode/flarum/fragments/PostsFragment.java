package com.bycode.flarum.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bycode.flarum.Presenters.LatestDiscussionsPresenter;
import com.bycode.flarum.R;
import com.bycode.flarum.listAdapters.DiscussionsAdapter;
import com.bycode.flarum.models.Post;
import com.bycode.flarum.models.Posts;


public class PostsFragment extends Fragment {

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }



}
