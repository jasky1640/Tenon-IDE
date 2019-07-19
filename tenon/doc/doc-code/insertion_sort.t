module insertion_sort

  const num arr_length = 10;
  var num a{arr_length};

  function void main()
    a = [18, 2, 34, 55, 67, 12, 1, 88, 79, 50];

    for i from 1 to arr_length do
      twrite_num(a{i});
    end

    twrite("-----------------------");

    insertion_sort_func();
    for i from 1 to arr_length do
      twrite_num(a{i});
    end
  end

  function void insertion_sort_func()
    var num temp;
    var num j;
    for i from 2 to arr_length do
      temp = a{i};
      j = i;
      while ((j > 1) and (a{j - 1} > temp)) do
        a{j} = a{j - 1};
        j = j - 1;
      end
      a{j} = temp;
    end
  end

end
