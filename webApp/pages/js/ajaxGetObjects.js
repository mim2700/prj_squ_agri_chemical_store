
var objForm;
var operType;
var subitems_indx;

var http = getHTTPObject(); // We create the XMLHTTPRequest Object

function handleHttpResponse() {

    if (http.readyState == 4) {
        if (http.status == 200) {
        
        if(operType=="Type")
        	updatingTypeOperation();
        else if(operType=="Grade")
        	updatingGradeOperation();
        else if(operType=="Safety")
        	updatingSafetyOperation();
        else if(operType=="User")
        	updatingUserOperation();
         else if(operType=="ItemsList")
        	updatingItemsListOperation();
         else if(operType=="subItemsList")
        	updatingSubItemsListOperation();
         else if(operType=="AllItems")
        	updatingAllItemsOperation();
         else if(operType=="itemProperties_adjustment")
        	updatingItemPropertiesOperation();
         
            
        } 
    }    
}

//var ids=new Array();
//var names=new Array();
//var qtys=new Array();

function searchFormDB()
{
 alert(666666);
}

function updatingItemPropertiesOperation()
{

	var code = http.responseXML.getElementsByTagName("item");
	
	if (code.length > 0)
	{
				    
	     var type  = code[0].childNodes[2].firstChild.nodeValue;
	     var isMulti  = code[0].childNodes[3].firstChild.nodeValue;
	     var safety  = code[0].childNodes[4].firstChild.nodeValue;
	     //var grade  = code[0].childNodes[5].firstChild.nodeValue;
	     var measurment  = code[0].childNodes[6].firstChild.nodeValue;
	     

	    /* 
	    if(grade !="null")
	     {
	     	document.getElementById('items['+subitems_indx+'].grade').value=grade;
	     	document.getElementById('items['+subitems_indx+'].grade').disabled = true;
	     }
	     else
	     {
	     	document.getElementById('items['+subitems_indx+'].grade').value="0";
	     	document.getElementById('items['+subitems_indx+'].grade').disabled = false;
	     }
	    */ 	
	     if(safety !="null")
	     {
	        if(document.getElementById('items[0].safety') != null)
	        {
		        document.getElementById('items[0].safety').value=safety;
		     	document.getElementById('items[0].safety').disabled = true;
	        }
	     	
	     }
	     else
	     {
	       if(document.getElementById('items[0].safety') != null)
	       {  
	        	document.getElementById('items[0].safety').value="0";
		     	document.getElementById('items[0].safety').disabled = false;
	       }
		  
	     }
	     	
	     if(type !="null")	
	     {
	       if(document.getElementById('items[0].type') != null)
	       {
		       document.getElementById('items[0].type').value= type;
			 	document.getElementById('items[0].type').disabled = true;
	       }
		 	
		 }
		 else
		 {
		     if(document.getElementById('items[0].type') != null)
		 	{
		 		document.getElementById('items[0].type').value= "0";
		 		document.getElementById('items[0].type').disabled = false;
		 	}
		 }
		 	
		 if(measurment !="null")
		 {	
		 	if(document.getElementById('items[0].measurment') != null)
		 	{
			 	document.getElementById('items[0].measurment').value= measurment;
			 	document.getElementById('items[0].measurment').disabled = true;
		 	}
		 	
		 }	
		 else
		 {
		 	if(document.getElementById('items[0].measurment') != null)
		 	{
			 	document.getElementById('items[0].measurment').value= "0";
			 	document.getElementById('items[0].measurment').disabled = false;
		 	}
		 	
		 }
	  
	     if(isMulti=="1")
	     {
	     	if(document.getElementById('items[0].multipleSubItem') != null)
	     	{
		     	document.getElementById('items[0].multipleSubItem').checked = true;
		     	document.getElementById('items[0].multipleSubItem').disabled = true;
	     	}
	     	
	     }
	     else
	     {
	     	if(document.getElementById('items[0].multipleSubItem') != null)
	     	{
		     	document.getElementById('items[0].multipleSubItem').checked = false;
		     	document.getElementById('items[0].multipleSubItem').disabled = false;
	     	}
	     	
	     }

	 }
	 else
	 {
	 		//document.getElementById('items['+subitems_indx+'].grade').value="0";
			document.getElementById('items[0].type').value="0";
			document.getElementById('items[0].safety').value="0";
			document.getElementById('items[0].measurment').value="0";
			
			document.getElementById('items[0].itemQuantity').value="0";
			
			document.getElementById('items[0].multipleSubItem').checked = false;
	     	document.getElementById('items[0].multipleSubItem').disabled = false;
	 }
	 
}

