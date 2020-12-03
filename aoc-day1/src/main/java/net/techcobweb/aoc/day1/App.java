package net.techcobweb.aoc.day1;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class App 
{
    private static final int SUM_TARGET = 2020 ;

    public Integer[] findPairAddingUpTo2020( List<Integer> possibleNumbers ) throws Exception {
        
        Collections.sort( possibleNumbers );

        int size = possibleNumbers.size();

        for( int firstNumberIndex = 0 ; firstNumberIndex < size ; firstNumberIndex +=1 ) {
            Integer firstNumber = possibleNumbers.get(firstNumberIndex);

            int secondNumberIndex = size-1 ;
            while( secondNumberIndex > firstNumberIndex ) {

                Integer secondNumber = possibleNumbers.get(secondNumberIndex);
  
                if( firstNumber + secondNumber == SUM_TARGET ) {
                    Integer[] pair = new Integer[2];
                    pair[1] = firstNumber ;
                    pair[0] = secondNumber ;
                    return pair ;
                }

                secondNumberIndex -=1 ;
            }
        }

        throw new Exception("No two numbers add up to 2020");
    }

	public List<Integer> readFileIntoList(String fileName) throws Exception {

        List<Integer> numbers = new ArrayList<Integer>();

        InputStream input = getClass().getClassLoader().getResourceAsStream(fileName);

        if( input == null ) {
            throw new Exception("Not found");
        }

        InputStreamReader reader = new InputStreamReader( input );
        LineNumberReader lineReader = new LineNumberReader(reader);


        boolean done = false ;
        while( !done ) {
            String line = lineReader.readLine();
            if( line == null ) {
                done = true ;
            } else {
                int number = Integer.parseInt(line);
                numbers.add(number);
            }
        }

		return numbers;
	}

	public long solve(String fileName) throws Exception {
        System.out.println("Reading list from file "+fileName);
        List<Integer> numbers = readFileIntoList(fileName);
        System.out.println("Read list containing "+numbers.size()+" numbers");
        Integer[] pair = findPairAddingUpTo2020( numbers );
        System.out.println("Numbers picked out are : "+pair[0]+" and "+pair[1]);
        long result = pair[0] * pair[1];
        return result ;
	}

}
