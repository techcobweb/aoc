package net.techcobweb.aoc.day1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void findPairSimpleTwoNumbers() throws Exception 
    {
        App toTest = new App();
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add( 2020 );
        numbers.add( 0 );
        Integer[] pair  = toTest.findPairAddingUpTo2020( numbers );
        assertEquals( 2020 , pair[0].intValue() );
        assertEquals( 0 , pair[1].intValue() );
    }


    @Test
    public void findSingle1010NumberIsntAPair() throws Exception 
    {
        App toTest = new App();
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add( 1010 );
        try {
            Integer[] pair  = toTest.findPairAddingUpTo2020( numbers );
            fail("Single 1010 number should not be detected as a pair!");
        }
        catch( Exception ex ) {
            // Expected.
        }
    }


    @Test
    public void findTwo1010NumbersAreAPair() throws Exception 
    {
        App toTest = new App();
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add( 1010 );
        numbers.add( 1010 );
        Integer[] pair  = toTest.findPairAddingUpTo2020( numbers );
        assertEquals( 1010 , pair[0].intValue() );
        assertEquals( 1010 , pair[1].intValue() );
    }


    @Test
    public void findPairIn4Numbers() throws Exception 
    {
        App toTest = new App();
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add( 1010 );
        numbers.add(1);
        numbers.add(2);
        numbers.add( 1010 );
        Integer[] pair  = toTest.findPairAddingUpTo2020( numbers );
        assertEquals( 1010 , pair[0].intValue() );
        assertEquals( 1010 , pair[1].intValue() );
    }


    @Test
    public void findPairInSimpleTestNumbers() throws Exception 
    {
        App toTest = new App();
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add( 1721 );
        numbers.add( 979 );
        numbers.add( 366 );
        numbers.add( 299 );
        numbers.add( 675 );
        numbers.add( 1456 );
        Integer[] pair  = toTest.findPairAddingUpTo2020( numbers );
        assertEquals( 1721 , pair[0].intValue() );
        assertEquals( 299 , pair[1].intValue() );
    }


    @Test
    public void readFileIntoList() throws Exception 
    {
        App toTest = new App();
        List<Integer> numbers = toTest.readFileIntoList("simple.txt");
        Integer[] pair  = toTest.findPairAddingUpTo2020( numbers );
        assertEquals( 1721 , pair[0].intValue() );
        assertEquals( 299 , pair[1].intValue() );
    }

    
    @Test
    public void solveSimpleProblem() throws Exception 
    {
        App toTest = new App();
        long result = toTest.solve("simple.txt");
        assertEquals( 1721L*299L , result );
    }

    @Test
    public void solveComplexProblem() throws Exception 
    {
        App toTest = new App();
        long result = toTest.solve("complex.txt");
        assertEquals( 299299L , result );
    }

}
