/*
Count no. of bits.
*/

// method that can be used to find no of bits in a digit.
private static int getBits(int num){
        int count = 0;
        while(num > 0){
            count++;
            num/=2;
        }    
        return count;
    }
