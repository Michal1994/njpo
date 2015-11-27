package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RandomArrayGeneratorTest {

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

}
