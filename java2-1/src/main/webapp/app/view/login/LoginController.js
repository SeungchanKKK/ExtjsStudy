Ext.define('Study21.view.login.LoginController',{
    extend : 'Ext.app.ViewController',
    alias : 'controller.login',
    //로그인 버튼클릭
    loginBtn : function (btn) {
        var values = btn.up("form").getForm().getValues();
        console.log(values);
        Ext.Ajax.request({
            url : '/loginInfo',
            method : 'POST',
            params : values,
            success : function (res) {
                var api =Ext.decode(res.responseText);
                if(api['code'] == 200){
                    btn.up("window").close();
                    Ext.widget("main");
                }
                else {
                    alert(api['msg']);
                    return;
                }
            }
        });
        // btn.up("window").close();
        // Ext.widget("main");
    }
})