package senha.factory;

import org.springframework.stereotype.Component;
import senha.model.Senha;

@Component
public class SenhaFactory {

  private Senha senha;

  public String  incrementaSenha (String numero){

    int num = Integer.parseInt(numero);
    return String.format("%04d", ++num);
  }

}
