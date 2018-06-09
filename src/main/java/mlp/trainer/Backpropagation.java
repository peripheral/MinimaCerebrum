package mlp.trainer;

public class Backpropagation {

	/**
	 * Tests if the attributes in data are zero mean
	 * @param data - m by n matrix, m - rows, n - columns
	 * @return array with booleans in order A1,A2
	 */
	public boolean[] isNoneZeroMean(float[][] data) {
		if(data.length == 0) {
			return null;
		}
		boolean[] result = new boolean[data[0].length];
		float mean = 0;
		for(int col = 0; col < data[0].length; col++) {
			for(int row = 0;row < data.length;row++) {
				mean = mean + data[row][col]/data.length;
			}
			if(mean > Float.MIN_VALUE) {
				result[col] = true;
			}
			mean = 0;
		}
		return result;
	}

	/**
	 * Calculate variances per attribute, all values under same column belongs to same
	 * attributes 
	 * @param data - m by n matrix, m - rows, n - columns
	 * @return array with booleans in order A1,A2
	 */
	public boolean[] isLargeVariance(float[][] data, float threshold) {
		if(data.length == 0) {
			return null;
		}
		boolean[] result = new boolean[data[0].length];
		double[] mean = new double[data[0].length];
		double[] variance = new double[data[0].length];
		for(int col = 0; col < data[0].length; col++) {			
			mean[col] = 0;
			for(int row = 0;row < data.length;row++) {
				mean[col]  = mean[col] + data[row][col]/data.length;
			}
		}
		for(int col = 0; col < data[0].length; col++) {
			variance[col] = 0;
			for(int row = 0;row < data.length;row++) {
				variance[col]  = (float) (variance[col] + Math.pow(data[row][col]-mean[col],2)/data.length);
			}
		}
		for(int col = 0; col < result.length;col++) {
			if(threshold >= mean[col]/Math.sqrt(variance[col])) {
				result[col] = true;
			}
		}
		return result;
	}

	/**function that determines if inputs are correlated. 
	 * Function takes as input array of float arrays.
	 * The row presents an input example, the column presents attribute
	 * Correlation with Person's moment product  Pxy = Cov(X,Y)/(sY*sX);
	 * @param data - m by n matrix, m - rows, n - columns
	 * @param threshold - limit that evaluates correlation to true. 1 is positive correlation, -1 negative
	 * @return array with booleans in order A1,A2
	 */
	public boolean[] areInputsCorrelated(float[][] data, float threshold) {
		if(data.length == 0) {
			return null;
		}
		int resultSize = 0;
		for(int i = 0;i<data[0].length;i++) {
			resultSize = resultSize + i;
		}
		boolean[] result = new boolean[resultSize];
		double[] mean = new double[data[0].length];
		double[] covariance = new double[data[0].length];
		for(int col = 0; col < data[0].length; col++) {			
			mean[col] = 0;
			for(int row = 0;row < data.length;row++) {
				mean[col]  = mean[col] + data[row][col]/data.length;
			}
		}
		for(int col = 0; col < data[0].length-1; col++) {
			covariance[col] = 0;
			for(int row = 0;row < data.length;row++) {
				for(int row1 = 0;row1 < data.length;row1++) {
					covariance[col]  = (float) (covariance[col] +
							(data[row][col]-mean[col])*(data[row1][col+1]-mean[col+1])/(2*data.length));
				}
			}
		}

		for(int i = 0;i < covariance.length;i++) {
			for(int ii = 0;ii< mean.length-1;ii++) {
				if(threshold < Math.abs(covariance[i]/(mean[ii]*mean[ii+1]))) {
					result[i] = true;
				}else {
					result[i] = false;
				}
				i++;
			}
		}		
		return result;
	}

}