package ejercicio_4;

public class Main {
    public static void main(String[] args) {
        ImpresoraBasica impresoraSimple = new Impresora("HP DeskJet");
        ImpresoraMultifuncional multifuncional = new ImpresoraMultifuncional("Canon MX922");

        impresoraSimple.imprimir("Flagio LP III");

        multifuncional.imprimir("Hoja de vida");
        multifuncional.escanear("Foto de perfil");
    }
}