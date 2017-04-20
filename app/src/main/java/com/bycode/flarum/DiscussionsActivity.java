package com.bycode.flarum;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bycode.flarum.Presenters.LatestDiscussionsPresenter;
import com.bycode.flarum.listAdapters.DiscussionsAdapter;
import com.bycode.flarum.models.Post;
import com.bycode.flarum.models.Posts;

public class DiscussionsActivity extends AppCompatActivity implements LatestDiscussionsPresenter.LatestDiscussionsPresenterListener {
    private DiscussionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussions);

        Bundle b = getIntent().getExtras();
        String address = b.getString("address");
        setTitle(address);
        initRecyclerView();

        LatestDiscussionsPresenter latestDiscussionsPresenter = new LatestDiscussionsPresenter(this, this);
        latestDiscussionsPresenter.getDiscussions(address);

    }

    @Override
    public void latestDiscussionsReady(Posts posts) {
        for (Post post : posts.getData()) {
            Log.e("aa", post.getAttributes().toString());
            adapter.addDiscussion(post.getAttributes());
        }
    }

    private void initRecyclerView() {
        RecyclerView items = (RecyclerView) findViewById(R.id.discussions_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        items.setHasFixedSize(true);
        items.setLayoutManager(linearLayoutManager);
        adapter = new DiscussionsAdapter();
        items.setAdapter(adapter);
    }
}
