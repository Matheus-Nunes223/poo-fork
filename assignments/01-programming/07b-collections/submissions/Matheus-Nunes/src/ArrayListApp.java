
import java.util.ArrayList;
import java.util.Collections;
 
public class ArrayListApp {
  public static void main(String[] args) {
 
        // Create and Print ArrayList:
        System.out.println("Create and Print ArrayList:");
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);
 
        // Iterate ArrayList Elements:
        System.out.println("Iterate ArrayList Elements:");
        for (String cor : cores) {
        System.out.println(cor);
        }
 
        // Insert at First Position:
        System.out.println("Insert at First Position:");
        cores.add(0, "Vermelho");
        System.out.println(cores);
 
        // Retrieve Element by Index:
        System.out.println("Retrieve Element by Index:");
        int indexBusca = 2;
        if (indexBusca >= 0 && indexBusca < cores.size()) {
            System.out.println("Elemento no índice " + indexBusca + ": " + cores.get(indexBusca));
        } else {
            System.out.println("Índice " + indexBusca + " inválido.");
        }
 
        // Update ArrayList Element:
        System.out.println("Update ArrayList Element:");
        String elementoAtualizado = cores.set(1, "Laranja");
        System.out.println("Elemento atualizado: " + elementoAtualizado);
        System.out.println(cores);
 
        // Remove Third Element:
        System.out.println("Remove Third Element:");
        // 🔧 ERRO 5: era "cores.size() < 2" → deve ser "cores.size() > 2" para garantir que índice 2 existe
        if (cores.size() > 2) {
            String removido = cores.remove(2);
            System.out.println("Elemento removido: " + removido);
        } else {
            System.out.println("O ArrayList não possui terceiro elemento.");
        }
        System.out.println(cores);
 
        // Search Element in ArrayList:
        System.out.println("Search Element in ArrayList:");
        System.out.println("Lista atual: " + cores);
        String busca = "Laranja";
        System.out.println("\"" + busca + "\" está na lista? " + cores.contains(busca));
 
        // Sort ArrayList:
        System.out.println("Sort ArrayList:");
        Collections.sort(cores);
        System.out.println(cores);
 
        // Copy ArrayList:
        System.out.println("Copy ArrayList:");
        ArrayList<String> coresCopia = new ArrayList<>(cores);
        System.out.println("Lista copiada: " + coresCopia);
 
        // Shuffle ArrayList:
        System.out.println("Shuffle ArrayList:");
        Collections.shuffle(cores);
        System.out.println("Lista embaralhada: " + cores);
 
        // Reverse ArrayList:
        System.out.println("Reverse ArrayList:");
        Collections.reverse(cores);
        System.out.println("Lista invertida: " + cores);
 
        // Extract Sublist from ArrayList:
        System.out.println("Extract Sublist from ArrayList:");
        int fromIndex = 0;
        int toIndex = 2;
        if (fromIndex >= 0 && toIndex <= cores.size() && fromIndex <= toIndex) {
            System.out.println("Sublista [" + fromIndex + ", " + toIndex + "): " + cores.subList(fromIndex, toIndex));
        } else {
            System.out.println("Índices de sublista inválidos.");
        }
 
        // Compare Two ArrayLists:
        System.out.println("Compare Two ArrayLists:");
        ArrayList<String> listaA = new ArrayList<>();
        listaA.add("Verde");
        listaA.add("Azul");
        ArrayList<String> listaB = new ArrayList<>();
        listaB.add("Verde");
        listaB.add("Azul");
        System.out.println("listaA: " + listaA);
        System.out.println("listaB: " + listaB);
        System.out.println("São iguais? " + listaA.equals(listaB));
 
        // Swap ArrayList Elements:
        System.out.println("Swap ArrayList Elements:");
        int posA = 0, posB = cores.size() - 1;
        System.out.println("Antes do swap: " + cores);
        Collections.swap(cores, posA, posB);
        System.out.println("Após swap [" + posA + "] <-> [" + posB + "]: " + cores);
 
        // Join Two ArrayLists:
        System.out.println("Join Two ArrayLists:");
        ArrayList<String> extras = new ArrayList<>();
        extras.add("Rosa");
        extras.add("Roxo");
        ArrayList<String> listaUnida = new ArrayList<>(cores);
        listaUnida.addAll(extras);
        System.out.println("Lista unida: " + listaUnida);
 
        // Clone ArrayList:
        System.out.println("Clone ArrayList:");
        @SuppressWarnings("unchecked")
        ArrayList<String> listaClonada = (ArrayList<String>) cores.clone();
        System.out.println("Lista clonada: " + listaClonada);
 
        // Clear ArrayList:
        System.out.println("Clear ArrayList:");
        cores.clear();
        System.out.println("Lista após clear: " + cores);
 
        // Check if ArrayList is empty:
        System.out.println("Check if ArrayList is empty:");
        System.out.println("O ArrayList está vazio? " + cores.isEmpty());
 
        // Trim ArrayList Capacity:
        System.out.println("Trim ArrayList Capacity:");
        cores.trimToSize();
        System.out.println("trimToSize() chamado: " + cores);
 
        // Increase ArrayList Capacity:
        System.out.println("Increase ArrayList Capacity:");
        cores.ensureCapacity(20);
        System.out.println("ensureCapacity(20) chamado: " + cores);
 
        // Repovoando para as últimas operações
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
 
        // Replace Second Element:
        System.out.println("Replace Second Element:");
        System.out.println("Antes: " + cores);
        cores.set(1, "Cinza");
        System.out.println("Após substituir índice 1 por Cinza: " + cores);
 
        // Print Elements by Position:
        System.out.println("Print Elements by Position:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
    }
}
