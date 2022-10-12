Ext.onReady(function(){
	//Ext.window.window
	Ext.create("Ext.panel.Panel",{
		border : true,
		width : 300,
		height : 300,
		renderTo : Ext.getBody(),
		items : [{
			xtype : 'button',
			text : '패널버튼',
			handler : function(btn){
				var win = Ext.create("Ext.window.Window",{
				text: "버튼실험",
				width : 300,
				height : 300,
				minWidth : 250,
				minHeight : 250,
				maxWidth : 350,
				maxHeight : 350, 
				title : 'Window Title',
				items : [{
					xtype : 'button',
					text : '버튼',
				}],
				maximizable: true,
				modal : true,
				});
				win.show();
			}
		}]
	})
	/*var win = Ext.create("Ext.window.Window",{
		text: "버튼실험",
		width : 300,
		height : 300,
		minWidth : 250,
		minHeight : 250,
		maxWidth : 350,
		maxHeight : 350,
		autoShow : true,
		title : 'Window Title',
		items : [{
			xtype : 'button',
			text : '버튼',
		}],
		maximizable: true,
		modal : true,
		//resizable : false
	});*/
}) 