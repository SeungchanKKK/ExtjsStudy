Ext.define('Study21.view.member.MemberList', {
    extend : 'Ext.grid.Panel',
    listeners : {
        boxready : 'onLoadData'
    },
    xtype : 'memberList',
    requires : ['Ext.ux.ProgressBarPager'],
    controller : 'memberList',
    viewModel : 'memberList',
    title : '회원목록',
    columnLines: true,
    plugins : 'cellediting',
    tbar: [{
        xtype: 'combo',
        displayField : 'key',
        valueField : 'value',
        queryMode : 'local',
        value : 'memberNick',
        name : 'searchCode',
        store : {
            fields : ['key','value'],
            data : [{
                key : '아이디',
                value : 'memberNick'
            },{
                key : '이름',
                value : 'memberNm'
            }]
        }
    },{
        xtype: 'textfield',
        name: 'searchValue',
        emptyText: '검색어를 입력하세요'
    }, {
        xtype: 'button',
        text: '검색',
        handler : 'searchBtn'
    }],
    columns: [{
        xtype: 'rownumberer'
    }, {
        text: '이름',
        flex: 1,
        dataIndex: 'memberNm',
        editor: {
            xtype: 'textfield'
        }
    }, {
        text: '회원ID',
        flex: 1,
        dataIndex: 'memberNick',
        editor: {
            xtype: 'textfield'
        }
    },{
        text: '주소',
        flex: 1,
        dataIndex: 'address',
        editor: {
            xtype: 'textfield'
        }
    }, {
        text: '등록일',
        flex: 1,
        dataIndex: 'rgstrDt',
        renderer : function (value) {
            if(value != undefined && value != null && value != ""){
                return Ext.util.Format.date(new Date(value),"Y-m-d H:i:s")
            }
        }
    }
    ],
    bind : {
        store : '{memberList}'
    },
    bbar : {
        xtype : 'pagingtoolbar',
        plugins : 'ux-slidingpager',
        // plugins : 'ux-progressbarpager',
        displayInfo: true
    }
});