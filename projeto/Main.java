package projeto;

public class Main {
    public static void main(String[] args) {
        Usuario aluno = new Aluno("Pedro", "Pedo@unb.com", 
        "61981832741", "olameunome", "Eng Software", "232002050",2);
        Usuario tecnico = new Serv_ADM("232002010", "Andre", "Andre@unb.br", 
        "619858754", "meunome", "Cordenador", "Software");
        Usuario professor = new Professor("MAria", "Maria@unb.com", 
        "619832712", "meunome2", "232002015", "Software", "Professor");
        System.out.println(aluno.imprimir());
        System.out.println(tecnico.imprimir());
        System.out.println(professor.imprimir()); 
        
        }

   
    
}
