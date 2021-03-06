package com.bycode.flario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bycode.flario.Presenters.DiscussionPresenter;
import com.bycode.flario.Presenters.LatestDiscussionsPresenter;
import com.bycode.flario.fragments.website.DiscussionFragment;
import com.bycode.flario.fragments.website.DiscussionsFragment;
import com.bycode.flario.listAdapters.DiscussionsAdapter;
import com.bycode.flario.listAdapters.PostsAdapter;
import com.bycode.flario.models.Discussion;
import com.bycode.flario.models.DiscussionAttributes;
import com.bycode.flario.models.DiscussionIncluded;
import com.bycode.flario.models.DiscussionResponse;
import com.bycode.flario.models.DiscussionsResponse;
import com.bycode.flario.models.localDatabase.Website;

import java.util.List;

public class WebsiteActivity extends AppCompatActivity implements
        DiscussionsFragment.OnFragmentInteractionListener,
        DiscussionFragment.OnFragmentInteractionListener,
        LatestDiscussionsPresenter.LatestDiscussionsPresenterListener,
        DiscussionPresenter.DiscussionPresenterListener {

    private DiscussionsAdapter discussionsAdapter;
    private Website website = new Website();
    private PostsAdapter postsAdapter = new PostsAdapter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        Bundle b = getIntent().getExtras();
        String title = b.getString("title");
        String address = b.getString("address");

        setTitle(title);

        LatestDiscussionsPresenter latestDiscussionsPresenter = new LatestDiscussionsPresenter(this, this);
        latestDiscussionsPresenter.getDiscussions(address);

        List<Website> websitesLocale = Website.find(Website.class, "address = ?", address);

        this.website = websitesLocale.get(0);

        discussionsAdapter = new DiscussionsAdapter(this, getWebsite());

        android.support.v4.app.FragmentManager fragmentManager = WebsiteActivity.this.getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        DiscussionsFragment fragment = new DiscussionsFragment();

        fragmentTransaction.add(R.id.relativelayout_for_fragment, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void latestDiscussionsReady(DiscussionsResponse discussionsResponse) {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_discussions);
        progressBar.setVisibility(View.GONE);

        for (Discussion discussion : discussionsResponse.getData()) {
            DiscussionAttributes discussionAttributes = discussion.getDiscussionAttributes();
            discussionAttributes.setId(Integer.parseInt(discussion.getId()));
            discussionsAdapter.addDiscussion(discussionAttributes);
        }
    }


    @Override
    public Website getWebsite() {
        return website;
    }

    @Override
    public DiscussionsAdapter getDiscussionsAdapter() {
        return discussionsAdapter;
    }

    @Override
    public void showToast(int text_id, int length) {
        Toast.makeText(this, getResources().getText(text_id), length).show();
    }

    @Override
    public PostsAdapter getPostAdapter() {
        return postsAdapter;
    }

    @Override
    public void discussionReady(DiscussionResponse discussionResponse) {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_discussion);
        progressBar.setVisibility(View.GONE);

        for (DiscussionIncluded discussionIncluded : discussionResponse.getIncluded()) {
            postsAdapter.addPost(discussionIncluded);
        }
    }
}
