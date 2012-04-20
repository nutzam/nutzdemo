<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	if(request.getSession(true) == null || request.getSession(false).getAttribute("name") == null){
		response.sendRedirect("./login.jsp");
	} 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>低值易耗品管理   神华销售集团有限公司华北能源贸易分公司朔西办事处 </title>
<link rel="stylesheet" href="resources/css/ext-all.css" type="text/css"></link>
<link rel="stylesheet" href="css/site.css" type="text/css"></link>
<link rel="stylesheet" href="css/GridFilters.css" type="text/css"></link>
<link rel="stylesheet" href="css/RangeMenu.css" type="text/css"></link>



<script type="text/javascript" src="js/ext-all-debug.js"></script>
<script type="text/javascript" src="js/ext-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/FiltersFeature.js"></script>
<script type="text/javascript" src="js/filter/Filter.js"></script>
<script type="text/javascript" src="js/filter/NumericFilter.js"></script>
<script type="text/javascript" src="js/filter/StringFilter.js"></script>
<script type="text/javascript" src="js/filter/DateFilter.js"></script>
<script type="text/javascript" src="js/filter/ListFilter.js"></script>
<script type="text/javascript" src="js/filter/BooleanFilter.js"></script>
<script type="text/javascript" src="js/menu/RangeMenu.js"></script>
<script type="text/javascript" src="js/menu/ListMenu.js"></script>
<style type="text/css">

.x-grid-checkheader {
    height: 14px;
    background-image: url('resources/themes/images/default/form/unchecked.gif');
    background-position: 50% -2px;
    background-repeat: no-repeat;
    background-color: transparent;
}

.x-grid-checkheader-checked {
    background-image: url('resources/themes/images/default/form/checked.gif');
}

