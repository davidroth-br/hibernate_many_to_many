package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @Column(name = "PROJECT_ID")
    private Integer projectId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "BUDGET")
    private Long budget;
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @ManyToMany(mappedBy="projects")
    private Set<Employees> employees = new HashSet<>();

    public Project() {
    }

    public Project(Integer projectId, String name, Long budget, Date creationDate) {
        this.projectId = projectId;
        this.name = name;
        this.budget = budget;
        this.creationDate = creationDate;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }
}
