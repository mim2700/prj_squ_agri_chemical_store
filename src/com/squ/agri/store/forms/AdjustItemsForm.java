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
 * Package Name   : com.squ.agri.store.forms
 * File Name      : AdjustItemsForm.java
 * 
 * Date           : Aug 18, 2009
 * 
 */
package com.squ.agri.store.forms;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.squ.agri.store.bo.Adjustment;
import com.squ.agri.store.bo.Department;
import com.squ.agri.store.bo.Item;
import com.squ.agri.store.bo.Measurment;
import com.squ.agri.store.bo.SubItem;

import org.apache.commons.collections.Factory;
import org.apache.commons.collections.ListUtils;

/**
 * @author Administrator
 * 
 */
public class AdjustItemsForm extends ActionForm implements Factory
{
	private String adjusmentType = null;

	private String dep_Destination = null;
	private String dep_Source = null;

	private Adjustment adjustment = null;
	private Department source_Dept = null;
	private Department dest_Dept = null;

	protected List items = ListUtils.lazyList(new ArrayList(), this);
	protected List subItems = ListUtils.lazyList(new ArrayList(), this);

	private int totalSubItems = 0;

	private String userRole = null;
	private Measurment measurment = null;

	/**
	 * @return the adjusmentType
	 */
	public String getAdjusmentType()
	{
		return adjusmentType;
	}

	/**
	 * @param adjusmentType
	 *            the adjusmentType to set
	 */
	public void setAdjusmentType(String adjusmentType)
	{
		this.adjusmentType = adjusmentType;
	}

	/**
	 * @return the dep_Destination
	 */
	public String getDep_Destination()
	{
		return dep_Destination;
	}

	/**
	 * @param dep_Destination
	 *            the dep_Destination to set
	 */
	public void setDep_Destination(String dep_Destination)
	{
		this.dep_Destination = dep_Destination;
	}

	/**
	 * @return the dep_Source
	 */
	public String getDep_Source()
	{
		return dep_Source;
	}

	/**
	 * @param dep_Source
	 *            the dep_Source to set
	 */
	public void setDep_Source(String dep_Source)
	{
		this.dep_Source = dep_Source;
	}

	/**
	 * @return the adjustment
	 */
	public Adjustment getAdjustment()
	{
		return adjustment;
	}

	/**
	 * @param adjustment
	 *            the adjustment to set
	 */
	public void setAdjustment(Adjustment adjustment)
	{
		this.adjustment = adjustment;
	}

	/**
	 * @return the source_Dept
	 */
	public Department getSource_Dept()
	{
		return source_Dept;
	}

	/**
	 * @param source_Dept
	 *            the source_Dept to set
	 */
	public void setSource_Dept(Department source_Dept)
	{
		this.source_Dept = source_Dept;
	}

	/**
	 * @return the dest_Dept
	 */
	public Department getDest_Dept()
	{
		return dest_Dept;
	}

	/**
	 * @param dest_Dept
	 *            the dest_Dept to set
	 */
	public void setDest_Dept(Department dest_Dept)
	{
		this.dest_Dept = dest_Dept;
	}

	/**
	 * @return the subItems
	 */
	public List getSubItems()
	{
		return this.subItems;
	}

	/**
	 * @param subItems
	 *            the subItems to set
	 */

	public void setSubItems(final List subItems)
	{
		this.subItems = ListUtils.lazyList(subItems, this);
	}

	public SubItem getSubItems(int index)
	{
		return (SubItem) subItems.get(index);
	}

	/**
	 * @return the items
	 */
	public List getItems()
	{
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(List items)
	{
		this.items = items;
	}

	public Item getItems(int index)
	{
		return (Item) items.get(index);
	}

	// 'Factory' method for LazyList
	public Object create()
	{
		return new Object();
	}

	/**
	 * @return the totalSubItems
	 */
	public int getTotalSubItems()
	{
		return totalSubItems;
	}

	/**
	 * @param totalSubItems
	 *            the totalSubItems to set
	 */
	public void setTotalSubItems(int totalSubItems)
	{
		this.totalSubItems = totalSubItems;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole()
	{
		return userRole;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(String userRole)
	{
		this.userRole = userRole;
	}

	/**
	 * @return the measurment
	 */
	public Measurment getMeasurment()
	{
		return measurment;
	}

	/**
	 * @param measurment
	 *            the measurment to set
	 */
	public void setMeasurment(Measurment measurment)
	{
		this.measurment = measurment;
	}

	// 'Factory' method for LazyList
	// public Object create() {
	// return new SubItem();
	// }

}
