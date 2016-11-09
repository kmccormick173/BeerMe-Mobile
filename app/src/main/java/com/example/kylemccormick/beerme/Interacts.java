package com.example.kylemccormick.beerme;

import android.media.Image;

/**
 * Created by kylemccormick on 9/18/16.
 */
public class Interacts {

    String name;
    String status;
    String iconName;
    int iconId;


    public int getIconId() {

        if(iconName.equals("request sent")) {
            iconId = R.drawable.quarterfulltwo;
        } else if (iconName.equals("photo received")) {
            iconId = R.drawable.threequarterfulltwo;
        } else if (iconName.equals("beer approved")) {
            iconId = R.drawable.fullbeertwo;
        } else if (iconName.equals("request received")) {
            iconId = R.drawable.quarterfull;
        } else if (iconName.equals("photo sent")) {
            iconId = R.drawable.threequarterfull;
        } else if (iconName.equals("beer sent")) {
            iconId = R.drawable.fullbeer;
        } else if (iconName.equals("proof denied")) {
            iconId = R.drawable.empty;
        }
        return iconId;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String toString() {
        String niceOutput = "Name: " + getName() + "Status: " + getStatus() + "Get Id: " + getIconName();
        return niceOutput;
    }
}
