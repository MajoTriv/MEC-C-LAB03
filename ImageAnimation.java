import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ImageAnimation extends JFrame implements ActionListener, ChangeListener {
    private final JLabel imageLabel;
    private final JSlider speedSlider;
    private final Timer timer;
    private final ImageIcon[] images;
    private int currentImageIndex;

    public ImageAnimation() {
     images = new ImageIcon[9];
    images[0] = new ImageIcon("C:\\Users\\maria\\OneDrive\\Documentos\\NetBeansProjects\\AnimacionImagenes\\Imagenes/imagen01.png");
    images[1] = new ImageIcon("C:\\Users\\maria\\OneDrive\\Documentos\\NetBeansProjects\\AnimacionImagenes\\Imagenes/imagen02.png");
    images[2] = new ImageIcon("C:\\Users\\maria\\OneDrive\\Documentos\\NetBeansProjects\\AnimacionImagenes\\Imagenes/imagen03.png");
    images[3] = new ImageIcon("C:\\Users\\maria\\OneDrive\\Documentos\\NetBeansProjects\\AnimacionImagenes\\Imagenes/imagen04.png");
    images[4] = new ImageIcon("C:\\Users\\maria\\OneDrive\\Documentos\\NetBeansProjects\\AnimacionImagenes\\Imagenes/imagen05.png");
    images[5] = new ImageIcon("C:\\Users\\maria\\OneDrive\\Documentos\\NetBeansProjects\\AnimacionImagenes\\Imagenes/imagen06.png");
    images[6] = new ImageIcon("C:\\Users\\maria\\OneDrive\\Documentos\\NetBeansProjects\\AnimacionImagenes\\Imagenes/imagen07.png");
    images[7] = new ImageIcon("C:\\Users\\maria\\OneDrive\\Documentos\\NetBeansProjects\\AnimacionImagenes\\Imagenes/imagen08.png");
    images[8] = new ImageIcon("C:\\Users\\maria\\OneDrive\\Documentos\\NetBeansProjects\\AnimacionImagenes\\Imagenes/imagen09.png");

        imageLabel = new JLabel(images[0]);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        speedSlider = new JSlider(1, 10, 5);
        speedSlider.setMajorTickSpacing(1);
        speedSlider.setPaintTicks(true);
        speedSlider.addChangeListener(this);
        add(speedSlider, BorderLayout.SOUTH);

        timer = new Timer(1000 / speedSlider.getValue(), this);
        timer.start();

        setTitle("Image Animation");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        currentImageIndex = (currentImageIndex + 1) % images.length;
        imageLabel.setIcon(images[currentImageIndex]);
    
        timer.setDelay(1000 / speedSlider.getValue());
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        timer.setDelay(1000 / speedSlider.getValue());
    }

    public static void main(String[] args) {
        ImageAnimation imageAnimation = new ImageAnimation();
    }
}