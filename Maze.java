import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Maze 
{
    private static String file;
    private static int numRows;
    private static int numCols;
    private static String[][] maze;
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
    
    
    // String a;
    // public void read() { //no problems
        // while ((a = Maze.readString()) != null) {
            // System.out.println(a);
        // }
        // Maze.saveAndClose();
    // }
    public static void setNumRows() {
        numRows = Integer.parseInt(Maze.readString().trim()); 
        Maze.saveAndClose();
    }
    
    public static int getNumRows() {
        return numRows;
    }
    
    public static void setNumCols() {
        Maze.readString();
        numCols = Integer.parseInt(Maze.readString().trim()); 
        Maze.saveAndClose();
    }
    
    public static int getNumCols() {
        return numRows;
    }
    
    public static void setMaze() {
        maze = new String[numRows][numCols];
    }
    
    public static String[][] getMaze() {
        return maze;
    }
    
    public void printMaze() {
        //blockage = F, free space = O
        Maze.readString();
        Maze.readString();
        String line;
        while ((line = Maze.readString()) != null) {
            
            int tempRow;
            int tempCol; 
            if (line.indexOf(" ") != -1) {
                tempRow = Integer.parseInt(line.substring(0, line.indexOf(" ")).trim());
                tempCol = Integer.parseInt(line.substring(line.indexOf(" ")).trim());
            }else {
                tempRow = Integer.parseInt(line.substring(0, line.indexOf("\t")).trim());
                tempCol = Integer.parseInt(line.substring(line.indexOf("\t")).trim());
            }
            
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    if (tempRow == row && tempCol == col) { 
                        maze[row][col] = "F";
                        
                    }else {
                        if (maze[row][col] == null) {
                            maze[row][col] = "O";
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
    
    public static boolean atEdge(int row, int col) {
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) {
            return true;
        }
        return false;
    }
    
    public static boolean atWall(int row, int col) {
        if (maze[row][col].equals("F")) {
            return true;
        }
        return false;
    }
    
    public static boolean atPath(int row, int col) {
        if (maze[row][col].equals("P")) {
            return true;
        }
        return false;
    }
    
    public boolean isSolvable(int startR, int startC, String[][] mazeAry) {
          maze[startR][startC] = "P";
          if (Maze.atEdge(startR - 1, startC) || Maze.atWall(startR - 1, startC) || Maze.atPath(startR - 1, startC)) { //up
              System.out.println("exists");
              if (Maze.atEdge(startR, startC + 1) || Maze.atWall(startR, startC + 1) || Maze.atPath(startR, startC + 1)) { //right
                  System.out.println("exists");
                if (Maze.atEdge(startR + 1, startC) || Maze.atWall(startR + 1, startC) || Maze.atPath(startR + 1, startC)) { //down
                    System.out.println("exists");
                    if (Maze.atEdge(startR, startC - 1) || Maze.atWall(startR, startC - 1) || Maze.atPath(startR, startC - 1)) { //left
                        System.out.println("exists");
                       if (startR == maze.length - 1 && startC == maze[0].length - 1) {
                           return true;
                       } else {
                           return false;
                       }
                    }
                }
              }
          } 
          else {
              if (!(Maze.atEdge(startR - 1, startC) || Maze.atWall(startR - 1, startC) || Maze.atPath(startR - 1, startC))) { //up
                  if (isSolvable(startR - 1, startC, mazeAry)) {
                      return true;
                  }
              }
              if (!(Maze.atEdge(startR, startC + 1) || Maze.atWall(startR, startC + 1) || Maze.atPath(startR, startC + 1))) { //right
                  if (isSolvable(startR, startC + 1, mazeAry)) {
                      return true;
                  }
              }
              if (!(Maze.atEdge(startR + 1, startC) || Maze.atWall(startR + 1, startC) || Maze.atPath(startR + 1, startC))) { //down
                  if (isSolvable(startR + 1, startC, mazeAry)) {
                      return true;
                  }
              }
              if (!(Maze.atEdge(startR, startC - 1) || Maze.atWall(startR, startC - 1) || Maze.atPath(startR, startC - 1))) { //left
                  if (isSolvable(startR, startC - 1, mazeAry)) {
                      return true;
                  }
              }
              return false;
          }
          return false;
    }
}
