module string_comparison_searching

  function void main()
    var string str1 = "hello";
    var string str2 = "world";
    var string str3 = str1;

    ! string comparison
    if (str1 == str3) then
      tpwrite("The str1 is equal to the str3.");
    end
    if (str1 <> str2) then
      tpwrite("The str1 is not equal to the str2.");
    end

    ! string searching
    ! strmemb
    tpwrite_bool(strmemb(str1, 2, str2));
    tpwrite_bool(strmemb(str1, 3, str2));
    tpwrite_bool(strmemb(str1, 5, str2));
    ! strfind
    tpwrite_num(strfind("IRB 6400", 1, STR_DIGIT));
    tpwrite_num(strfind("IRB 6400", 1, STR_WHITE));
    tpwrite_num(strfind("Test", 1, str1));
    tpwrite_num(strfind("Test", 1, str1, NotInSet = 1));
    !strmatch
    tpwrite_num(strmatch("robot", 1, "bo"));
    tpwrite_num(strmatch("robot", 1, str1));
    !strorder
    tpwrite_bool(strorder("FIRST", "SECOND", STR_UPPER));
    tpwrite_bool(strorder("FIRST", "FIRSTB", STR_UPPER));
    tpwrite_bool(strorder("FIRSTB", "FIRST", STR_UPPER));
  end
end
