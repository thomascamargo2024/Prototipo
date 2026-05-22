package modelos;

public class Cadastro {
    private static int contador = 1;

    private Integer id;
    private String nome;
    private String fone;
    private String cpf;

    public Cadastro(String nome, String fone, String cpf) {
        this.id = contador++;
        this.nome = nome;
        this.fone = fone;
        this.cpf = cpf;
    }

    public String getNome() { return nome; }

    public String getCpf(){
        return cpf;
    }
}