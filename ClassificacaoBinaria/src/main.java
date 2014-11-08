import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int N=100;
		int D=4;
		double w1=1;
		double w0=1;
		double xtreino[][]= new double[N][D];
		double ytreino[]=new double[N];
		//String ytreino[]=new String[N];
		double wi[]=new double[D];
		int inicio=0;
		int colunax=3;
		int colunay=4;
		double alfa=0.01;
		double tolerancia=4;
		int passos=100000;
		int p=0;
		
		double erro=100;
		String aux="";
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Henrique\\Documents\\Eng Computação\\Inteligência Artificial\\Classificacao\\iris2.data"));
			aux=br.readLine();
			while(aux!=null)
			{		
     			String aux2[]=aux.split(",");
     			for (int i=inicio;i<(D-inicio);i++)
     				xtreino[p][i]=Double.parseDouble(aux2[i]);
     			if (aux2[colunay].contains("Iris-setosa"))
     				ytreino[p]=1;
     			else
     				ytreino[p]=0;
     			p++;
				aux=br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		p=0;
		do{
			double multwx=0;
			for (int i=0;i<N;i++)
			{
				for (int j=inicio;j<(D-inicio);j++)
				   multwx+=xtreino[i][j]*wi[j];

				int hx=limiar(multwx);
				for (int k=inicio;k<(D-inicio);k++)
					wi[k]=wi[k]-alfa*(hx-ytreino[i])*xtreino[i][k];
				multwx=0;
			}
			p++;

		}while ((p<passos));
	
		System.out.print("Com "+p+" passos");
	//	System.in.read()
		double i1,i2,i3,i4;
		Scanner input=new Scanner(System.in);
		do{
	        System.out.println("Entre com o I:");
	        i1=Double.parseDouble(input.nextLine());
	        System.out.println("Entre com o j:");
	        i2=Double.parseDouble(input.nextLine());
	        System.out.println("Entre com o x:");
	        i3=Double.parseDouble(input.nextLine());
	        System.out.println("Entre com o z:");
	        i4=Double.parseDouble(input.nextLine());
	     
	        int hx=limiar(wi[0]*i1+wi[1]*i2+wi[2]*i3+wi[3]*i4);
	        if (hx==1)
	        	System.out.println("Iris-Setosa");
	        else
	        	System.out.println("Iris-versicolor");
		}while ((i1+i2+i3+i4)!=0);
		input.close();
	}
	private static int limiar(double lim)
	{
		if (lim>0)
			return 1;
		else
			return 0;
	}

}
