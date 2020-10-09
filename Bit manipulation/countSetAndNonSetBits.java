/*
Count the total set bits and non-set bits in a given number.
Eg: 10100100101
    total set bits = 5
    total non-set bits = 6
*/



class GfG{
    public void count(long n){
        // your code here.
        int totalBitsCount = (int)(Math.log(n) / Math.log(2)) + 1;
        int countOfSetBits = 0;
        int countOfNonSetBits = 0;
        while(n != 0){
            countOfSetBits++;
            n &= (n-1);
        }
        countOfNonSetBits = totalBitsCount - countOfSetBits;
        System.out.println(countOfSetBits + " " + countOfNonSetBits);
    }
}


/*

total bits count in a number N = |_ log2(N) _| + 1 

*/
