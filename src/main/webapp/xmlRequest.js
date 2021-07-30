$(document).ready(function () {
  console.log("document ready");
  $.getJSON("generatedData.json", function (data) {
    var filtered = $.grep(data, function (elem, index) {
      return elem.project == "casestudy";
    });
    $.each(filtered, function (id, item) {
      $(
        "<li id='" + id + "'>" + item.contentString + " " + "</li>"
      ).appendTo("#tasks");
    });
  });
});
