package com.cgihosting.service.admin;

import com.cgihosting.domain.RefActionsWorkflowDTO;
import org.springframework.data.domain.Page;

import java.io.Serializable;

/**
 * Created by marinib on 09/01/2017.
 */

public interface GererWorkflowsService extends Serializable{


    public Page<RefActionsWorkflowDTO> recupererRefActionsWorkflows(Integer page, Integer ligneParPage);




}
