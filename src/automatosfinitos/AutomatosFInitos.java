package automatosfinitos;

public class AutomatosFInitos {

    static int[][][] transicao = {{{0, 1}, {0}}, {{}, {2}}, {{}, {}}};
    static int[] aceitacao = {2};

    public static void main(String[] args) {
        String entrada = "11100";
        int posicao = 0;
        int[] estados = {0};
        int[] estadosFinais = testa(entrada, estados, posicao);
        if(aceita(estadosFinais)) {
            System.out.println("Cadeia aceita");
        } else {
            System.out.println("Cadeia rejeitada");
        }
    } // fim da main

    private static int[] testa(String entrada, int[] estados, int posicao) {
        if (posicao == entrada.length()) {
            if (aceita(estados)) {
                return estados;
            }
            System.out.println("<<backtrack>> Fim da cadeia");
            return null;
        }
        int simbolo = Integer.parseInt(entrada.substring(posicao, posicao + 1));
        for (int i : estados) {
            imprimeCI(entrada, i, posicao);
            int[] novosEstados = transicao[i][simbolo];
            if (novosEstados.length == 0) {
                System.out.println("<<backtrack>> Sem opções");
                return null;
            } // fim do if
            int[] transicoes = testa(entrada, novosEstados, posicao + 1);
            if (transicoes != null) return transicoes;
        } // fim do for
        return null;
    } // fim da função testa

    private static boolean aceita(int[] estados) {
        if (estados == null) return false;
        for (int i : estados) {
            for (int j : aceitacao) {
                if (i == j) return true;
            }
        }
        return false;
    } // fim da função aceita

    private static void imprimeCI(String entrada, int estado, int posicao) {
        System.out.print(entrada.substring(0, posicao));
        System.out.print("[q"+estado+"]");
        System.out.println(entrada.substring(posicao));
    }

} // fim da clasee
