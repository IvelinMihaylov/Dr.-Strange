var ourRequest = new XMLHttpRequest();
ourRequest.open('GET',"/api/article/all");
ourRequest.onload = function(){
    var ourData = JSON.parse(ourRequest.responseText);
    for (i = 0; i < ourData.length; i++) {
        renderHTML(ourData[i]);
        console.log(ourData[i]);
    }
}
ourRequest.send();

function renderHTML(data) {
    var htmlString = "";
    console.log(data[0]);
    console.log(data[1]);
    console.log(data[2]);
    console.log(data[3]);
    console.log(data[4]);
    console.log(data[5]);

      htmlString += "<img class=\"article-image\" src='"+data[5]+"'></img>";
      htmlString += "<article class=\"article-conteiner\"> <h3 class=\"caption\">" + data[1] + "</h3>";
      htmlString += "<h4 class=\"topic\">"+data[2]+"</h4>";
      htmlString += "<p class=\"article-paragraphe\">"+data[4]+"</p>";
      htmlString += "<h4 class=\"author\">"+data[3]+"</h4>";

      $( "#main" ).append( $( htmlString ) );

    // animalContainer.insertAdjacentHTML('#main', htmlString);
}