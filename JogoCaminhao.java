import java.util.Scanner;

public class caminhao {

	int combustivel = 6;
	int posicao = 0;
	int [] mapa = new int [10];

	public void avancar(){
		if ((combustivel>0)&&(posicao<mapa.length-1)){
			posicao++;
			combustivel--;
		}
		else if ((combustivel <=0)&&(mapa[posicao]>0)){
			System.out.println("voce esta sem combustivel porem olha pro lado tem ali pega!");
		}
		else if (combustivel<=0){
			System.out.println("você esta sem combustivel nb ");
			System.exit(0);
		}
		if (posicao == mapa.length-1){
			System.out.println("**!!Winner!!**");
			System.exit(0);
		}

	}
	public void voltar(){

		if ((combustivel>0)&&(posicao<9)){
			combustivel--;
			posicao--;
		}

		else if ((combustivel<=0)&&(mapa[posicao]>0)){
			System.out.println("Você esta sem combustivel carregue ao lado \n");

		}
		else if (combustivel<=0){
			System.out.println("voce esta sem combustivel, <<<Game Over>>> \n");
			System.exit(0);
		}
	}
	public void carregar(){
		if (posicao==0){
			combustivel=6;
		}
		else if (mapa[posicao]>0){
			combustivel++;
			mapa[posicao]--;
			System.out.println("Carregado \n");

		}else if (mapa[posicao]<=0){
			System.out.println("não tem combustivel neste local \n");
		}
	}
	public void descarregar() {
		
		
		if (combustivel<=0){
			System.out.println("você esta sem combustivel nb sem cheats para o senhor ");
		}

		else if ((combustivel>0)&&(mapa[posicao]>=0)){
			mapa[posicao]++;
			combustivel--;
			System.out.println("descarregado \n");

		}


	}

	public String checar(){
		String checar="";
		checar+="Posicao: "+posicao+
				" Combustivel: "+combustivel+
				" Combustiveis nesta posição do Caminho: "+mapa[posicao];
		return checar;

	}


	public static void main(String [] args){
		boolean loop = true;
		Scanner ler = new Scanner(System.in);
		String opcao;
		caminhao carro = new caminhao();
		do{
			System.out.println("Você esta iniciando o jogo caminhão onde quer ir?\n Para avançar digite Avancar: \n" +
					" Para Voltar Digite voltar: \n"+ "para carregar digite carregar: \n para descarregar digite descarregar:");
			opcao = ler.next();

			if (opcao.equals("avancar")){
				carro.avancar();
				System.out.println(carro.checar());

			}else if(opcao.equals("voltar")){
				carro.voltar();
				System.out.println(carro.checar());

			}else if (opcao.equals("carregar")){
				carro.carregar();
				System.out.println(carro.checar());

			}else if (opcao.equals("descarregar")){
				carro.descarregar();
				System.out.println(carro.checar());
			}

		}while(loop=true);

		ler.close();
	}
}
