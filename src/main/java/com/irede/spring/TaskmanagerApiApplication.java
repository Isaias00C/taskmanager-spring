package com.irede.spring;


import com.irede.spring.model.Prioridade;
import com.irede.spring.model.Tarefa;
import com.irede.spring.repository.TarefaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TaskmanagerApiApplication implements CommandLineRunner{

    private final TarefaRepository tarefaRepository;

    public TaskmanagerApiApplication(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;

    }

    public static void main(String[] args){
        SpringApplication.run(TaskmanagerApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Tarefa tarefa1 = new Tarefa("Estudar JPA", "Revisar repository", Prioridade.ALTA);
        Tarefa tarefa2 = new Tarefa("Configurar Postgres", "Configurar bando de dados", Prioridade.MEDIA);

        tarefaRepository.save(tarefa1);
        tarefaRepository.save(tarefa2);

        System.out.println("Buscando todos os registros");

        for(Tarefa t : tarefaRepository.findAll()){
            System.out.println(t);
        }
    }
}
