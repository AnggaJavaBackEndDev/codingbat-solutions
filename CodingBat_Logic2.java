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

    /**
     * Soal: luckySum
     Given 3 int values, a b c, return their sum. However, if one of the values is 13 then it does not count towards the sum and values to its right do not count. 
     So for example, if b is 13, then both b and c do not count.

     *Logika: Menghitung total variabel a, b, dan c dengan kodndisi khusus,
     yang apabila salahsatu dari ketiga variabel tersebut berangka 13, maka sisa angka setelahnya tak perlu dijumlahkan
    */
    public int luckySum(int a, int b, int c) {
      if(a==13) return 0;
      if(b==13) return a;
      if(c==13) return a+b;
        
      return a+b+c;
    }

    /**
     * Soal: noTeenSum
     Given 3 int values, a b c, return their sum. However, if any of the values is a teen -- in the range 13..19 inclusive -- then that value counts as 0, except 15 and 16 do not count as a teens. 
     Write a separate helper "public int fixTeen(int n) {"that takes in an int value and returns that value fixed for the teen rule. 
     In this way, you avoid repeating the teen code 3 times (i.e. "decomposition"). Define the helper below and at the same indent level as the main noTeenSum().

     *Logika: Jika salahsatu parameter a, b, dan c bernilai rentang 13 sampa 19, kecuali 15 dan 16, maka kembalikan angka 0
    */
     public int noTeenSum(int a, int b, int c) {
          return fix(a)+fix(b)+fix(c);
    }

    public int fix(int n){
          if(n>=13 && n<=19 && n!=15 && n!=16) {return 0;}
      return n;
    }

    /**
     * Soal: roundSum
     For this problem, we'll round an int value up to the next multiple of 10 if its rightmost digit is 5 or more, so 15 rounds up to 20. 
     Alternately, round down to the previous multiple of 10 if its rightmost digit is less than 5, so 12 rounds down to 10. 
     Given 3 ints, a b c, return the sum of their rounded values. 
     To avoid code repetition, write a separate helper "public int round10(int num) {" and call it 3 times. Write the helper entirely below and at the same indent level as roundSum().

     *Logika: Jika angka belakang Kurang dari 5 maka bulatkan kebawah, tapi jika angak belakangnya lebih atau sama dengan 5 maka bulatkan ke atas
    */
    public int roundSum(int a, int b, int c) {
      return round10(a)+round10(b)+round10(c);
    }

    public int round10(int n){
        int rd=n%10; //Variabel untuk mendpatkan angka paling akhir
        
      return n%10 < 5 ? n-rd : n+(10-rd);
    }
    /**
     *Soal:closeFar
     Given three ints, a b c, return true if one of b or c is "close" (differing from a by at most 1), 
     while the other is "far", differing from both other values by 2 or more. Note: Math.abs(num) computes the absolute value of a number.

     *Logika: Kembalikan true jika b atau c berjarak maksimal 1 dan salahsatu dari b atau c (yang tidak berjarak maksimal 1 dari a),
              Berjarak 2 dari a dan b atau c yang tidak berjarak 1 dengan a.
    */
    public boolean closeFar(int a, int b, int c) {
      return (Math.abs(a-b) <=1 && Math.abs(c-a)>=2 && Math.abs(c-b) >=2) ||
             (Math.abs(a-c) <=1 && Math.abs(b-a)>=2 && Math.abs(b-c) >=2);
    }
    /**
     *Soal:blackjack
     Given 2 int values greater than 0, return whichever value is nearest to 21 without going over. Return 0 if they both go over.

     *Logika: Cari angka yang paling dekat dari 21 tapi tidak boleh lebih dari 21, jika melebihi dari 21 maka dianggap gugur (0)
    */
    public int blackjack(int a, int b) {
      if(a>21) a=0;
      if(b>21) b=0;
      return (a>b) ? a:b;
    }
    /**
     *Soal:evenlySpaced
    Given three ints, a b c, one of them is small, one is medium and one is large. 
    Return true if the three values are evenly spaced, so the difference between small and medium is the same as the difference between medium and large.

    *Logika:Urutkan angka a, d, dan c, lalu lakukan perhitungan untuk memastikan a, b, dan c meiliki selisih angka yang sama
    */
    public boolean evenlySpaced(int a, int b, int c) {
      int[] nums={a,b,c};
      java.util.Arrays.sort(nums);
  
      return (nums[1]-nums[0]) == (nums[2]-nums[1]);
    }

    /**
     * We want make a package of goal kilos of chocolate. We have small bars (1 kilo each) and big bars (5 kilos each). 
     Return the number of small bars to use, assuming we always use big bars before small bars. Return -1 if it can't be done.

     *Logika: Mencari ukuran pas untuk memnuhi permintaan goal, dengan cara menggunakan big terlebih dahulu,
     Lalu temukan sisa kurang dari goal menggunakan small, jika small dapat memenuhi maka kembalikan jumlah angka yang dibtuhkan untuk memnuhi goal, jika tidak kembalikan -1.
    */
    public int makeChocolate(int small, int big, int goal) {
      int yangDipakaiBig = Math.min(big, goal / 5);
      int sisaKilo = goal - (yangDipakaiBig * 5);
      return small >= sisaKilo ? sisaKilo : -1;
       }

}
