package mobi.roomies.Interfaces;

/**
 * Created by HeyImRige on 4/14/2017.
 */

public class SingletonGroup {
    private static SingletonGroup instance = null;


    String id;
    String joinKey;
    String members;



    protected SingletonGroup(){

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

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }
}