function updatingAllItemsOperation()
{
	     var code = http.responseXML.getElementsByTagName("item");
	     
	     clearlistbox(document.getElementById('lstItemName'));
           

		 var flag_empty=false;
			 
			 if(code.length >0)
			 {
			 	flag_empty=true;
			 	
			 	document.getElementById('lstItemName').style.visibility = "visible";
			 	document.getElementById('lstItemCode').style.visibility = "visible";
			 	
			 	document.getElementById('itemCode').disabled=false;
			 	document.getElementById('itemName').disabled=false;
			 	document.getElementById('txtQuantityAvialable').disabled=false;
			 	
			 	for(var i = 0; i < code.length; i++)
	                {
	                       id= code[i].childNodes[0].firstChild.nodeValue;
	   					   name= code[i].childNodes[1].firstChild.nodeValue;
	                       qty = code[i].childNodes[2].firstChild.nodeValue;
	                      	
	                     if(qty >0)
	                     {
	                     	flag_empty=false;
	                     
	                     	addOption('lstItemCode',id,id);
	  						addOption('itemCode',id,id);
	  						
	                      	addOption('lstItemName',name,name);
	                      	addOption('itemName',name,name);
	                      	
	                      	addOption('txtQuantityAvialable',qty,qty);
	                     
	                     }
	  						
	
	
	
	                           
	                }
			 }
			 else
			 {
				 flag_empty=true;
			 }
           
           if(flag_empty) 
           {
           		document.getElementById('lstItemName').style.visibility = "hidden";
			 	document.getElementById('lstItemCode').style.visibility = "hidden";
			 	
			 	document.getElementById('itemCode').disabled="disabled";
			 	document.getElementById('itemName').disabled="disabled";
			 	document.getElementById('txtQuantityAvialable').disabled="disabled";
			 	
           }          

}

function updatingSubItemsListOperation()
{
	var code = http.responseXML.getElementsByTagName("item");
	
	clearlistbox(document.getElementById('subItems['+subitems_indx+'].subItemId'));
	clearlistbox(document.getElementById('subItems['+subitems_indx+'].qtyAvailable'));

	if (code.length > 0)
	{
			document.getElementById('subItems['+subitems_indx+'].subItemId').disabled = false;
		
		for(var i = 0; i < code.length; i++)
	       {
	       
	            id  = code[i].childNodes[0].firstChild.nodeValue;
	            qty = code[i].childNodes[1].firstChild.nodeValue;
	            addOption('subItems['+subitems_indx+'].subItemId',id,id);
	            addOption('subItems['+subitems_indx+'].qtyAvailable',qty,qty);
	  		
	        }
	
	}
	 else
	 	document.getElementById('subItems['+subitems_indx+'].subItemId').disabled = "disabled";


	 	
                
}


function updatingItemsListOperation(){

           
            var code = http.responseXML.getElementsByTagName("item");
                
             clearlistbox(document.getElementById('lstItemName'));
             clearlistbox(document.getElementById('lstItemCode'));
             clearlistbox(document.getElementById('itemCode'));
             clearlistbox(document.getElementById('itemName'));
             clearlistbox(document.getElementById('txtQuantityAvialable'));

			 var flag_empty=false;
			 
			 if(code.length >0)
			 {
			 	flag_empty=true;
			 	
			 	document.getElementById('lstItemName').style.visibility = "visible";
			 	document.getElementById('lstItemCode').style.visibility = "visible";
			 	
			 	document.getElementById('itemCode').disabled=false;
			 	document.getElementById('itemName').disabled=false;
			 	document.getElementById('txtQuantityAvialable').disabled=false;
			 	
			 	for(var i = 0; i < code.length; i++)
	                {
	                       id= code[i].childNodes[0].firstChild.nodeValue;
	   					   name= code[i].childNodes[1].firstChild.nodeValue;
	                       qty = code[i].childNodes[2].firstChild.nodeValue;
	                      	
	                     if(qty >0)
	                     {
	                     	flag_empty=false;
	                     
	                     	addOption('lstItemCode',id,id);
	  						addOption('itemCode',id,id);
	  						
	                      	addOption('lstItemName',name,name);
	                      	addOption('itemName',name,name);
	                      	
	                      	addOption('txtQuantityAvialable',qty,qty);
	                     
	                     }
	  						
	
	
	
	                           
	                }
			 }
			 else
			 {
				 flag_empty=true;
			 }
           
           if(flag_empty) 
           {
           		document.getElementById('lstItemName').style.visibility = "hidden";
			 	document.getElementById('lstItemCode').style.visibility = "hidden";
			 	
			 	document.getElementById('itemCode').disabled="disabled";
			 	document.getElementById('itemName').disabled="disabled";
			 	document.getElementById('txtQuantityAvialable').disabled="disabled";
			 	
           }          
  
}

