public class CodingBat_Logic2 {

    /**
     * Soal: MakeBricks
       We want to make a row of bricks that is goal inches long. 
       We have a number of small bricks (1 inch each) and big bricks (5 inches each). 
       Return true if it is possible to make the goal by choosing from the given bricks. 
       This is a little harder than it looks and can be done without any loops. See also: Introduction to MakeBricks
     * Logika: Mencari KombinaSi yang pas untuk goal.
     */
    public boolean makeBricks(int small, int big, int goal) {
        return (goal <= big * 5 + small) && (goal % 5 <= small);
    }

    /**
     * Soal: Lone Sum
       Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values, it does not count towards the sum.
     * Logika: Setiap nombor ditambah hanya jika ia unik (tidak sama dengan yang lain).
     */
    public int loneSum(int a, int b, int c) {
        int sum = 0;
        
        if (a != b && a != c) sum += a;
        if (b != a && b != c) sum += b;
        if (c != a && c != b) sum += c;
        
        return sum;
    }
}
