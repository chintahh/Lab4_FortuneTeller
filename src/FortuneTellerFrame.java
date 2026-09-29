import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private final JPanel mainPnl = new JPanel(new BorderLayout());
    private final JPanel topPnl = new JPanel();
    private final JPanel middlePnl = new JPanel(new BorderLayout());
    private final JPanel bottomPnl = new JPanel();

    private JLabel titleLbl;
    private JTextArea fortuneArea;
    private JScrollPane scroller;
    private JButton readBtn;
    private JButton quitBtn;

    private final Font titleFont = new Font("Serif", Font.BOLD | Font.ITALIC, 48);
    private final Font fortuneFont = new Font("SansSerif", Font.PLAIN, 20);
    private final Font buttonFont = new Font("SansSerif", Font.BOLD, 22);

    private final String[] fortunes = {
            "You will find a matching sock. Eventually.",
            "A closed mouth gathers no foot, but you'll try anyway.",
            "Your code will compile on the first try. Just kidding.",
            "You will soon be hungry. Then full. Then hungry again.",
            "Someone is thinking of you. It's probably your landlord.",
            "The Wi-Fi will be strong where you least need it.",
            "You will win an argument with your GPS. It will not care.",
            "Today's lucky number is whatever is on your parking ticket.",
            "A great opportunity awaits you behind that unread email.",
            "You will pet a dog soon. This is the best part of the prophecy.",
            "Beware of the off-by-one error. It is always closer than you think.",
            "Your future holds many meetings that could have been emails.",
            "You will remember the password right after you reset it.",
            "❄\uFE0E☟\uFE0E☼\uFE0E☜\uFE0E☜\uFE0E ☟\uFE0E☜\uFE0E☼\uFE0E⚐\uFE0E☜\uFE0E\uD83D\uDCA7\uFE0E \uD83D\uDD48\uFE0E✋\uFE0E☹\uFE0E☹\uFE0E ✌\uFE0E\uD83C\uDFF1\uFE0E\uD83C\uDFF1\uFE0E☜\uFE0E✌\uFE0E☼\uFE0E ❄\uFE0E⚐\uFE0E \uD83D\uDC4C\uFE0E✌\uFE0E☠\uFE0E✋\uFE0E\uD83D\uDCA7\uFE0E☟\uFE0E ❄\uFE0E☟\uFE0E☜\uFE0E ✌\uFE0E☠\uFE0E☝\uFE0E☜\uFE0E☹\uFE0E\uD83D\uDD6F\uFE0E\uD83D\uDCA7\uFE0E ☟\uFE0E☜\uFE0E✌\uFE0E✞\uFE0E☜\uFE0E☠\uFE0E"
    };

    private final Random rnd = new Random();
    private int lastIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createTopPanel();
        createMiddlePanel();
        createBottomPanel();

        mainPnl.add(topPnl, BorderLayout.NORTH);
        mainPnl.add(middlePnl, BorderLayout.CENTER);
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);
        add(mainPnl);
    }

    private void createTopPanel() {
        ImageIcon raw = new ImageIcon("fortuneteller.png");
        Image scaled = raw.getImage().getScaledInstance(100, -1, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaled);

        titleLbl = new JLabel("Fortune Teller", icon, SwingConstants.CENTER);
        titleLbl.setFont(titleFont);

        titleLbl.setVerticalTextPosition(SwingConstants.BOTTOM);
        titleLbl.setHorizontalTextPosition(SwingConstants.CENTER);
        topPnl.add(titleLbl);
    }

    private void createMiddlePanel() {
        fortuneArea = new JTextArea(10, 40);
        fortuneArea.setFont(fortuneFont);
        fortuneArea.setEditable(false);
        scroller = new JScrollPane(fortuneArea);
        middlePnl.add(scroller, BorderLayout.CENTER);
    }

    private void createBottomPanel() {
        bottomPnl.setLayout(new GridLayout(1, 2, 10, 10));

        readBtn = new JButton("Read My Fortune!");
        readBtn.setFont(buttonFont);
        readBtn.addActionListener((ActionEvent) -> showNextFortune());

        quitBtn = new JButton("Quit");
        quitBtn.setFont(buttonFont);
        quitBtn.addActionListener((ActionEvent) -> System.exit(0));

        bottomPnl.add(readBtn);
        bottomPnl.add(quitBtn);
    }

    private void showNextFortune() {
        int index;
        do {
            index = rnd.nextInt(fortunes.length);
        } while (index == lastIndex);
        lastIndex = index;

        fortuneArea.append(fortunes[index] + "\n");
        // Keep the newest fortune visible
        fortuneArea.setCaretPosition(fortuneArea.getDocument().getLength());
    }
}