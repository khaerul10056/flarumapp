package com.bycode.flario.listAdapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bycode.flario.DiscussionsActivity;
import com.bycode.flario.R;
import com.bycode.flario.fragments.WebsitesFragment;
import com.bycode.flario.models.localDatabase.Website;

import java.util.ArrayList;
import java.util.List;

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
        viewHolder.tv_website_title.setText(websites.get(i).getTitle());
        viewHolder.bt_remove.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String address = websites.get(i).getAddress();
                List<Website> websitesLocale = Website.find(Website.class, "address = ?", address);

                for (Website website : websitesLocale) {
                    Website.delete(website);
                }
                removeWebsite(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return websites != null ? websites.size() : 0;
    }

    public void addWebsite(Website website) {
        websites.add(website);
        notifyDataSetChanged();
    }

    public void removeWebsite(int website_position) {
        websites.remove(website_position);
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_website_address;
        private TextView tv_website_title;
        private Button bt_remove;

        ViewHolder(View view) {
            super(view);
            tv_website_address = (TextView)view.findViewById(R.id.tv_website_addreess);
            tv_website_title = (TextView)view.findViewById(R.id.tv_website_title);
            bt_remove = (Button)view.findViewById(R.id.bt_remove);
        }
    }
}
