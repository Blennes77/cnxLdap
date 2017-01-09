package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="ref_workflows_uuid")
public class WorkflowUUIDDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="RWU_ID")
    private int id;

    @Column(name="RWU_ID_NOM_WORKFLOW")
    private Integer idWorkflow;

    @Column(name="RWU_UUID_WORKFLOW")
    private String uuidWorkflow = "";

    @Column(name="RWU_ID_ENV")
    private int typeEnv;

    @OneToOne
    @JoinColumn(name="RWU_ID_ENV", insertable = false, updatable = false)
    private TypeEnvironnementDTO typeEnvironnementDTO;


    @OneToOne
    @JoinColumn(name="RWU_ID_NOM_WORKFLOW", insertable = false, updatable = false)
    private WorkflowNomDTO workflowNomDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdWorkflow() {
        return idWorkflow;
    }

    public void setIdWorkflow(Integer idWorkflow) {
        this.idWorkflow = idWorkflow;
    }

    public String getUuidWorkflow() {
        return uuidWorkflow;
    }

    public void setUuidWorkflow(String uuidWorkflow) {
        this.uuidWorkflow = uuidWorkflow;
    }

    public int getTypeEnv() {
        return typeEnv;
    }

    public void setTypeEnv(int typeEnv) {
        this.typeEnv = typeEnv;
    }

    public TypeEnvironnementDTO getTypeEnvironnementDTO() {
        return typeEnvironnementDTO;
    }

    public void setTypeEnvironnementDTO(TypeEnvironnementDTO typeEnvironnementDTO) {
        this.typeEnvironnementDTO = typeEnvironnementDTO;
    }

    public WorkflowNomDTO getWorkflowNomDTO() {
        return workflowNomDTO;
    }

    public void setWorkflowNomDTO(WorkflowNomDTO workflowNomDTO) {
        this.workflowNomDTO = workflowNomDTO;
    }
}
