public class Driver
{
    public static void main() 
    {
        Maze maze1 = new Maze("maze1.txt");
        maze1.read();
        maze1.printMaze();
        maze1.isSolvable();
        System.out.println();
        
        Maze maze2 = new Maze("maze2.txt");
        maze2.read();
        maze2.printMaze();
        maze2.isSolvable();
        System.out.println();
        
        Maze maze3 = new Maze("maze3.txt");
        maze3.read();
        //maze3.printMaze();
        maze3.isSolvable();
    }
}
