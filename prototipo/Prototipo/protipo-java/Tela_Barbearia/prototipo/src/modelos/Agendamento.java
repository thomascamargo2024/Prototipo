package modelos;

public class Agendamento {

    private Cadastro cliente;
    private String servico;
    private String horario;
    private String status;

    public Agendamento(Cadastro cliente, String servico, String horario) {
        this.cliente = cliente;
        this.servico = servico;
        this.horario = horario;
        this.status = "Pendente";
    }

    public Cadastro getCliente() {
        return cliente;
    }

    public String getServico() {
        return servico;
    }

    public String getHorario() {
        return horario;
    }

    public String getStatus() {
        return status;
    }

    public void confirmar() {
        if(!status.equals("Cancelado")){
            status = "Confirmado";
        }
    }

    public void cancelar() {
        status = "Cancelado";
    }

    @Override
    public String toString() {
        return cliente.getNome() + " | " + servico + " | " + horario + " | [" + status + "]";
    }
}