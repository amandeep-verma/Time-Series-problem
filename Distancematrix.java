
package helper;

import java.util.Scanner;

public class Distancematrix {
	public static void main(String[] args) {
		
		System.out.println("Change the value of r->row and c->column in line number 12,13 to required input values");
		
		Scanner sc=new Scanner(System.in);
		int r=6; // number of rows
		int c=5; // number of columns
		
		System.out.println("Enter all the "+r+" rows elements and then enter all the "+c+" column elements");
		float[] row=new float[r];
		float[] col=new float[c];
		
		//to store the row element
		for(int i=0;i<r;i++)
		{
			row[i]=sc.nextFloat();
		}
		//to store the column element
		for(int j=0;j<c;j++)
		{
			col[j]=sc.nextFloat();
		}
		
		//2D array mat[][] to do the computations
		float[][] mat=new float[r][c];
		
		//computations and storing them in array mat[][]
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				mat[i][j]=(row[i]-col[j])*(row[i]-col[j]);
			}
		}
		
		//printing back the result from array mat[][]
		System.out.printf("\t");
		for(int i=0;i<c;i++)
		{
			System.out.printf("%.2f\t",col[i]);
		}
		System.out.println();
		for(int i=0;i<r;i++)
		{
			System.out.printf("%.2f\t",row[i]);
			for(int j=0;j<c;j++)
			{
				System.out.printf("%.2f\t",mat[i][j]);
			}
			System.out.println();
		}
		sc.close();
	}
}
