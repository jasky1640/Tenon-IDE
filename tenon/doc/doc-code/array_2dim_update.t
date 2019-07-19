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

    ! update the arrays by index
    var num index1 = 2;
    var num index2 = 3;
    var num update_num_value = 0;
    a{index1, index2} = update_num_value;
    twrite_num(a{index1, index2});

    var string update_string_value = "zero";
    b{index1, index2} = update_string_value;
    twrite_string(b{index1, index2});

    var pos update_pos_value = [0, 0, 0];
    c{index1, index2} = update_pos_value;
    twrite_pos(c{index1, index2});

    ! update the num array by value
    var num num_value_old = 5;
    var num num_value_new = 15;
    index1 = 0;
    index2 = 0;
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        if a{i, j} == num_value_old then
          a{i, j} = num_value_new;
          index1 = i;
          index2 = j;
        end
      end
    end
    if ((index1 == 0) or (index2 == 0)) then
      twrite("Can't find the value in array.");
    else
      twrite_num(a{index1, index2});
    end

    ! update the string array by value
    var string string_value_old = "five";
    var string string_value_new = "fifth";
    index1 = 0;
    index2 = 0;
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        if b{i, j} == string_value_old then
          b{i, j} = string_value_new;
          index1 = i;
          index2 = j;
        end
      end
    end
    if ((index1 == 0) or (index2 == 0)) then
      twrite("Can't find the value in array.");
    else
      twrite_string(b{index1, index2});
    end

    ! search the pos array by value
    var pos pos_value_old = [0, 0, 5];
    var pos pos_value_new = [0, 0, 15];
    index1 = 0;
    index2 = 0;
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        if c{i, j} == pos_value_old then
          index1 = i;
          index2 = j;
          c{i, j} = pos_value_new;
        end
      end
    end
    if ((index1 == 0) or (index2 == 0)) then
      twrite("Can't find the value in array.");
    else
      twrite_pos(c{index1, index2});
    end

  end
end

