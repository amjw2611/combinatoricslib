package org.paukov.simplex;

import java.util.List;

import org.junit.Test;
import org.paukov.simplex.Simplex;
import org.paukov.simplex.exception.SimplexException;
import org.paukov.simplex.parser.Parser;
import org.paukov.simplex.parser.Token;
import org.paukov.simplex.problem.Solution;

import static org.junit.Assert.assertEquals;

public class SimplexTest {

    @Test
    public void simpleMaxTest() {

	String[] problem = new String[] { " MAX 50X1+60X2+65X3",
		"SUBJECT TO", 
		"2X1 + 3X2 + 2.5X3 <= 600",
		"3X1 + 2X2 + 2.5X3 <= 500",
		"X1 + 2X2 + X3 = 100",
		"X1 >=0",
		"X2 >=0", 
		"X3 >=0", "END" };

	Parser parser = new Parser(problem);

	List<Token> tokens = parser.getTokens();

	Simplex simplexSolver = null;
	try {
	    simplexSolver = new Simplex(tokens);
	} catch (SimplexException e) {
	    e.printStackTrace();
	    System.out.print("Error");
	}
	Solution solution = simplexSolver.resolve();
	System.out.print(solution);

	assertEquals(6500.0, solution.getOptimalObjectiveFunctionValue(),
		0.00001);
	assertEquals(0.0, solution.getResult("X1"), 0.00001);
	assertEquals(0.0, solution.getResult("X2"), 0.00001);
	assertEquals(100.0, solution.getResult("X3"), 0.00001);

    }
    
    public void simpleMinTest() {

	String[] problem = new String[] { " MIN 50X1+60X2+65X3",
		"SUBJECT TO", "2X1 + 3X2 + 2.5X3 <= 600",
		"3X1 + 2X2 + 2.5X3 <= 500", "X1 + 2X2 + X3 = 100", "X1 >=0",
		"X2 >=0", "X3 >=0", "END" };

	Parser parser = new Parser(problem);

	List<Token> tokens = parser.getTokens();

	Simplex simplexSolver = null;
	try {
	    simplexSolver = new Simplex(tokens);
	} catch (SimplexException e) {
	    e.printStackTrace();
	    System.out.print("Error");
	}
	Solution solution = simplexSolver.resolve();
	System.out.print(solution);

	assertEquals(3000.0, solution.getOptimalObjectiveFunctionValue(),
		0.00001);
	assertEquals(0.0, solution.getResult("X1"), 0.00001);
	assertEquals(50.0, solution.getResult("X2"), 0.00001);
	assertEquals(0.0, solution.getResult("X3"), 0.00001);

    }

   
    
}
