public class Driver
{
    public static void main() 
    {
        String line;
        while ((line = MazeFile1.readString()) != null) {
            System.out.println(line);
        }
        
    }
}
