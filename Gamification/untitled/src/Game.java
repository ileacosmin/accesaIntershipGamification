import java.io.*;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Comparator;

public class Game {

    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<String> quests = new ArrayList<String>();
    private ArrayList<String> answers = new ArrayList<String>();

    public void addQuest(String quest, String answer) {
        this.quests.add(quest);
        this.answers.add(answer);
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setQuests(ArrayList<String> quests) {
        this.quests = quests;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void showPlayers(){
        for(int i=0;i<players.size();i++)
            System.out.println(players.get(i).getUsername()+" "+players.get(i).getTokens());
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<String> getQuests() {
        return quests;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public String GetUsernameByIndex(int i){
        return players.get(i).getUsername();
    }
    public String GetQuestsByIndex(int i){
        return quests.get(i);
    }
    public String GetAnswerByIndex(int i){
        return answers.get(i);
    }
    public Player getPlayerByName(String username) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getUsername().equals(username)) {
                return players.get(i);
            }
        }
        return null;
    }
    Comparator<Player> byTokens = new Comparator<Player>() {
        public int compare(Player p1, Player p2) {
            return p2.getTokens() - p1.getTokens();
        }
    };
    public void sortPlayersByTokens(){
        players.sort(byTokens);
    }
    public void updatePlayer(Player player,String username){
        for(int i=0;i<players.size();i++){
            if(players.get(i).getUsername().equals(username)){
                players.set(i,player);
            }
        }
    }
    public boolean searchPlayer(String username){
        for(int i=0;i<players.size();i++){
            if(players.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    public boolean checkAnswer(int index, String answer){
        if(answers.get(index).equals(answer))
            return true;
        else return false;
    }
    public void writeBinaryData(String fileName, ArrayList<Player> players, ArrayList<String> quests, ArrayList<String> answers) {
        try {
            // Create a new ObjectOutputStream with a FileOutputStream
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));

            // Write the ArrayLists to the ObjectOutputStream
            outputStream.writeObject(players);
            outputStream.writeObject(quests);
            outputStream.writeObject(answers);

            // Close the ObjectOutputStream
            outputStream.close();

            System.out.println("Binary file saved successfully.");
        } catch (Exception ex) {
            System.out.println("Error writing binary file: " + ex.getMessage());
        }
    }
    public static void readBinaryData(String fileName, ArrayList<Player> players, ArrayList<String> quests, ArrayList<String> answers) {

        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {

            players.addAll((ArrayList<Player>) ois.readObject());
            quests.addAll((ArrayList<String>) ois.readObject());
            answers.addAll((ArrayList<String>) ois.readObject());

            System.out.println("Binary data has been read from the file successfully.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    // Add getters and setters for the ArrayLists
}


