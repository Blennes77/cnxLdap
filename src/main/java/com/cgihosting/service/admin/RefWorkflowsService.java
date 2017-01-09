package com.cgihosting.service.admin;

import com.cgihosting.domain.WorkflowUUIDDTO;

import java.io.Serializable;

/**
 * Created by marinib on 09/01/2017.
 */

public interface RefWorkflowsService extends Serializable{


    WorkflowUUIDDTO recupererRefWorkflowsUuiDTO(String codeEnvironnement, String nomWorkflow, int idHebergeur);




}
