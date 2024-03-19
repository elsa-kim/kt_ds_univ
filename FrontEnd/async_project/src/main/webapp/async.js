$().ready(function () {
  // // 비동기 통신 코드
  // // $.get("url", function(응답데이터(servlet이 전달해준 데이터)){});
  // $.get("/async_project/async", function(response){
  // 	console.log("response", response); //text
  //
  // 	var object = JSON.parse(response); // JSON 데이터를 객체리터럴로 변환
  // 	console.log(object);
  //
  // 	// $(".async-data").text(response);
  // 	$(".async-data").text("Name : " + object.name);
  // });
  // // 여기에 response 작성하면 undefined
  // // $(".async-data").text("Load data...");

  $(".github-user").on("click", function () {
    $(".ajax-data").text("Load data...");

    $.get("https://api.github.com/users", function (response) {
      $(".ajax-data").text("");
      var userList = $("<ul></ul>");

      //   response.foreach(function (user) {
      // 	userImage.on("click", function () {
      //    	//   var nowUrl = location.href; // 현재 url
      // 		// window.location.href = ""; //window 생략가능, 해당 url로 이동
      // 		location.href = user.html_url;
      //	 });
      // 	userName.on("click", function () {
      // 		location.href = user.html_url;
      // 	});

      //	userDivInItem.append(userImage);
      // 	userDivInItem.append(userName);
      // 	userItem.append(userDivInItem);
      // 	userList.append(userItem);
      // 	})

      //     $(".ajax-data").append(userList);

      // ECMAScript 2015 Spec;
      // for each
      for (const user of response) {
        // var user = response[i];

        var userItem = $("<li></li>");
        var userDivInItem = $("<div></div>");
        var userImage = $("<img src='" + user.avatar_url + "'/>");
        var userName = $("<p></p>");
        userName.text(user.login);

        userImage.on("click", function () {
          //   var nowUrl = location.href; // 현재 url
          // window.location.href = ""; //window 생략가능, 해당 url로 이동
          location.href = user.html_url;
        });
        userName.on("click", function () {
          location.href = user.html_url;
        });

        userDivInItem.append(userImage);
        userDivInItem.append(userName);
        userItem.append(userDivInItem);
        userList.append(userItem);
      }

      $(".ajax-data").append(userList);
    });
  });

  $(".jsonplaceholder-post").on("click", function () {
    $(".ajax-data").text("Load data...");
    $.get("https://jsonplaceholder.typicode.com/posts", function (response) {
      $(".ajax-data").text("");
      // response.forEach(function (post) {
      for (const post of response) {
        (function () {
          var postList = $("<div></div>");

          var postTitle = $("<p></p>");
          postTitle.text(post.title);

          var postId = $("<p></p>");
          postId.text(" / ");

          var userId = $("<span></span>");
          userId.text("userId : " + post.userId);
          postId.prepend(userId);

          var id = $("<span></span>");
          id.text("id : " + post.id);
          postId.append(id);

          var postBody = $("<p></p>");
          postBody.text(post.body);
          postBody.addClass("hide");

          postTitle.on("click", function () {
            if (postBody.is(".hide")) {
              postBody.removeClass("hide");
            } else {
              postBody.addClass("hide");
            }
          });
          postId.on("click", function () {
            if (postBody.is(".hide")) {
              postBody.removeClass("hide");
            } else {
              postBody.addClass("hide");
            }
          });

          postList.append(postTitle);
          postList.append(postId);
          postList.append(postBody);

          $(".ajax-data").append(postList);
        })();
      }
      // });
    });
  });
});
