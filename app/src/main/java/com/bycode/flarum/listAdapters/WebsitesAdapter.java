package com.bycode.flarum.listAdapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bycode.flarum.DiscussionsActivity;
import com.bycode.flarum.R;
import com.bycode.flarum.models.localDatabase.Website;

import java.util.ArrayList;

/**
 * Created by michal on 19.04.2017.
 */

public class WebsitesAdapter extends RecyclerView.Adapter<WebsitesAdapter.ViewHolder> {
    private ArrayList<Website> websites = new ArrayList<>();

    public WebsitesAdapter() {}

    @Override
    public WebsitesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.website_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final WebsitesAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DiscussionsActivity.class);
                Bundle b = new Bundle();
                b.putString("address", websites.get(i).getAddress());
                intent.putExtras(b);
                v.getContext().startActivity(intent);

            };
        });

        viewHolder.tv_website_address.setText(websites.get(i).getAddress());
    }

    @Override
    public int getItemCount() {
        return websites != null ? websites.size() : 0;
    }

    public void addWebsite(Website website) {
        websites.add(website);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_website_address;
        ViewHolder(View view) {
            super(view);
            tv_website_address = (TextView)view.findViewById(R.id.tv_website_addreess);
        }
    }
}
