package com.cgihosting.domain.referentiel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 09/01/2017.
 */

@Entity
@Table(name="referentiel_actions_workflows")
public class ReferentielActionsWorkflowDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="RAW_ID")
    private Integer id;

    @Column(name="RAW_ACTION_WORKFLOW")
    private String actionWorkflow = "";

    @Column(name="RAW_DESCRIPTION_WORKFLOW")
    private String descriptionWorkflow = "";

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

    public String getDescriptionWorkflow() {
        return descriptionWorkflow;
    }

    public void setDescriptionWorkflow(String descriptionWorkflow) {
        this.descriptionWorkflow = descriptionWorkflow;
    }
}
