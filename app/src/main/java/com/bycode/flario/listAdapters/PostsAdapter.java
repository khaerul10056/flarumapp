package com.bycode.flario.listAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bycode.flario.R;
import com.bycode.flario.WebsiteActivity;
import com.bycode.flario.fragments.website.DiscussionFragment;
import com.bycode.flario.models.DiscussionAttributes;
import com.bycode.flario.models.DiscussionIncluded;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by michal on 25.04.2017.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    private ArrayList<DiscussionIncluded> discussionIncluded = new ArrayList<>();
    private WebsiteActivity activity;

    public PostsAdapter(WebsiteActivity websiteActivity) {
        activity = websiteActivity;

    }

    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tv_post.setHtml(discussionIncluded.get(i).getAttributes().getContentHtml());
//        viewHolder.tv_discuss_comments.setText(discussions.get(i).getCommentsCount().toString());
//        viewHolder.tv_discuss_datetime.setText(discussions.get(i).getLastTime());
    }

    @Override
    public int getItemCount() {
        return discussionIncluded != null ? discussionIncluded.size() : 0;
    }

    public void addPost(DiscussionIncluded discussionIncluded) {
        if (Objects.equals(discussionIncluded.getType(), "posts") && discussionIncluded.getAttributes().getContentHtml() != null) {
            this.discussionIncluded.add(discussionIncluded);
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private HtmlTextView tv_post;

        ViewHolder(View view) {
            super(view);

            tv_post = (HtmlTextView)view.findViewById(R.id.tv_post);
        }
    }
}


