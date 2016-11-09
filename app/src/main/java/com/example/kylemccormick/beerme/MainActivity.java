package com.example.kylemccormick.beerme;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kylemccormick.beerme.CellAdapters.InteractionCellAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Interacts> interacts = new ArrayList<Interacts>();
    //ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final ListView listView = (ListView) findViewById(android.R.id.list);

        /*
        "request sent""photo received""beer approved""request received""photo sent""beer sent""proof denied"
         */

        Interacts interact1 = new Interacts();
        interact1.setIconName("request sent");
        interact1.setName("Kyle McCormick");
        interact1.setStatus("Beer Request Sent");
        interacts.add(interact1);


        Interacts interact2 = new Interacts();
        interact2.setIconName("photo received");
        interact2.setName("Anjali Patel");
        interact2.setStatus("Photo Pending");
        interacts.add(interact2);

        Interacts interact3 = new Interacts();
        interact3.setIconName("request received");
        interact3.setName("Tim Woods");
        interact3.setStatus("Beer Request Received");
        interacts.add(interact3);

        Interacts interact4 = new Interacts();
        interact4.setIconName("photo sent");
        interact4.setName("Kyle Murray");
        interact4.setStatus("Photo Sent");
        interacts.add(interact4);

        Interacts interact5 = new Interacts();
        interact5.setIconName("beer approved");
        interact5.setName("Anjali Patel");
        interact5.setStatus("Beer Approved");
        interacts.add(interact5);

        Interacts interact6 = new Interacts();
        interact6.setIconName("beer sent");
        interact6.setName("Tim Woods");
        interact6.setStatus("Beer Sent");
        interacts.add(interact6);

        Interacts interact7 = new Interacts();
        interact7.setIconName("proof denied");
        interact7.setName("Kyle Murray");
        interact7.setStatus("Get a Beer");
        interacts.add(interact7);


        //ListView listView = getListView();
        InteractionCellAdapter adapter = new InteractionCellAdapter(this, interacts);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                                                Interacts interact = (Interacts) arg0.getAdapter().getItem(position);
                                                String status = interact.getStatus();
                                                if(status == "Beer Request Sent") {
                                                    goToCamera();
                                                } else if(status == "Photo Pending") {
                                                    goToImage();
                                                }
                                            }
                                        }
        );

    }

    public void goToSendBeer() {
        Intent intent = new Intent(this, Send_Beer.class);
        startActivity(intent);
    }

    public void goToFindFriends() {
        Intent intent = new Intent(this, Find_Friends.class);
        startActivity(intent);
    }

    public void goToSettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void goToCamera(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(cameraIntent);
    }

    public void goToImage(){
        Intent imageIntent = new Intent(this, PhotoViewerActivity.class);
        startActivity(imageIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.send_beer:
                goToSendBeer();
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
