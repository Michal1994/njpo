package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuadraticEquationSolverTest {

	@Test
	public void testNotQuadratic() {
		assertEquals(false, QuadraticEquationSolver.isQuadraticEquation(0));
	}
	
	@Test
	public void testQuadratic() {
		for(int i = -99; i < 100; i+=2)
			assertEquals(true, QuadraticEquationSolver.isQuadraticEquation(i));
	}
	
	@Test
	public void testDeltaNegativ() {
		assertEquals(-4, QuadraticEquationSolver.calculateDelta(1, 0, 1), 0);
		assertEquals(-8, QuadraticEquationSolver.calculateDelta(1, 2, 3), 0);
	}
	
	@Test
	public void testDeltaZero() {
		assertEquals(0, QuadraticEquationSolver.calculateDelta(1, 2, 1), 0);
		assertEquals(0, QuadraticEquationSolver.calculateDelta(4, 4, 1), 0);
	}
	
	@Test
	public void testDeltaPositiv() {
		assertEquals(80, QuadraticEquationSolver.calculateDelta(1, -10, 5), 0);
		assertEquals(8, QuadraticEquationSolver.calculateDelta(7, 8, 2), 0);
	}
	
	@Test
	public void testSolveNotQuadratic() {
		double[] array = new double[1];
		array[0] = 5;
		assertArrayEquals(array, QuadraticEquationSolver.calculateRootsOfEquation(0, 2, -10), 0);
	}
	
	@Test
	public void testSolveQuadraticDeltaNegativ() {
		double[] array = new double[0];
		assertArrayEquals(array, QuadraticEquationSolver.calculateRootsOfEquation(1, 0, 1), 0);
	}
	
	@Test
	public void testSolveQuadraticDeltaZero() {
		double[] array = new double[1];
		array[0] = -1;
		assertArrayEquals(array, QuadraticEquationSolver.calculateRootsOfEquation(1, 2, 1), 0);
	}
	
	@Test
	public void testSolveQuadraticDeltaPositiv() {
		double[] array = new double[2];
		array[0] = -2;
		array[1] = -1;
		assertArrayEquals(array, QuadraticEquationSolver.calculateRootsOfEquation(1, 3, 2), 0);
	}
	
}
