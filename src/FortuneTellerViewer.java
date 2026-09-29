import javax.swing.*;
import java.awt.*;

public class FortuneTellerViewer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();

            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            int width = screenSize.width * 3 / 4;
            int height = screenSize.height * 3 / 4;

            frame.setSize(width, height);
            frame.setLocation((screenSize.width - width) / 2,
                    (screenSize.height - height) / 2);
            frame.setVisible(true);
        });
    }
}