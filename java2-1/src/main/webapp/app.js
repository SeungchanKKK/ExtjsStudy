/*
 * This file launches the application by asking Ext JS to create
 * and launch() the Application class.
 */
Ext.application({
    extend: 'Study21.Application',

    name: 'Study21',

    requires: [
        // This will automatically load all classes in the Study21 namespace
        // so that application classes do not need to require each other.
        'Study21.*'
    ],

    // The name of the initial view to create.
    // mainView: 'Study21.view.main.Main'
});