function clearlistbox(lb){
  for (var i=lb.options.length-1; i>=0; i--){
    lb.options[i] = null;
  }
  lb.selectedIndex = -1;
}

function addOption(lst,text,value)
{
	var o = document.createElement("option");
	o.text = text
	o.value = value;
	document.getElementById(lst).add(o);
	
}




function updatingTypeOperation(){


            var tid = http.responseXML.getElementsByTagName("tid");
            var tname = http.responseXML.getElementsByTagName("tname");
            var active = http.responseXML.getElementsByTagName("active");
            
           
          objForm.typeId2.value=tid[0].firstChild.nodeValue;
          objForm.typeName.value=tname[0].firstChild.nodeValue;
         
          if(active[0].firstChild.nodeValue=="1")
          	objForm.typeActive.checked=true;
          else
          	objForm.typeActive.checked=false;
          	
}

function updatingGradeOperation(){

 
            var gid = http.responseXML.getElementsByTagName("gid");
            var name = http.responseXML.getElementsByTagName("name");
            var number = http.responseXML.getElementsByTagName("number");
            var desc = http.responseXML.getElementsByTagName("desc");
            var active = http.responseXML.getElementsByTagName("active");
            
           //alert (role[0].firstChild.nodeValue);
          objForm.gradeId2.value=gid[0].firstChild.nodeValue;
          objForm.gradeName.value=name[0].firstChild.nodeValue;
          objForm.gradeNumber.value=number[0].firstChild.nodeValue;
          objForm.gradeDescription.value=desc[0].firstChild.nodeValue;
          
          if(active[0].firstChild.nodeValue=="1")
          	objForm.gradeActive.checked=true;
          else
          	objForm.gradeActive.checked=false;
          
          
}

function updatingSafetyOperation(){

 			var sid = http.responseXML.getElementsByTagName("sid");
            var un_number = http.responseXML.getElementsByTagName("un_number");
            var other_number = http.responseXML.getElementsByTagName("other_number");
            var desc = http.responseXML.getElementsByTagName("desc");
            var active = http.responseXML.getElementsByTagName("active");
            
           //alert (role[0].firstChild.nodeValue);
          objForm.safetyId2.value=sid[0].firstChild.nodeValue;
          objForm.un_Number.value=un_number[0].firstChild.nodeValue;
          objForm.other_number.value=other_number[0].firstChild.nodeValue;
          objForm.safetyDescription.value=desc[0].firstChild.nodeValue;
          
          if(active[0].firstChild.nodeValue=="1")
          	objForm.safetyActive.checked=true;
          else
          	objForm.safetyActive.checked=false;
}

function updatingUserOperation(){

 
            var uid = http.responseXML.getElementsByTagName("uid");
            var name = http.responseXML.getElementsByTagName("name");
            var role = http.responseXML.getElementsByTagName("role");
            var deptId = http.responseXML.getElementsByTagName("deptId");
            var active = http.responseXML.getElementsByTagName("active");
            
           //alert (role[0].firstChild.nodeValue);
           //document.writeln(http.responseText);
           //alert(http.responseText);
          objForm.name.value=name[0].firstChild.nodeValue;
          objForm.deptId.value=deptId[0].firstChild.nodeValue;
          objForm.role.value=role[0].firstChild.nodeValue;
          
          if(active[0].firstChild.nodeValue=="1")
          	objForm.active.checked=true;
          else
          	objForm.active.checked=false;
          
          
 		
}



