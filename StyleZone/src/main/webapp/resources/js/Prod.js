$(document).ready(function(){
	 var path="http://localhost:10048/StyleZone/resources/images/";
  $("#productstable").DataTable({
	
	  "ajax": {
		    "url": "http://localhost:10048/StyleZone/admin/adminproducts/all",
		    "dataSrc": ""
		  },
	  "columns": [
          { "data": "productName" },
          { "data": "",
        	"render":function(data,type,row)
        	{
        	  return "&#8360;."+row.productPrice+"";
          }  
          
          },
          { "data":"quantity" },
          
          {data:"productName",
        	  mRender:function(data,type,row){
        		  return '<img src="'+path+data+'.jpg" width="25px" height="25px"></img>';
        	  }
          },
          
          {"data":"productId",
        	  "render":function(data,type,row){
        		  return "<a href='http://localhost:10048/StyleZone/admin/"+row.productId+"/editproduct' class='btn btn-primary'>Edit</a>";
        	  }
          },
        	
         {"data":"",
        	  "render":function(data,type,row){
        		  return "<a href='http://localhost:8089/myproject/admin/"+row.productId+"/deleteproduct' class='btn btn-primary'>Delete</a>";
        	  }
          }  
                    
      ]
  });
    
    
});