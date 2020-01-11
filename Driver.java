public class Driver
{
    public static void main() 
    {
        String line;
        while ((line = MazeFile.readString()) != null) {
            System.out.println(line);
        }
        
    }
}
