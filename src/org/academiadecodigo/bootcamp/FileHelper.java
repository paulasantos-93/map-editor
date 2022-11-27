package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.ui.Representable;

import java.io.*;

/**
 * Serializes and Deserializes Representable objects from/to disk
 */
public class FileHelper {

    private String file;

    public FileHelper(String file) {
        this.file = file;
    }

    /**
     * Serialize to disk
     * @param representable the object to serialize
     */
    public void saveRepresentation(Representable representable) {

        try {

            System.out.println("saving to " + file);

            FileWriter writer = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(writer);
            bWriter.write(representable.getRepresentation());
            bWriter.close(); // auto-flush is done on close

        } catch (IOException ex) {
            System.out.println("error saving: " + ex.getMessage());
        }

    }

    /**
     * Deserialize from disk
     * @return the object representation
     */
    public String loadRepresentation() {

        String result = "";

        try {

            System.out.println("loading from " + file);

            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);

            String line = "";
            while ((line = bReader.readLine()) != null) {
                result += line + "\n";
            }

            bReader.close();

        } catch (IOException ex) {

            System.out.println("loading error: " + ex.getMessage());

        } finally {
            return result;
        }
    }
}
