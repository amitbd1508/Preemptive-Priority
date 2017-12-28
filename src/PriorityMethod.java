/*
 * PriorityMethod.java
 *
 * Created on October 6, 2008, 3:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
import javax.swing.*;
public class PriorityMethod {
    
    public double AverageWaitingTime(int[] burst, int[] arrival, int[] priority){
        int i, j = 0, Tt=0, Time=0, min, max1=0;
        char[] S = new char[10];
        char[] start = new char[10];
        int[] Wt = new int[10];
        int[] B = new int[10];
        int[] A = new int[10];
        int[] P = new int[10];
        double Twt=0.0, Awt;
        
        for(i=1;i<=6;i++)
	{
            B[i]=burst[i];
            A[i]=arrival[i];
            P[i]=priority[i];
            Wt[i]=0;
            S[i]='T';
            start[i]='F';
            Tt=Tt+B[i];
            if(A[i]>Time)
		Time=A[i];
            if(P[i]>max1)
		max1=P[i];
	}
	
	int w=0,flag=0,t=0;
	i=1;
	while(t<Time)
	{
		if(A[i]<=t && B[i]!=0)
		{
			if(flag==0)
			{
				Wt[i]=Wt[i]+w;
			}
			B[i]=B[i]-1;
			if(B[i]==0)
				S[i]='F';
			start[i]='T';
			t++;
			w=w+1;
			if(S[i]!='F')
			{
				j=1;flag=1;
				while(j<=6 && flag!=0)
				{
					if(S[j]!='F' && P[i]>P[j] && A[j]<=t && i!=j)
					{
						flag=0;
						Wt[i]=Wt[i]-w;
						i=j;
					}
					else
					{
						flag=1;
					}
					j++;
				}
			}
			else
			{
				i++;
				j=1;
				while(A[j]<=t &&j<=6)
				{
					if(P[i]>P[j] && S[j]!='F')
					{
						flag=0;
						i=j;
					}
					j++;
				}
			}
		}
		else{
			if(flag==0)
               i++;
		    t++;
                }
	}
        while(w<Tt)
	{
		min=max1+1;
		i=1;
		while(i<=6)
		{
			if(min>P[i] && S[i]=='T')
			{
				min=P[i];
				j=i;
			}
			i++;
		}
		i=j;
		if(w==Time && start[i]=='T')
		{
			w=w+B[i];
			S[i]='F';
		}
		else
		{
			Wt[i]=Wt[i]+w;
			w=w+B[i];
			S[i]='F';
		}
	}
        for(i=1;i<=6;i++)
            Twt=Twt+(Wt[i]-A[i]);
        Awt=Twt/6;
        JOptionPane.showMessageDialog(null,"Waiting Time Info for every Process\n\tP1 = "+
                (Wt[1]-A[1])+"\n\tP2 = "+(Wt[2]-A[2])+"\n\tP3 = "+(Wt[3]-A[3])+"\n\tP4 = "+
                (Wt[4]-A[4])+"\n\tP5 = "+(Wt[5]-A[5])+"\n\tP6 = "+(Wt[6]-A[6]));
        return Awt;
    }
    
     public double AverageTurningTime(int[] burst, int[] arrival, int[] priority){
         int i, j = 0, Tt=0, Time=0, min, max1=0;
        char[] S = new char[10];
        char[] start = new char[10];
        int[] Wt = new int[10];
        int[] B = new int[10];
        int[] A = new int[10];
        int[] P = new int[10];
        int[] Wtm = new int[10];
        double Ttt=0.0, Att;
        for(i=1;i<=6;i++)
	{
            B[i]=burst[i];
            Wtm[i]=B[i];
            A[i]=arrival[i];
            P[i]=priority[i];
            Wt[i]=0;
            S[i]='T';
            start[i]='F';
            Tt=Tt+B[i];
            if(A[i]>Time)
		Time=A[i];
            if(P[i]>max1)
		max1=P[i];
	}
	
	int w=0,flag=0,t=0;
	i=1;
	while(t<Time)
	{
		if(A[i]<=t && B[i]!=0)
		{
			if(flag==0)
			{
				Wt[i]=Wt[i]+w;
			}
			B[i]=B[i]-1;
			if(B[i]==0)
				S[i]='F';
			start[i]='T';
			t++;
			w=w+1;
			if(S[i]!='F')
			{
				j=1;flag=1;
				while(j<=6 && flag!=0)
				{
					if(S[j]!='F' && P[i]>P[j] && A[j]<=t && i!=j)
					{
						flag=0;
						Wt[i]=Wt[i]-w;
						i=j;
					}
					else
					{
						flag=1;
					}
					j++;
				}
			}
			else
			{
				i++;
				j=1;
				while(A[j]<=t &&j<=6)
				{
					if(P[i]>P[j] && S[j]!='F')
					{
						flag=0;
						i=j;
					}
					j++;
				}
			}
		}
		else{
			if(flag==0)
               i++;
		    t++;
                }
	}
        while(w<Tt)
	{
		min=max1+1;
		i=1;
		while(i<=6)
		{
			if(min>P[i] && S[i]=='T')
			{
				min=P[i];
				j=i;
			}
			i++;
		}
		i=j;
		if(w==Time && start[i]=='T')
		{
			w=w+B[i];
			S[i]='F';
		}
		else
		{
			Wt[i]=Wt[i]+w;
			w=w+B[i];
			S[i]='F';
		}
	}
        for(i=1;i<=6;i++){
            Ttt=Ttt+((Wt[i]-A[i])+Wtm[i]);
        }
        Att=Ttt/6;
        JOptionPane.showMessageDialog(null,"Turning Time Info for every Process\n\tP1 = "+
                ((Wt[1]-A[1])+Wtm[1])+"\n\tP2 = "+((Wt[2]-A[2])+Wtm[2])+"\n\tP3 = "+((Wt[3]-A[3])+Wtm[3])+"\n\tP4 = "+
                ((Wt[4]-A[4])+Wtm[4])+"\n\tP5 = "+((Wt[5]-A[5])+Wtm[5])+"\n\tP6 = "+((Wt[6]-A[6])+Wtm[6]));
        return Att;
    }
}
