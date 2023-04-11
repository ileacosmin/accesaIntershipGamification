import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Main {
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<String> quests = new ArrayList<String>();
    private ArrayList<String> answers = new ArrayList<String>();

    public static void main(String[] args) {
        Game G= new Game();
/*
        Player P = new Player("cosmin",12);

        G.addPlayer(P);

        Player P2 = new Player("ilea",13);
        G.addPlayer(P2);
        G.addQuest("What is the capital of France?","Paris");
        G.addQuest("Who wrote Romeo and Juliet?","Shakespeare");
        G.addQuest("What is the name of the first man on the moon?","Armstrong");
        G.addQuest("What is the largest planet in our solar system? ","Jupiter");
        G.addQuest("What is the name of the fastest land animal?","Cheetah");
        G.addQuest("What is the largest ocean on Earth?","Pacific");
        G.addQuest("What is the smallest country in the world?","Vatican");
        G.addQuest("What is the most populated country in the world? ","China");
        G.addQuest("What is the highest mountain in the world?","Everest");
        G.addQuest("What is the chemical symbol for gold? ","Au");
       */
        Main app = new Main();
        app.players.addAll(G.getPlayers());
        app.quests.addAll(G.getQuests());
        app.answers.addAll(G.getAnswers());

        Game.readBinaryData("data.bin", app.players, app.quests, app.answers);
        G.setPlayers(app.players);
        G.setAnswers(app.answers);
        G.setQuests(app.quests);

        Frame frame = new Frame(G);

    }
}