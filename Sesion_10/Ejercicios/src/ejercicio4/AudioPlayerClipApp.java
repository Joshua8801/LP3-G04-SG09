
package ejercicio4;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;


public class AudioPlayerClipApp extends JFrame {
    private Clip clip;
    private long pausePositionMicros = 0L;

    private final JButton btnOpen    = new JButton("Abrir WAV...");
    private final JButton btnPlay    = new JButton("Reproducir");
    private final JButton btnPause   = new JButton("Pausar");
    private final JButton btnResume  = new JButton("Reanudar");
    private final JLabel  lblEstado  = new JLabel("Estado: sin archivo");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AudioPlayerClipApp().setVisible(true));
    }

    public AudioPlayerClipApp() {
        super("Ejercicio 4 - Reproducir / Pausar / Reanudar (WAV)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(560, 140);
        setLocationRelativeTo(null);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 12));
        buttons.add(btnOpen);
        buttons.add(btnPlay);
        buttons.add(btnPause);
        buttons.add(btnResume);

        lblEstado.setBorder(BorderFactory.createEmptyBorder(0, 12, 8, 12));

        add(buttons, BorderLayout.CENTER);
        add(lblEstado, BorderLayout.SOUTH);

        // Listeners
        btnOpen.addActionListener(e -> openWav());
        btnPlay.addActionListener(e -> playFromStart());
        btnPause.addActionListener(e -> pause());
        btnResume.addActionListener(e -> resumeAudio());

        // Estados iniciales
        btnPlay.setEnabled(false);
        btnPause.setEnabled(false);
        btnResume.setEnabled(false);
    }

    /** Abrir un archivo WAV y cargarlo en Clip */
    private void openWav() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Selecciona un archivo WAV (PCM)");
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                // Cerrar clip anterior
                closeClipIfNeeded();

                AudioInputStream ais = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(ais);

                // Resetear estado
                pausePositionMicros = 0L;
                lblEstado.setText("Estado: cargado " + file.getName());

                // Habilitar botones
                btnPlay.setEnabled(true);
                btnPause.setEnabled(false);
                btnResume.setEnabled(false);

                // Liberar recursos cuando termina
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP && clip.getMicrosecondPosition() >= clip.getMicrosecondLength()) {
                        // Llegó al final
                        SwingUtilities.invokeLater(() -> {
                            lblEstado.setText("Estado: reproducción finalizada");
                            btnPause.setEnabled(false);
                            btnResume.setEnabled(false);
                        });
                        clip.stop();
                        clip.setMicrosecondPosition(0);
                    }
                });
            }
        } catch (UnsupportedAudioFileException uafe) {
            showError("Formato no soportado. Usa WAV PCM (no comprimido).");
        } catch (LineUnavailableException lue) {
            showError("Dispositivo/Linea de audio no disponible: " + lue.getMessage());
        } catch (Exception ex) {
            showError("Error al abrir WAV: " + ex.getMessage());
        }
    }

    /** Reproducir desde el inicio */
    private void playFromStart() {
        if (clip != null) {
            clip.stop();
            clip.setMicrosecondPosition(0);
            clip.start();
            pausePositionMicros = 0L;
            lblEstado.setText("Estado: reproduciendo (inicio)");
            btnPause.setEnabled(true);
            btnResume.setEnabled(false);
        }
    }

    /** Pausar: guarda posición y detiene */
    private void pause() {
        if (clip != null && clip.isRunning()) {
            pausePositionMicros = clip.getMicrosecondPosition();
            clip.stop();
            lblEstado.setText("Estado: pausado en " + (pausePositionMicros / 1_000_000.0) + " s");
            btnPause.setEnabled(false);
            btnResume.setEnabled(true);
        }
    }

    /** Reanudar desde la posición pausada */
    private void resumeAudio() {
        if (clip != null) {
            clip.setMicrosecondPosition(pausePositionMicros);
            clip.start();
            lblEstado.setText("Estado: reproduciendo (reanudar)");
            btnPause.setEnabled(true);
            btnResume.setEnabled(false);
        }
    }

    /** Cierra el clip previo si existe */
    private void closeClipIfNeeded() {
        if (clip != null) {
            try {
                clip.stop();
                clip.close();
            } catch (Exception ignored) {}
            clip = null;
        }
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
        lblEstado.setText("Estado: " + msg);
    }
}
