package mobi.roomies.Interfaces;

/**
 * Created by HeyImRige on 4/14/2017.
 */

public class SingletonUser {
    private static SingletonUser instance = null;


    String id;
    String name;
    String email;
    String avatarURL;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    protected SingletonUser() {
        // Exists only to defeat instantiation.
    }
    public static SingletonUser getInstance() {
        if(instance == null) {
            instance = new SingletonUser();
        }
        return instance;
    }
}
