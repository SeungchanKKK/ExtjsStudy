Ext.define('Study21.store.MemberList',
    {
        extend: 'Ext.data.Store',
        alias: 'store.memberList',
        storeId: 'memberList',
        autoLoad: false,
        fields: ['id', 'memberNm', 'memberNick', 'address', 'rgstrDt'],
        pageSize: 5,
        proxy: {
            type: 'ajax',
            actionMethods: {
                read: 'POST'
            },
            url: '/api/list/member',
            reader: {
                type: 'json',
                rootProperty: 'data',
                totalProperty: 'totalCount'
            }
        }
    })