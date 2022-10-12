/**
 * Single radio field. Similar to checkbox, but automatically handles making sure only one radio
 * is checked at a time within a group of radios with the same name.
 *
 * # Labeling
 *
 * In addition to the {@link Ext.form.Labelable standard field labeling options}, radio buttons
 * may be given an optional {@link #boxLabel} which will be displayed immediately to the right
 * of the input. Also see {@link Ext.form.RadioGroup} for a convenient method of grouping related
 * radio buttons.
 *
 * # Values
 *
 * The main value of a Radio field is a boolean, indicating whether or not the radio is checked.
 *
 * The following values will check the radio:
 *
 * - `true`
 * - `'true'`
 * - `'1'`
 * - `'on'`
 *
 * Any other value will uncheck it.
 *
 * In addition to the main boolean value, you may also specify a separate {@link #inputValue}.
 * This will be sent as the parameter value when the form is
 * {@link Ext.form.Basic#submit submitted}. You will want to set this value if you have multiple
 * radio buttons with the same {@link #name}, as is almost always the case.
 *
 * # Example usage
 *
 *     @example
 *     Ext.create('Ext.form.Panel', {
 *         title      : 'Order Form',
 *         width      : 300,
 *         bodyPadding: 10,
 *         renderTo   : Ext.getBody(),
 *         items: [
 *             {
 *                 xtype      : 'fieldcontainer',
 *                 fieldLabel : 'Size',
 *                 defaultType: 'radiofield',
 *                 defaults: {
 *                     flex: 1
 *                 },
 *                 layout: 'hbox',
 *                 items: [
 *                     {
 *                         boxLabel  : 'M',
 *                         name      : 'size',
 *                         inputValue: 'm',
 *                         id        : 'radio1'
 *                     }, {
 *                         boxLabel  : 'L',
 *                         name      : 'size',
 *                         inputValue: 'l',
 *                         id        : 'radio2'
 *                     }, {
 *                         boxLabel  : 'XL',
 *                         name      : 'size',
 *                         inputValue: 'xl',
 *                         id        : 'radio3'
 *                     }
 *                 ]
 *             },
 *             {
 *                 xtype      : 'fieldcontainer',
 *                 fieldLabel : 'Color',
 *                 defaultType: 'radiofield',
 *                 defaults: {
 *                     flex: 1
 *                 },
 *                 layout: 'hbox',
 *                 items: [
 *                     {
 *                         boxLabel  : 'Blue',
 *                         name      : 'color',
 *                         inputValue: 'blue',
 *                         id        : 'radio4'
 *                     }, {
 *                         boxLabel  : 'Grey',
 *                         name      : 'color',
 *                         inputValue: 'grey',
 *                         id        : 'radio5'
 *                     }, {
 *                         boxLabel  : 'Black',
 *                         name      : 'color',
 *                         inputValue: 'black',
 *                         id        : 'radio6'
 *                     }
 *                 ]
 *             }
 *         ],
 *         bbar: [
 *             {
 *                 text: 'Smaller Size',
 *                 handler: function() {
 *                     var radio1 = Ext.getCmp('radio1'),
 *                         radio2 = Ext.getCmp('radio2'),
 *                         radio3 = Ext.getCmp('radio3');
 *
 *                     //if L is selected, change to M
 *                     if (radio2.getValue()) {
 *                         radio1.setValue(true);
 *                         return;
 *                     }
 *
 *                     //if XL is selected, change to L
 *                     if (radio3.getValue()) {
 *                         radio2.setValue(true);
 *                         return;
 *                     }
 *
 *                     //if nothing is set, set size to S
 *                     radio1.setValue(true);
 *                 }
 *             },
 *             {
 *                 text: 'Larger Size',
 *                 handler: function() {
 *                     var radio1 = Ext.getCmp('radio1'),
 *                         radio2 = Ext.getCmp('radio2'),
 *                         radio3 = Ext.getCmp('radio3');
 *
 *                     //if M is selected, change to L
 *                     if (radio1.getValue()) {
 *                         radio2.setValue(true);
 *                         return;
 *                     }
 *
 *                     //if L is selected, change to XL
 *                     if (radio2.getValue()) {
 *                         radio3.setValue(true);
 *                         return;
 *                     }
 *
 *                     //if nothing is set, set size to XL
 *                     radio3.setValue(true);
 *                 }
 *             },
 *             '-',
 *             {
 *                 text: 'Select color',
 *                 menu: {
 *                     indent: false,
 *                     items: [
 *                         {
 *                             text: 'Blue',
 *                             handler: function() {
 *                                 var radio = Ext.getCmp('radio4');
 *                                 radio.setValue(true);
 *                             }
 *                         },
 *                         {
 *                             text: 'Grey',
 *                             handler: function() {
 *                                 var radio = Ext.getCmp('radio5');
 *                                 radio.setValue(true);
 *                             }
 *                         },
 *                         {
 *                             text: 'Black',
 *                             handler: function() {
 *                                 var radio = Ext.getCmp('radio6');
 *                                 radio.setValue(true);
 *                             }
 *                         }
 *                     ]
 *                 }
 *             }
 *         ]
 *     });
 */
