package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 */
public class InitialisationMatrice extends Observable {

    private ArrayList<ArrayList<Integer>> matrice = new ArrayList<>();

    /**
     * 
     * @param path
     */
    public void lecture(final String path) {
        try {
            FileReader fileReader = new FileReader(path);

            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();

            int nbLine = countLine(path);

            for (int ii = 0; ii < nbLine; ii++) {
                String[] words = line.split(",");
                ArrayList<Integer> matLine = new ArrayList<>();

                for (String word : words) {
                    System.out.println(word);
                    matLine.add(Integer.parseInt(word));
                }

                line = reader.readLine();
                matrice.add(matLine);

                System.out.println(matrice);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.notifyObservers();
    }

    /**
     * 
     * @param path
     * @return
     */
    public Integer countLine(final String path) {
        Integer count = 0;

        try {
            FileReader fileReader = new FileReader(path);

            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();

            while (line != null) {
                count++;
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    public ArrayList<ArrayList<Integer>> getMatrice() {
        return matrice;
    }
}
