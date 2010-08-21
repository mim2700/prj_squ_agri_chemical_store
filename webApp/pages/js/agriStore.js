//Pop up window - code start
var ie=document.all
var dom=document.getElementById
var ns4=document.layers
var calunits=document.layers? "" : "px"
var PopupWin_bouncelimit
var direction="up"
var PopupWin_usedropin=1
var paramUrl;
var url;
//var refreshOnce;
//var subItemsPage;
//var subItemsPage_timeout;

function PopupCenter(pageURL, title,w,h) 
{

	var left = (screen.width/2)-(w/2);
	var top = (screen.height/2)-(h/2);
	var targetWin = window.open (pageURL, title, 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='+w+', height='+h+', top='+top+', left='+left);

	return targetWin;
} 

function pause(millis)
   
      {
   
      var date = new Date();
   
      var curDate = null;
   

      do { curDate = new Date(); }
   
     while(curDate-date < millis)
   
}

function PopupMe(webUrl,procId,prnNo,itemCode,itemName,itemQuantity,status,indexNo,uid){

//document.getElementsByName(objName).item(i);
//var gradeSelect=document.getElementsByName("arrItems["+indexNo+"].grade").item(indexNo);
//var gradeSelect=document.getElementsByName("arrItems["+indexNo+"].grade").item(0);
//var gradeIndx=gradeSelect.selectedIndex;
//var gradeValue=gradeSelect.options[gradeIndx].value;

var safetySelect=document.getElementsByName("arrItems["+indexNo+"].safety").item(0);
var safetyIndx=safetySelect.selectedIndex;
var safetyValue=safetySelect.options[safetyIndx].value;

var multipleSubItem=document.getElementsByName("arrItems["+indexNo+"].multipleSubItem").item(0);

var measurmentSelect = document.getElementsByName("arrItems["+indexNo+"].measurment").item(0);
var measurmentIndx=measurmentSelect.selectedIndex;
var measurmentValue=measurmentSelect.options[measurmentIndx].value;

if( measurmentValue != "0")
{

	var r = true;
	
	var msg_multi = "Mutltiple";
	
	if(!multipleSubItem.disabled & multipleSubItem.checked)
	{
	
			msg_multi = "NOT Mutltiple";
	
	 r = confirm(" This Item Is "+ msg_multi +",,, \nThere is no revert for this \n\n Do You want to continue?");
	
	}


	if (r)
	{
		paramUrl="?procId="+procId+"&prnNo="+prnNo+"&itemCode="+itemCode+"&itemName="+itemName+"&itemQuantity="+itemQuantity+"&safety="+safetyValue+"&status="+status+"&uid="+uid+"&multipleSubItem="+multipleSubItem.checked+"&measurment="+measurmentValue+"&indexNo="+indexNo;
		url=webUrl+paramUrl;

		// subItemsPage=window.open("http://"+ location.host +"/"+webUrl+paramUrl, "", "scrollbars=1");
		 subItemsPage= PopupCenter("http://"+ location.host +""+webUrl+paramUrl, "",1000,400) 

		subItemsPage.focus();
			
		if(subItemsPage && !subItemsPage.closed){
		
		pause(1000);
				
		subItemsPage.location.reload(true);

		subItemsPage.focus();
		}
	}
	else

		multipleSubItem.checked=false;
}else
	alert("Please select Measurments.");	
		
}
function PopupWin_dropin(){
scroll_top=(ie)? truebody().scrollTop : window.pageYOffset
if (parseInt(PopupWin_crossobj.top)<100+scroll_top){
PopupWin_crossobj.top=parseInt(PopupWin_crossobj.top)+40+calunits
if (parseInt(PopupWin_crossobj.top)>100+scroll_top){PopupWin_crossobj.top=100+scroll_top}}else{
clearInterval(PopupWin_dropstart)
PopupWin_bouncestart=setInterval("PopupWin_bouncein()",50)}}

function PopupWin_bouncein(){
PopupWin_crossobj.top=parseInt(PopupWin_crossobj.top)-PopupWin_bouncelimit+calunits
if (PopupWin_bouncelimit<0)
PopupWin_bouncelimit+=8
PopupWin_bouncelimit=PopupWin_bouncelimit*-1
if (PopupWin_bouncelimit==0){
clearInterval(PopupWin_bouncestart)}}

function PopupWin_dismissbox(){
if (window.PopupWin_bouncestart) clearInterval(PopupWin_bouncestart)
PopupWin_crossframe.src=""
PopupWin_crossobj.visibility="hidden"
}

function truebody(){
return (document.compatMode && document.compatMode!="BackCompat")? document.documentElement : document.body}
//Pop up window - code end



/***********************************************
* Textarea Maxlength script- © Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for legal use.
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}


//==============================================================================================
//=======================================   CHECK SUBMITS ======================================
//==============================================================================================

//=========================    checkItems.do  ===========================
function check_checkItems_Empty_and_submit()
{

		var prnNo = document.getElementsByName('prnNo')['prnNo']['value'];
	
		
		if(prnNo != "")
			CheckItemsDynaForm.submit();
		else
			alert(" Please enter PRN number");
		

}

//=========================    checkItems.do  ===========================

function check_checkItemsDetails_Empty_and_submit()
{

		var deptDestId = document.getElementsByName('deptDestId')['deptDestId']['value'];
	
		
		if(deptDestId != "0")
			procurementForm.submit();
		else
			alert(" Please select Department");
		

}


//=========================    adminUserAdd.do   ===========================

function check_AddUser_Empty_and_submit()
{

		var role = document.getElementsByName('role')['role']['value'];
		var deptId = document.getElementsByName('deptId')['deptId']['value'];
		var uid = document.getElementsByName('uid')['uid']['value'];
		var pwd = document.getElementsByName('pwd')['pwd']['value'];
		
		if(role != "0" && deptId !="0" && uid != "" && pwd !="")
			LoginForm.submit();
		else
			alert(" Please Complete the Empty Fields");
		

}

//=========================    adminUserUpdate.do   ===========================

function check_updateUser_Empty_and_submit()
{

		var uid = document.getElementsByName('uid')['uid']['value'];
	
		
		if(uid != "0")
			LoginForm.submit();
		else
			alert(" Please choose a user");
		

}

//=========================    consumption.do   ===========================

function check_consumption_Empty_and_submit()
{

	if(balance_consumption_quantity()== true)
	{
	
		var itemQuantity = document.getElementsByName('itemQuantity')['itemQuantity']['value'];
		var itemCode = document.getElementsByName('itemCode')['itemCode']['value'];
		
		if(itemQuantity != "" && itemCode != "" && itemQuantity != "0")
			ConsumeItemsForm.submit();
		else
			alert(" Please select Item & enter quantity");
		
	}
}

function balance_consumption_quantity()
{

		var quantity = document.getElementsByName('itemQuantity')['itemQuantity']['value'];
		var avialable_qty = document.getElementsByName('txtQuantityAvialable')['txtQuantityAvialable']['value'];
		
		if(	parseInt(quantity) > parseInt(avialable_qty))
		{
			document.getElementsByName('itemQuantity')['itemQuantity']['value'] = 	parseInt(avialable_qty);
			alert(" wrong quantity 1 !!");
			return false;
			
		}else if(parseInt(quantity) < 0)
		{
			quantity = 0;
			alert(" wrong quantity  2 !!");
			return false;
		}
		
		return true;

}

//=========================    adjustments.do   ===========================

function check_adjustment_Empty_and_submit()
{

		var adjusmentType = document.getElementsByName('adjusmentType')['adjusmentType']['value'];
		var dep_Source = document.getElementsByName('dep_Source')['dep_Source']['value'];
		
		if(adjusmentType != "0" && dep_Source != "0")
			AdjustItemsForm.submit();
		else
			alert(" Please select adjustment Type & Department");
		

}


//=========================    adjustmentsDetails.do   ===========================

function check_adjustmentsDetails_Empty_and_submit(var_adjust_action)
{
	var result;
		var qty = document.getElementsByName('items[0].itemQuantity')['items[0].itemQuantity']['value'];
	 	var itemCode = document.getElementsByName('items[0].itemCode')['items[0].itemCode']['value'];
	 	
	 	if (var_adjust_action == "R")
	 	{
			var itemType = document.getElementsByName('items[0].type')['items[0].type']['value'];
			var itemMeasurment = document.getElementsByName('items[0].measurment')['items[0].measurment']['value'];

	 	}else
	 	{
	 		itemType="1";
	 		itemMeasurment="1";
	 	}
	 	
		if(itemCode != "0" && parseFloat(qty)>0 && itemType != "0" && itemMeasurment != "0")
			result="OK";
		else
			result=" Wrong !";
	
			
		if(result=="OK")
			AdjustItemsForm.submit();
		else
			alert(result);
			

}

//=========================    itemGrade.do   ===========================

function check_itemGrade_Empty_and_submit()
{

	 	var gradeName = document.getElementsByName('gradeName')['gradeName']['value'];
		var gradeNumber = document.getElementsByName('gradeNumber')['gradeNumber']['value'];
		
		if(gradeName != "" && gradeNumber !="")
			itemGradeForm.submit();
		else
			alert(" Please enter grade name & number");
		

}

//=========================    itemType.do   ===========================

function check_itemType_Empty_and_submit()
{
		var typeName = document.getElementsByName('typeName')['typeName']['value'];
		
		if(typeName != "")
			itemTypeForm.submit();
		else
			alert(" Please enter type name");
		

}

//=========================    itemSafety.do   ===========================

function check_itemSafety_Empty_and_submit()
{
		var un_Number = document.getElementsByName('un_Number')['un_Number']['value'];
		var safetyDescription = document.getElementsByName('safetyDescription')['safetyDescription']['value'];
		
		if(un_Number != "" && safetyDescription !="")
			itemSafetyForm.submit();
		else
			alert(" Please enter safety number & description");
		

}


//=========================    orderAcceptanceItemDetail.do   ===========================

function submit_StoreOrderItems(total)
	{
	
		var result = check_StoreOrderItems_Validation_and_submit(total);
				
		if(result == "OK")
		{
			procurementForm.submit();
		}
		else
		{
			alert("All items require type, measurment & details");
		}
	}
	
function check_StoreOrderItems_Validation_and_submit(totalItems)
{
	var total = parseInt(totalItems);
	var result ='OK';
	
	 for(var i=0;i<total;i++)
	 {
	 	
	 	var status = document.getElementById("status"+i).value;
	 	var measurmant = document.getElementsByName('arrItems['+i+'].measurment')['arrItems['+i+'].measurment']['value'];
	 	var type =  document.getElementsByName('arrItems['+i+'].type')['arrItems['+i+'].type']['value'];
	 	var deptDestId =  document.getElementsByName('arrItems['+i+'].deptDestId')['arrItems['+i+'].deptDestId']['value'];
	 	
	 	if(status !='OK' || measurmant=='0' || type=='0' || deptDestId=='0')
	 	{
	 		result ='NO';
	 		break;
	 	}

	 }
	
	return result;
}
//==============================================================================================	
//==============================================================================================

function updateParent(txtBoxName) {
	document.getElementById(txtBoxName).value='OK';
	//window.close("http://"+ location.host +"/"+url);
	 //self.close();
	 PopupWin_dismissbox();
    return false;
}

function confirmForMultipleItems()
{
	var itemCode = document.getElementsByName('items[0].itemCode')['items[0].itemCode']['value'];

	if(itemCode!='0')
	{
		var chked = document.getElementById('items['+subitems_indx+'].multipleSubItem').checked;
		var disbled = document.getElementById('items['+subitems_indx+'].multipleSubItem').disabled;
	
		if(!disbled && chked)
			var r = confirm(" You choose this item is multiple ,,, \nThere is no revert for this \n\n Do You want to continue?");
	
		if(!r)
		{
			document.getElementById('items['+subitems_indx+'].multipleSubItem').checked=false;
		}
	}
}

function adjust_select_subItem_Qty(indx)
{
   document.getElementById('subItems['+indx+'].qtyAvailable').selectedIndex = document.getElementById('subItems['+indx+'].subItemId').selectedIndex;
}

function updateMultipleSubitems(serialNo,total,sendr)
{

	var manuDate 	= document.getElementsByName('subItems[0].manuDate')['subItems[0].manuDate']['value'];
	var expireDate 	= document.getElementsByName('subItems[0].expireDate')['subItems[0].expireDate']['value'];

	if(sendr=="multipleSubItem")
	{
	
	  for(var i=1;i<total;i++)
		{
			document.getElementsByName('subItems['+i+'].manuDate')['subItems['+i+'].manuDate']['value'] = manuDate;
			document.getElementsByName('subItems['+i+'].expireDate')['subItems['+i+'].expireDate']['value'] = expireDate;
		}
		
	}else if(sendr=="manuDate" &&  serialNo==0)
	{
		 for(var i=1;i<total;i++)
			document.getElementsByName('subItems['+i+'].manuDate')['subItems['+i+'].manuDate']['value'] = manuDate;
			
	}else if(sendr=="expireDate"  && serialNo==0)
	{
		 for(var i=1;i<total;i++)
			document.getElementsByName('subItems['+i+'].expireDate')['subItems['+i+'].expireDate']['value'] = expireDate;
	}
}

function balance_Adjust_Reduce_Quantity(obj,indx,var_adjust_action)
{

	if(var_adjust_action=="R")
	{
	
		var qty = document.getElementsByName('items['+indx+'].itemQuantity')['items['+indx+'].itemQuantity']['value'];
	
		if(qty==null || parseInt(qty) <= 0 ||qty=="" || qty=="0")
		{
			alert("Wrong Qauntity !! ");
			document.getElementsByName('items['+indx+'].itemQuantity')['items['+indx+'].itemQuantity']['value'] = "0";
		}
		
	}else
	{
		var qty_available = document.getElementsByName('subItems['+indx+'].qtyAvailable')['subItems['+indx+'].qtyAvailable']['value'];
		var qty = document.getElementsByName('items['+indx+'].itemQuantity')['items['+indx+'].itemQuantity']['value'];
	
		if(qty_available == null || qty==null|| parseInt(qty) > parseInt(qty_available)|| parseInt(qty) <= 0 || qty_available == "" || qty=="" || qty=="0")
		{
			alert("Wrong Qauntity !! ");
			document.getElementsByName('items['+indx+'].itemQuantity')['items['+indx+'].itemQuantity']['value'] = document.getElementsByName('subItems['+indx+'].qtyAvailable')['subItems['+indx+'].qtyAvailable']['value'];
		}
		
	}

}

function consume_ItemCode_updateFields()
{
	var indx = document.getElementById('lstItemCode').selectedIndex;
	
	document.getElementById('lstItemName').selectedIndex=indx;
	
	document.getElementById('itemCode').selectedIndex=indx;
	document.getElementById('itemName').selectedIndex=indx;
	document.getElementById('txtQuantityAvialable').selectedIndex=indx;
	
	
	
	
}

function consume_ItemName_updateFields()
{
	var indx=document.getElementById('lstItemName').selectedIndex;
	
	document.getElementById('lstItemCode').selectedIndex=indx;

	document.getElementById('itemCode').selectedIndex=indx;
	document.getElementById('itemName').selectedIndex=indx;
	document.getElementById('txtQuantityAvialable').selectedIndex=indx;
	
}

function consume_SelectedItems_updateFields(changedField)
{

	var indx =0;

	if( changedField == 'itemCode')
	{
		indx = document.getElementById('itemCode').selectedIndex;
		
		document.getElementById('itemName').selectedIndex = indx;
		document.getElementById('txtQuantityAvialable').selectedIndex = indx;
		
	}
	else if( changedField == 'itemName')
	{
		indx = document.getElementById('itemName').selectedIndex;
		
		document.getElementById('itemCode').selectedIndex = indx;
		document.getElementById('txtQuantityAvialable').selectedIndex = indx;
		
	}
	else if( changedField == 'txtQuantityAvialable')
	{
		indx = document.getElementById('txtQuantityAvialable').selectedIndex;
		
		document.getElementById('itemCode').selectedIndex = indx;
		document.getElementById('itemName').selectedIndex = indx;
		
	}
	
}

function balanceTheQuantity(obj,indx)
{
	var objName = obj.getAttribute("name").split(".")[1];
	
	 var total = parseInt(document.getElementById("Received_Qty"+indx).value);
	 
	 
	
	if(objName=="itemQuantity")
	{
		var itemQty =  parseInt(document.getElementsByName('arrItems['+indx+'].'+objName)['arrItems['+indx+'].'+objName]['value']);
	 	var cs_Qty =  parseInt(document.getElementsByName('arrItems['+indx+'].itemCentralStoreQty')['arrItems['+indx+'].itemCentralStoreQty']['value']);
		
		if(itemQty>=0)
		{
			if((total-itemQty)>=0)
				document.getElementsByName('arrItems['+indx+'].itemCentralStoreQty')['arrItems['+indx+'].itemCentralStoreQty']['value'] = total-itemQty;
			else
			{
				alert("Total quantity in both department and cs store not acceed: "+total);
				document.getElementsByName('arrItems['+indx+'].'+objName)['arrItems['+indx+'].'+objName]['value']=total-cs_Qty;
			}
		}else
		{
		
			alert(" No Negative Values Accepted !! ");
			document.getElementsByName('arrItems['+indx+'].'+objName)['arrItems['+indx+'].'+objName]['value']=0;
			document.getElementsByName('arrItems['+indx+'].itemCentralStoreQty')['arrItems['+indx+'].itemCentralStoreQty']['value'] = total;
		}	
	
	}else
	{
	
		var itemQty =  parseInt(document.getElementsByName('arrItems['+indx+'].itemQuantity')['arrItems['+indx+'].itemQuantity']['value']);
	    var cs_Qty =  parseInt(document.getElementsByName('arrItems['+indx+'].'+objName)['arrItems['+indx+'].'+objName]['value']);
	
		if(cs_Qty>=0)
		{
			if((total-cs_Qty)>=0)
				document.getElementsByName('arrItems['+indx+'].itemQuantity')['arrItems['+indx+'].itemQuantity']['value'] = total-cs_Qty;
			else
			{
				alert("Total quantity in both department and cs store not acceed: "+total);
				document.getElementsByName('arrItems['+indx+'].'+objName)['arrItems['+indx+'].'+objName]['value']=total-itemQty;
			}
		}
		else
		{
		
			alert(" No Negative Values Accepted !! ");
			document.getElementsByName('arrItems['+indx+'].'+objName)['arrItems['+indx+'].'+objName]['value']=0;
			document.getElementsByName('arrItems['+indx+'].itemQuantity')['arrItems['+indx+'].itemQuantity']['value'] = total;
		}
		
	} 
	
}


function updateDepartmentList(value)
{
	for(var i=0;i<999;i++)
		try
		  {
		    document.getElementsByName('arrItems['+i+'].deptDestId')['arrItems['+i+'].deptDestId']['value']=value;
		    
		  }
		catch(err)
		  {
		   i=999;
		  }
}

function checkDates_Subitems(total)
{
	max = total;

	var ok=true;
	var msg;
	
	for(var i=0;i<max;i++)
		try
		  {
		    var manuDate = document.getElementsByName('subItems['+i+'].manuDate')['subItems['+i+'].manuDate']['value'];
		    var expireDate = document.getElementsByName('subItems['+i+'].expireDate')['subItems['+i+'].expireDate']['value'];
		    
		    var sizeVal = document.getElementsByName('subItems['+i+'].size')['subItems['+i+'].size']['value'];
		   
		   
		    if(manuDate=="" || expireDate=="" )
		    {
		    	ok=false;
		    	 i=max;
		    	 msg =" The date fields can't be empty ";		    
		    }
		    
		    
		    if(sizeVal=="")
		    {
		    	ok=false;
		    	 i=max;
		    	 msg =" The size field can't be empty ";		    
		    }
		    
		  		    
		    	
		    var manuArr= new Array();
		     manuArr=manuDate.split("-");
		  
		    var expireArr= new Array();
		     expireArr=expireDate.split("-");
		     
		   if(manuArr[0]>expireArr[0])
		   {
		    	ok=false;
		    	 i=max;	
		    	 msg =" The Expiry Date should be \n greater then Manufacturing Date  ";		    
		   }  
		  
		    if(manuArr[1]>expireArr[1])
		   {
		    	ok=false;
		    	 i=max;	
		    	 msg =" The Expiry Date should be \n greater then Manufacturing Date  ";	    
		   }
		     
		     if(manuArr[2]>=expireArr[2])
		   {
		    	ok=false;
		    	 i=max;	
		    	 msg =" The Expiry Date should be \n greater then Manufacturing Date  ";	    
		   }  
		  }
		catch(err)
		  {
		  
		   i=max;
		  }
		  
		  if(ok)
		  	return "OK";
		  else
		    return msg;
}


function deleteRequest(Id)
{
	var oRows = document.getElementById('requests').getElementsByTagName('tr');
	
	var ts = document.getElementById(Id).rowIndex ;
	document.getElementById('requests').deleteRow(document.getElementById(Id).rowIndex);
	
	
	//for(var i=ts+1 ; i<=oRows.length; i++)
	//{

		//document.getElementById('items_'+(i)).id = 'items_'+(i-1);
		//document.getElementById('avaiblableQty_'+(i)).id= 'avaiblableQty_'+(i-1);
		//document.getElementById('txtQtyRequested_'+(i)).id= 'txtQtyRequested_'+(i-1);
		
		//var st ="javascript: changeAvailableOption("+(i-1)+"); ";
		//alert(st);
		//document.getElementById('items_'+(i)).setAttribute("onchange",st);
	//}


}


function changeAvailableOption(rowIndx)
{

	document.getElementById('avaiblableQty_'+rowIndx).selectedIndex = document.getElementById('items_'+rowIndx).selectedIndex;
}

function addNewRequest()
{	

	  var tblBody = document.getElementById('requests').tBodies[0];
	
	  var newRow = tblBody.insertRow(-1);  
	  
	  newRow.id =randomUniqueID();
 	  var row_no = document.getElementById(newRow.id).rowIndex;
	  var st;
	 	
			st =  '<select id="items_'+row_no+'" onchange="javascript: changeAvailableOption('+row_no+'); " ><option selected="selected" value="1">Acetone</option><option  value="2">Test Tube</option></select>'
		 	 
	   var newCell0 = newRow.insertCell(0);
	   newCell0.innerHTML = st;
  
  
  			st =  '<select id="avaiblableQty_'+row_no+'" disabled="disabled" ><option selected="selected" value="1">20</option><option  value="2">30</option></select>'
  
	  var newCell1 = newRow.insertCell(1);
	  newCell1.innerHTML =st;
  
   
		st = '<input type="text" id="txtQtyRequested_'+row_no+'" size="11" name="T3" />';
		
   	  var newCell2 = newRow.insertCell(2);
  	  newCell2.innerHTML =  st ;
  
  	if(row_no == 1)
		st = " &nbsp;&nbsp; ";
	else
		st = "<input type='button' value='X' style='color: red;'  onclick='javascript: deleteRequest(\"" + newRow.id + "\");' /> ";
		
   var newCell2 = newRow.insertCell(3);
  newCell2.innerHTML =  st ;


}

    
function disableOwnerDepartments()
{

	var i=0;
	
	var oRows = document.getElementById('productDetails').getElementsByTagName('tr');
	var iRowCount = oRows.length;

	
	for(i=1;i<=iRowCount -1 ;i++)
	{

		if( document.getElementById('addField_'+i) != null)
		{
				document.getElementById('addField_'+i).innerHTML ='&nbsp;';
				resetDepartments(i);
		}
	}

}


function enableOwnerDepartments()
{
	var i=0;
	
	var oRows = document.getElementById('productDetails').getElementsByTagName('tr');
	var iRowCount = oRows.length;

	for(i=1;i<=iRowCount -1 ;i++)
	{
	
		if( document.getElementById('addField_'+i) != null)	
					document.getElementById('addField_'+i).innerHTML ='<input id="btnAddDept_'+i+'" runat ="server" type="button" value="Add Department" style="height: 23px" onclick="javascript: addNewDepartment('+i+');" />';


	}

}

function deleteTableRow(tblId, rowId)
{
	var oRows = document.getElementById('tableDep_'+tblId).getElementsByTagName('tr');
	
	var ts = document.getElementById(rowId).rowIndex ;
	document.getElementById('tableDep_'+tblId).deleteRow(document.getElementById(rowId).rowIndex);
	document.getElementById('txtRemarks_'+tblId).rows -= 2;
	
	
	for(var i=ts+2 ; i<=oRows.length+1; i++)
	{

		document.getElementById('cmbDept_p'+tblId+'_'+(i)).id = 'cmbDept_p'+tblId+'_'+(i-1);
		document.getElementById('txtQty_p'+tblId+'_D_'+(i)).id= 'txtQty_p'+tblId+'_D_'+(i-1);
		document.getElementById('txtQty_CS_p'+tblId+'_D_'+(i)).id= 'txtQty_CS_p'+tblId+'_D_'+(i-1);

	}


}
 function resetDepartments(pId)
{//alert(pId);

	var oRows = document.getElementById('tableDep_'+pId).getElementsByTagName('tr');
		//alert(oRows.length);
		var i=1;
		var lstObjs = new Array(oRows.length);
		var r=0;
		
		while(i < oRows.length)
		{
			lstObjs[r++]=document.getElementById('tableDep_'+pId).getElementsByTagName('tr')[i].id;
		
			//lstObjs[r++] = 1;document.getElementById('tableDep_'+pId).rows(i).id
			//alert(document.getElementById('tableDep_'+pId).rows(i).id);
			//deleteTableRow(pId,document.getElementById('tableDep_'+pId).rows(i).id);
		//alert(document.getElementById(document.getElementById('tableDep_'+pId).rows(i).id).rowIndex);
		//if(document.getElementById('tableDep_'+pId) != null)
			//document.getElementById('tableDep_'+pId).deleteRow(1);
			i++;
		}
		
		for(var t=0; t<r; t++)
			deleteTableRow(pId,lstObjs[t]);
		
		 document.getElementById('txtRemarks_'+pId).rows = 2;
	
}

//addRowInnerHTML
function addNewDepartment(tblId)
{	

	  var tblBody = document.getElementById('tableDep_'+tblId).tBodies[0];
	
	  var newRow = tblBody.insertRow(-1);  
	  
	  newRow.id =randomUniqueID();
 	 var row_no = document.getElementById(newRow.id).rowIndex+1;
	 var st;
			
  		st = '<select id="cmbDept_p'+tblId +'_'+row_no+'" style="width: 276; height:21">'
	+'<option > Animal and Veterinary Sciences </option><option > Crop Sciences </option>'
	+'<option > Food Science and Nutrition </option> <option > Marine Science and Fisheries </option>'
	+' <option > Natural Resource Economics </option> <option > Soils, Water and Agricultural Engineering </option></select>';

		 
  var newCell0 = newRow.insertCell(0);
  newCell0.innerHTML = st;
  
  var newCell1 = newRow.insertCell(1);
  newCell1.innerHTML ='<input id="txtQty_p'+tblId +'_D_'+row_no+'" type="text" style="width: 60px" />';
  
  //alert(row_no);
  	if(row_no == 1)
		st = " &nbsp;&nbsp; ";
		else
	st = "<input type='button' value='X' style='color: red;'  onclick='javascript: deleteTableRow(\"" + tblId + "\",\"" + newRow.id + "\");' /> ";
		
   var newCell2 = newRow.insertCell(2);
  newCell2.innerHTML = '&nbsp;<input id="txtQty_CS_p'+tblId +'_D_'+row_no+'" type="text" style="width: 60px" />' ;
  
  var newCell3 = newRow.insertCell(3);
  newCell3.innerHTML =st;
  
  if( row_no ==1)
  	document.getElementById('txtRemarks_'+tblId).rows = 2;
  else
  	document.getElementById('txtRemarks_'+tblId).rows += 2;
  
  //alert(document.getElementById('txtRemarks_'+tblId).rows);
  
  
//tableDep_1.deleteRow (rd1.rowIndex)

}

function setAllDeps(theVal)
{
//alert(theVal);
	var i=0;
	
	var oRows = document.getElementById('productDetails').getElementsByTagName('tr');
	var iRowCount = oRows.length;

	for(i=1;i<=iRowCount;i++)
	{
		
		if(document.getElementById('cmbDept_p'+i+'_1') != null)
		{
			resetDepartments(i);
			 document.getElementById('cmbDept_p'+i+'_1').selectedIndex= theVal;
		}
	}
	
}


function ismaxlength(obj){

var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)

}


function randomUniqueID()
{
	var chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
   var uniqId = "";
   var length =10;
   
  do{
  
		  uniqId = "newObj_";
		 
		  for(x=0;x<length;x++)
		  {
		    i = Math.floor(Math.random() * 62);
		    uniqId += chars.charAt(i);
		  }
	  
	 }while(document.getElementById(uniqId) != null)
  
  return uniqId;
}
