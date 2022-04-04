import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageViewer {
    public static void main(String[] args) {

        JFrame frame = new ImageViewerFrame();
        frame.setTitle("Gallery");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class ImageViewerFrame extends JFrame {
    JLabel label;
    JFileChooser chooser;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    public ImageViewerFrame(){
        setSize(500, 500);

        label = new JLabel();
        add(label);

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu = new JMenu("File");
        menuBar.add(menu);

        menuItem = new JMenuItem("Open");
        menu.add(menuItem);
        menuItem.addActionListener(e -> {

            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });


    }
}
