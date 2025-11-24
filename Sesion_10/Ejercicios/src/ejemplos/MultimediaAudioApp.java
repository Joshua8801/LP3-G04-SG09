
package ejemplos;

import javax.swing.*;
import javax.sound.sampled.*;
import java.io.File;

public class MultimediaAudioApp extends JFrame {
    private Clip clip;
    private long pausePositionMicros = 0L;

    private final JButton btnOpen   = new JButton("Abrir WAV");
    private final JButton btnPlay   = new JButton("Reproducir");
    private final JButton btnPause  = new JButton("Pausar");
    private final JButton btnResume = new JButton("Reanudar");
    private final JButton btnStop   = new JButton("Detener");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MultimediaAudioApp().setVisible(true));
    }

    public MultimediaAudioApp() {
        super("Multimedia (Audio WAV) con Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(520, 110);
        setLocationRelativeTo(null);

        JPanel p = new JPanel();
        p.add(btnOpen); p.add(btnPlay); p.add(btnPause); p.add(btnResume); p.add(btnStop);
        add(p);

        btnOpen.addActionListener(e -> openWav());
        btnPlay.addActionListener(e -> play());
        btnPause.addActionListener(e -> pause());
        btnResume.addActionListener(e -> resumeAudio());
        btnStop.addActionListener(e -> stopAll());
    }

    private void openWav() {
        try {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                AudioInputStream ais = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(ais);
                pausePositionMicros = 0L;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al abrir WAV: " + ex.getMessage());
        }
    }

    private void play() {
        if (clip != null) {
            clip.stop();
            clip.setMicrosecondPosition(0);
            clip.start();
        }
    }

    private void pause() {
        if (clip != null && clip.isRunning()) {
            pausePositionMicros = clip.getMicrosecondPosition();
            clip.stop();
        }
    }

    private void resumeAudio() {
        if (clip != null) {
            clip.setMicrosecondPosition(pausePositionMicros);
            clip.start();
        }
    }

    private void stopAll() {
        if (clip != null) {
            clip.stop();
            clip.setMicrosecondPosition(0);
        }
    }
}