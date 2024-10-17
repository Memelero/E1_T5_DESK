package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkoutFrame extends JFrame {
    private JLabel labelCronometro;
    private JLabel labelTiempoEjercicio;
    private JLabel labelDescanso;
    private JButton botonInicio;
    private boolean enEjecucion = false;
    private Timer workoutTimer;
    private Timer serieTimer;
    private Timer descansoTimer;
    private int tiempoTotal = 0;
    private int tiempoSerie = 30; // Ejemplo de duración de la serie en segundos
    private int tiempoDescanso = 15; // Ejemplo de duración del descanso en segundos

    
    public WorkoutFrame() {
        // Configuración básica del JFrame
        setTitle("Workout Timer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Etiqueta del cronómetro principal (arriba a la izquierda)
        labelCronometro = new JLabel("Cronómetro Workout: 00:00");
        labelCronometro.setForeground(Color.LIGHT_GRAY);
        labelCronometro.setBounds(10, 10, 200, 30);
        add(labelCronometro);

        // Etiqueta de la primera serie (arriba en el centro)
        JLabel labelSerieDescripcion = new JLabel("Ejercicio X - Descripción");
        labelSerieDescripcion.setForeground(Color.LIGHT_GRAY);
        labelSerieDescripcion.setBounds(300, 10, 200, 30);
        add(labelSerieDescripcion);

        // Etiqueta para el nombre del workout (arriba a la derecha)
        JLabel labelWorkout = new JLabel("Workout 1");
        labelWorkout.setForeground(Color.LIGHT_GRAY);
        labelWorkout.setBounds(600, 10, 100, 30);
        add(labelWorkout);

        // Panel para mostrar el tiempo de la serie y descanso
        labelTiempoEjercicio = new JLabel("Tiempo Ejercicio: 00:00");
        labelTiempoEjercicio.setForeground(Color.LIGHT_GRAY);
        labelTiempoEjercicio.setBounds(10, 50, 200, 30);
        add(labelTiempoEjercicio);

        labelDescanso = new JLabel("Descanso: 00:00");
        labelDescanso.setForeground(Color.LIGHT_GRAY);
        labelDescanso.setBounds(10, 80, 200, 30);
        add(labelDescanso);

        // Botones de series (simulación)
        JPanel panelSeries = new JPanel();
        panelSeries.setLayout(new GridLayout(3, 1, 10, 10));
        panelSeries.setBounds(200, 150, 400, 150);
        add(panelSeries);

        JButton botonSerie1 = new JButton("*FOTO* Número Serie 1");
        JButton botonSerie2 = new JButton("*FOTO* Número Serie 2");
        JButton botonSerie3 = new JButton("*FOTO* Número Serie 3");
        panelSeries.add(botonSerie1);
        panelSeries.add(botonSerie2);
        panelSeries.add(botonSerie3);

        // Botón de inicio/pausa
        botonInicio = new JButton("Iniciar");
        botonInicio.setBackground(Color.GREEN);
        botonInicio.setBounds(360, 450, 100, 50);
        botonInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!enEjecucion) {
                    iniciarWorkout();
                } else {
                    pausarWorkout();
                }
            }
        });
        add(botonInicio);

        // Botón de salir
        JButton botonSalir = new JButton("Salir");
        botonSalir.setBackground(Color.RED);
        botonSalir.setBounds(650, 500, 100, 50);
        add(botonSalir);

        // Timers para el workout y las series
        workoutTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempoTotal++;
                actualizarCronometro();
            }
        });

        serieTimer = new Timer(1000, new ActionListener() {
            int tiempoRestanteSerie = tiempoSerie;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (tiempoRestanteSerie > 0) {
                    tiempoRestanteSerie--;
                    labelTiempoEjercicio.setText("Tiempo Ejercicio: " + tiempoRestanteSerie);
                } else {
                    serieTimer.stop();
                    iniciarDescanso();
                }
            }
        });

        descansoTimer = new Timer(1000, new ActionListener() {
            int tiempoRestanteDescanso = tiempoDescanso;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (tiempoRestanteDescanso > 0) {
                    tiempoRestanteDescanso--;
                    labelDescanso.setText("Descanso: " + tiempoRestanteDescanso);
                } else {
                    descansoTimer.stop();
                    botonInicio.setText("Siguiente Serie");
                    botonInicio.setBackground(Color.GREEN);
                }
            }
        });
    }

    private void iniciarWorkout() {
        enEjecucion = true;
        botonInicio.setText("Pausar");
        botonInicio.setBackground(Color.YELLOW);
        workoutTimer.start();
        iniciarSerie();
    }

    private void pausarWorkout() {
        enEjecucion = false;
        botonInicio.setText("Iniciar");
        botonInicio.setBackground(Color.GREEN);
        workoutTimer.stop();
        serieTimer.stop();
        descansoTimer.stop();
    }

    private void iniciarSerie() {
        serieTimer.start();
    }

    private void iniciarDescanso() {
        descansoTimer.start();
    }

    private void actualizarCronometro() {
        int minutos = tiempoTotal / 60;
        int segundos = tiempoTotal % 60;
        labelCronometro.setText(String.format("Cronómetro Workout: %02d:%02d", minutos, segundos));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WorkoutFrame frame = new WorkoutFrame();
            frame.setVisible(true);
        });
    }
}
