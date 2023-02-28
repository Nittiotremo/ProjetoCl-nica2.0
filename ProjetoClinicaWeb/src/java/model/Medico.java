package model;

public class Medico extends People {

    private String crmMedico;
    private boolean statusMedico;

    public Medico() {
        
    }

    public Medico(String crmMedico, boolean statusMedico, int codigoPessoa, String nomePessoa, String dataNascimentoPessoa, String cpfPessoa, String senhaPessoa) {
        super(codigoPessoa, nomePessoa, dataNascimentoPessoa, cpfPessoa, senhaPessoa);
        this.crmMedico = crmMedico;
        this.statusMedico = statusMedico;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }

    public boolean isStatusMedico() {
        return statusMedico;
    }

    public void setStatusMedico(boolean statusMedico) {
        this.statusMedico = statusMedico;
    }
}
