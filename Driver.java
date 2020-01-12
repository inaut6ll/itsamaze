public class Driver
{
    public static void main() 
    {
        Maze maze1 = new Maze("maze1.txt");
        Maze maze2 = new Maze("maze2.txtx");
        Maze maze3 = new Maze("maze3.txtx");
        Maze.readString();
        
        maze1.isSolvable();
        maze2.isSolvable();
        maze3.isSolvable();
    }
}
