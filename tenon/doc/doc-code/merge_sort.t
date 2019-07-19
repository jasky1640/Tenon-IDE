module merge_sort

  const num arr_length = 10;

  function void main()
    var num a{arr_length} = [18, 2, 34, 55, 67, 12, 1, 88, 79, 50];
    var num b{arr_length};

    for i from 1 to arr_length do
      twrite_num(a{i});
    end

    twrite("-----------------------");

    merge_sort_func(a, 1, arr_length, b);

    for i from 1 to arr_length do
      twrite_num(a{i});
    end

  end

  function void merge_sort_func(alias num a{*}, num first, num last, alias num b{*})
    if (first < last) then
      var num mid = (first + last) div 2;
      merge_sort_func(a, first, mid, b);
      merge_sort_func(a, mid + 1, last, b);
      merge_array(a, first, mid, last, b);
    end
  end

  function void merge_array(alias num a{*}, num first, num mid, num last, alias num b{*})
    var num i = first;
    var num j = mid + 1;
    var num m = mid;
    var num n = last;
    var num k = 1;

    while ((i <= m) and (j <= n)) do
      if (a{i} <= a{j}) then
        b{k} = a{i};
        k++;
        i++;
      else
        b{k} = a{j};
        k++;
        j++;
      end
    end

    while (i <= m) do
      b{k} = a{i};
      k++;
      i++;
    end

    while (j <= n) do
      b{k} = a{j};
      k++;
      j++;
    end

    for i from 1 to (k - 1) do
      a{first + i - 1} = b{i};
    end

  end
end
