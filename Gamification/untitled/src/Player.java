import java.util.ArrayList;
import java.io.Serializable;

public class Player implements Serializable{
    private String username;
    private int tokens;
    private ArrayList<String> Badges = new ArrayList<String>();

    public String getUsername() {
        return username;
    }

    public int getTokens() {
        return tokens;
    }

    @Override
    public String toString() {
        return "username='" + username + '\'' +
                ", tokens=" + tokens +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public void setBadges(ArrayList<String> badges) {
        Badges = badges;
    }

    public Player(String username, int tokens) {
        this.username = username;
        this.tokens = tokens;
    }
}
