package refatora;
public class Refatora {
    public static void main(String[] args) {
        //INSTÂNCIA OBJETO DA CLASSE GERADOR DE NOTA FISCAL
        GeradorDeNotaFiscal geradorNota = new GeradorDeNotaFiscal();
        //INSTÂNCIA OBJETO DA CLASSE FATURA
        Fatura geraFatura = new Fatura();
        // EXECUTA OS METODOS
        geradorNota.gera(geraFatura);

    }
    
}
