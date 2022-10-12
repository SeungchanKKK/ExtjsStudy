Ext.onReady(function () {

    // text : button 처럼 문구 출력할때 필요한속성
    // expanded : 확장여부 - children package
    // children : json array 형태 text/ expanded/ children/ leaf depth별로 하위값 적용
    // leaf : true - 마지막 노드. 파일 아이콘 출력

    Ext.create("Ext.panel.Panel", {
        width: 500,
        height: 500,
        renderTo: Ext.getBody(),
        items: [{
            xtype: 'treepanel',
            store : {
                root: {
                    text: 'Servers',
                    expanded: false,
                },
                proxy : {
                    type : 'ajax',
                    url : '/data/tree.json',
                    reader : {
                        type : 'json'
                    }
                }
            }
        }]
    })
})