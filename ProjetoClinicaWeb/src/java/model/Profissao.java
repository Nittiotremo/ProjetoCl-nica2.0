package model;

public class Profissao {

    private int codigoProfissao;
    private String nomeProfissao;

    public Profissao() {

    }

    public Profissao(int codigoProfissao, String nomeProfissao) {
        this.codigoProfissao = codigoProfissao;
        this.nomeProfissao = nomeProfissao;
    }

    public int getCodigoProfissao() {
        return codigoProfissao;
    }

    public void setCodigoProfissao(int codigoProfissao) {
        this.codigoProfissao = codigoProfissao;
    }

    public String getNomeProfissao() {
        return nomeProfissao;
    }

    public void setNomeProfissao(String nomeProfissao) {
        this.nomeProfissao = nomeProfissao;
    }
}
