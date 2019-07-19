module string_conversion

  function void main()
    ! numtostr
    var string str1 = numtostr(0.38125, 3);
    twrite(str1);

    ! strtoval
    var pos pos1;
    twrite_bool(strtoval("{2, 2, 2}", pos1));
    twrite_pos(pos1);

    ! strmap
    twrite(strmap("Robotics", "aeiou", "AEIOU"));
    twrite(strmap("Robotics", STR_LOWER, STR_UPPER));

    ! strtobyte
    twrite_num(strtobyte("10"));
    twrite_num(strtobyte("AE", Hex = true));
    twrite_num(strtobyte("176", Okt = true));
    twrite_num(strtobyte("00001010", Bin = true));
    twrite_num(strtobyte("A", Char = true));

    ! bytetostr
    twrite(bytetostr(122));
    twrite(bytetostr(122, Hex = true));
    twrite(bytetostr(122, Okt = true));
    twrite(bytetostr(122, Bin = true));
    twrite(bytetostr(122, Char = true));

    ! dectohex
    twrite(dectohex("88888"));

    ! hextodec
    twrite(hextodec("88888"));
  end
end
