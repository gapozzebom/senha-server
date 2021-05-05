package senha.cotroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import senha.service.ISenhaService;

@RestController
public class SenhaController {

  private final ISenhaService senhaService;

  public SenhaController(ISenhaService senhaService) {
    this.senhaService = senhaService;
  }

  @PostMapping("/v1/gera-senha")
  ResponseEntity<Object> geraSenha (@RequestBody @Validated SenhaRequest tpoFila) {
    return ResponseEntity.ok(senhaService.gravarSenha(tpoFila.getTpoFila()));
  }

  @PatchMapping("/v1/chama-senha")
  ResponseEntity<Object> chamaSenha () {
    return ResponseEntity.ok(senhaService.chamarSenha());
  }

  @GetMapping("/v1/ultima-senha")
  ResponseEntity<Object> senhaChamada () {
    return ResponseEntity.ok(senhaService.ultimaSenha());
  }

  @DeleteMapping("/v1/exclui-senhas")
  ResponseEntity<Object> excluiSenhas () {
    senhaService.deletarSenhas();
    return ResponseEntity.ok().build();
  }
}
