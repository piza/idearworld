$(function(){
	init();
});

function init(){
	$.ajax({
		type:"post",
		dataType:"json",
		url:"/ShareIdear/idear/LoadIdearAction.action",
	      success:function(data){
	    	  $('#showIdear').append(
	    			  "<div> <b>"+data.idearId+"</b>  <br>" +
	    		  		"<b>"+data.title+"</b> <br>" +
	    		  		"<p>"+data.problem+"</p> <br>" +
	    		  		"<p>"+data.solution+"</p> <br>" +
	    		  		"</div>"	  
	    	  );
	      }
	},"json");
		
	
}

