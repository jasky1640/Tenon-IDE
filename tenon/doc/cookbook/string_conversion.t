module string_conversion

  function void main()
    ! numtostr
    var string str1 = numtostr(0.38125, 3);
    tpwrite(str1);

    ! strtoval
    var pos pos1;
    tpwrite_bool(strtoval("{2, 2, 2}", pos1));
    tpwrite_pos(pos1);

    ! strmap
    tpwrite(strmap("Robotics", "aeiou", "AEIOU"));
    tpwrite(strmap("Robotics", STR_LOWER, STR_UPPER));

    ! strtobyte
    tpwrite_num(strtobyte("10"));
    tpwrite_num(strtobyte("AE", Hex = 1));
    tpwrite_num(strtobyte("176", Okt = 1));
    tpwrite_num(strtobyte("00001010", Bin = 1));
    tpwrite_num(strtobyte("A", Char = 1));

    ! bytetostr
    tpwrite(bytetostr(122));
    tpwrite(bytetostr(122, Hex = 1));
    tpwrite(bytetostr(122, Okt = 1));
    tpwrite(bytetostr(122, Bin = 1));
    tpwrite(bytetostr(122, Char = 1));

    ! dectohex
    tpwrite(dectohex("88888"));

    ! hextodec
    tpwrite(hextodec("88888"));
  end
end
