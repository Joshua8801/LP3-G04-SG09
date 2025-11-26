
package ejercicio3;

import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;

/**
 * Reproductor de efectos de sonido con Swing y Clip (WAV).
 * Botones: Aplausos, Campana, Explosión.
 */
public class EfectosSonidoApp extends JFrame {

    // Ajusta estas rutas a tus archivos WAV
    private static final String WAV_APLAUSOS = "src/ejercicio3/aplausos.wav";  // p.ej. "assets/aplausos.wav"
    private static final String WAV_CAMPANA  = "src/ejercicio3/campana.wav";   // p.ej. "assets/campana.wav"
    private static final String WAV_EXPLOSION= "src/ejercicio3/explosion.wav"; // p.ej. "assets/explosion.wav"

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EfectosSonidoApp().setVisible(true));
    }

    public EfectosSonidoApp() {
        super("Ejercicio 3 - Efectos de sonido (WAV) con Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(520, 140);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 16, 16));

        JButton btnAplausos = new JButton("Aplausos");
        JButton btnCampana  = new JButton("Campana");
        JButton btnExplosion= new JButton("Explosión");

        // Handlers: reproducen el WAV correspondiente
        btnAplausos.addActionListener(e -> playWav(WAV_APLAUSOS));
        btnCampana.addActionListener(e -> playWav(WAV_CAMPANA));
        btnExplosion.addActionListener(e -> playWav(WAV_EXPLOSION));

        // Opcional: botón para elegir un WAV cualquiera
        JButton btnAbrir = new JButton("Abrir WAV...");
        btnAbrir.addActionListener(e -> openAndPlayDialog());

        panel.add(btnAplausos);
        panel.add(btnCampana);
        panel.add(btnExplosion);
        panel.add(btnAbrir);

        add(panel);
    }

    /**
     * Reproduce un archivo WAV usando Clip.
     * Soporta PCM (Linear PCM: 8/16 bit, mono/stereo, sample rates comunes).
     */
    private void playWav(String path) {
        try {
            File audioFile = new File(path);
            if (!audioFile.exists()) {
                JOptionPane.showMessageDialog(this,
                        "No se encontró el archivo:\n" + audioFile.getAbsolutePath(),
                        "Archivo inexistente", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try (AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile)) {
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.start();

                // Cerrar clip cuando termine para liberar recursos
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                });
            }
        } catch (UnsupportedAudioFileException uafe) {
            JOptionPane.showMessageDialog(this,
                    "Formato de audio no soportado.\nUsa WAV PCM estándar.",
                    "Audio no soportado", JOptionPane.ERROR_MESSAGE);
        } catch (LineUnavailableException lue) {
            JOptionPane.showMessageDialog(this,
                    "Dispositivo de audio no disponible: " + lue.getMessage(),
                    "Error de audio", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al reproducir: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Diálogo para elegir y reproducir cualquier WAV. */
    private void openAndPlayDialog() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Selecciona un archivo WAV");
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selected = chooser.getSelectedFile();
            playWav(selected.getAbsolutePath());
        }
    }
}
