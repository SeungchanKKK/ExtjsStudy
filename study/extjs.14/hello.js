Ext.onReady(function () {
    Ext.create("Ext.panel.Panel", {
            width: 800,
            height: 500,
            renderTo: Ext.getBody(),
            layout: 'fit',
            items: [{
                xtype: 'grid',
                columns: [{
                    text: 'a'
                }, {
                    text: 'b'
                }, {
                    text: 'c'
                }]
            }]
        }
    )
})