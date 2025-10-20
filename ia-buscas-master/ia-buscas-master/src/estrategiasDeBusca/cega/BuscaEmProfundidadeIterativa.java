package estrategiasDeBusca.cega;

import java.util.Collections;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import espacoDeEstados.Estado;

public class BuscaEmProfundidadeIterativa {

    private Estado<?> eInicial;
    private Estado<?> eObjetivo;
    private int limiteMaximo;

    private Stack<Estado<?>> eAbertos = new Stack<>();
    private List<Estado<?>> caminho = new ArrayList<>();

    public BuscaEmProfundidadeIterativa(Estado<?> eInicial, Estado<?> eObjetivo, int limiteMaximo) {
        this.eInicial = eInicial;
        this.eObjetivo = eObjetivo;
        this.limiteMaximo = limiteMaximo;
    }

    public List<Estado<?>> getCaminhoSolucao() {
        return caminho;
    }

    public void buscar() {
        for (int limite = 0; limite <= limiteMaximo; limite++) {
            eAbertos.clear();
            caminho.clear();

            eInicial.setNivel(0);
            eAbertos.push(eInicial);

            if (buscaProfundidadeLimitada(limite)) {
                System.out.println("Solução encontrada no limite = " + limite);
                break;
            }
        }
    }

    private boolean buscaProfundidadeLimitada(int limite) {
        while (!eAbertos.isEmpty()) {
            Estado<?> atual = eAbertos.pop();

            if (atual.equals(eObjetivo)) {
                construirCaminho(atual);
                return true;
            }

            if (atual.getNivel() < limite) {
                for (Estado<?> suc : (List<Estado<?>>) atual.getSucessores()) {
                    suc.setNivel(atual.getNivel() + 1);
                    suc.setAncestral(atual);
                    eAbertos.push(suc);
                }
            }
        }
        return false;
    }

    private void construirCaminho(Estado<?> objetivo) {
        Estado<?> e = objetivo;
        while (e != null) {
            caminho.add(e);
            e = e.getAncestral();
        }
        Collections.reverse(caminho);
    }
}
