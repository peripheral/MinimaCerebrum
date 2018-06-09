package mlp.trainer.tests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import mlp.trainer.Backpropagation;

public class BackpropagationTest {
	private Backpropagation sut;

	@BeforeEach
	void init() {
		sut = new Backpropagation();
	}

	void testCalculateSquiredErrorPerNeuron() {

	}

	/**
	 * Test for function of determining if the data has NoneZeroMean,
	 * that takes as input array with input arrays.
	 * The row presents an input example, the column presents attribute
	 * isNoneZeroMean should return true if the mean != 0 else false
	 */
	@Test
	void testNoneZeroMean() {
		float[][] data = {{1,2,-2},
				{1,5,6},
				{1,5,-4}};
		boolean[] isNoneZeroMeanActual = sut.isNoneZeroMean(data);
		boolean[] expected = {true,true,false};
		assertArrayEquals(expected,isNoneZeroMeanActual);
	}

	/**
	 * Test tests function that determines if Variance is too large.
	 *  Function takes as input array with input arrays.
	 * The row presents an input example, the column presents attribute.
	 * The function isLargeVariance bases on ratio of expected(mean) / standard deviation and user defined threshold.
	 * if expected(mean) / standard deviation > threshold - false, else true
	 * A1 = {1,2,3}, A2 = {4,5,6}, A3 = {7,100,-50}
	 * Mean A1 = 2, mean A2 = 5, mean A3 = 28.5; 
	 * Variance A1 = (1-2)^2+(2-2)^2+(3-2)^2 = 1+0+1 = 2
	 * Variance A2 = (4-5)^2+(5-5)^2+(6-5)^2 = 1+0+1 = 2
	 * Variance A3 = ((7-28.5)^2+(100-28.5)^2+(-50-28.5)^2)/3 = 3912.25
	 * standard dev A3 = 62.5479815821
	 */
	@Test
	void testIsVarianceLarge() {
		float[][] data = {{1,4,7},
				{2,5,100},
				{3,6,-50}};
		float threshold = 0.50f;
		boolean[] expected = {false,false,true};
		boolean[] isVarianceLargeActual = sut.isLargeVariance(data,threshold);
		assertArrayEquals(expected,isVarianceLargeActual);
	}

	/**
	 * Test tests function that determines if inputs are correlated. 
	 * Function takes as input array with input arrays.
	 * The row presents an input example, the column presents attribute
	 * Correlation with Person's moment product  Pxy = Cov(X,Y)/(sY*sX);
	 * mean A1 = 2,mean A2 = 5, mean A3 = 8;
	 * Variance A1 = (1-2)^2+(2-2)^2+(3-2)^2 = 1+0+1 = 2
	 * Variance A2 = (4-5)^2+(5-5)^2+(6-5)^2 = 1+0+1 = 2
	 * Variance A3 = (7-8)^2+(8-8)^2+(9-8)^2 = 1+0+1 = 2
	 * Cov(A1,A2)  = E[(X - E[X])*(Y-E[Y])]
	    = ((1-2)*(4-5)+(1-2)*(5-5)+(1-2)*(6-5)+
		(2-2)*(4-5)+(2-2)*(5-5)+(2-2)*(6-5)+
		(3-2)*(4-5)+(3-2)*(5-5)+(3-2)*(6-5)) = 0
	 * Pa1a2 = Cov(A1,A2)/(sA1*sA2) = 0
	 */
	@Test
	void testTestOnCorrelationAmongVariables () {
		float[][] data = {{1,4,7},
				{2,5,8},
				{3,6,9}};
		boolean[] isCorrelatedExpected = {false,false,false};
		float threshold = 0.3f;
		boolean[] isCorrelated = sut.areInputsCorrelated(data,threshold);

		assertArrayEquals(isCorrelatedExpected,isCorrelated);
	}

}