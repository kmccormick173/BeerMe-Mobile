package com.example.kylemccormick.beerme.CellAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.kylemccormick.beerme.Find_Friends;
import com.example.kylemccormick.beerme.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylemccormick on 10/1/16.
 */
public class FindFriendsCellAdapter extends BaseAdapter implements Filterable{
    private Context mContext;
    private ArrayList<String> mFriends;
    private ArrayList<String> mmFriends;

    public FindFriendsCellAdapter(Context context, ArrayList<String> friends){

        mContext = context;
        mFriends = friends;
        mmFriends = friends;

    }

    @Override
    public int getCount() {
        return mmFriends.size();
    }

    @Override
    public Object getItem(int position) {
        return mmFriends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.addfriend_custom_cell, null);
            holder = new ViewHolder();
            holder.contact = (TextView) convertView.findViewById(R.id.contact);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String friend = mmFriends.get(position);
        holder.contact.setText(friend);
        return convertView;

    }

    private static class ViewHolder {

        TextView contact;

    }



    ContactsFilter mContactsFilter;

    public Filter getFilter() {
        if (mContactsFilter == null)
            mContactsFilter = new ContactsFilter();

        return mContactsFilter;
    }

    private class ContactsFilter extends Filter {


        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // Create a FilterResults object
            FilterResults results = new FilterResults();

            // If the constraint (search string/pattern) is null
            // or its length is 0, i.e., its empty then
            // we just set the `values` property to the
            // original contacts list which contains all of them
            if (constraint == null || constraint.length() == 0) {
                results.values = mFriends;
                results.count = mFriends.size();
            }
            else {
                // Some search copnstraint has been passed
                // so let's filter accordingly
                ArrayList<String> filteredContacts = new ArrayList<String>();

                // We'll go through all the contacts and see
                // if they contain the supplied string
                for (String c : mFriends) {
                    if (c.toUpperCase().contains( constraint.toString().toUpperCase() )) {
                        // if `contains` == true then add it
                        // to our filtered list
                        filteredContacts.add(c);
                    }
                }

                // Finally set the filtered values and size/count
                results.values = filteredContacts;
                results.count = filteredContacts.size();
            }

            // Return our FilterResults object
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            System.out.println(mmFriends.toString());
            mmFriends = (ArrayList<String>) results.values;
            System.out.println(mmFriends.toString());
            notifyDataSetChanged();

        }


    }

}
