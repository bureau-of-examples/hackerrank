package codegolf.fizzbuzz;

/**
 * https://www.hackerrank.com/challenges/Solution
 */
class Solution{public static void main(String[]a){for(int i=0;++i<101;)System.out.println((i%3<1?"Fizz":"")+(i%5<1?"Buzz":i%3<1?"":i));}}
