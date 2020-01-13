import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Maze 
{
    private static String file;
    private int numRows;
    private int numCols;
    private String[][] maze;
    private static Scanner in;
    private static BufferedWriter out;

    public Maze(String file) {
        this.file = file;
    }
    
    public static String readString() {
        if (in == null) {
            try {
                in = new Scanner(new File(file));
            }
            catch (Exception e) {
                System.err.println("Cannot open file for input!");
                e.printStackTrace();
            }
        }
        try {
            if (in.hasNext()) {
                String s = in.nextLine();
                return s;
            }
            else {
                return null;
            }
        }
        catch (Exception e) {
            System.err.println("Cannot read  file!");
            e.printStackTrace();
        }
        return null;

    }

    public static void writeString(String s) {
        if (out == null) {
            try {
                out = new BufferedWriter(new FileWriter(file));
            }
            catch (Exception e) {
                System.err.println("Cannot create file for output!");
                e.printStackTrace();
            }
        }

        try {
            out.write(s);
            out.newLine();
            //out.write("|");
        }
        catch (Exception e) {
            System.err.println("Cannot write file!");
            e.printStackTrace();
        }

    }

    public static void saveAndClose() {
        if (in != null) {
            try {
                in.close();
                in = null;
            }
            catch (Exception e) {
                System.err.println("Cannot close input file!");
                e.printStackTrace();
            }
        }      
        if (out != null) {
            try {
                out.close();
                out = null;
            }
            catch (Exception e) {
                System.err.println("Cannot close output file!");
                e.printStackTrace();
            }
        }
    }
    
    
    String a;
    public void read() { //no problems
        while ((a = Maze.readString()) != null) {
            System.out.println(a);
        }
        Maze.saveAndClose();
    }
    
    public void printMaze() {
        numRows = Integer.parseInt(Maze.readString().trim()); 
        numCols = Integer.parseInt(Maze.readString().trim());
        maze = new String[numRows][numCols];
        
        //blockage = O, free space = L
        String line;
        while ((line = Maze.readString()) != null) {
            int tempRow = Integer.parseInt(line.substring(0, line.indexOf(" ")).trim());
            int tempCol = Integer.parseInt(line.substring(line.indexOf(" ")).trim());
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    if (tempRow == row && tempCol == col) { 
                        maze[row][col] = "O";
                        
                    }else {
                        if (maze[row][col] == null) {
                            maze[row][col] = "L";
                        }   
                    }
                }
            }
        }
        
        Maze.saveAndClose();
        
        for (String[] row: maze) {
            for (String val: row) {
                System.out.print(val);
            }
            System.out.println("");
        }
    }
    
    public boolean isSolvable() {
        return true;
    }
}
