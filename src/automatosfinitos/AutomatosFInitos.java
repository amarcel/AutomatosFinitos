
package automatosfinitos;


public class AutomatosFInitos {

    public static void main(String[] args) {
        String entrada = "11100";
        int posicao = 0, estado = 0;
        while (posicao < entrada.length()) {
            imprimeCI(entrada, estado, posicao);
            char simbolo = entrada.charAt(posicao);
            if (estado == 0 && simbolo == '0') {
                estado = 0;
            } ...
            posicao++;
        } // fim do while
        imprimeCI(entrada, estado, posicao);
        
    } // fim da main

    private static void imprimeCI(String entrada, int estado, int posicao) {
        System.out.print(entrada.substring(0, posicao));
        System.out.print("[q"+estado+"]");
        System.out.println(entrada.substring(posicao));
    }

} // fim da clasee
