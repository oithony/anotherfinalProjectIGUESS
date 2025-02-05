package controller;

import model.UsuarioModel;
import repository.UsuarioRepository;

public class UsuarioController {
    UsuarioRepository usuarioRepository = new UsuarioRepository();

    public String salvar(UsuarioModel usuario){
        String retornoDaRepository = usuarioRepository.salvar(usuario);
        return retornoDaRepository;
    }
}
