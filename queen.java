package mmmmm;
import java.util.*;
public class Quuenproblem {
	static boolean isSafe(char[][] dp,int row,int col,int n)
	{
		for(int i=row;i>=0;i--)
		{
			if(dp[i][col]=='Q')
				return false;
		}
		for(int i=row,j=col;i>=0&&j>=0;i--,j--)
		{
			if(dp[i][j]=='Q')
			{
				return false;
			}
			
		}
		for(int i=row,j=col;i>=0&&j<n;i--,j++) {
			if(dp[i][j] == 'Q')
				return false;
		}
		return true;
	}
	static void display(char[][] dp,int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
	static void place(char[][] dp,int row,int n)
	{
		if(row==n)
		{
			display(dp,n);
			return;
		}
		else
		{
			for(int col=0;col<n;col++)
			{
				if(isSafe(dp,row,col,n))
				{
					dp[row][col]='Q';
					place(dp,row+1,n);
					dp[row][col]='-';
				}
			}
		}
	}

	public static void main(String[] args) {
		int n=5;
		char[][] dp=new char[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				dp[i][j]='-';
			}
		}
		place(dp,0,n);

	}

}
