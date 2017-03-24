package mobi.roomies.models;

/**
 * Created by HeyImRige on 12/2/2016.
 */

public class ChatItem {


    public String name;
    public String text;


    public ChatItem(){

    }

    public ChatItem(String name, String text){
        this.name = name;
        this.text = text;
    }

    public String GetText(){
        return name;
    }
}
