/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation 
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.opensource.org/licenses/cpl.php
 * 
 ******************************************************************************/

package com.ibm.adtech.jastor.jet;

import com.ibm.adtech.jastor.inference.OntologyClass;

/**
 * 
 * @author Ben Szekely (<a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com</a>)
 *
 */
public interface OntologyClassTemplate {
    public static final String copyright = "(C) Copyright IBM Corporation 2005  All Rights Reserved.";

    public String generate(OntologyClass oc);
    
    public OntologyClassFileProvider getFileProvider();
    
    public void setFileProvider(OntologyClassFileProvider fileProvider);
    
}
