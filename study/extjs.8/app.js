Ext.onReady(function(){
	//1. ExtJS ALERT
	//Ext.Msg.alert("타이틀","바디");
	/*Ext.Msg.confirm("타이틀","바디",function(button){
		if(button == 'yes'){
			alert("예");
		}
		else {
			alert("아니오");
		}
	});*/
	
	// t, tr, tl, b, br, bl
	/*Ext.toast({
		html : "토스트입니다",
		align : 'br'
	})*/
	
	Ext.MessageBox.show({
		title : '상단제목',
		msg : '몸통내용',
		icon : Ext.MessageBox.INFO,
		buttonText : {
			ok : '오케이',
			no : '노',
			yes : '예스',
			cancel : '캔슬'
		},
		buttons : Ext.MessageBox.YESNOCANCEL,
		fn : function(button) {
		if(button == 'yes'){
			alert("예");
		}
		else {
			alert("아니오");
		}
		}
	});
})