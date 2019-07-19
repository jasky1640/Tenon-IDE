module array

  const num arr_length1 = 2;
  const num arr_length2 = 2;
  const num arr_length3 = 2;

  function void main()
    var num a{arr_length1, arr_length2, arr_length3}; 
    var string b{arr_length1, arr_length2, arr_length3}; 
    var pos c{arr_length1, arr_length2, arr_length3}; 
    var num d{arr_length1, arr_length2, arr_length3}; 
    var string e{arr_length1, arr_length2, arr_length3}; 
    var pos f{arr_length1, arr_length2, arr_length3}; 

    ! init the arrays with the constants
    a = [[[1, 2], [3, 4]], [[5, 6], [7, 8]]];
    b = [[["one", "two"], ["three", "four"]],
         [["five", "six"], ["seven", "eight"]]];
    c = [[[[0, 0, 1], [0, 0, 2]], [[0, 0, 3], [0, 0, 4]]],
         [[[0, 0, 5],[0, 0, 6]], [[0, 0, 7], [0, 0, 8]]]];

    ! traverse the arrays
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        for k from 1 to arr_length3 do
          twrite_num(a{i, j, k});
        end
      end
    end

    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        for k from 1 to arr_length3 do
          twrite_string(b{i, j, k});
        end
      end
    end

    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        for k from 1 to arr_length3 do
          twrite_pos(c{i, j, k});
        end
      end
    end

    ! init the arrays with the vars
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        for k from 1 to arr_length3 do
          d{i, j, k} = (i - 1) * 4 + (j - 1) * 2 + k;
          f{i, j, k} = [0, 0, (i - 1) * 4 + (j - 1) * 2 + k];
        end
      end
    end

    var string str1{arr_length1, arr_length2} = [["one", "two"], ["three", "four"]];
    var string str2{arr_length1, arr_length2} = [["five", "six"], ["seven", "eight"]];
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        e{1, i, j} = str1{i, j};
        e{2, i, j} = str2{i, j};
      end
    end

    ! traverse the arrays
    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        for k from 1 to arr_length3 do
          twrite_num(d{i, j, k});
        end
      end
    end

    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        for k from 1 to arr_length3 do
          twrite_string(e{i, j, k});
        end
      end
    end

    for i from 1 to arr_length1 do
      for j from 1 to arr_length2 do
        for k from 1 to arr_length3 do
          twrite_pos(f{i, j, k});
        end
      end
    end

  end
end

