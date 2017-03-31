/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author situsnow
 */

public class CalculateVF {
	
	public static void main (String args[]){
		int[][] aaMatrix = new int[5][5];
		aaMatrix[0][0] = 20;
		aaMatrix[0][1] = 20;
		aaMatrix[0][2] = 20;
		aaMatrix[0][3] = 20;
		aaMatrix[0][4] = 20;
		
		aaMatrix[1][0] = 20;
		aaMatrix[1][1] = 55;
		aaMatrix[1][2] = 55;
		aaMatrix[1][3] = 40;
		aaMatrix[1][4] = 55;
		
		aaMatrix[2][0] = 20;
		aaMatrix[2][1] = 55;
		aaMatrix[2][2] = 55;
		aaMatrix[2][3] = 40;
		aaMatrix[2][4] = 55;
		
		aaMatrix[3][0] = 20;
		aaMatrix[3][1] = 40;
		aaMatrix[3][2] = 40;
		aaMatrix[3][3] = 40;
		aaMatrix[3][4] = 40;
		
		aaMatrix[4][0] = 20;
		aaMatrix[4][1] = 55;
		aaMatrix[4][2] = 55;
		aaMatrix[4][3] = 40;
		aaMatrix[4][4] = 55;
		int[][] bondMatrix = new int[5][5];
		for (int x = 0; x < 5; x++){
			for (int y = 0; y < 5; y++){
				int result = 0;
				for (int z = 0; z < 5; z ++){
					result += aaMatrix[z][x] * aaMatrix[z][y];
					bondMatrix[x][y] = result;
				}
				
			}
		}
		
		System.out.println("The bond matrix is:");
		for(int x = 0; x < 5; x++){
			System.out.print("[");
			for (int y = 0; y < 5; y++){
				System.out.print(bondMatrix[x][y] + ",");
			}
			System.out.println("]");
		}
		
		//Change the i,k,j value according to the actual ordering
		int i = 3;
		int k = 4;
		int j = 5;
		
		int contValue;
		if (i == 0){
			contValue = 2 * bondMatrix[k-1][j-1];
		}else{
			contValue = 2 * bondMatrix[i-1][k-1] + 2 * bondMatrix[k-1][j-1] - 2 * bondMatrix[i-1][j-1];
		}
		
		System.out.println(contValue);
		
		
	}
	

}

