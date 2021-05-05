package senha.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import senha.factory.SenhaFactory;
import senha.model.Senha;
import org.springframework.stereotype.Service;
import senha.repository.ISenhaRepository;

@Service
public class SenhaService implements ISenhaService{

  private final ISenhaRepository senhaRepository;
  private final SenhaFactory senhaFactory;

  public SenhaService(ISenhaRepository senhaRepository, SenhaFactory senhaFactory) {
    this.senhaRepository = senhaRepository;
    this.senhaFactory = senhaFactory;
  }

  @Override
  public Senha gravarSenha(String tpoFila) {

    Senha ultimasenha = buscaUltimaSenhaRegistrada(tpoFila);
    String proximoNumero = senhaFactory.incrementaSenha(ultimasenha.getNumero());
    return senhaRepository.save(new Senha(null, tpoFila, proximoNumero, false, null));
  }

  @Override
  public Senha chamarSenha() {
    Senha proxSenha =  buscaProximaSenha();
    proxSenha.setIsDeleted(true);
    proxSenha.setChamadoEm(LocalDateTime.now());
    return senhaRepository.save(proxSenha);
  }

  @Override
  public Senha ultimaSenha() {
    return buscaUltimaSenhaChamada();
  }

  @Override
  public void deletarSenhas() {
    senhaRepository.deleteAll();
  }

  private Senha buscaUltimaSenhaRegistrada(String tpoFila){
      return senhaRepository.findTopByTpoFilaOrderByTpoFilaDescNumeroDesc(tpoFila)
             .orElse(new Senha(null, tpoFila, "0000", false, null));
  }

  private Senha buscaProximaSenha(){
    return senhaRepository.findTopByIsDeletedOrderByTpoFilaDescNumeroAsc(false)
        .orElse(buscaUltimaSenhaChamada());
  }

  private Senha buscaUltimaSenhaChamada(){
    return senhaRepository.findTopByIsDeletedOrderByChamadoEmDesc(true)
        .orElse(new Senha(null, "", "0000", false, null));
  }
}
