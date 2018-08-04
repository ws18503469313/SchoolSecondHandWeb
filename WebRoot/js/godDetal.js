$(function(){
	//������۰�ť��ʾ����,Ӱ������
	$("#comment").click(function() {
		$("#comments").show();
		$(".disc").hide();
	});
	
	//���������ť��ʾ����,Ӱ������
	$("#discrip").click(function() {
		$("#disc").show();
		$("#comments").hide();
	});
	
	//���ͼƬ��ͼƬsrc
	$(".small").click(function(){
		var src = this.src;
		$(".big").attr("src",src);
	});
	
	//AJAX��һ�����ۻظ�
	$('.submitreply').click(function (){   //���һ����ť��ִ������Ĵ���  
	     var reply=$('.reply').val(); //���л��?��ֵ������params����  
	     var comment_id = $('.comment_id').val();
	     if(reply == null || reply == ""){
	    	 alert("请输入评论!");
	    	 return;
	     }
	     $.ajax({  
	       url:'god/reply', 	//��̨�������php  
	       type:'post',         //��ݷ��ͷ�ʽpost  
	       dataType:'text',     //������ݸ�ʽjson���  
	       data:{reply:reply,comment_id:comment_id},         //Ҫ���ݵ���� ���л���ı���  
	       success:function(message){//�ش�����(�����Ǻ�����)���ɹ���ִ��update_page������Դ��Σ�data��,�����������ص������Ϊ����  
	    	   window.alert(message);
	    	   $(this).parent("tr").children(":input").val("");
	       }	
	     });  
	});
	
	$("#aic").click(function(){
		var id = $(this).val();
		if(window.confirm("确认加入收藏!")){
			$.ajax({
				url:'god/addInCollection',
				method:'get',
				dataType:'text',
				data:{id:id},
				success:function(message){
					alert(message);
				}
			});
		}
	});
});