function getSubItemsList(subItemCode,deptId,indx,adjustId)
{
	subitems_indx = indx;

  if(document.getElementById('subItems['+subitems_indx+'].subItemId') != null)
	if(subItemCode==0)
	{
		clearlistbox(document.getElementById('subItems['+subitems_indx+'].subItemId'));
		clearlistbox(document.getElementById('subItems['+subitems_indx+'].qtyAvailable'));
		document.getElementById('subItems['+subitems_indx+'].subItemId').disabled = "disabled";
	}
	
	else
	{
		var url =  getCurrentHostUrl()+"/pages/item/subItemsList.jsp?id=";
		operType="subItemsList";
		
		http.open("GET", url + escape(subItemCode) + "&deptId=" + escape(deptId)+"&adjustId=" + escape(adjustId), true);
	    http.onreadystatechange = handleHttpResponse;
	    
	    http.send(null);
		
	}
   else
   {
   
   		if(subItemCode==0)
		{
			//document.getElementById('items['+subitems_indx+'].grade').value="0";
			document.getElementById('items['+subitems_indx+'].type').value="0";
			document.getElementById('items['+subitems_indx+'].safety').value="0";
			document.getElementById('items['+subitems_indx+'].measurment').value="0";
			
			document.getElementById('items['+subitems_indx+'].itemQuantity').value="0";
			
			document.getElementById('items['+subitems_indx+'].multipleSubItem').checked = false;
	     	document.getElementById('items['+subitems_indx+'].multipleSubItem').disabled = false;
	     	
			//document.getElementById('subItems['+subitems_indx+'].subItemId').disabled = "disabled";
		}
		
		else
		{

	   		var url =  getCurrentHostUrl()+"/pages/item/itemProperties.jsp?id=";
			operType="itemProperties_adjustment";
			http.open("GET", url + escape(subItemCode), true);
		    http.onreadystatechange = handleHttpResponse;
		    
		    http.send(null);
		 }
	
   }
	
	
}

function getItemsList(deptId,vl,searchBy,from) {

	//var url = "getItemsList.do?id="
	var url =  getCurrentHostUrl()+"/pages/item/getItemsList.jsp?id="
	operType="ItemsList";

    http.open("GET", url + escape(deptId) + "&value=" + escape(vl) + "&searchBy=" + escape(searchBy)+ "&from=" + escape(from), true);
    http.onreadystatechange = handleHttpResponse;
    
    http.send(null);
    
	//startOperation(deptId,vl,searchBy,url);

}

function getAllItems(deptId) {

	var searchBy ="all_available";
	var vl=null;
	//var url = "getItemsList.do?id="
	var url =  getCurrentHostUrl()+"/pages/item/getItemsList.jsp?id="
	operType="AllItems";

    http.open("GET", url + escape(deptId) + "&value=" + escape(vl) + "&searchBy=" + escape(searchBy), true);
    http.onreadystatechange = handleHttpResponse;
    
    http.send(null);
    
	//startOperation(deptId,vl,searchBy,url);

}

function getType(objF,vl) {

	objForm=objF;
	var url =  getCurrentHostUrl()+"/pages/item/type/getType.jsp?id=";
	operType="Type";
	
	if(vl=="0")
	{
		 objForm.typeId2.value="";
         objForm.typeName.value="";
		 objForm.typeActive.checked=false;
    
	}
	else
		startOperation(vl,url);

}


function getGrade(objF,vl) {

	objForm=objF;
	var url =  getCurrentHostUrl()+"/pages/item/grade/getGrade.jsp?id=";
	operType="Grade";
	if(vl=="0")
	{
	      objForm.gradeId2.value="";
          objForm.gradeName.value="";
          objForm.gradeNumber.value="";
          objForm.gradeDescription.value="";
          objForm.gradeActive.checked=false;
	}else
		startOperation(vl,url);

}

function getSafety(objF,vl) {

	objForm=objF;
	var url =  getCurrentHostUrl()+"/pages/item/safety/getSafety.jsp?id=";
	operType="Safety";
	
	if(vl=="0")
	{
		 objForm.safetyId2.value="";
         objForm.un_Number.value="";
         objForm.other_number.value="";
         objForm.safetyDescription.value="";
         objForm.safetyActive.checked=false;
	
	}else
		startOperation(vl,url);

}

function getUserObj(objF,vl) {

	objForm=objF;
	var url =  getCurrentHostUrl()+"/pages/user/getUser.jsp?id=";
	//var url = "getUser2.do?id="
	operType="User";
	startOperation(vl,url);

}

function startOperation(vl,url)
{
    var idValue = vl;
   
    http.open("GET", url + escape(idValue), true);
    http.onreadystatechange = handleHttpResponse;
    
    http.send(null);

}

//function startOperation(deptId,vl,searchBy,url)
//{
  
  

//}

function getHTTPObject() {
	var xmlhttp;

	if (window.XMLHttpRequest)
  {
  // code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else if (window.ActiveXObject)
  {
  // code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
else
  {
  alert("Your browser does not support XMLHTTP!");
  }

	return xmlhttp;
}

function getCurrentHostUrl()
{
	var loc = location.href;
		
	var pos = loc.indexOf("/");
	pos = loc.indexOf("/",pos+1);
	pos = loc.indexOf("/",pos+1);
	pos = loc.indexOf("/",pos+1);
	
	return loc.substring(0,pos);

}