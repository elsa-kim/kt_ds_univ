$().ready(function(){
    var alertDialog = $(".alert-dialog");

    // 배열.
    if (alertDialog && alertDialog.length > 0) {
      alertDialog[0].showModal();
    }
  
    $("#email").on("keyup", function () {
      // 서버에게 사용할 수 있는 이메일인지 확인 받는다.
      $.get(
        "/ajax/member/regist/available",
        { email: $(this).val() },
        function (response) {
          var available = response.available;
          if (available) {
            $("#email").addClass("available");
            $("#email").removeClass("unusable");
            $("#btn-regist").removeAttr("disabled");
          } else {
            $("#email").addClass("unusable");
            $("#email").removeClass("available");
            $("#btn-regist").attr("disabled", "disabled");
          }
        }
      );
    });

    $("#btn-login").on("click", function(){

        $(".error").remove();
        $("div.grid").removeAttr("style");

        $.post("/ajax/member/login", {
            email:$("#email").val(),
            password:$("#password").val(),
            nextUrl: $("#next").val()
        }, function(response){
            
            var errors = response.data.errors
            var errorMessage = response.data.errorMessage
            var next = response.data.next

            console.log(response)
            // 파라미터 유효성 검사에 실패했을 경우
            if(errors){
                console.log(errors)

                // for-in
                // 배열 => 인덱스 할당
                // 객체리터럴에 => 키 할당
                for(var key in errors){
                    // console.log(key)
                    // console.log(errors.key) // errors 안의 key라는 프로퍼티의 값을 가져오라는 것
                    // console.log(errors[key]) // 이렇게 가져와야 함
                    var errorDiv = $("<div></div>")
                    errorDiv.addClass("error")
                    // <div class="error"></div>

                    
                    var values = errors[key]
                    for (var i in values){
                        var errorValue = values[i]
                        console.log(errorValue)

                        var error = $("<div></div>")
                        error.text(errorValue);

                        errorDiv.append(error);
                    }

                    $("input[name="+key+"]").after(errorDiv);
                }

            
                

                if(errors.email && errors.password){
                    // 클래스 지정
                    // $("div.grid").addClass("validator-fail-both")
                    var emailFailCount = errors.email.length;
                    var passwordFailCount = errors.password.length;
                    
                    // Inline-Style 지정
                    $("div.grid").css({
                        "grid-template-rows":"28px "+(21*emailFailCount)+"px 28px "+(21*passwordFailCount)+"px 1fr",
                    });
                    
                    
                }else if(errors.email){
                    // $("div.grid").addClass("validator-fail-email")
                    var emailFailCount = errors.email.length;

                    $("div.grid").css({
                        "grid-template-rows":"28px "+(21*emailFailCount)+"px 28px  1fr",
                    });
                }else if(errors.password){
                    // $("div.grid").addClass("validator-fail-password")
                    var passwordFailCount = errors.password.length;
                    $("div.grid").css({
                        "grid-template-rows":"28px 28px "+(21*passwordFailCount)+"px 1fr",
                    });
                }
            }
            
            // 파라미터 유효성 검사는 패스
            // 이메일이나 패스워드가 잘못된 경우
            if(errorMessage){
                console.log(errorMessage)
                var errorDiv = $("<div></div>");
                errorDiv.addClass("error");
                errorDiv.text(errorMessage);

                $("#loginForm").after(errorDiv);
            }

            // 정상적으로 로그인에 성공한 경우
            if(next){
                location.href = next
            }


            /*
            response = {
                data: {
                    errors: {
                        "email": []
                    }, 
                    errorMessage: "",
                    next: "/board/search"
                }
            }
            */
        });
    })
})