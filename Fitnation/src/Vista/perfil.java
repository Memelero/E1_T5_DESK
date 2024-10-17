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
import javax.swing.UIManager;

public class perfil extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private static BufferedImage imagenFondo;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Cargar la imagen de fondo antes de mostrar el frame
                    imagenFondo = ImageIO.read(perfil.class.getResource("/img/fondo2.jpg"));
                    perfil frame = new perfil();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public perfil() {
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
        lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
        lblNewLabel.setBounds(394, 348, 34, 14);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        textField.setBounds(449, 163, 202, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Contraseña:");
        lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(362, 408, 66, 14);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        textField_1.setBounds(449, 345, 202, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("Cambiar datos");
        btnNewButton.setForeground(new Color(255, 128, 64));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        btnNewButton.setBounds(482, 457, 136, 23);
        contentPane.add(btnNewButton);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        textField_2.setColumns(10);
        textField_2.setBounds(449, 226, 202, 20);
        contentPane.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        textField_3.setColumns(10);
        textField_3.setBounds(449, 405, 202, 20);
        contentPane.add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        textField_4.setColumns(10);
        textField_4.setBounds(449, 282, 202, 20);
        contentPane.add(textField_4);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
        lblNombre.setBounds(380, 166, 48, 14);
        contentPane.add(lblNombre);
        
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
        lblApellido.setBounds(380, 229, 48, 14);
        contentPane.add(lblApellido);
        
        JLabel lblFnacimiento = new JLabel("F.Nacimiento:");
        lblFnacimiento.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
        lblFnacimiento.setBounds(352, 285, 76, 14);
        contentPane.add(lblFnacimiento);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240));
        panel.setBounds(0, 0, 735, 65);
        contentPane.add(panel);
                panel.setLayout(null);
        
                JLabel lblNewLabel_2 = new JLabel("");
                lblNewLabel_2.setBounds(24, 11, 130, 40);
                panel.add(lblNewLabel_2);
                lblNewLabel_2.setIcon(new ImageIcon(registro.class.getResource("/img/logo-pequeño.png")));
                
                JButton btnNewButton_1 = new JButton("INICIO\r\n");
                btnNewButton_1.setBackground(new Color(240, 240, 240));
                btnNewButton_1.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                btnNewButton_1.setBounds(164, 11, 112, 40);
                panel.add(btnNewButton_1);
                
                JButton btnNewButton_1_1 = new JButton("EJERCICIOS\r\n");
                btnNewButton_1_1.setBackground(new Color(240, 240, 240));
                btnNewButton_1_1.setBounds(292, 11, 112, 40);
                panel.add(btnNewButton_1_1);
                
                JButton btnNewButton_1_1_1 = new JButton("RUTINAS\r\n");
                btnNewButton_1_1_1.setBackground(new Color(240, 240, 240));
                btnNewButton_1_1_1.setBounds(429, 11, 112, 40);
                panel.add(btnNewButton_1_1_1);
                
                JButton btnNewButton_1_1_1_1 = new JButton("PERFIL");
                btnNewButton_1_1_1_1.setBackground(new Color(240, 240, 240));
                btnNewButton_1_1_1_1.setBounds(569, 11, 112, 40);
                panel.add(btnNewButton_1_1_1_1);
    }
}
