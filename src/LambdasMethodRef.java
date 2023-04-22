import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdasMethodRef {

    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("rodrigo", 35));
        usuarios.add(new Usuario("julianne", 30));

        Function<Usuario, String> funcLambda = s -> s.getNome();
        usuarios.forEach(s -> System.out.println(s.getNome()));
//        usuarios.forEach(System.out::println); Nao dá certo pois a informaçao está dentro de Usuario
    }
}

class Usuario {
    private String nome;
    private Integer idade;

    public Usuario(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
