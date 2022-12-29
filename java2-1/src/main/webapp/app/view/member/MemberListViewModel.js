Ext.define('Study21.view.member.MemberListViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.memberList',
    // data : {
    //     id : 0,
    //     memberNm: '',
    //     memberNick : '',
    //     address : '',
    //     rgstrDt : '',
    //     searchValue : ''
    // },
    stores: {
        memberList: {
            type : 'memberList'
        }

    }
})