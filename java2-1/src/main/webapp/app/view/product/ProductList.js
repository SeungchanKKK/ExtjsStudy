Ext.define('Study21.view.product.ProductList', {
    extend: 'Ext.panel.Panel',
    xtype: 'productList',
    controller : 'productList',
    viewModel : 'productList',
    listeners : {
        boxready : 'onLoadData',
        resize :'setGridHeight',
    },
    title: '상품목록',
    items : [{
       xtype : 'toolbar',
        items : [{
           xtype : 'textfield',
            fieldLabel :'상품명',
            name : 'productNM',
            bind : {
               value : '{productNM}'
            }
        },{
            xtype : 'numberfield',
            fieldLabel :'가격',
            name :'price',
            bind: {
                value: '{price}'
            }
        },{
            xtype : 'numberfield',
            fieldLabel :'재고량',
            name : 'amount',
            bind: {
                value: '{amount}'
            }
        },{
            xtype : 'button',
            text : '등록',
            handler : 'addProduct'
        },{
           xtype: 'button',
            text: '초기화',
            handler: 'formatBtn'
        }]
    },{
        xtype: 'grid',
        listeners : {
            celldblclick : 'onUpdateForm'
        },
        viewConfig : {
            emptyText : '상품이 존재하지 않습니다.'
        },
        height: 150,
        columnLines : true,
        tbar : [{
            flex:1,
            xtype : 'textfield',
            emptyText: '검색어를 입력하세요',
            name : 'searchValue',
            bind : {
                value : '{searchValue}'
            }
        },{
            xtype: 'button',
            text : '검색',
            handler : 'searchBtn'
        }],
        columns : [{
            xtype : 'rownumberer'
        },{
            text : '상품명',
            flex : 1,
            style : 'text-align : center',
            dataIndex : 'productNM'
        },{
            text : '가격',
            flex : 1,
            style : 'text-align : center',
            dataIndex : 'price'
        },{
            text : '재고량',
            flex : 1,
            style : 'text-align : center',
            dataIndex : 'amount'
        },{
            text : '등록일',
            flex : 1,
            style : 'text-align : center',
            dataIndex : 'rgstrDt',
            renderer : function (value) {
                if(value != undefined && value != null && value != ""){
                    return Ext.util.Format.date(new Date(value),"Y-m-d H:i:s")
                }
            }
        },{
            xtype: 'widgetcolumn',
            text: '삭제',
            flex: 1,
            style : 'text-align : center',
            widget : {
                xtype : 'button',
                text : '상품삭제',
                handler : 'productdlt'
            }
        }],
        bind : {
            store : '{productList}'
        }
    }]
});