Ext.define('Ext.form.field.Radio', {
    extend: 'Ext.form.field.Checkbox',
    alias: ['widget.radiofield', 'widget.radio'],
    alternateClassName: 'Ext.form.Radio',

    requires: ['Ext.form.RadioManager'],

    /**
     * @property {Boolean} isRadio
     * The value `true` to identify an object as an instance of this or derived class.
     * @readonly
     */
    isRadio: true,

    /**
     * @cfg {String} uncheckedValue
     * @private
     */

    inputType: 'radio',

    formId: null,

    /**
     * @cfg {Boolean/String/Number} [modelValue=inputValue]
     * The value to use for {@link #getModelData} when checked. Uses the {@link #inputValue}
     * by default.
     *
     * @since 6.2.1
     */
    modelValue: undefined,

    /**
     * @cfg {Boolean/String/Number} modelValueUnchecked
     * The value to use for {@link #getModelData} when unchecked.
     *
     * @since 6.2.1
     */
    modelValueUnchecked: null,

    initComponent: function() {
        var me = this;

        if (me.modelValue === undefined) {
            me.modelValue = me.inputValue;
        }

        me.callParent();
    },

    /**
     * If this radio is part of a group, it will return the selected value
     * @return {String}
     */
    getGroupValue: function() {
        var selected = this.getManager().getChecked(this.name, this.getFormId());

        return selected ? selected.inputValue : null;
    },

    onRemoved: function() {
        this.callParent(arguments);
        this.formId = null;
    },

    /**
     * Sets either the checked/unchecked status of this Radio, or, if a string value is passed,
     * checks a sibling Radio of the same name whose value is the value specified.
     * @param {String/Boolean} value Checked value, or the value of the sibling radio button
     * to check.
     * @return {Ext.form.field.Radio} this
     */
    setValue: function(value) {
        var me = this,
            active;

        if (Ext.isBoolean(value)) {
            me.callParent(arguments);
        }
        else {
            active = me.getManager().getWithValue(me.name, value, me.getFormId()).getAt(0);

            if (active) {
                active.setValue(true);
            }
        }

        return me;
    },

    /**
     * Returns the submit value for the checkbox which can be used when submitting forms.
     * @return {Boolean/Object} True if checked, null if not.
     */
    getSubmitValue: function() {
        return this.checked ? this.inputValue : null;
    },

    onChange: function(newVal, oldVal) {
        var me = this,
            ownerCt = me.ownerCt,
            r, rLen, radio, radios;

        me.callParent(arguments);

        // Standard compliant browsers only fire change event on the radio button
        // that became checked so we need to update other buttons in the group.
        // See also IE8 override.
        if (!me.$groupChange) {
            if (newVal) {
                radios = me.getManager().getByName(me.name, me.getFormId()).items;
                rLen = radios.length;

                for (r = 0; r < rLen; r++) {
                    radio = radios[r];

                    if (radio !== me) {
                        radio.updateValueFromDom();
                    }
                }
            }

            if (ownerCt && ownerCt.isRadioGroup && ownerCt.simpleValue) {
                ownerCt.checkChange();
            }
        }
    },

    getManager: function() {
        return Ext.form.RadioManager;
    }
});
