Ext.onReady(function () {
    Ext.create("Ext.panel.Panel", {
            width: 800,
            height: 500,
            renderTo: Ext.getBody(),
            layout: 'fit',
            items: [{
                xtype: 'grid',
                columns: [{
                    text: 'a',
                    dataIndex : 'si',
                    flex : 1
                }, {
                    text: 'b',
                    dataIndex : 'gungu',
                    flex: 1
                }, {
                    text: 'c',
                    dataIndex : 'dong',
                    flex: 1
                }],
                store : {
                    field : ['si','gungu','dong'],
                    proxy : {
                        type : 'ajax',
                        // url :
                    }
                }
            }]
        }
    )
})

