module quick_sort

  const num arr_length = 10;
  var num a{arr_length};

  function void main()
    a = [18, 2, 34, 55, 67, 12, 1, 88, 79, 50];

    for i from 1 to arr_length do
      twrite_num(a{i});
    end

    twrite("-----------------------");

    quick_sort_func(a, 1, arr_length);
    for i from 1 to arr_length do
      twrite_num(a{i});
    end
  end

  function void quick_sort_func(alias num a{*}, num first, num last)
    if (first < last) then
      var num i = first;
      var num j = last;
      var num temp = a{i};
      while (i < j) do
        while((i < j) and (a{j} > temp)) do
          j--;
        end
        if (i < j) then
          a{i} = a{j};
          i++;
        end
        while((i < j) and (a{i} < temp)) do
          i++;
        end
        if (i < j) then
          a{j} = a{i};
          j--;
        end
      end
      a{i} = temp;
      quick_sort_func(a, first, i - 1);
      quick_sort_func(a, i + 1, last);
    end
  end

end
