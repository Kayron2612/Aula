import espacoDeEstados.*;
import estrategiasDeBusca.cega.*;

public class Main {

    public static void main(String[] args) {

        char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
        char[] cfgFim = {'1','2','3','4','5','6','7',' ','8'};

        Puzzle8 puzzleInicial = new Puzzle8();
        puzzleInicial.setEstado(cfgIni);

        Puzzle8 puzzleFinal = new Puzzle8();
        puzzleFinal.setEstado(cfgFim);

        int limiteMaximo = 20;

        BuscaEmProfundidadeIterativa busca = new BuscaEmProfundidadeIterativa(puzzleInicial, puzzleFinal, limiteMaximo);
        busca.buscar();

        if (!busca.getCaminhoSolucao().isEmpty()) {
            System.out.println("\n--- Caminho da Solução ---");
            for (Estado<?> e : busca.getCaminhoSolucao()) {
                System.out.println(e);
            }
        } else {
            System.out.println("\n❌ Nenhuma solução encontrada.");
        }
    }
}
