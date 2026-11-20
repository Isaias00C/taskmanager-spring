package com.irede.spring;


import com.irede.spring.model.Prioridade;
import com.irede.spring.model.Tarefa;
import com.irede.spring.model.Usuario;
import com.irede.spring.repository.TarefaRepository;
import com.irede.spring.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TaskmanagerApiApplication implements CommandLineRunner{

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;

    public TaskmanagerApiApplication(TarefaRepository tarefaRepository, UsuarioRepository usuarioRepository){
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;

    }

    public static void main(String[] args){
        SpringApplication.run(TaskmanagerApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Usuario ana = new Usuario("Ana Souza", "ana@amil.com", "123455");
        Usuario bruno = new Usuario("Bruno Lima", "bruno@email.com", "123345");

        usuarioRepository.save(ana);
        usuarioRepository.save(bruno);

        Tarefa tarefa1 = new Tarefa("Estudar JPA", "Revisar repository", Prioridade.ALTA);
        ana.adicionarTarefa(tarefa1);

        Tarefa tarefa2 = new Tarefa("Configurar Postgres", "Configurar bando de dados", Prioridade.MEDIA);
        bruno.adicionarTarefa(tarefa2);

        tarefaRepository.save(tarefa1);
        tarefaRepository.save(tarefa2);

        System.out.println("Buscando todos os registros");

        for(Tarefa t : tarefaRepository.findAll()){
            System.out.println(t);
        }
    }
}
