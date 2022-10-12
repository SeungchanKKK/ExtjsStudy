Ext.onReady(function(){
	Ext.create("Ext.panel.Panel",{
		width : 300,
		height : 300,
		renderTo : Ext.getBody(),
		items : [{
			xtype : 'combo',
			displayField :'key',
			valueField : 'value',
			store : {
				fields : ['key','value'],
				proxy : {
					type : 'ajax',
					url : '/data/combo.json',
					reader : {
						type : 'json',
						rootProperty : 'data'
					}
				}
			}
		},{
			xtype : 'grid',
			columns : [{
				text : '컬럼1',
				dataIndex : 'column1'
			},{
				text : '컬럼2',
				dataIndex : 'column2'
			},{
				text : '컬럼3',
				dataIndex : 'column3'
			}],
			store : {
				autoLoad : true,
				fields : ['column1','column2','column3'],
				proxy : {
					type : 'ajax',
					url : '/data/grid.json',
					reader : {
						type : 'json',
						rootProperty : 'data'
					}
				}
			}
		}]
	})
})