module string_shell_sort

  const num arr_length = 10;

  function void main()
    var string a{arr_length} = ["she", "sells", "seashells", "by", "the",
                        "seashore", "sherf", "sell", "are", "surely"];

    for i from 1 to arr_length do
      twrite(a{i});
    end

    twrite("-----------------------");

    shell_sort_func(a);
    for i from 1 to arr_length do
      twrite(a{i});
    end
  end

  function void shell_sort_func(alias string a{*})
    var num d = arr_length div 2;
    while (d >= 1) do
      shell_insert(a, d);
      d = d div 2;
    end
  end

  function void shell_insert(alias string a{*},num d)
    var num index = d + 1;
    for i from index to arr_length do
      var num j =  i - d;
      var string temp = a{i};

      while ((j > 0) and (strorder(temp, a{j}, STR_LOWER))) do
        a{j + d} = a{j};
        j = j - d;
      end

      if (j <> i - d) then
        a{j + d} = temp;
      end
    end
  end

end
