import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java RelatorioCompras <arquivo_entrada> <arquivo_saida>");
            return;
        }
        Path caminhoEntrada = Paths.get(args[0]);
        Path caminhoSaida   = Paths.get(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais   = new ArrayList<>();

        
        List<String> linhas;
        try {
            linhas = Files.readAllLines(caminhoEntrada);
        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
            return;
        }

        
        for (String linha : linhas) {
            String[] campos = linha.split(",");

            // Ignora linhas malformadas
            if (campos.length < 3) {
                continue;
            }

            String nomeCliente  = campos[0].trim();
            String valorStr     = campos[2].trim();

            double valor;
            try {
                valor = Double.parseDouble(valorStr);
            } catch (NumberFormatException e) {
                System.err.println("Valor inválido na linha, ignorando: \"" + linha + "\"");
                continue;
            }

            
            int indice = clientes.indexOf(nomeCliente);
            if (indice >= 0) {
                totais.set(indice, totais.get(indice) + valor);
            } else {
                clientes.add(nomeCliente);
                totais.add(valor);
            }
        }

        
        ArrayList<String> linhasSaida = new ArrayList<>();
        for (int i = 0; i < clientes.size(); i++) {
            linhasSaida.add(clientes.get(i) + ": " + totais.get(i));
        }

        
        try {
            Files.write(caminhoSaida, linhasSaida);
            System.out.println("Relatório gerado com sucesso em: " + caminhoSaida.toAbsolutePath());
        } catch (Exception e) {
            System.err.println("Erro ao gravar o arquivo de saída: " + e.getMessage());
        }
    }
}