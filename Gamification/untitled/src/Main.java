import java.util.ArrayList;

public class Main {
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<String> quests = new ArrayList<String>();
    private ArrayList<String> answers = new ArrayList<String>();
    public static void main(String[] args) {
        Game G= new Game();

       /* Player P = new Player("cosmin",12);

        G.addPlayer(P);

        Player P2 = new Player("ilea",13);
        G.addPlayer(P2);
        G.addQuest("1+1","2");
        G.addQuest("2+2","4");
        G.addQuest("2+3","5");
        G.addQuest("3+3","6");
        G.addQuest("4+3","7");
        G.addQuest("4+4","8");
*/

        Main app = new Main();
        app.players.addAll(G.getPlayers());
        app.quests.addAll(G.getQuests());
        app.answers.addAll(G.getAnswers());
      //  G.writeBinaryData("data.bin",app.players,app.quests,app.answers);


        Game.readBinaryData("data.bin",app.players,app.quests,app.answers);
        G.setPlayers(app.players);
        G.setAnswers(app.answers);
        G.setQuests(app.quests);
        new Frame(G);

    }
}