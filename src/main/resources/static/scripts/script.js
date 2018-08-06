var ourRequest = new XMLHttpRequest();
ourRequest.open('GET',"/api/article/all");
ourRequest.onload = function(){
    var ourData = JSON.parse(ourRequest.responseText);
    for (i = 0; i < ourData.length; i++) {
        renderHTML(ourData[i]);
    }
}
ourRequest.send();

function renderHTML(data) {
    var htmlString = "";

      htmlString += "<article class=\"article-conteiner\"> <img class=\"article-image\" src='"+data[5]+"'></img>";
      htmlString += " <h3 class=\"caption\">" + data[1] + "</h3>";
      htmlString += "<h4 class=\"topic\">"+data[2]+"</h4>";
      htmlString += "<p class=\"article-paragraphe\">"+data[4]+"</p>";
      htmlString += "<h4 class=\"author\">"+data[3]+"</h4></article>";

      $( "#main" ).append( $( htmlString ) );

}