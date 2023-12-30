import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Eine Klasse, die eine Datei "datenbank.txt" liest, die im selben Ordner wie das Programm liegt.
 * Sie entfernt das Zeichen "|" aus den Zeilen und gibt eine bestimmte Anzahl von Zeilen aus.
 */
public class DatenbankLeser {

    /**
     * Hauptmethode, die beim Starten des Programms ausgeführt wird.
     * @param args Die Befehlszeilenargumente (hier wird die Anzahl der auszugebenden Zeilen erwartet).
     */
    public static void main(String[] args) {
        // Überprüfe, ob ein gültiger Befehlszeilenparameter vorhanden ist
        if (args.length != 1) {
            System.out.println("Bitte geben Sie die Anzahl der auszugebenden Zeilen als Kommandozeilenparameter an.");
            return;
        }

        // Versuche, die Anzahl der auszugebenden Zeilen zu erhalten
        int numOfLines;
        try {
            numOfLines = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            // Fehlerbehandlung, falls der Befehlszeilenparameter keine Zahl ist
            System.out.println("Der übergebene Parameter ist keine gültige Zahl.");
            return;
        }

        // Versuche, die Datei zu lesen
        try {
            // Öffne die Datei "datenbank.txt"
            BufferedReader reader = new BufferedReader(new FileReader("datenbank.txt"));
            String line;
            int linesPrinted = 0;

            // Lese jede Zeile der Datei, entferne "|" und gib sie aus (bis zur angegebenen Anzahl)
            while ((line = reader.readLine()) != null && linesPrinted < numOfLines) {
                line = line.replace("|", ""); // Entferne "|"
                System.out.println(line);
                linesPrinted++;
            }

            // Schließe den BufferedReader, nachdem alles gelesen wurde
            reader.close();
        } catch (FileNotFoundException e) {
            // Fehlerbehandlung, wenn die Datei nicht gefunden wird
            System.out.println("Die Datei 'datenbank.txt' wurde nicht gefunden.");
        } catch (IOException e) {
            // Fehlerbehandlung für andere Ein-/Ausgabe-Probleme
            System.out.println("Ein Ein-/Ausgabe-Fehler ist aufgetreten.");
        }
    }
}
