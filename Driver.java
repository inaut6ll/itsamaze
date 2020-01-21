public class Driver
{
    public static void main() 
    {
        System.out.println("Maze 1: ");
        Maze maze1 = new Maze("maze1.txt");
        //maze1.read();
        maze1.setNumRows();
        maze1.setNumCols();
        maze1.setMaze();
        maze1.printMaze();
        maze1.isSolvable(0, 0, maze1.getMaze());
        System.out.println("");
        
        System.out.println("Maze 2: ");
        Maze maze2 = new Maze("maze2.txt");
        //maze2.read();
        maze2.setNumRows();
        maze2.setNumCols();
        maze2.setMaze();
        maze2.printMaze();
        maze2.isSolvable(0, 0, maze1.getMaze());
        System.out.println("");
        
        System.out.println("Maze 3: ");
        Maze maze3 = new Maze("maze3.txt");
        //maze3.read();
        maze3.setNumRows();
        maze3.setNumCols();
        maze3.setMaze();
        maze3.printMaze();
        maze3.isSolvable(0, 0, maze1.getMaze());
    }
}
