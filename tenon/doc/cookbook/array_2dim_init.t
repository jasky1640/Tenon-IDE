module array

  const num arr_length1 = 2;
  const num arr_length2 = 5;

  function void main()
    var num a{arr_length1, arr_length2}; 
    var string b{arr_length1, arr_length2};
    var pos c{arr_length1, arr_length2};
    var num d{arr_length1, arr_length2}; 
    var string e{arr_length1, arr_length2};
    var pos f{arr_length1, arr_length2};

    ! init the arrays with the constants
    a = [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]];
    b = [["one", "two", "three", "four", "five"],
         ["six", "seven", "eight", "nine", "ten"]];
    c = [[[0, 0, 1], [0, 0, 2], [0, 0, 3], [0, 0, 4], [0, 0, 5]],
         [[0, 0, 6], [0, 0, 7], [0, 0, 8], [0, 0, 9], [0, 0, 10]]];

    ! traverse the arrays
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        tpwrite_num(a{i, j});
      end
    end

    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        tpwrite_string(b{i, j});
      end
    end

    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        tpwrite_pos(c{i, j});
      end
    end

    ! init the arrays with the vars
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        d{i, j} = (i - 1) * arr_length2 + j;
        f{i, j} = [0, 0, (i - 1) * arr_length2 + j];
      end
    end

    var string str1{arr_length2} = ["one", "two", "three", "four", "five"];
    var string str2{arr_length2} = ["six", "seven", "eight", "nine", "ten"];
    for i from 1 to arr_length2 do
      e{1, i} = str1{i};
      e{2, i} = str2{i};
    end

    ! traverse the arrays
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        tpwrite_num(d{i, j});
      end
    end

    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        tpwrite_string(e{i, j});
      end
    end

    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        tpwrite_pos(f{i, j});
      end
    end

  end
end

