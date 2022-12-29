Ext.define('Study21.view.product.ProductListController',{
    extend : 'Ext.app.ViewController',
    alias : 'controller.productList',
    //최초데이터 로드
    onLoadData : function (obj){
        var me = this;
        var view = me.getView();
        var viewModel = me.getViewModel();
        //view['xtype'] == "productList"
        var store = viewModel.getStore(view['xtype']);
        store.load();
    },
    //검색기능
    searchBtn : function (btn) {
        var me = this;
        var view = me.getView();
        var viewModel = me.getViewModel();
        var store = viewModel.getStore(view['xtype']);
        store.getProxy().setExtraParam("searchValue",viewModel.get("searchValue"));
        store.load({
            callback : function (data) {
                console.log(data)
            }
        })
    },
    // 상품목록그리드 리사이즈
    setGridHeight : function (obj){
      obj.down("grid").setHeight(Ext.Element.getViewportHeight());
    },
    //상품저장/수정
    addProduct : function (btn) {
        var me = this;
        var view = me.getView();
        var viewModel = me.getViewModel();
        var url = "/api/add/product";
        var params = {
            productNM : viewModel.get("productNM"),
            price : viewModel.get("price"),
            amount : viewModel.get("amount"),
        };

        //수정
        if(viewModel.get("id") > 0){
            console.log("수정처리")
            params.id = viewModel.get("id")
            url = "/api/update/product";
        }

        Ext.Ajax.request({
            url : url,
            method : 'POST',
            params : params,
            success : function (res) {
                var result = Ext.decode(res.responseText);
                //정상등록
                if(result['code']==200){
                    viewModel.getStore(view['xtype']).load();
                    alert(result['message'])
                }
                else {
                    Ext.Msg.alert("알림",result['message']);
                    return;
                }
            }
        });
    },
    productdlt : function (btn) {
        var me = this;
        var view = me.getView();
        var viewModel = me.getViewModel();
        var record = btn.getWidgetRecord();

        Ext.Ajax.request({
            url : '/api/remove/product',
            method : 'POST',
            params: {
                id : record.get("id")
            },
            success : function (res) {
                var result = Ext.decode(res.responseText);
                if(result['code']==200){
                    viewModel.getStore(view['xtype']).load();
                    alert(result['message'])
                }else {
                    Ext.Msg.alert("알림",result['msg']);
                    return;
                }
            }
        })
    },
    //셀 수정기능
    onUpdateForm : function (obj,td,cellIndex,record,tr,rowIndex,e,eOpt) {
        var me = this;
        var view = me.getView();
        var viewModel = me.getViewModel();

        viewModel.set("id",record.get("id"));
        viewModel.set("productNM",record.get("productNM"));
        viewModel.set("price",record.get("price"));
        viewModel.set("amount",record.get("amount"));
        console.log(viewModel.get("id"))
    },
    //초기화 버튼 클릭
    formatBtn : function(btn) {
        var me = this;
        var view = me.getView();
        var viewModel = me.getViewModel();
        var store = viewModel.getStore(view['xtype']);
        viewModel.set("id", 0);
        viewModel.set("productNM", "");
        viewModel.set("price", 0);
        viewModel.set("amount", 0);
        store.getProxy().setExtraParam("searchValue",null);
        store.load({
            callback : function (data) {
                console.log(data)
                viewModel.set("searchValue","")
            }
        })
    }
})