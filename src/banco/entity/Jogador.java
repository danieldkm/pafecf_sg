package banco.entity;

public class Jogador {

    private Integer idJogador;
    private String nome;
    private String salvoEm;

    public Jogador() {
    }

    public Jogador(Integer idJogador) {
        this.idJogador = idJogador;
    }

    public Jogador(Integer idJogador, String nome) {
        this.idJogador = idJogador;
        this.nome = nome;
    }

    public Integer getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Integer idJogador) {
        this.idJogador = idJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int hashCode() {
        int hash = 0;
        hash += (idJogador != null ? idJogador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jogador)) {
            return false;
        }
        Jogador other = (Jogador) object;
        if ((this.idJogador == null && other.idJogador != null) || (this.idJogador != null && !this.idJogador.equals(other.idJogador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.Jogador[ idJogador=" + idJogador + " ]";
    }

    public String getSalvoEm() {
        return salvoEm;
    }

    public void setSalvoEm(String salvoEm) {
        this.salvoEm = salvoEm;
    }

}
