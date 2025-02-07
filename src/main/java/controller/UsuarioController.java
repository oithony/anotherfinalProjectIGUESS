package controller;

import model.UsuarioModel;
import repository.UsuarioRepository;

import java.sql.SQLException;
import java.util.List;

public class UsuarioController {
    UsuarioRepository usuarioRepository = new UsuarioRepository();

    public String salvar(UsuarioModel usuario){
        String retornoDaRepository = usuarioRepository.salvar(usuario);
        return retornoDaRepository;
    }
    public List<UsuarioModel> buscarTodos() throws SQLException{
        return usuarioRepository.buscarTodos();
    }
}
