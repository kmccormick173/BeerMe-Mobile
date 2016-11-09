package com.example.kylemccormick.beerme.CellAdapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import android.widget.TextView;

import com.example.kylemccormick.beerme.Interacts;
import com.example.kylemccormick.beerme.R;

/**
 * Created by kylemccormick on 9/18/16.
 */
public class InteractionCellAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Interacts> mInteractions;

    public InteractionCellAdapter(Context context, ArrayList<Interacts> interactions){

        mContext = context;
        mInteractions = interactions;
    }

    @Override
    public int getCount() {
        return mInteractions.size();
    }

    @Override
    public Object getItem(int position) {
        return mInteractions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.interaction_custom_cell, null);
            holder = new ViewHolder();
            holder.beerIcon = (ImageView) convertView.findViewById(R.id.beerIcon);
            holder.otherUser = (TextView) convertView.findViewById(R.id.otherUser);
            holder.status = (TextView) convertView.findViewById(R.id.beerStatus);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Interacts interaction = mInteractions.get(position);

        holder.beerIcon.setImageResource(interaction.getIconId());
        holder.otherUser.setText(interaction.getName());
        holder.status.setText(interaction.getStatus());
        return convertView;

    }

    private static class ViewHolder {
        ImageView beerIcon;
        TextView otherUser;
        TextView status;

    }
}

