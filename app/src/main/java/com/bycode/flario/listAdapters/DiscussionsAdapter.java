package com.bycode.flario.listAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bycode.flario.Presenters.DiscussionPresenter;
import com.bycode.flario.Presenters.LatestDiscussionsPresenter;
import com.bycode.flario.R;
import com.bycode.flario.WebsiteActivity;
import com.bycode.flario.fragments.website.DiscussionFragment;
import com.bycode.flario.fragments.website.DiscussionsFragment;
import com.bycode.flario.models.DiscussionAttributes;
import com.bycode.flario.models.localDatabase.Website;

import java.util.ArrayList;

/**
 * Created by michal on 19.04.2017.
 */

public class DiscussionsAdapter extends RecyclerView.Adapter<DiscussionsAdapter.ViewHolder> {
    private ArrayList<DiscussionAttributes> discussions = new ArrayList<>();
    private WebsiteActivity activity;
    private Website website;

    public DiscussionsAdapter(WebsiteActivity websiteActivity, Website website) {
        this.activity = websiteActivity;
        this.website = website;

    }

    @Override
    public DiscussionsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.discuss_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DiscussionsAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.tv_discuss_title.setText(discussions.get(i).getTitle());
        viewHolder.tv_discuss_comments.setText(discussions.get(i).getCommentsCount().toString());
        viewHolder.tv_discuss_datetime.setText(discussions.get(i).getLastTime());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DiscussionPresenter discussionPresenter = new DiscussionPresenter(activity, activity.getApplicationContext());
                discussionPresenter.getDiscussion(website.getAddress(), discussions.get(i).getId());

                android.support.v4.app.FragmentManager fragmentManager = activity.getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                DiscussionFragment fragment = new DiscussionFragment();

                fragmentTransaction.replace(R.id.relativelayout_for_fragment, fragment);
                fragmentTransaction.commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return discussions != null ? discussions.size() : 0;
    }

    public void addDiscussion(DiscussionAttributes discussionAttributes) {
        discussions.add(discussionAttributes);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_discuss_title;
        private TextView tv_discuss_comments;
        private TextView tv_discuss_datetime;

        ViewHolder(View view) {
            super(view);

            tv_discuss_title = (TextView)view.findViewById(R.id.tv_discuss_title);
            tv_discuss_comments = (TextView)view.findViewById(R.id.tv_discuss_comments);
            tv_discuss_datetime = (TextView)view.findViewById(R.id.tv_discuss_datetime);
        }
    }
}
