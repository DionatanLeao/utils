public class ValidarCNPJ {
    public static void main(String[] args) {
        String cnpj = "36.376.039/0001-50";
        boolean retorno = validarCNPJ(cnpj);

        if (retorno == true) {
            System.out.println("CNPJ válido");
        }
        else {
            System.out.println("CNPJ inválido");
        }
    }

    public static boolean validarCNPJ(String cnpj) {
        int tamanho;
        String numeros;
        String digitos;
        int soma;
        int pos;
        int resultado;

        cnpj = cnpj.replace(".", "");
        cnpj = cnpj.replace("/", "");
        cnpj = cnpj.replace("-", "");

        if (cnpj == "") return false;

        if (cnpj.length() != 14)
            return false;

        // Valida o digito vefiricador
        tamanho = cnpj.length() - 2;
        numeros = cnpj.substring(0, tamanho);
        digitos = cnpj.substring(tamanho);
        soma = 0;
        pos = tamanho - 7;
        for (int i = tamanho; i >= 1; i--) {
            soma += numeros.charAt(tamanho - i) * pos--;
            if (pos < 2)
                pos = 9;
        }
        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
        if (resultado != digitos.charAt(0))
            return false;

        tamanho = tamanho + 1;
        numeros = cnpj.substring(0, tamanho);
        soma = 0;
        pos = tamanho - 7;
        for (int i = tamanho; i >= 1; i--) {
            soma += numeros.charAt(tamanho - i) * pos--;
            if (pos < 2)
                pos = 9;
        }
        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
        if (resultado != digitos.charAt(1))
            return false;

        return true;
    }
}