.x-grid-checkheader-editor .x-form-cb-wrap {
    text-align: center;
}
.item-add {
    background-image: url('images/add.png');
}
.item-delete {
    background-image: url('images/delete.png');
}
.item-insert {
    background-image: url('images/insert.png');
}
.item-insertprint {
    background-image: url('images/insertprint.png');
}
.item-use {
    background-image: url('images/use.png');
}
.item-useprint {
    background-image: url('images/useprint.png');
}
.item-destoryed {
    background-image: url('images/destoryed.png');
}
.item-destoryedprint {
    background-image: url('images/destoryedprint.png');
}
.item-export {
    background-image: url('images/export.png');
}
.item-help {
    background-image: url('images/help.png');
}
</style>
<script type="text/javascript">
Ext.define('Ext.ux.CheckColumn', {
    extend: 'Ext.grid.column.Column',
    alias: 'widget.checkcolumn',
    
    constructor: function() {
        this.addEvents(
            'checkchange'
        );
        this.callParent(arguments);
    },

    /**
     * @private
     * Process and refire events routed from the GridView's processEvent method.
     */
    processEvent: function(type, view, cell, recordIndex, cellIndex, e) {
        if (type == 'mousedown' || (type == 'keydown' && (e.getKey() == e.ENTER || e.getKey() == e.SPACE))) {
            var record = view.panel.store.getAt(recordIndex),
                dataIndex = this.dataIndex,
                checked = !record.get(dataIndex);
                
            record.set(dataIndex, checked);
            this.fireEvent('checkchange', this, recordIndex, checked);
            // cancel selection.
            return false;
        } else {
            return this.callParent(arguments);
        }
    },

    // Note: class names are not placed on the prototype bc renderer scope
    // is not in the header.
    renderer : function(value){
        var cssPrefix = Ext.baseCSSPrefix,
            cls = [cssPrefix + 'grid-checkheader'];

        if (value) {
            cls.push(cssPrefix + 'grid-checkheader-checked');
        }
        return '<div class="' + cls.join(' ') + '">&#160;</div>';
    }
});
Ext.onReady(function(){
	var useWin,useForm,destoryedWin,destoryedForm,batchWin,batchForm;
    var currentArguments;
	Ext.tip.QuickTipManager.init();
    Ext.define('Department', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},
            {name: 'name', type: 'string'}
        ]
    });
    var departmentField = {
        xtype: 'combobox',
        name: 'department',
        fieldLabel: '部门',
        typeAhead: true,
        triggerAction: 'all',
        displayField: 'name',
        valueField: 'name',
        selectOnTab: true,
        store: new Ext.data.Store({
            model: 'Department',
            proxy: {
                type: 'ajax',
                url : 'department/list',
                reader: {
                    type: 'json',
                    root: 'list'
                }
            },
            autoLoad: true
        }),
        lazyRender: true,
        listClass: 'x-combo-list-small'
    };
    var departmentField1 = {
        xtype: 'combobox',
        name: 'department',
        typeAhead: true,
        triggerAction: 'all',
        displayField: 'name',
        valueField: 'name',
        selectOnTab: true,
        store: new Ext.data.Store({
            model: 'Department',
            proxy: {
                type: 'ajax',
                url : 'department/list',
                reader: {
                    type: 'json',
                    root: 'list'
                }
            },
            autoLoad: true
        }),
        lazyRender: true,
        listClass: 'x-combo-list-small'
    };
	Ext.define('Item', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},
            {name: 'name', type: 'string'},
            {name: 'version', type: 'string'},
            {name: 'unit', type: 'string'},
            {name: 'department', type: 'string'},
            {name: 'price', type: 'int'},
            {name: 'place', type: 'string'},
            {name: 'user', type: 'string'},
            {name: 'principal', type: 'string'},
            {name: 'usetime',  type: 'date'},
            {name: 'destroydate', type: 'date'},
            {name: 'destroyed', type: 'bool'},
            {name: 'destroyreason', type: 'string'},
            {name: 'conditions', type: 'string'},
            {name: 'comment', type: 'string'}
        ]
    });
	var store = Ext.create('Ext.data.Store', {
		autoLoad:true,
        autoDestroy: true,
        pageSize: 20,
        model: 'Item',
        proxy: {
            type: 'ajax',
            url: 'item/list',
            reader: {
                type: 'json',
                root: 'list',
                totalProperty: 'pager.recordCount'
            }
        },
        sorters: [{
            property: 'id',
            direction:'DESC'
        }],
        listeners:{
            load: function(store,operation,options){
                var rawData = store.proxy.reader.rawData;
                currentArguments = {
                    filter:rawData.filter,
                    sort:rawData.sort
                };
            }
        }
    });
    var cellEditing = Ext.create('Ext.grid.plugin.CellEditing', {
        clicksToEdit: 2
    });
    var filters = {
        ftype: 'filters',
        encode: true,
        local: false,
        menuFilterText : '筛选',
        filters: [{
            type: 'numeric',
            dataIndex: 'id'
        },{
            type: 'string',
            dataIndex: 'name'
        },{
            type: 'string',
            dataIndex: 'version'
        },{
            type: 'string',
            dataIndex: 'unit'
        },{
            type: 'string',
            dataIndex: 'user'
        },{
            type: 'string',
            dataIndex: 'principal'
        },{
            type: 'date',
            dataIndex: 'usetime'
        },{
            type: 'string',
            dataIndex: 'department'
        },{
            type: 'string',
            dataIndex: 'place'
        },{
            type: 'numeric',
            dataIndex: 'count'
        },{
            type: 'numeric',
            dataIndex: 'price'
        },{
            type: 'numeric',
            dataIndex: 'total'
        },{
            type: 'string',
            dataIndex: 'comment'
        },{
            type: 'string',
            dataIndex: 'destroyreason'
        },{
            type: 'string',
            dataIndex: 'conditions'
        }, {
            type: 'boolean',
            dataIndex: 'destroyed'
        }]
    };
    
    function renderDestroyed(value,p,r){
        if(value)
            return '已报废';
        else
            return '';
    }
    var grid = Ext.create('Ext.grid.Panel', {
        store: store,
        loadMask: true,
        multiSelect: true,
        features: [filters],
        columns: [{
                    id: 'id',
                    header: '序号',
                    dataIndex: 'id',
                    flex: 1
                }, {
                    header: '名称',
                    dataIndex: 'name',
                    width: 130,
                    field: {
                        allowBlank: false
                    }
                }, {
                    header: '规格型号',
                    dataIndex: 'version',
                    width: 70,
                    field: {
                        allowBlank: false
                    }
                }, {
                    header: '单位',
                    dataIndex: 'unit',
                    width: 70,
                    field: {
                        allowBlank: false
                    }
                },{
                    header: '部门',
                    dataIndex: 'department',
                    flex: 1,
                    field: departmentField1
                }, {
                    header: '价格',
                    dataIndex: 'price',
                    flex: 1,
                    align: 'right',
                    field: {
                        allowBlank: false
                    }
                }, {
                    header: '存放地点',
                    dataIndex: 'place',
                    flex: 1,
                    field: {
                        allowBlank: false
                    }
                }, {
                    header: '领用人',
                    dataIndex: 'user',
                    flex: 1,
                    field: {
                        allowBlank: false
                    }
                }, {
                    header: '负责人',
                    dataIndex: 'principal',
                    flex: 1,
                    field: {
                        allowBlank: false
                    }
                }, {
                    header: '领用时间',
                    xtype: 'datecolumn',
                    dataIndex: 'usetime',
                    flex: 1,
                    field: {
                    	xtype: 'datefield',
                    	format: 'Y-m-d',
                        allowBlank: false
                    }
                }, {
                    header: '报废日期',
                    xtype: 'datecolumn',
                    dataIndex: 'destroydate',
                    flex: 1,
                    field: {
                        xtype: 'datefield',
                        allowBlank: true,
                        format: 'Y-m-d'
                    }
                }, {
                    header: '是否报废',
                    dataIndex: 'destroyed',
                    renderer: renderDestroyed,
                    flex: 1,
                    editor: {
                        xtype: 'checkbox',
                        cls: 'x-grid-checkheader-editor'
                    }
                }, {
                    header: '报废原因',
                    dataIndex: 'destroyreason',
                    flex: 1,
                    field: {
                        allowBlank: false
                    }
                },{
                    header: '现场查看情况',
                    dataIndex: 'conditions',
                    flex: 1,
                    field: {
                        allowBlank: false
                    }
                },{
                    header: '备注',
                    dataIndex: 'comment',
                    flex: 1,
                    field: {
                        allowBlank: true
                    }
        }],
        renderTo:  Ext.getBody(),
        height:532,
        frame: true,
        plugins: [cellEditing],
        listeners:{
        	edit:function(e){
        		if(e.context.record.data.id === 0){
	        		Ext.Ajax.request({ 
						url: 'item/add', 
						params: e.context.record.data,
						method: 'post', 
						async :  false,
						success: function(result, request) { 
							if(result.responseText === 'true')
								store.load();
						}, 
						failure: function(result, request) { 
							Ext.MessageBox.alert('系统异常', '请求数据失败！'); 
						} 
					});
				}else{
					Ext.Ajax.request({ 
						url: 'item/update', 
						params: e.context.record.data,
						method: 'post', 
						async :  false,
						success: function(result, request) { 
							if(result.responseText === 'true')
								store.load();
						}, 
						failure: function(result, request) { 
							Ext.MessageBox.alert('系统异常', '请求数据失败！'); 
						} 
					});
				}
        	},
        	 selectionchange: function(view, records) {
                grid.down('#removeItem').setDisabled(!records.length);
                grid.down('#useItem').setDisabled(!records.length);
                grid.down('#usePrintItem').setDisabled(!records.length);
                grid.down('#destoryedItem').setDisabled(!records.length);
                grid.down('#destoryedPrintItem').setDisabled(!records.length);
                grid.down('#insertItem').setDisabled(!records.length);
                grid.down('#tagPrintItem').setDisabled(records.length != 1);
            }
        },
        tbar: [{
            text: '添加',
            iconCls: 'item-add',
            handler : function() {
                cellEditing.cancelEdit();

                // Create a record instance through the ModelManager
                var r = Ext.ModelManager.create({
                	id:0,
                    comment: "",
					department: "办公室",
					name: "名称",
					price: 0,
					version: "规格",
                    place: "存放地点",
                    user: "领用人",
                    principal: '负责人',
                    usetime:new Date(),
                    destroyed:false
                }, 'Item');

                store.insert(0, r);
                cellEditing.startEditByPosition({row: 0, column: 1});
            }
        }, {
            itemId: 'removeItem',
            text: '删除',
            iconCls: 'item-delete',
            handler: function() {
                var sm = grid.getSelectionModel();
                cellEditing.cancelEdit();
                var items= [];
                Ext.Array.each(sm.selected.items, function(item) {
                    items.push(item.data.id);
                });
                Ext.Ajax.request({ 
                        url: 'item/delete', 
                        params: {items:items.join(",")},
                        method: 'post', 
                        async :  false,
                        success: function(result, request) { 
                            if(result.responseText === 'true')
                                store.load(); 
                        }, 
                        failure: function(result, request) { 
                            Ext.MessageBox.alert('系统异常', '请求数据失败！'); 
                        } 
                });
            },
            disabled: true
        },'-', {
            itemId: 'batchItem',
            text: '批量入库',
            iconCls: 'item-insert',
            handler: function() {
                cellEditing.cancelEdit();
                showBatchForm();
            }
        }, {
            itemId: 'insertItem',
            text: '打印入库单',
            iconCls: 'item-insertprint',
            handler: function() {
                var items = getSelectedItem();
                var insertPrintItemWin = new Ext.Window({
                     title:'打印入库单',
                     id:'insertPrintItemWin',
                     width:980,
                     height:480,
                     closable:true,
                     resizable:true,
                     minimizable:true,
                     maximizable:true,
                     html: "<iframe name='insertPrintItem' src='item/insertprint?items=" + items.join(",") + "' style='width:100%; height:100%;'></iframe>",
                     tbar: [{
                        text: '打印',
                        xtype: 'button',
                        iconCls: 'employee-add',
                        handler : function() {
                            printThis('insertPrintItem');
                        }
                    }]
                    
                });

                insertPrintItemWin.show();
                //window.frames[ 'usePrintItem '].print();
            },
            disabled: true
        },'-', {
        	itemId: 'useItem',
            text: '出库',
            iconCls: 'item-use',
            handler: function() {
                
                showUseForm();
            },
            disabled: true
        }, {
            itemId: 'usePrintItem',
            text: '打印出库单',
            iconCls: 'item-useprint',
            handler: function() {
                var items = getSelectedItem();
                var usePrintItemWin = new Ext.Window({
                     title:'打印出库单',
                     id:'usePrintItemWin',
                     width:980,
                     height:480,
                     closable:true,
                     resizable:true,
                     minimizable:true,
                     maximizable:true,
                     html: "<iframe name='usePrintItem' src='item/useprint?items=" + items.join(",") + "' style='width:100%; height:100%;'></iframe>",
                     tbar: [{
                        text: '打印',
                        xtype: 'button',
                        iconCls: 'employee-add',
                        handler : function() {
                            printThis('usePrintItem');
                        }
                    }]
                    
                });

                usePrintItemWin.show();
                //window.frames[ 'usePrintItem '].print();
            },
            disabled: true
        },'-', {
            itemId: 'destoryedItem',
            text: '报废',
            iconCls: 'item-destoryed',
            handler: function() {
                showDestoryedForm();
            },
            disabled: true
        }, {
            itemId: 'destoryedPrintItem',
            text: '打印核销审批单',
            iconCls: 'item-destoryedprint',
            handler: function() {
                var items = getSelectedItem();
                var destoryedPrintWin = new Ext.Window({
                     title:'打印核销审批单',
                     id:'destoryedPrintWin',
                     width:980,
                     height:480,
                     closable:true,
                     resizable:true,
                     minimizable:true,
                     maximizable:true,
                     html: "<iframe name='destoryedPrintItem' src='item/destoryedprint?items=" + items.join(",") + "' style='width:100%; height:100%;'></iframe>",
                     tbar: [{
                        text: '打印',
                        xtype: 'button',
                        iconCls: 'employee-add',
                        handler : function() {
                            printThis('destoryedPrintItem');
                        }
                    }]
                    
                });

                destoryedPrintWin.show();
            },
            disabled: true
        },'-', {
            itemId: 'tagPrintItem',
            text: '打印标签',
            iconCls: 'item-destoryedprint',
            handler: function() {
                var items = getSelectedItem();
                var tagPrintWin = new Ext.Window({
                     title:'打印标签',
                     id:'tagPrintWin',
                     width:280,
                     height:164,
                     closable:true,
                     resizable:true,
                     minimizable:true,
                     maximizable:true,
                     html: "<iframe name='tagPrintItem' src='item/tagprint?item=" + items[0] + "' style='width:100%; height:100%;'></iframe>",
                     tbar: [{
                        text: '打印',
                        xtype: 'button',
                        iconCls: 'employee-add',
                        handler : function() {
                            printThis('tagPrintItem');
                        }
                    }]
                    
                });

                tagPrintWin.show();
            },
            disabled: true
        },'-',{
            itemId: 'exportItem',
            text: '导出',
            iconCls: 'item-export',
            handler: function() {
                window.location = "item/export?filter=" + Ext.JSON.encode(currentArguments.filter) + "&sort=" + Ext.JSON.encode(currentArguments.sort);
            }
        },'->',{
            itemId: 'helptem',
            text: '帮助',
            iconCls: 'item-help',
            handler: function() {
                Ext.MessageBox.alert('帮助', '<li>1.低值易耗品数据管理的原则 “数据集中管理，票据按需打印”</li>'
                                        + '<li>2.选择多项 Ctrl + 鼠标单击 或 Shift + 鼠标单击；修改某数据 鼠标双击</li>'
                                        + '<li>3.在打印出入库及核销票据时，相同的种类(批次)的低值易耗品将进行合并，合并的规则是“名称，规格，价格皆相同”</li>'
                                        + '<li>4.打印票据时请注意纸质票据中项目(指合并后)的上限，出入库票据为10项，核销票据为8项</li>'
                                );
            }
        }],
        bbar: Ext.create('Ext.PagingToolbar', {
            store: store,
            displayInfo: true,
            displayMsg: '当前显示 {0} - {1} of {2}',
            emptyMsg: "当前没有易耗品"
        })
    });
    store.loadPage(1);
    grid.headerCt.on('sortchange', function(){
        store.load();
    });
    window.printThis = function (frameName){
        window.frames[frameName].focus();
        window.frames[frameName].print();
    }
    function getSelectedItem(){
        var sm = grid.getSelectionModel();
        var items= [];
        Ext.Array.each(sm.selected.items, function(item) {
                        items.push(item.data.id);
        });
        return items;
    }
    function showUseForm() {
        var items = getSelectedItem();
        if (!useWin) {
            useForm = Ext.widget('form', {
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                border: false,
                bodyPadding: 10,

                fieldDefaults: {
                    labelAlign: 'top',
                    labelWidth: 100,
                    labelStyle: 'font-weight:bold'
                },
                defaults: {
                    margins: '0 0 10 0'
                },

                items: [ {
                    xtype: 'textfield',
                    fieldLabel: '低易品',
                    name: 'items',
                    allowBlank: false,
                    value:items
                }, 
                departmentField, 
                {
                    xtype: 'textfield',
                    fieldLabel: '领用人',
                    name: 'user',
                    allowBlank: false
                }, {
                    xtype: 'textfield',
                    fieldLabel: '负责人',
                    name: 'principal',
                    allowBlank: false
                },{
                    xtype: 'textfield',
                    fieldLabel: '存放地点',
                    name: 'place',
                    allowBlank: false
                }, {
                    fieldLabel: '领取时间',
                    format: 'Y-m-d',
                    value: new Date(),
                    name: 'usetime',
                    xtype: 'datefield'
                },{
                    xtype: 'textareafield',
                    name: 'comment',
                    fieldLabel: '备注',
                    labelAlign: 'top',
                    flex: 1,
                    margins: '0'
                }],

                buttons: [{
                    text: '取消',
                    handler: function() {
                        this.up('form').getForm().reset();
                        this.up('window').hide();
                    }
                }, {
                    text: '提交',
                    handler: function() {
                        if (this.up('form').getForm().isValid()) {
                            // In a real application, this would submit the form to the configured url
                            // this.up('form').getForm().submit();
                            Ext.Ajax.request({ 
                                    url: 'item/use', 
                                    params: this.up('form').getForm().getValues(),
                                    method: 'post', 
                                    async :  false,
                                    success: function(result, request) { 
                                        if(result.responseText === 'true')
                                            store.load(); 
                                    }, 
                                    failure: function(result, request) { 
                                        Ext.MessageBox.alert('系统异常', '请求数据失败！'); 
                                    } 
                            });
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                        }
                    }
                }]
            });

            useWin = Ext.widget('window', {
                title: '领用',
                closeAction: 'hide',
                width: 400,
                height: 500,
                minHeight: 500,
                layout: 'fit',
                resizable: true,
                modal: true,
                items: useForm
            });
        }
        useForm.getForm().findField('items').setValue(items);
        useWin.show();
    }

    function showDestoryedForm() {
        var items = getSelectedItem();
        if (!destoryedWin) {
            destoryedForm = Ext.widget('form', {
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                border: false,
                bodyPadding: 10,

                fieldDefaults: {
                    labelAlign: 'top',
                    labelWidth: 100,
                    labelStyle: 'font-weight:bold'
                },
                defaults: {
                    margins: '0 0 10 0'
                },

                items: [ {
                    xtype: 'textfield',
                    fieldLabel: '低易品',
                    name: 'items',
                    allowBlank: false,
                    value:items
                }, {
                    xtype: 'textfield',
                    fieldLabel: '报废原因',
                    name: 'destroyreason',
                    allowBlank: false
                }, {
                    xtype: 'textfield',
                    fieldLabel: '现场查看情况',
                    name: 'conditions',
                    allowBlank: false
                }, {
                    fieldLabel: '报销时间',
                    format: 'Y-m-d',
                    value: new Date(),
                    name: 'destroydate',
                    xtype: 'datefield'
                }],

                buttons: [{
                    text: '取消',
                    handler: function() {
                        this.up('form').getForm().reset();
                        this.up('window').hide();
                    }
                }, {
                    text: '提交',
                    handler: function() {
                        if (this.up('form').getForm().isValid()) {
                            Ext.Ajax.request({ 
                                    url: 'item/destoryed', 
                                    params: this.up('form').getForm().getValues(),
                                    method: 'post', 
                                    async :  false,
                                    success: function(result, request) { 
                                        if(result.responseText === 'true')
                                            store.load(); 
                                    }, 
                                    failure: function(result, request) { 
                                        Ext.MessageBox.alert('系统异常', '请求数据失败！'); 
                                    } 
                            });
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                        }
                    }
                }]
            });

            destoryedWin = Ext.widget('window', {
                title: '报废',
                closeAction: 'hide',
                width: 400,
                height: 300,
                minHeight: 300,
                layout: 'fit',
                resizable: true,
                modal: true,
                items: destoryedForm
            });
        }
        destoryedForm.getForm().findField('items').setValue(items);
        destoryedWin.show();
    }
    function showBatchForm() {
        var items = getSelectedItem();
        if (!batchWin) {
            batchForm = Ext.widget('form', {
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                border: false,
                bodyPadding: 10,

                fieldDefaults: {
                    labelAlign: 'top',
                    labelWidth: 100,
                    labelStyle: 'font-weight:bold'
                },
                defaults: {
                    margins: '0 0 10 0'
                },

                items: [ 
                {
                    xtype: 'textfield',
                    fieldLabel: '名称',
                    name: 'name',
                    allowBlank: false
                }, {
                    xtype: 'textfield',
                    fieldLabel: '规格型号',
                    name: 'version',
                    allowBlank: false
                },{
                    xtype: 'numberfield',
                    fieldLabel: '数量',
                    name: 'count',
                    allowBlank: false
                },{
                    xtype: 'numberfield',
                    fieldLabel: '价格',
                    name: 'price',
                    allowBlank: false
                },{
                    xtype: 'textareafield',
                    name: 'comment',
                    fieldLabel: '备注',
                    labelAlign: 'top',
                    flex: 1,
                    margins: '0'
                }],

                buttons: [{
                    text: '取消',
                    handler: function() {
                        this.up('form').getForm().reset();
                        this.up('window').hide();
                    }
                }, {
                    text: '提交',
                    handler: function() {
                        if (this.up('form').getForm().isValid()) {
                            // In a real application, this would submit the form to the configured url
                            // this.up('form').getForm().submit();
                            Ext.Ajax.request({ 
                                    url: 'item/batchadd', 
                                    params: this.up('form').getForm().getValues(),
                                    method: 'post', 
                                    async :  false,
                                    success: function(result, request) { 
                                        if(result.responseText === 'true')
                                            store.load(); 
                                    }, 
                                    failure: function(result, request) { 
                                        Ext.MessageBox.alert('系统异常', '请求数据失败！'); 
                                    } 
                            });
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                        }
                    }
                }]
            });

            batchWin = Ext.widget('window', {
                title: '批量入库',
                closeAction: 'hide',
                width: 400,
                height: 400,
                minHeight: 400,
                layout: 'fit',
                resizable: true,
                modal: true,
                items: batchForm
            });
        }
        batchWin.show();
    }
});

</script>
</head>
<body>
<h1 style="font-weight:normal;color:999;">低值易耗品管理系统</h1>
 <div id="editor-grid"></div>

</body>
</html>