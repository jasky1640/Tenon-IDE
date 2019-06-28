module string_basicOp

  function void main()
    var string str1 = "hello";

    ! assign a value(copy a string)
    var string str2;
    str2 = str1;
    tpwrite(str2);

    ! string concatenation
    var string str3 = " ";
    var string str4 = "world";
    str1 = str2 + str3 + str4;
    tpwrite(str1);

    ! get the legth of string
    var num length = strlen(str1);
    tpwrite_num(length);

    ! get the part of string
    var string str5 = strpart(str1, 4, 4);
    tpwrite(str5);
  end
end
