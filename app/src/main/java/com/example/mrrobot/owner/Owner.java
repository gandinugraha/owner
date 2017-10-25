package com.example.mrrobot.owner;

/**
 * Created by Mr Robot on 10/19/2017.
 */

public class Owner {
    private String name,address,user,email,profile_pic,response;

    public Owner(String sName, String sAddress, String mUser, String sEmail, String profile_pic){
        this.name = sName;
        this.address = sAddress;
        this.email = sEmail;
        this.user = mUser;
        this.profile_pic = profile_pic;

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String geUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public String getResponse() {
        return response;
    }
}
