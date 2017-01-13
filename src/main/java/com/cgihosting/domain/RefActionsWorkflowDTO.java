package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 09/01/2017.
 */

@Entity
@Table(name="ref_actions_workflows")
public class RefActionsWorkflowDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="RAW_ID")
    private Integer id;

    @Column(name="RAW_ACTION_WORKFLOW")
    private String actionWorkflow = "";

    @Column(name="RAW_DESCRIPTION_WORKFLOW")
    private String descriptiondWorkflow = "";


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionWorkflow() {
        return actionWorkflow;
    }

    public void setActionWorkflow(String actionWorkflow) {
        this.actionWorkflow = actionWorkflow;
    }

    public String getDescriptiondWorkflow() {
        return descriptiondWorkflow;
    }

    public void setDescriptiondWorkflow(String descriptiondWorkflow) {
        this.descriptiondWorkflow = descriptiondWorkflow;
    }
}
