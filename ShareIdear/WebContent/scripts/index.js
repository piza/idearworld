$(function(){
	init();
});

function init(){
	
	$('#createIdearForm').submit(function(event){
		//$.ajax({
		event.preventDefault();
//		    url:"/ShareIdear/idear/CreateIdearAction.action?title="
//		    	+$('#title').val()+
//		    	"&problem="+$('#problem').val()+
//		    	"&solution="+$('#solution').val(),
		var $form=$(this),dataType="json"
        	,url= $form.attr('action');
		
		$.post(url,
			dataType,
		     function(data){
		    	alert(data);
		}
		);
		
	});
}