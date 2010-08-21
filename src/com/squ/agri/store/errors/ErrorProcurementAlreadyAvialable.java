/**
 * Organisation   : Sultan Qaboos University
 * Client         : College of Agriculture & Marine Sciences
 * Project        : Chemical Store Management
 * Client Contact : Mr. Jamal Al-Sabahi (jamal@squ.edu.om)
 *
 * Developed by   : CIS Department
 *                  SQU, Muscat, Oman.
 *
 *------- Technical Details ---------------
 * Project Name   : cvs2_prj_squ_agri_chemical_store
 * Package Name   : com.squ.agri.store.errors
 * File Name      : ErrorProcurementAlreadyAvialable.java
 * 
 * Date           : Feb 1, 2010
 * 
 */
package com.squ.agri.store.errors;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Administrator
 * 
 */
public class ErrorProcurementAlreadyAvialable extends Exception
{

	public ErrorProcurementAlreadyAvialable()
	{
		ResourceBundle labels = ResourceBundle.getBundle(
				"com.squ.agri.store.properties.ApplicationResources", Locale
						.getDefault());

		// super(labels.getString("error.procurement.alreadyAvialable"));
	}

}
