# Aula
Alterações principais

Main.java

Substituiu a classe de busca original (BuscaEmProfundidadeLimitada) pela nova BuscaEmProfundidadeIterativa.

Loop iterativo de profundidade passou a ser interno na classe de busca, deixando o Main mais limpo.

Impressão do caminho da solução em formato de tabuleiro 3x3.

Puzzle8.java

Implementado método getSucessores() para gerar todos os movimentos válidos do 8-puzzle.

Cada sucessor recebe referência ao ancestral e nível, fundamental para reconstruir o caminho da solução.

Sobrescrito toString() para exibir o tabuleiro de forma clara.

Mantidos atributos custo e avaliacao para futuras expansões.

Estado.java

Criada classe base genérica para estados (Estado), contendo:

Estado atual (T estado)

Nível (nivel)

Ancestral (ancestral)

Método getSucessores() genérico

Sobrescrita de equals() e toString()

BuscaEmProfundidadeIterativa.java

Estrutura de busca limpa e segura:

Pilha (Stack) para explorar estados (DFS).

Loop iterativo que aumenta o limite de profundidade até encontrar a solução.

Reconstrução do caminho da solução com ancestral.

Checagem de pilha vazia para evitar exceções.

Separação clara entre busca limitada e loop iterativo.
