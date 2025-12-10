import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ImageViewer extends JFrame
{
    private JLabel imageLabel;
    private JScrollPane scrollPane;

    public ImageViewer()
    {
        setTitle("Aplikasi Image Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        makeMenuBar();

        imageLabel = new JLabel("Silakan buka file gambar dari menu File > Open", SwingConstants.CENTER);
        scrollPane = new JScrollPane(imageLabel);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void makeMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");

        openItem.addActionListener(e -> openFile());
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(openItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }

    private void openFile()
    {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
            imageLabel.setText("");
            imageLabel.setIcon(icon);
        }
    }
}
