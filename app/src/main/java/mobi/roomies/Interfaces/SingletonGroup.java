package mobi.roomies.Interfaces;

import java.util.ArrayList;

import mobi.roomies.models.User;

/**
 * Created by HeyImRige on 4/14/2017.
 */

public class SingletonGroup {
    private static SingletonGroup instance = null;


    String id;
    String joinKey;
    private ArrayList<User> members;



    protected SingletonGroup(){
        members = new ArrayList<User>();
    }
    public static SingletonGroup getInstance(){
        if (instance == null){
            instance = new SingletonGroup();


        }
        return instance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoinKey() {
        return joinKey;
    }

    public void setJoinKey(String joinKey) {
        this.joinKey = joinKey;
    }


    public ArrayList<User> getUserList(){
        return members;
    }

}
