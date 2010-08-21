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
public abstract class MsgDigest
{
	private static String simpleTxt = null;

	public MsgDigest(String userText)
	{
		this.simpleTxt = userText;
	}

	public static String getEncryptText() throws GeneralSecurityException
	{
		// TODO create encryption logic useing MD5/SHA1

		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(simpleTxt.getBytes(), 0, simpleTxt.length());

		byte[] digest = m.digest();

		String strDigest = "";
		for (int i = 0; i < digest.length; i++)
		{
			strDigest += Integer.toString((digest[i] & 0xff) + 0x100, 16)
					.substring(1);
		}

		return strDigest;
	}

}
