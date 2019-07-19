module array

  const num arr_length = 10;

  function void main()
    var num a{arr_length}; 
    var string b{arr_length};
    var pos c{arr_length};

    a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    b = ["one", "two", "three", "four", "five", "six", "seven",
         "eight", "nine", "ten"];
    c = [[0, 0, 1], [0, 0, 2], [0, 0, 3], [0, 0, 4], [0, 0, 5],
         [0, 0, 6], [0, 0, 7], [0, 0, 8], [0, 0, 9], [0, 0, 10]];

    ! update the num array vualue by index
    var num update_num_index = 5;
    var num update_num_value = 15;
    a{update_num_index} = update_num_value;
    twrite_num(a{update_num_index});

    ! update the string array value by index
    var num update_string_index = 5;
    var string update_string_value = "fifth";
    b{update_string_index} = update_string_value;
    twrite_string(b{update_string_index});

    ! update the pos array vualue by index
    var num update_pos_index = 5;
    var pos update_pos_value = [0, 0, 15];
    c{update_pos_index} = update_pos_value;
    twrite_pos(c{update_pos_index});

    ! update the num array value by value
    var num update_num_value_old = 6;
    var num update_num_value_new = 16;
    var num index_temp = 0;
    for i from 1 to arr_length do
      if a{i} == update_num_value_old then
        a{i} = update_num_value_new;
        index_temp = i;
      end
    end
    twrite_num(a{index_temp});

    ! update the string array value by value
    var string update_string_value_old = "six";
    var string update_string_value_new = "sixteen";
    index_temp = 0;
    for i from 1 to arr_length do
      if b{i} == update_string_value_old then
        b{i} = update_string_value_new;
        index_temp = i;
      end
    end
    twrite_string(b{index_temp});

    ! update the pos array value by value
    var pos update_pos_value_old = [0, 0, 6];
    var pos update_pos_value_new =  [0, 0, 16];
    index_temp = 0;
    for i from 1 to arr_length do
      if c{i} == update_pos_value_old then
        c{i} = update_pos_value_new;
        index_temp = i;
      end
    end
    if index_temp == 0 then
      twrite("Can't find the value in array.");
    else
      twrite_pos(c{index_temp});
    end
  end

end
