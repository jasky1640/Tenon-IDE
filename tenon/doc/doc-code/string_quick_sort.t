module string_quick_sort

  const num arr_length = 10;

  function void main()
    var string a{arr_length} = ["she", "sells", "seashells", "by", "the",
                        "seashore", "sherf", "sell", "are", "surely"];

    for i from 1 to arr_length do
      twrite(a{i});
    end

    twrite("-----------------------");

    quick_sort_func(a, 1, arr_length);
    for i from 1 to arr_length do
      twrite(a{i});
    end
  end

  function void quick_sort_func(alias string a{*}, num first, num last)
    if (first < last) then
      var num i = first;
      var num j = last;
      var string temp = a{i};
      while (i < j) do
        while((i < j) and (strorder(temp, a{j}, STR_LOWER))) do
          j--;
        end
        if (i < j) then
          a{i} = a{j};
          i++;
        end
        while((i < j) and (strorder(a{i}, temp, STR_LOWER))) do
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
