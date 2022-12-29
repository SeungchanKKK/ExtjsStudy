Ext.define('Study21.view.product.ProductListViewModel',{
    extend : 'Ext.app.ViewModel',
    alias : 'viewmodel.productList',
    data : {
        id : 0,
        productNM: '',
        price : 0,
        amount : 0,
        searchValue : ''
    },
    stores : {
        productList : {
            type : 'productList'
        }
    }
})