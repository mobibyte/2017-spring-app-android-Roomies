package mobi.roomies.models;

/**
 * Created by Kevin on 11/4/2016.
 */

public class Expense {

    private String title, type, owedToUserName, owedFromUserName, amount, emoji;


    public Expense(String title, String type, String owedToUserName, String owedFromUserName, String amount, String emoji) {
        this.title = title;
        this.type = type;
        this.owedToUserName = owedToUserName;
        this.owedFromUserName = owedFromUserName;
        this.amount = amount;
        this.emoji = emoji;
    }

    public Expense(){

    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setType(String title) {
        this.type = title;
    }

    public String getType() {
        return type;
    }


    public String getOwedToUserName() {
        return owedToUserName;
    }

    public void setOwedToUserName(String owedToUserName) {
        this.owedToUserName = owedToUserName;
    }

    public String getOwedFromUserName() {
        return owedFromUserName;
    }

    public void setOwedFromUserName(String owedFromUserName) {
        this.owedFromUserName = owedFromUserName;
    }

    public String toString(){
        return title;
    }
}
