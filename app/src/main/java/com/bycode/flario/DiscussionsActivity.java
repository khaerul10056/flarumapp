package com.bycode.flario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.bycode.flario.Presenters.LatestDiscussionsPresenter;
import com.bycode.flario.listAdapters.DiscussionsAdapter;
import com.bycode.flario.models.Discussion;
import com.bycode.flario.models.DiscussionsResponse;

public class DiscussionsActivity extends AppCompatActivity implements LatestDiscussionsPresenter.LatestDiscussionsPresenterListener {
    private DiscussionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussions);

        Bundle b = getIntent().getExtras();
        String title = b.getString("title");
        String address = b.getString("address");

        setTitle(title);
        initRecyclerView();

        LatestDiscussionsPresenter latestDiscussionsPresenter = new LatestDiscussionsPresenter(this, this);
        latestDiscussionsPresenter.getDiscussions(address);

    }

    @Override
    public void latestDiscussionsReady(DiscussionsResponse discussionsResponse) {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_discussions);
        progressBar.setVisibility(View.GONE);

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
