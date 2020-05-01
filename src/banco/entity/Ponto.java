package banco.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "ponto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ponto.findAll", query = "SELECT p FROM Ponto p"),
    @NamedQuery(name = "Ponto.findByIdPonto", query = "SELECT p FROM Ponto p WHERE p.idPonto = :idPonto"),
    @NamedQuery(name = "Ponto.findByTempo", query = "SELECT p FROM Ponto p WHERE p.tempo = :tempo"),
    @NamedQuery(name = "Ponto.findByTeste", query = "SELECT p FROM Ponto p WHERE p.teste = :teste"),
    @NamedQuery(name = "Ponto.findByTentativa", query = "SELECT p FROM Ponto p WHERE p.tentativa = :tentativa"),
    @NamedQuery(name = "Ponto.findByPontuacao", query = "SELECT p FROM Ponto p WHERE p.pontuacao = :pontuacao")})
public class Ponto implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPonto")
    private Integer idPonto;
    @Basic(optional = false)
    @Column(name = "tempo")
    private double tempo;
    @Basic(optional = false)
    @Column(name = "teste")
    private String teste;
    @Basic(optional = false)
    @Column(name = "tentativa")
    private int tentativa;
    @Basic(optional = false)
    @Column(name = "pontuacao")
    private double pontuacao;
    @ManyToMany(mappedBy = "pontoCollection")
    private Collection<Jogador> jogadorCollection;
    public Ponto()
    {

    }    

    public Ponto(Integer idPonto) {
        this.idPonto = idPonto;
    }

    public Ponto(Integer idPonto, double tempo, String teste, int tentativa, double pontuacao) {
        this.idPonto = idPonto;
        this.tempo = tempo;
        this.teste = teste;
        this.tentativa = tentativa;
        this.pontuacao = pontuacao;
    }

    public Integer getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(Integer idPonto) {
        this.idPonto = idPonto;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    public int getTentativa() {
        return tentativa;
    }

    public void setTentativa(int tentativa) {
        this.tentativa = tentativa;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    @XmlTransient
    public Collection<Jogador> getJogadorCollection() {
        return jogadorCollection;
    }

    public void setJogadorCollection(Collection<Jogador> jogadorCollection) {
        this.jogadorCollection = jogadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPonto != null ? idPonto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ponto)) {
            return false;
        }
        Ponto other = (Ponto) object;
        if ((this.idPonto == null && other.idPonto != null) || (this.idPonto != null && !this.idPonto.equals(other.idPonto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.Ponto[ idPonto=" + idPonto + " ]";
    }
}