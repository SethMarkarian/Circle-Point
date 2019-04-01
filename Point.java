
/**
 * A class that describes a Point object as a pair of coordinates (x, y)
 */
public class Point
{
    private int x, y;
    
    /**
     * Constructor with parameters.
     * Sets the instance variables equal
     * to the parameters.
     */
    public Point(int px, int py) {
        x = px;
        y = py;
    }
    
    /**
     * Constructor with no parameters.
     * Sets x and y equal to 0.
     */
    public Point() {
        x = 0;
        y = 0;
    }
    
    /**
     * Accessor: Returns x-coordinate
     */
    public int getX() {
        return x;
    }
    
    /**
     * Accessor: Returns y-coordinate
     */
    public int getY() {
        return y;
    }
    
    /**
     * Uses the distance formula to return the distance
     * between this point and another point, casted to an int.
     * 
     * Notice the parameter is ANOTHER Point object,
     * different from "this" one. We can call the methods
     * on that other Point object.
     */
    public int distance(Point other) {
        double a = Math.pow(x - other.getX(), 2);
        double b = Math.pow(y - other.getY(), 2);
        return (int) Math.sqrt(a + b);
    }
    
    /**
     * Modifier method that moves the point.
     */
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
    
    /**
     * Accessor method that returns a String representing
     * the point.
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
