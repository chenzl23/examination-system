$(function(){

    //defaults
    $.fn.editable.defaults.url = '/post';

    //editables
    $('.username').editable({
        url: '/post',
        type: 'text',
        pk: 1,
        name: 'use1rname',
        title: 'Enter username'
    });

    $('.name').editable({
        url: '/post',
        type: 'text',
        pk: 1,
        name: 'use1rname',
        title: 'Enter username'
    });

});