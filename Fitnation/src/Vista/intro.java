package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class intro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private static BufferedImage imagenFondo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Cargar la imagen de fondo antes de mostrar el frame
                    imagenFondo = ImageIO.read(intro.class.getResource("/img/fondo.jpg"));
                    intro frame = new intro();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public intro() {
        // Crear el contentPane principal con imagen de fondo
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibuja la imagen de fondo en el contentPane
                if (imagenFondo != null) {
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        
        // Configurar el contentPane correctamente
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 751, 582);
        
        setLocationRelativeTo(null);

        // Resto del contenido
        JLabel lblNewLabel = new JLabel("Email:");
        lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        lblNewLabel.setBounds(230, 211, 33, 14);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        textField.setBounds(281, 208, 202, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Contraseña:");
        lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(199, 254, 64, 14);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        textField_1.setBounds(281, 251, 202, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("REGISTRARSE");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBackground(new Color(255, 128, 64));
        btnNewButton.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        btnNewButton.setBounds(279, 447, 136, 23);
        contentPane.add(btnNewButton);

        JSeparator separator = new JSeparator();
        separator.setBounds(88, 370, 561, 14);
        contentPane.add(separator);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(intro.class.getResource("/img/logo.png")));
        lblNewLabel_2.setBounds(108, 11, 482, 165);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblnoTienesCuenta = new JLabel("¿No tienes cuenta?");
        lblnoTienesCuenta.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        lblnoTienesCuenta.setBounds(292, 412, 106, 14);
        contentPane.add(lblnoTienesCuenta);
        
        JButton btnNewButton_1 = new JButton("INICIAR SESIÓN");
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        btnNewButton_1.setBackground(new Color(255, 128, 64));
        btnNewButton_1.setBounds(281, 313, 136, 23);
        contentPane.add(btnNewButton_1);
    }
}
