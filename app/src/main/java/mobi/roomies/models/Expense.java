package mobi.roomies.models;

/**
 * Created by Kevin on 11/4/2016.
 */

public class Expense {

    //private String title, type, owedToUserName, owedFromUserName, amount, emoji;

    //temp to make it work
    private String amount, title, username, type, emoji, owedFrom;

    public Expense() {
    }

    public String getOwedFrom() {
        return owedFrom;
    }

    public void setOwedFrom(String owedFrom) {
        this.owedFrom = owedFrom;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
