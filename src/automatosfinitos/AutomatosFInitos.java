
package automatosfinitos;


public class AutomatosFInitos {

    public static void main(String[] args) {
        String entrada = "1111000";
        int posicao = 0, estado = 0;
        int[][] transicao = {{0, 1}, {1, 0}};
        int[] aceitacao = {1};
         while (posicao < entrada.length()) {
            imprimeCI(entrada, estado, posicao);
            int simbolo = Integer.parseInt(
                    entrada.substring(posicao, posicao+1) );
            estado = transicao[estado][simbolo];
            posicao++;
        } // fim do while
        imprimeCI(entrada, estado, posicao);
        boolean aceita = false;
        for (int i : aceitacao) {
            if (estado == i){
                aceita = true; break;
            }
        } // fim do for
        System.out.println("Cadeia aceita? " 
                + (aceita ? "SIM" : "NÃO"));
    } // fim da main

    private static void imprimeCI(String entrada, int estado, int posicao) {
        System.out.print(entrada.substring(0, posicao));
        System.out.print("[q"+estado+"]");
        System.out.println(entrada.substring(posicao));
    }

} // fim da clasee
