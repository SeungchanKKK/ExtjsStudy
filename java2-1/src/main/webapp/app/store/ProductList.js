Ext.define('Study21.store.ProductList', {
    extend : 'Ext.data.BufferedStore',
    alias : 'store.productList',
    storeId : 'productList',
    autoLoad : false,
    fields : ['productNM','price','amount','rgstrDt'],
    proxy : {
        type : 'ajax',
        actionMethods : {
            read : 'POST'
        },
        url : '/api/list/product',
        reader : {
            type : 'json',
            rootProperty : 'data',
            totalProperty : 'totalCount'
        }
    }
})