import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;
import javax.swing.text.Document;
import static java.lang.Thread.sleep;

	

	



public class Sudoku extends JFrame{
	
	public Sudoku(String s)
	{
		super();
	}
	
	private JTextField[][] box=new JTextField[9][9];
	private JButton solve;
	
	public void setcomponent()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				box[i][j]=new JTextField();
				 setLayout(null);
		           box[i][j].setBounds(50+25*(j),50+25*(i),25,25);
	              add(box[i][j]);
				  box[i][j].setMargin(new java.awt.Insets(2, 5, 2, 2));
				  box[i][j].setText("0");
				
			}
		}
		solve=new JButton();
		solve.setBounds(350,150,70,30);
		add(solve);
		solve.setText("Solve");
		solve.addActionListener(new Handler());
		
	}
	
class solution
{
int[][] a=new int[9][9];  
int xrow=0;
int xcol=0;


public void printff()
{
	for(int i=0;i<9;i++)
	{
		for(int j=0;j<9;j++)
			System.out.print(a[i][j]+" ");
		System.out.println("");
	}
}


public void initi()
{
	for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{   
					a[i][j]=Integer.parseInt(box[i][j].getText());
			}
		}
}
public void set_solution()
{
	for(int i=0;i<9;i++)
	{for(int j=0;j<9;j++)
		{
			box[i][j].setText(Integer.toString(a[i][j]));
		}
	}
}

public boolean checkunassign()
{

    for(int i=0;i<9;i++)
    {
        for(int j=0;j<9;j++)
        {
            if(a[i][j]==0)
			{xrow=i;
		     xcol=j;
				return true;
			}
        }
    }

        return false;
}
public boolean colmatch(int x,int ans)
  {

      for(int i=0;i<9;i++)
        if(a[i][x]==ans)
        return true;
      return false;
  }
 public boolean rowmatch(int x,int ans)
{
    for(int i=0;i<9;i++)
        if(a[x][i]==ans)
          return true;
    return false;
}

public boolean boxmatch(int x,int y,int ans)
{
    for(int i=x-x%3;i<x+3-x%3;i++)
    {
        for(int j=y-y%3;j<y+3-y%3;j++)
        {
            if(a[i][j]==ans)
                return true;
        }
    }
    return false;
}

public boolean is_safe(int x,int y,int ans)
  {
      return (!this.colmatch(y,ans)&&!this.rowmatch(x,ans)&&!this.boxmatch(x,y,ans));
  }

public boolean solver()
{
	int row;
	int col;
    if(!checkunassign())
        return true;
     row=xrow;
	 col=xcol;
	
    for(int i=1;i<=9;i++)
    {
        if(is_safe(row,col,i))
            {
              a[row][col]=i;
              if(solver())
                return true;
               a[row][col]=0;
              }

    }
    return false;
 }
}
	  class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("ABCDEFGHIJKL");
			System.out.println("ALI AKBAR ANSARI");
		
		
		solution obj=new solution();
		obj.initi();
		obj.solver();
		obj.printff();
		obj.set_solution();
	}
		
	}
	
	
	

	
	 public static void main(String[] args)
 {
	 Sudoku board=new Sudoku("Sudoku Solver");
	 board.setcomponent();
	 board.setSize(600,500);
	 board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 board.setVisible(true);
 }	 
}
