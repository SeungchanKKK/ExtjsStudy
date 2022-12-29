Ext.define('Study21.view.order.OrderListViewModel',{
    extend : 'Ext.app.ViewModel',
    alias : 'viewmodel.orderList',
    stores : {
        orderList : {
            fields: ['productNM', 'price', 'amount', 'rgstrDt'],
            data: [{
                productNM: '지우개',
                price: 500,
                amount: 100,
                rgstrDt: new Date()
            }, {
                productNM: '지우개',
                price: 500,
                amount: 100,
                rgstrDt: new Date()
            }, {
                productNM: '지우개',
                price: 500,
                amount: 100,
                rgstrDt: new Date()
            }, {
                productNM: '지우개',
                price: 500,
                amount: 100,
                rgstrDt: new Date()
            }]
        }
    }
})