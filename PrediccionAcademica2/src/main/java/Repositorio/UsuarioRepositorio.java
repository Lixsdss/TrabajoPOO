package Repositorio;

import Dominio.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio {
    private List<Usuario> usuarios=new ArrayList<>();
    
    public void agregarUsuario(Usuario usuario) {
        // Verifica duplicados por id/email antes de agregar
        boolean existe = false;
        for (Usuario u : usuarios) {
            if (u.getId() == usuario.getId() || u.getEmail().equals(usuario.getEmail())) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            usuarios.add(usuario); // ✅ Se agrega solo una vez, si no existe
        }
    }
    // Buscar usuario por ID
    public Usuario buscarId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    // Buscar usuario por email
    public Usuario findByEmail(String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    // Obtener todos los usuarios (copia para encapsulamiento)
    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }

    // Eliminar usuario por ID
    public boolean eliminarUsuario(int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                usuarios.remove(i);
                return true;
            }
        }
        return false;
    }

    // Actualizar usuario (reemplaza si existe por ID)
    public boolean actualizarUsuario(Usuario usuarioActualizado) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuarioActualizado.getId()) {
                usuarios.set(i, usuarioActualizado);
                return true;
            }
        }
        return false;
    }
}
