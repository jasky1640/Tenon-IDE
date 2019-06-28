module array

  const num arr_length = 10;

  function void main()
    var num a{arr_length}; 
    var string b{arr_length};
    var pos c{arr_length};
    var num d{arr_length}; 
    var string e{arr_length};
    var pos f{arr_length};

    ! init the arrays with the constants
    a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    b = ["one", "two", "three", "four", "five", "six", "seven",
         "eight", "nine", "ten"];
    c = [[0, 0, 1], [0, 0, 2], [0, 0, 3], [0, 0, 4], [0, 0, 5],
         [0, 0, 6], [0, 0, 7], [0, 0, 8], [0, 0, 9], [0, 0, 10]];

    ! traverse the arrays
    for i from 1 to arr_length do
      tpwrite_num(a{i});
    end

    for i from 1 to arr_length do
      tpwrite_string(b{i});
    end

    for i from 1 to arr_length do
      tpwrite_pos(c{i});
    end

    ! init the arrays with the vars
    for i from 1 to arr_length do
      d{i} = i;
      f{i} = [0, 0, i];
    end

    var string str1 = "one";
    e{1} = str1;
    var string str2 = "two";
    e{2} = str2;
    var string str3 = "three";
    e{3} = str3;
    var string str4 = "four";
    e{4} = str4;
    var string str5 = "five";
    e{5} = str5;
    var string str6 = "six";
    e{6} = str6;
    var string str7 = "seven";
    e{7} = str7;
    var string str8 = "eight";
    e{8} = str8;
    var string str9 = "nine";
    e{9} = str9;
    var string str10 = "ten";
    e{10} = str10;


    ! traverse the arrays
    for i from 1 to arr_length do
      tpwrite_num(d{i});
    end

    for i from 1 to arr_length do
      tpwrite_string(e{i});
    end

    for i from 1 to arr_length do
      tpwrite_pos(f{i});
    end

  end
end
