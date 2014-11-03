/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function requestServices(query) {
    var url = 'http://localhost:8080/factoryEcomation_Services/webresources/entities.services/find/' + query;
    var data = {};
    $.support.cors = true;
    $.ajax({
        type: 'GET',
        url: url,
        async: true,
        jsonpCallback: 'jsonCallback',
        contentType: "application/json",
        dataType: 'json',
        //crossDomain : true,
        success: function(json) {
            fillServiceTable(json);
        },
        error: function(e) {
            console.log(e);
        },
        onload: function(json) {
            //console.log(json);
        }
    });
}
