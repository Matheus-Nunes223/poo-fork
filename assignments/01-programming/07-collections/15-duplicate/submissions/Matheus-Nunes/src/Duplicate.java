import java.util.Scanner;
import java.util.TreeSet;

public class Dupiclate {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        TreeSet<String> nomes = new TreeSet<String>();
        String opcao;
        
        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        System.out.print("> ");
        opcao = teclado.nextLine();
        while(!(opcao.equalsIgnoreCase("fim"))){
            if (!opcao.trim().isEmpty()) {
                String nomeFormatado = opcao.substring(0, 1).toUpperCase() + opcao.substring(1).toLowerCase();
                nomes.add(nomeFormatado);
            }
            System.out.print("> ");
            opcao = teclado.nextLine(); 
        }
        
        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes); 
        
        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");
        System.out.print("> ");
        opcao = teclado.nextLine();
        
        while(!opcao.equalsIgnoreCase("sair")){
            String buscaFormatada = opcao.substring(0, 1).toUpperCase() + opcao.substring(1).toLowerCase();
            if(nomes.contains(buscaFormatada)){
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
            System.out.print("> ");
            opcao = teclado.nextLine();
        }
    }
        
}