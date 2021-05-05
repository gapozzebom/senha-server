package senha.service;

import senha.model.Senha;

public interface ISenhaService {

    Senha gravarSenha(String tpoFila);
    Senha chamarSenha();
    Senha ultimaSenha();
    void deletarSenhas();
}
