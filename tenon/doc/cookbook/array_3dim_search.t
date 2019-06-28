module array

  const num arr_length1 = 2;
  const num arr_length2 = 2;
  const num arr_length3 = 2;

  function void main()
    var num a{arr_length1, arr_length2, arr_length3}; 
    var string b{arr_length1, arr_length2, arr_length3}; 
    var pos c{arr_length1, arr_length2, arr_length3}; 

    ! init the arrays with the constants
    a = [[[1, 2], [3, 4]], [[5, 6], [7, 8]]];
    b = [[["one", "two"], ["three", "four"]],
         [["five", "six"], ["seven", "eight"]]];
    c = [[[[0, 0, 1], [0, 0, 2]], [[0, 0, 3], [0, 0, 4]]],
         [[[0, 0, 5],[0, 0, 6]], [[0, 0, 7], [0, 0, 8]]]];

    ! search the arrays by index
    var num index1 = 2;
    var num index2 = 2;
    var num index3 = 1;
    tpwrite_num(a{index1, index2, index3});
    tpwrite_string(b{index1, index2, index3});
    tpwrite_pos(c{index1, index2, index3});

    ! search the num array by value
    var num num_value = 6;
    index1 = 0;
    index2 = 0;
    index3 = 0;
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        for k from 1 to arr_length3 do
          if a{i, j, k} == num_value then
            index1 = i;
            index2 = j;
            index3 = k;
          end
        end
      end
    end
    if ((index1 == 0) or (index2 == 0) or (index3 == 0)) then
      tpwrite("Can't find the value in array.");
    else
      tpwrite_num(index1);
      tpwrite_num(index2);
      tpwrite_num(index3);
    end

    ! search the string array by value
    var string string_value = "six";
    index1 = 0;
    index2 = 0;
    index3 = 0;
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        for k from 1 to arr_length3 do
          if b{i, j, k} == string_value then
            index1 = i;
            index2 = j;
            index3 = k;
          end
        end
      end
    end
    if ((index1 == 0) or (index2 == 0) or (index3 == 0)) then
      tpwrite("Can't find the value in array.");
    else
      tpwrite_num(index1);
      tpwrite_num(index2);
      tpwrite_num(index3);
    end

    ! search the pos array by value
    var pos pos_value = [0, 0, 6];
    index1 = 0;
    index2 = 0;
    index3 = 0;
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        for k from 1 to arr_length3 do
          if c{i, j, k} == pos_value then
            index1 = i;
            index2 = j;
            index3 = k;
          end
        end
      end
    end
    if ((index1 == 0) or (index2 == 0) or (index3 == 0)) then
      tpwrite("Can't find the value in array.");
    else
      tpwrite_num(index1);
      tpwrite_num(index2);
      tpwrite_num(index3);
    end

  end
end

