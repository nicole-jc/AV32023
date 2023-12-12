package antiV;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

/*Feito por: 
 Nicole Cavagnino  Jardim, RA: 172313373 :)
 Lana Soek da Silva, RA: 172320186 */

public class BuscarArquivos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.println("Informe o caminho da pasta que deseja buscar os arquivos");
		String initPasta = sc.nextLine();
		
		List<String> arquivosEncontrados = new ArrayList<>();
		
		buscarArquivos(initPasta, arquivosEncontrados);
		
		relatorioBusca(arquivosEncontrados);
		
		System.out.println("Digite Y para buscar novamente ou pressione qualquer tecla para sair");
		String escolhaUser = sc.nextLine();
		
		if(!escolhaUser.equalsIgnoreCase("Y")) {
			break;
		  }
		 }
		}
	
	private static void buscarArquivos(String pasta, List<String> resultados) {
		File diretorio = new File(pasta);
		File[] listaArquivos = diretorio.listFiles();
		
		if(listaArquivos != null) {
			for(File arquivo : listaArquivos) {
				if(arquivo.isDirectory()) {
					buscarArquivos(arquivo.getAbsolutePath(), resultados);
				} else {
					if(arquivo.getName().toLowerCase().endsWith(".exe") ||
							arquivo.getName().toLowerCase().endsWith(".bat")) {
						resultados.add(arquivo.getAbsolutePath());
					}
				}
			}
		}
	}
	
	private static void relatorioBusca(List<String> resultados) {
		System.out.println("Arquivos encontrados: ");
		
		if(resultados.isEmpty()) {
			System.out.println("Nenhum arquivo encontrado.");
			
		} else {
			for (String caminho : resultados) {
				System.out.println(caminho);
			}
		}
	}
}
