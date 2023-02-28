package model;

public class Paciente extends Pessoa {

    private String numeroCartaoSusPaciente;
    private boolean statusPaciente;
    private Profissao profissao;

    public Paciente() {

    }

    public Paciente(String numeroCartaoSusPaciente, boolean statusPaciente, Profissao profissao, int codigoPessoa, String nomePessoa, String dataNascimentoPessoa, String cpfPessoa, String senhaPessoa) {
        super(codigoPessoa, nomePessoa, dataNascimentoPessoa, cpfPessoa, senhaPessoa);
        this.numeroCartaoSusPaciente = numeroCartaoSusPaciente;
        this.statusPaciente = statusPaciente;
        this.profissao = profissao;
    }

    public String getNumeroCartaoSusPaciente() {
        return numeroCartaoSusPaciente;
    }

    public void setNumeroCartaoSusPaciente(String numeroCartaoSusPaciente) {
        this.numeroCartaoSusPaciente = numeroCartaoSusPaciente;
    }

    public boolean isStatusPaciente() {
        return statusPaciente;
    }

    public void setStatusPaciente(boolean statusPaciente) {
        this.statusPaciente = statusPaciente;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }
}