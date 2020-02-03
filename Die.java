public class Die
{
    // instance variables
    private int sides;
    // constructor
    // create die of 6 sides
    public Die()
    {
        sides = 6;
    }
    // create die of assigned sides
    public Die(int sides)
    {
        this.sides = sides;
    }
    // methods
    // roll die and return number rolled
    public int roll()
    {
        int r = (int)(Math.random() * sides) + 1;
        return r;
    }
    // roll die up to certain number and return rolled number
    public int roll(int max)
    {
        // roll between 1 and the max
        int r = (int)(Math.random() * max) + 1;
        return r;
    }
}