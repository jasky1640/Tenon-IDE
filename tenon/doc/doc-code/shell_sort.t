module shell_sort

  const num arr_length = 10;
  var num a{arr_length};

  function void main()
    a = [18, 2, 34, 55, 67, 12, 1, 88, 79, 50];

    for i from 1 to arr_length do
      twrite_num(a{i});
    end

    twrite("-----------------------");

    shell_sort_func();
    for i from 1 to arr_length do
      twrite_num(a{i});
    end
  end

  function void shell_sort_func()
    var num d = arr_length div 2;
    while (d >= 1) do
      shell_insert(d);
      d = d div 2;
    end
  end

  function void shell_insert(num d)
    var num index = d + 1;
    for i from index to arr_length do
      var num j =  i - d;
      var num temp = a{i};

      while ((j > 0) and (a{j} > temp)) do
        a{j + d} = a{j};
        j = j - d;
      end

      if (j <> i - d) then
        a{j + d} = temp;
      end
    end
  end

end
