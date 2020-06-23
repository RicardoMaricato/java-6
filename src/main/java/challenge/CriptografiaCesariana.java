package challenge;

public class CriptografiaCesariana implements Criptografia {
    public static void main(String[] args) {
        CriptografiaCesariana teste = new CriptografiaCesariana();
        System.out.println(teste.descriptografar("ulfdugr"));
    }
    final int SEED = 3;

    @Override
    public String criptografar(String texto) {
        validateInput(texto);
        String lowerCaseInput = texto.toLowerCase();
        String result = moveCharsByValue(lowerCaseInput, SEED);

        return result;
    }

    @Override
    public String descriptografar(String texto) {
        validateInput(texto);
        String lowerCaseInput = texto.toLowerCase();
        String result = moveCharsByValue(lowerCaseInput, -SEED);

        return result;
    }

    private void validateInput(String input) {
        if (input == null)
            throw new NullPointerException();
        if (input.isEmpty())
            throw new IllegalArgumentException();
    }

    private String moveCharsByValue(String baseString, int value) {
        return baseString
                .codePoints()
                .map(character -> {
                    if (Character.isLetter(character))
                        return (char) ((int) character + value);
                    return character;
                }).collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append
                ).toString();
    }
}
