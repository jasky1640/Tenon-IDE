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

    ! search the array by index
    var num index = 4;
    twrite_num(a{4});
    twrite_string(b{4});
    twrite_pos(c{4});

    ! search the num array by value
    var num num_value = 4;
    var num num_value_index = 0;
    for i from 1 to arr_length do
      if a{i} == num_value then
        num_value_index = i;
      end
    end
    if num_value_index == 0 then
      twrite("Can't find the value in array.");
    else
      twrite_num(num_value_index);
    end

    ! search the string array by value
    var string string_value = "four";
    var num string_value_index = 0;
    for i from 1 to arr_length do
      if b{i} == string_value then
        string_value_index = i;
      end
    end
    if string_value_index == 0 then
      twrite("Can't find the value in array.");
    else
      twrite_num(string_value_index);
    end

    ! search the pos array by value
    var pos pos_value = [0, 0, 4];
    var num pos_value_index = 0;
    for i from 1 to arr_length do
      if c{i} == pos_value then
        pos_value_index = i;
      end
    end
    if pos_value_index == 0 then
      twrite("Can't find the value in array.");
    else
      twrite_num(pos_value_index);
    end

  end
end

