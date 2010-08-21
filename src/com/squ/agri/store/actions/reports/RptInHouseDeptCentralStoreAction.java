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
 * Package Name   : com.squ.agri.store.actions.reports
 * File Name      : RptInHouseDeptCentralStoreAction.java
 * 
 * Date           : Feb 20, 2010
 * 
 */
package com.squ.agri.store.actions.reports;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Administrator
 *
 */
public class RptInHouseDeptCentralStoreAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		
	
	Connection conn = null;
	// String path = request.getRealPath("/");
	String path = request.getSession().getServletContext().getRealPath("/");

	// File reportFile = new File(path+"/report2.jasper");

//	try
//	{
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//	}
//	catch (ClassNotFoundException e4)
//	{
//		// TODO Auto-generated catch block
//		e4.printStackTrace();
//	}
//	try
//	{
//		conn = DriverManager.getConnection(
//				"jdbc:oracle:thin:@172.20.10.73:1521:XE", "squ_agri_store",
//				"squ");
//	}
//	catch (SQLException e4)
//	{
//		// TODO Auto-generated catch block
//		e4.printStackTrace();
//	}

	Map parameters = new HashMap();
	JasperReport jasperReport = null;
	try
	{
		jasperReport = (JasperReport) JRLoader.loadObject(path
				+ "/pages/reports/rpt_dept_central_store.jasper");
	}
	catch (JRException e3)
	{
		// TODO Auto-generated catch block
		e3.printStackTrace();
	}

	JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(
			new ArrayList());

	JasperPrint jasperPrint = null;
	try
	{
		//jasperPrint = JasperManager.fillReport(jasperReport, parameters, conn);
		JasperFillManager.fillReportToFile(path+ "/pages/reports/rptInHouseDeptCentralStore.jasper", parameters, new JRBeanCollectionDataSource(null));
	}
	catch (JRException e2)
	{
		// TODO Auto-generated catch block

		e2.printStackTrace();
	}
	
	//jasperPrint.setName("SA9");
	//response.setContentType("application/pdf");
	ServletOutputStream outStream = null;
	try
	{
		outStream = response.getOutputStream();
	}
	catch (IOException e1)
	{

		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	JRPdfExporter exporter = new JRPdfExporter();
	exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
	exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, outStream);
	try
	{
		exporter.exportReport();
	}
	catch (JRException e)
	{
		// TODO Auto-generated catch block

		e.printStackTrace();
	}

	try
	{
		outStream.flush();
	}
	catch (IOException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try
	{
		outStream.close();
	}
	catch (IOException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	// return mapping.findForward("success");
	return null;
	}
}
