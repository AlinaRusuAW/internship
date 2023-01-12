package oop.model;

public class Employee {
    private Long id;
    private String name;
    private String prenume;
    private Long id_position;
    private Long salariu;

    public Employee(Long id, String name, String prenume, Long id_position, Long salariu) {
        this.id = id;
        this.name = name;
        this.prenume = prenume;
        this.id_position = id_position;
        this.salariu = salariu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Long getId_position() {
        return id_position;
    }

    public void setId_position(Long id_position) {
        this.id_position = id_position;
    }

    public Long getSalariu() {
        return salariu;
    }

    public void setSalariu(Long salariu) {
        this.salariu = salariu;
    }
}
