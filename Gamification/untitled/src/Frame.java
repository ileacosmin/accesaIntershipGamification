import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Frame{
    private JTextField tf1,tf2,tf3;
    private JButton b1,b2;
    private JFrame f= new JFrame("LOGIN PAGE");
    private JFrame f2 = new JFrame();
    private Game G;
    public Frame(Game Ga) {
        this.G=Ga;

        JLabel jlabel = new JLabel("Please enter the username: ");
        jlabel.setBounds(10,-40,200,100);
        jlabel.setOpaque(true);
        f.add(jlabel);

        tf1=new JTextField();
        tf1.setBounds(50,70,150,20);

        b1=new JButton("login");
        b1.setBounds(100,200,100,30);
        b1.addActionListener(this::actionPerformed);

        f.add(tf1);
        f.add(b1);
        f.setSize(300,300);
        f.setResizable(false);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void Frame2() {

        JFrame frame2 = new JFrame("Gamification");
        frame2.setSize(600, 200);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold components
        JPanel panel2 = new JPanel();

        // Add a label
        JLabel label2 = new JLabel();
        panel2.add(label2);
        label2.setText(G.getQuests().get(0));

        // Add a text field
        JTextField textField2 = new JTextField(20);
        panel2.add(textField2);

        // Add a submit button
        JButton submitButton2 = new JButton("Submit");
        panel2.add(submitButton2);
        submitButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check the answer
                String answer = textField2.getText();

                if(G.checkAnswer(0, answer)) {
                    System.out.println("Correct");

                    // Increase the player's token count
                    Player player = G.getPlayerByName(tf1.getText());
                    int nrTokens = player.getTokens() + 1;
                    player.setTokens(nrTokens);
                    G.updatePlayer(player, tf1.getText());

                    // Move the current question to the back of the list
                    String currentQuestion = G.getQuests().remove(0);
                    G.getQuests().add(currentQuestion);
                    String currentAnswer = G.getAnswers().remove(0);
                    G.getAnswers().add(currentAnswer);

                    // Update the label with the next string
                    label2.setText(G.getQuests().get(0));

                   // G.showPlayers();
                } else {
                    System.out.println("Incorrect");
                    System.out.println(G.GetAnswerByIndex(0));
                }
            }
        });

        // Add a skip button
        JButton skipButton2 = new JButton("Skip");
        panel2.add(skipButton2);
        skipButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move the current question to the back of the list
                String currentQuestion = G.getQuests().remove(0);
                G.getQuests().add(currentQuestion);
                String currentAnswer = G.getAnswers().remove(0);
                G.getAnswers().add(currentAnswer);

                // Update the label with the next string
                label2.setText(G.getQuests().get(0));
            }
        });

        // Add a leaderboard button
        JButton leaderboardButton = new JButton("Leaderboard");
        panel2.add(leaderboardButton);
        leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame3();
            }
        });

        // Add the panel to the frame
        frame2.add(panel2);

        // Set the frame to be visible
        frame2.setVisible(true);

        frame2.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("fereastra inchisa");
                G.writeBinaryData("data.bin", G.getPlayers(), G.getQuests(), G.getAnswers());
            }
        });
    }
    public void Frame3(){
        G.sortPlayersByTokens();
        JFrame frame3 = new JFrame("Leaderboard");
        frame3.setSize(600, 200);
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame3.setVisible(true);
        // Create a panel to hold components
        JPanel panel2 = new JPanel();
        panel2.setVisible(true);
        // Add a label
        JTextArea textArea=new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame3.add(scrollPane);
        String leaderboard= new String();

        for(int i=0; i<G.getPlayers().size();i++){
            textArea.append((i+1) + ". " + G.getPlayers().get(i).getUsername() + " " + G.getPlayers().get(i).getTokens() + "\n");
        }
        System.out.println(leaderboard);

    }
    public void actionPerformed(ActionEvent e){
        String s1=tf1.getText();

        if(e.getSource()==b1)
            if(this.G.searchPlayer(s1)){
                f.dispose();
                Frame2();
        }else System.out.println("nu este");
    }

}
