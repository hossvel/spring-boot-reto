package com.devhoss.utils;

import java.util.Arrays;

public class Utils {

	public static double promedioEdades(int[] array) {
		return Arrays.stream(array).average().orElse(Double.NaN);	
	}

	public static double desviacionEstandar( int[] array) {

		int sum = 0; 
		int n = array.length;
		double prom = promedioEdades(array);		    
		for (int i = 0; i < n; i++ ) 
			sum += Math.pow (array[i] - prom, 2);

		return Math.sqrt ( sum / ( double ) n );
	}

}
