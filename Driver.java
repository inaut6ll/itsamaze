public class Driver
{
    public static void main() 
    {
        Maze maze1 = new Maze("maze1.txt");
        Maze maze2 = new Maze("maze2.txt");
        Maze maze3 = new Maze("maze3.txt");
        
        maze1.read();
        
        //maze1.printMaze();
        //maze2.printMaze();
        //maze3.printMaze();
        
        maze1.isSolvable();
        maze2.isSolvable();
        maze3.isSolvable();
    }
}
