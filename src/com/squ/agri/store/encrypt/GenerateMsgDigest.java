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
 * Project Name   : prj_squ_agri_chemical_store
 * Package Name   : com.squ.agri.store.encrypt
 * File Name      : MsgDigest.java
 * 
 * Date           : Sep 1, 2009
 * 
 */
package com.squ.agri.store.encrypt;

import java.security.*;

/**
 * @author Administrator
 * 
 */
public class GenerateMsgDigest extends MsgDigest
{

	public GenerateMsgDigest(String userText)
	{
		super(userText);
	}

	public String getEncryptPassword() throws GeneralSecurityException
	{

		return super.getEncryptText();
	}

}
