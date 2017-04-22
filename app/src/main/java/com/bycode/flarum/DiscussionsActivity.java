package com.bycode.flarum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bycode.flarum.Presenters.LatestDiscussionsPresenter;
import com.bycode.flarum.listAdapters.DiscussionsAdapter;
import com.bycode.flarum.models.Discussion;
import com.bycode.flarum.models.DiscussionsResponse;

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
    public void latestDiscussionsReady(DiscussionsResponse discussionsResponse) {
        for (Discussion discussion : discussionsResponse.getData()) {
            adapter.addDiscussion(discussion.getDiscussionAttributes());
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
