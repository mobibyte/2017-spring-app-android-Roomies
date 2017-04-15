package mobi.roomies.Interfaces;

import mobi.roomies.models.User;

/**
 * Created by HeyImRige on 4/14/2017.
 */

public class SingletonUser {
    private static SingletonUser instance = null;
    private static User theUser= null;




    public String getId() {
        return theUser.getId();
    }

    public void setId(String id) {
        theUser.setId(id);
    }

    public String getName() {
        return theUser.getName();
    }

    public void setName(String name) {
        theUser.setName(name);
    }

    public String getEmail() {
        return theUser.getEmail();
    }

    public void setEmail(String email) {
        theUser.setEmail(email);
    }

    public String getAvatarURL() {
        return theUser.getAvatarURL();
    }

    public void setAvatarURL(String avatarURL) {
        theUser.setAvatarURL(avatarURL);
    }

    protected SingletonUser() {
        // Exists only to defeat instantiation.
    }
    public static SingletonUser getInstance() {
        if(instance == null) {
            instance = new SingletonUser();
            theUser = new User();
        }
        return instance;
    }
}
