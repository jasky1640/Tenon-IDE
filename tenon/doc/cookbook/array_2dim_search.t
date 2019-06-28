module array

  const num arr_length1 = 2;
  const num arr_length2 = 5;

  function void main()
    var num a{arr_length1, arr_length2}; 
    var string b{arr_length1, arr_length2};
    var pos c{arr_length1, arr_length2};

    a = [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]];
    b = [["one", "two", "three", "four", "five"],
         ["six", "seven", "eight", "nine", "ten"]];
    c = [[[0, 0, 1], [0, 0, 2], [0, 0, 3], [0, 0, 4], [0, 0, 5]],
         [[0, 0, 6], [0, 0, 7], [0, 0, 8], [0, 0, 9], [0, 0, 10]]];

    ! search the arrays by index
    var num index1 = 2;
    var num index2 = 3;
    tpwrite_num(a{index1, index2});
    tpwrite_string(b{index1, index2});
    tpwrite_pos(c{index1, index2});

    ! search the num array by value
    var num num_value = 4;
    index1 = 0;
    index2 = 0;
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        if a{i, j} == num_value then
          index1 = i;
          index2 = j;
        end
      end
    end
    if ((index1 == 0) or (index2 == 0)) then
      tpwrite("Can't find the value in array.");
    else
      tpwrite_num(index1);
      tpwrite_num(index2);
    end

    ! search the string array by value
    var string string_value = "four";
    index1 = 0;
    index2 = 0;
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        if b{i, j} == string_value then
          index1 = i;
          index2 = j;
        end
      end
    end
    if ((index1 == 0) or (index2 == 0)) then
      tpwrite("Can't find the value in array.");
    else
      tpwrite_num(index1);
      tpwrite_num(index2);
    end

    ! search the pos array by value
    var pos pos_value = [0, 0, 4];
    index1 = 0;
    index2 = 0;
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        if c{i, j} == pos_value then
          index1 = i;
          index2 = j;
        end
      end
    end
    if ((index1 == 0) or (index2 == 0)) then
      tpwrite("Can't find the value in array.");
    else
      tpwrite_num(index1);
      tpwrite_num(index2);
    end

  end
end

