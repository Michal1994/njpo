package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandomArrayGeneratorTest {
	
	static long start;
	
	@Before
	public void start(){
		start = System.nanoTime();
	}
	
	@Test
	public void testGenerate() {
		int[] a = RandomArrayGenerator.generate();
		assertEquals(10000000, a.length);
	}
	
	@Test
	public void testSort() {
		int[] a = RandomArrayGenerator.generate();
		int[] b = a.clone();
		Arrays.sort(b);
		RandomArrayGenerator.sort(a, 0, a.length-1);
		assertArrayEquals(b, a);
	}
	
	@After
	public void end(){
		System.out.println( (System.nanoTime() - start)/1000000 + "ms" );
	}

}
