package com.example.kylemccormick.beerme;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.kylemccormick.beerme.CellAdapters.FindFriendsCellAdapter;
import com.example.kylemccormick.beerme.CellAdapters.SendBeerCellAdapter;

import java.util.ArrayList;

public class Find_Friends extends AppCompatActivity {

    private ArrayList<String> friends = new ArrayList<String>();


    //ListView listView;
    public FindFriendsCellAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find__friends);

        final ListView listView = (ListView) findViewById(android.R.id.list);

        /*
        "request sent""photo received""beer approved""request received""photo sent""beer sent""proof denied"
         */


        //friends.add("Joe Schmo");
        friends.add("Bob Bobyyy");
        friends.add("Sue Susann");
        friends.add("Sam Sammyb");
        friends.add("Sally Sallgal");

        //ListView listView = getListView();
        adapter = new FindFriendsCellAdapter(this,friends);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                                                //startRequest();
                                            }
                                        }
        );


    }



    public void goToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void goToFindFriends() {
        Intent intent = new Intent(this, Find_Friends.class);
        startActivity(intent);
        finish();
    }

    public void goToSettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
        finish();
    }

    public void goToCamera(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(cameraIntent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);

        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }


        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.send_beer:
                goToHome();
                return true;
            case R.id.find_friends:
                goToFindFriends();
                return true;
            case R.id.settings:
                goToSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
