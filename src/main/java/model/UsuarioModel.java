package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Entity
@Table(name="usuario")
public class UsuarioModel implements List<UsuarioModel> {
  @Id
  @GeneratedValue
  private long idUsuario;
    private String nome;
    private String sexo;
    private int celular;
    private int email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setEmail(String text) {
    }

    public void setCelular(String text) {
    }

    public char[] getId() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<UsuarioModel> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(UsuarioModel usuarioModel) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends UsuarioModel> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends UsuarioModel> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public UsuarioModel get(int index) {
        return null;
    }

    @Override
    public UsuarioModel set(int index, UsuarioModel element) {
        return null;
    }

    @Override
    public void add(int index, UsuarioModel element) {

    }

    @Override
    public UsuarioModel remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<UsuarioModel> listIterator() {
        return null;
    }

    @Override
    public ListIterator<UsuarioModel> listIterator(int index) {
        return null;
    }

    @Override
    public List<UsuarioModel> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
