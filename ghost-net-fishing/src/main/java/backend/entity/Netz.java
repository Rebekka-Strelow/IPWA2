package backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "netz")
public class Netz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // Use a simple String for GPS coordinates for simplicity in this example
    @Column(name = "standort", nullable = false)
    private String standort;

    @Column(name = "groesse", nullable = false)
    private float groesse;

    @ManyToOne
    @JoinColumn(name = "verschollen_gemeldet_durch", nullable = true)
    private Person verschollenGemeldetDurch;

    @ManyToOne
    @JoinColumn(name = "bergung_bevorstehend_durch", nullable = true)
    private Person bergungBevorstehendDurch;

    @ManyToOne
    @JoinColumn(name = "gemeldet_von", nullable = true)
    private Person gemeldetVon;

    @ManyToOne
    @JoinColumn(name = "geborgen_durch", nullable = false)
    private Person geborgenDurch;

    // Constructors, getters, and setters
    public Netz() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStandort() {
        return standort;
    }

    public void setStandort(String standort) {
        this.standort = standort;
    }

	public Person getVerschollenGemeldetDurch() {
		return verschollenGemeldetDurch;
	}

	public void setVerschollenGemeldetDurch(Person verschollenGemeldetDurch) {
		this.verschollenGemeldetDurch = verschollenGemeldetDurch;
	}

	public Person getBergungBevorstehendDurch() {
		return bergungBevorstehendDurch;
	}

	public void setBergungBevorstehendDurch(Person bergungBevorstehendDurch) {
		this.bergungBevorstehendDurch = bergungBevorstehendDurch;
	}

	public Person getGemeldetVon() {
		return gemeldetVon;
	}

	public void setGemeldetVon(Person gemeldetVon) {
		this.gemeldetVon = gemeldetVon;
	}

	public Person getGeborgenDurch() {
		return geborgenDurch;
	}

	public void setGeborgenDurch(Person geborgenDurch) {
		this.geborgenDurch = geborgenDurch;
	}

	public void setGroesse(float groesse) {
		this.groesse = groesse;
	}

}
