package backend.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rolle")
public class Rolle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "bezeichnung", nullable = false)
    private String bezeichnung;

    @ManyToMany(mappedBy = "rollen")
    private Set<Person> personen;

    // Constructors, getters, and setters
    public Rolle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Set<Person> getPersonen() {
        return personen;
    }

    public void setPersonen(Set<Person> personen) {
        this.personen = personen;
    }
}
