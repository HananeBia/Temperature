
package fr.emse.majeureinfo.springbootintro.model;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class Temperature {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer degree;


    @SuppressWarnings("unused")
    public Temperature() {
    }

    public Temperature(Integer degree) {
        this.degree = degree ;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

}
