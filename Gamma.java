package helper;

import java.util.Scanner;

public class Gamma {

	//function to find minimum of 3 numbers
	static float min(float a,float b, float c)
	{
		if(a<b && a<c)
		{
			return a;
		}
		else if (b<c && b<a)
		{
			return b;
		}
		else
		{
			return c;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Change the value of r->row and c->column in program in line number 29,30 to required input values");
		Scanner sc=new Scanner(System.in);
		
		int r=7; // number of rows
		int c=8; // number of columns
		
		System.out.println("Enter all the "+r+" rows elements and then enter all the "+c+" column elements");
		// incrementing the number of to form matrix of 1 extra row and column to have infinity in first row and column
		r++; 
		c++;
		
		float[] row=new float[r];
		float[] col=new float[c];
		//to store the row element
		for(int i=1;i<r;i++)
		{
			row[i]=sc.nextFloat();
		}
		//to store the column element
		for(int j=1;j<c;j++)
		{
			col[j]=sc.nextFloat();
		}
		//2D array mat[][] to do the computations
		float[][] mat=new float[r][c];
		
		//storing 99.99 which represents infinity in the first row and first column of mat[][]
		//this value needs to be changed if the number in the input are higher than this
		for(int i=0;i<r;i++)
		{
			mat[i][0]=99.99f;
		}
		for(int j=0;j<c;j++)
		{
			mat[0][j]=99.99f;
		}
		
		//storing 0 at mat[0][0]
		mat[0][0]=0;
		
		//computations and storing them in array mat[][]
		for(int i=1;i<r;i++)
		{
			for(int j=1;j<c;j++)
			{
				mat[i][j]=((row[i]-col[j])*(row[i]-col[j])) + min(mat[i-1][j],mat[i-1][j-1],mat[i][j-1]);
			}
		}

		//printing the array[][] 
		System.out.printf("\t\t");
		for(int i=1;i<c;i++)
		{
			System.out.printf("%.2f\t",col[i]);
		}
		System.out.println();
		for(int i=0;i<7;i++)
		{
			System.out.printf("____________");
		}
		
		System.out.println();
		for(int i=0;i<r;i++)
		{
			if(i==0)
			{
				System.out.printf("\t|");
			}
			else
			{
				System.out.printf("%.2f\t|",row[i]);
			}
			
			for(int j=0;j<c;j++)
			{
				System.out.printf("%.2f\t",mat[i][j]);
			}
			System.out.println();
		}
		for(int i=0;i<7;i++)
		{
			System.out.printf("-------------");
		}
		
		// i and r to point to starting point 
		int i=r-1,j=c-1;
		System.out.println("\n"+"The path is ");
		
		//finding minimum value from left, top and left top diagonal elements to form the path
		while(i!=1 || j!=1)
		{
			System.out.printf("( %d,%d ),",i,j);
			
			if(mat[i-1][j]<mat[i-1][j-1] && mat[i-1][j]<mat[i][j-1])
			{
				i=i-1;
			}
			
			else if (mat[i-1][j-1]<mat[i][j-1] && mat[i-1][j-1]<mat[i-1][j])
			{
				i=i-1;
				j=j-1;
			}
			
			else
			{
				j=j-1;
			}
		}
		System.out.println("( "+i+","+j+" ),");
		sc.close();
	}
}
//0.2 0.3 0.2 0.4 0.1 0.9 
//f
//0.2 0.3 0.5 0.4 0.4 0.6 0.2
//0.3 0.4 0.5 0.55 0.65 0.7 0.8 0.1 
//0.1 0.2 0.25 0.3 0.4 0.5 0.6 0.9  
//0.35 0.25 0.3 0.4 0.6 0.55 0.5 0.65
