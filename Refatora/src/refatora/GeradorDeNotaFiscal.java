package refatora;
public class GeradorDeNotaFiscal {

    public NotaFiscal gera(Fatura fatura) {
        // CALCULA VAL IMPOSTO
        NotaFiscal nf = geraNf(fatura);
        // ENV. EMAIL
        enviaEmail(nf);
        // ARMAZENA BD
        salvaNoBanco(nf);
        return nf;
    }
    // CALC DA NF
    private NotaFiscal geraNf(Fatura fatura) {
        double valor = fatura.getValorMensal();
        double imposto = 0;
        if (valor < 200) {
            imposto = valor * 0.03;
        } else if (valor > 200 && valor <= 1000) {
            imposto = valor * 0.06;
        } else {
            imposto = valor * 0.07;
        }

        NotaFiscal nf = new NotaFiscal(valor, imposto);

        return nf;

    }
    // MSG DO EMAIL
    private void enviaEmail(NotaFiscal nf) {
        String msgDoEmail = "Caro cliente, <br/>";
        msgDoEmail += "É com prazer que lhe avisamos que sua nota fiscal foi "
                + "gerada no valor de " + nf.getValorLiquido() + ".<br/>";
        msgDoEmail += "Acesse o site da prefeitura e faça o download.<br/><br/>";
        msgDoEmail += "Obrigado!";

        System.out.println(msgDoEmail);
    }
    // INSERT NO BD
    private void salvaNoBanco(NotaFiscal nf) {
        String sql = "insert into notafiscal (cliente, valor)"
                + "values (?," + nf.getValorLiquido() + ")";

        System.out.println("Salvando no banco" + sql);
    }
}
