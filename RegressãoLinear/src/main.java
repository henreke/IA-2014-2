import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int N=23;
		double w1=1;
		double w0=1;
		double xtreino[]= new double[N];
		double ytreino[]=new double[N];
		int colunax=4;
		int colunay=2;
		double alfa=0.0001;
		double tolerancia=4;
		int passos=10000000;
		int p=0;
		
		double erro=100;
		String aux="";
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("H:\\IA\\o-ring-erosion-only.data"));
			aux=br.readLine();
			while(aux!=null)
			{		
     			String aux2[]=aux.split(" * ");
     			xtreino[p]=Double.parseDouble(aux2[colunax]);
     			ytreino[p]=Double.parseDouble(aux2[colunay]);
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
			double perda0=0;
			double perda1=0;
			for (int i=0;i<N;i++)
			{
				perda0+=(ytreino[i]-(w1*xtreino[i]+w0));
				perda1+=(ytreino[i]-(w1*xtreino[i]+w0))*xtreino[i];
			}
			erro=perda0*perda0;
			w1+=alfa*(perda1/N);
			w0+=alfa*(perda0/N);
			p++;

		}while ((erro>=tolerancia) && (p<passos));
	
		System.out.print("O valor de w1:"+w1+"\n valor de w0:"+w0+"\nCom "+p+" passos");
	//	System.in.read()

	}

}
