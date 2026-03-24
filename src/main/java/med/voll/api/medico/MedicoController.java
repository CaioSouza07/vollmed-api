package med.voll.api.medico;

import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    // ESSE NAO SERA UTILIZADO POIS NA REGRA DE NEGOCIO DEVEMOS TRAZER EM PAGINACAO POR 10 DADOS
    // E ORDENADO PELO NOME DO MEDICO
//    @GetMapping
//    public List<DadosListagemMedico> listarMedicos(Pageable paginacao){
//        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
//    }

    @GetMapping
    public Page<DadosListagemMedico> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    // aqui eu excluo de verdade do banco de dados (EXCLUSÃO FÍSICA)
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void deletar(@PathVariable Long id){
//        repository.deleteById(id);
//    }




}
