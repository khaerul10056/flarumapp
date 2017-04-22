package com.bycode.flarum.listAdapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bycode.flarum.R;
import com.bycode.flarum.models.DiscussionAttributes;

import java.util.ArrayList;

/**
 * Created by michal on 19.04.2017.
 */

public class DiscussionsAdapter extends RecyclerView.Adapter<DiscussionsAdapter.ViewHolder> {
    private ArrayList<DiscussionAttributes> discussions = new ArrayList<>();

    public DiscussionsAdapter() {}

    @Override
    public DiscussionsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.discuss_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DiscussionsAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tv_country.setText(discussions.get(i).getTitle());
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
        private TextView tv_country;
        ViewHolder(View view) {
            super(view);

            tv_country = (TextView)view.findViewById(R.id.tv_country);
        }
    }
}
