package backend.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "vorname", nullable = false)
    private String vorname;

    @Column(name = "telefonnummer")
    private String telefonnummer;

    @ManyToMany
    @JoinTable(
        name = "person_rolle",
        joinColumns = @JoinColumn(name = "person_id"),
        inverseJoinColumns = @JoinColumn(name = "rolle_id")
    )
    private Set<Rolle> rollen;

    // Constructors, getters, and setters
    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public Set<Rolle> getRollen() {
        return rollen;
    }

    public void setRollen(Set<Rolle> rollen) {
        this.rollen = rollen;
    }
}
