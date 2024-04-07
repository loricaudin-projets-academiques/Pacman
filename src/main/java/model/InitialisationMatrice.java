package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * class de contruction de la matrice de jeu.
 */
public class InitialisationMatrice extends Observable {

    private ArrayList<ArrayList<Integer>> matrice = new ArrayList<>();
    private String path;
    private ArrayList<Integer[]> positionsSquares;
    private ArrayList<Integer[]> freeBoxes;

    /**
     * @param path
     */
    public InitialisationMatrice(final String path) {
        this.path = path;

        this.positionsSquares = new ArrayList<>();
        this.freeBoxes = new ArrayList<>();
    }

    /**
     * methodes pour lire des données dans un fichier et construire la matrice du jeu.
     */
    public void lecture() {
        try {
            FileReader fileReader = new FileReader(path);

            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();

            int nbLine = countLine(path);

            for (int ii = 0; ii < nbLine; ii++) {
                String[] words = line.split(",");
                ArrayList<Integer> matLine = new ArrayList<>();

                for (String word : words) {
                    //System.out.println(word);
                    matLine.add(Integer.parseInt(word));
                }

                line = reader.readLine();
                matrice.add(matLine);

                //System.out.println(matrice);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        generatePositionsSquares();

        super.notifyObservers();
    }

    /**
     * methode pour retourner le nombre de ligne du fichier.
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

    private void generatePositionsSquares() {
        int squareSize = 50;
        for (int ii = 0; ii < matrice.size(); ii++) {
            for (int jj = 0; jj < matrice.get(ii).size(); jj++) {
                Integer[] coordsCarres = {
                    squareSize * jj,
                    squareSize * ii
                };
                if (matrice.get(ii).get(jj) == 1) {
                    this.positionsSquares.add(coordsCarres);
                } else {
                    this.freeBoxes.add(coordsCarres);
                }
            }
        }
    }

    public ArrayList<Integer[]> getFreeBoxes() {
        return this.freeBoxes;
    }

    public ArrayList<Integer[]> getPositionsSquares() {
        return this.positionsSquares;
    }


}
